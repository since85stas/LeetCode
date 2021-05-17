package yandAlgh.sprint7;

import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Game game = new Game();

        int numberOfCells = in.nextInt();
        for (int i = 0; i < numberOfCells; i++) {
            int index = in.nextInt();
            int richness = in.nextInt();
            int neigh0 = in.nextInt();
            int neigh1 = in.nextInt();
            int neigh2 = in.nextInt();
            int neigh3 = in.nextInt();
            int neigh4 = in.nextInt();
            int neigh5 = in.nextInt();
            int[] neighs = new int[]{neigh0, neigh1, neigh2, neigh3, neigh4, neigh5};
            Cell cell = new Cell(index, richness, neighs);
            game.board.add(cell);
        }

        while (true) {
            game.day = in.nextInt();
            game.nutrients = in.nextInt();
            game.mySun = in.nextInt();
            game.myScore = in.nextInt();
            game.opponentSun = in.nextInt();
            game.opponentScore = in.nextInt();
            game.opponentIsWaiting = in.nextInt() != 0;

            game.trees.clear();
            int numberOfTrees = in.nextInt();
            for (int i = 0; i < numberOfTrees; i++) {
                int cellIndex = in.nextInt();
                int size = in.nextInt();
                boolean isMine = in.nextInt() != 0;
                boolean isDormant = in.nextInt() != 0;
                Tree tree = new Tree(cellIndex, size, isMine, isDormant);
                game.trees.add(tree);
            }

            game.possibleActions.clear();
            int numberOfPossibleActions = in.nextInt();
            in.nextLine();
            for (int i = 0; i < numberOfPossibleActions; i++) {
                String possibleAction = in.nextLine();
                game.possibleActions.add(Action.parse(possibleAction));
            }

            game.getActionScores();

            Action action = game.getNextAction();
            System.out.println(action);
        }
    }
}

class Cell {

    int index;
    int richness;
    int[] neighbours;

    public Cell(int index, int richness, int[] neighbours) {
        this.index = index;
        this.richness = richness;
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "index=" + index +
                ", richness=" + richness +
                ", neighbours=" + Arrays.toString(neighbours) +
                '}';
    }
}

class Tree {

    int cellIndex;
    int size;
    boolean isMine;
    boolean isDormant;

    public Tree(int cellIndex, int size, boolean isMine, boolean isDormant) {
        this.cellIndex = cellIndex;
        this.size = size;
        this.isMine = isMine;
        this.isDormant = isDormant;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "cellIndex=" + cellIndex +
                ", size=" + size +
                ", isMine=" + isMine +
                ", isDormant=" + isDormant +
                '}';
    }
}

class Action {

    static final String WAIT = "WAIT";
    static final String SEED = "SEED";
    static final String GROW = "GROW";
    static final String COMPLETE = "COMPLETE";
    String type;
    Integer targetCellIdx;
    Integer sourceCellIdx;

    int score = 0;

    public Action(String type, Integer sourceCellIdx, Integer targetCellIdx) {
        this.type = type;
        this.targetCellIdx = targetCellIdx;
        this.sourceCellIdx = sourceCellIdx;
    }

    public Action(String type, Integer targetCellIdx) {
        this(type, null, targetCellIdx);
    }

    public Action(String type) {
        this(type, null, null);
    }

    static Action parse(String action) {
        String[] parts = action.split(" ");
        switch (parts[0]) {
            case WAIT:
                return new Action(WAIT);
            case SEED:
                return new Action(SEED, Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
            case GROW:
            case COMPLETE:
            default:
                return new Action(parts[0], Integer.valueOf(parts[1]));
        }
    }

    @Override
    public String toString() {
        if (WAIT.equalsIgnoreCase(type)) {
            return Action.WAIT;
        }
        if (SEED.equalsIgnoreCase(type)) {
            return String.format("%s %d %d", SEED, sourceCellIdx, targetCellIdx);
        }
        return String.format("%s %d", type, targetCellIdx);
    }
}

class Game {

    int day;
    int nutrients;
    List<Cell> board;
    List<Action> possibleActions;
    List<Tree> trees;
    int mySun, opponentSun;
    int myScore, opponentScore;
    boolean opponentIsWaiting;
    HashMap<Integer, Integer> treesSizes;


    public Game() {
        board = new ArrayList<>();
        possibleActions = new ArrayList<>();
        trees = new ArrayList<>();
    }

    Action getNextAction() {
        return getMaxScoreAction();
    }

    public void getActionScores() {

        countTreesSizes();

        for (Action action :
                possibleActions) {
            switch (action.type) {
                case Action.WAIT:
                    break;
                case Action.COMPLETE:
                    if (treesSizes.get(3) <= 3) {
                        if (day < 19) {
                            action.score = 0;
                        } else {
                            action.score = 5;
                        }
                    } else {
                        action.score = 4;
                    }
                    break;
                case Action.SEED:
                    action.score = getCellByIndx(action.targetCellIdx).richness;
                    break;
                case Action.GROW:
                    action.score = getCellByIndx(action.targetCellIdx).richness;
                    if (day < 18 || getTreeById(action.targetCellIdx).size > 1) {
                        action.score += getTreeById(action.targetCellIdx).size;
                    }
                    if (getTreeById(action.targetCellIdx).size == getMinSize()) {
                        action.score += 1;
                    }
                    break;
            }
        }
    }

    public void countTreesSizes() {
        treesSizes = new HashMap<>();
        for (Tree tree :
                trees) {
            if (treesSizes.containsKey(tree.size)) {
                treesSizes.put(tree.size, treesSizes.get(tree.size)+1);
            } else {
                treesSizes.put(tree.size, 1);
            }
        }
    }

    public int getMinSize() {
        int minCount= -1;
        int minsize = - 1;
        for (Integer size :
                treesSizes.keySet()) {
            if (treesSizes.get(size) > minCount) {
                minsize = size;
                minCount = treesSizes.get(size);
            }
            }
        return minsize;
    }

    public Tree getTreeById(int id) {
        for (Tree tree :
                trees) {
            if (tree.cellIndex == id) return tree;
        }
        return null;
    }

    public Action getMaxScoreAction() {
        int score = -1;
        Action maxAction = null;
        for (Action action :
                possibleActions) {
            if (action.score > score) {
                score = action.score;
                maxAction = action;
            }
        }
        if (maxAction == null) return null;
        else return maxAction;
    }

    public int getMaxScoreTreeId() {
        int maxSc = -1;
        Tree maxTree = null;
        for (Tree tree :
             trees) {
            if (tree.isMine) {
                int score = 20 + getCellByIndx(tree.cellIndex).richness;
                if (score > maxSc) {
                    maxSc = score;
                    maxTree = tree;
                }
            }
        }
        System.err.println(maxTree);
        if (maxTree != null) return maxTree.cellIndex;
        else return -1;
    }

    public Cell getCellByIndx(int ind) {
        for (Cell cell :
                board) {
            if (cell.index == ind) {
                return cell;
            }
            }
        return null;
    }

}