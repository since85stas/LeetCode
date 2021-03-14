package yandAlgh.sprint2;

import java.util.*;

enum States {
    ATTACK, DEFENCE
}

enum AttackSubStates {
    MOVING, AVOIDING
}

/**
 * Grab Snaffles and try to throw them through the opponent's goal!
 * Move towards a Snaffle and use your team id to determine where you need to throw it.
 **/
class Player {

    static List<Snaffle> snaffles;
    static List<Wizard> myTeam;
    static List<Wizard> enemyTeam;
    static Goal enemyGoal;
    static Goal myGoal;
    static List<Bludger> bludgers;

    static int magic;

    static int lastSnaffId = -1;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int myTeamId = in.nextInt(); // if 0 you need to score on the right of the map, if 1 you need to score on the left
        enemyGoal = new Goal(myTeamId);
        myGoal = new Goal(Math.abs(myTeamId-1));
        // game loop
        while (true) {
            snaffles = new ArrayList<>();
            myTeam =  new ArrayList<>();
            enemyTeam =  new ArrayList<>();
            bludgers = new ArrayList<>();

            int myScore = in.nextInt();
            int myMagic = in.nextInt();
            int opponentScore = in.nextInt();
            int opponentMagic = in.nextInt();
            int entities = in.nextInt(); // number of entities still in game
            for (int i = 0; i < entities; i++) {
                int entityId = in.nextInt(); // entity identifier
                String entityType = in.next(); // "WIZARD", "OPPONENT_WIZARD" or "SNAFFLE" (or "BLUDGER" after first league)
                int x = in.nextInt(); // position
                int y = in.nextInt(); // position
                int vx = in.nextInt(); // velocity
                int vy = in.nextInt(); // velocity
                int state = in.nextInt(); // 1 if the wizard is holding a Snaffle, 0 otherwise
                if (entityType.equals("WIZARD")) {
                    Wizard wizard = new Wizard(entityId,state,x,y,vx,vy);
                    myTeam.add(wizard);
                } else if (entityType.equals("SNAFFLE")) {
                    Snaffle snaffle = new Snaffle(entityId,x,y,vx,vy);
                    snaffles.add(snaffle);
                } else if (entityType.equals("OPPONENT_WIZARD")) {
                    Wizard wizard = new Wizard(entityId,state,x,y,vx,vy);
                    enemyTeam.add(wizard);
                } else if (entityType.equals("BLUDGER")) {
                    Bludger bludger = new Bludger(entityId,x,y,vx,vy);
                    bludgers.add(bludger);
                }

            }

//            myTeam.get(0).state.state = States.ATTACK;
//
//            myTeam.get(1).state.state = States.ATTACK;
//
//            myTeam.get(0).getNextMove();
//
//            myTeam.get(1).getNextMove();

            getStates();

            myTeam.get(0).getNextMove();
            myTeam.get(1).getNextMove();
        }
    }

    static void getStates() {

        for (int i = 0; i < 2; i++) {
            Wizard myWizard = myTeam.get(i);

            myWizard.state.state = States.ATTACK;
            myWizard.subState = AttackSubStates.MOVING;

            int bludgId = -1;
            for (Bludger bludger :
                    bludgers) {
                if (bludger.isEntityCollide(myWizard, 10)) {
                    bludgId = bludger.id;
                    myWizard.subState = AttackSubStates.AVOIDING;
                    break;
                }
            }
        }

    }

    static class Entity {
        int id;
        Position pos = new Position();
        int vx;
        int vy;
        int r;

        public Entity(int id, int x, int y, int vx, int vy, int r) {
            this.id = id;
            this.pos.x = x;
            this.pos.y = y;
            this.vx = vx;
            this.vy = vy;
            this.r = r;
        }

        public int getDistance(Entity entity) {
            int dist = (int)Math.sqrt( (pos.x-entity.pos.x)*(pos.x-entity.pos.x) + (pos.y-entity.pos.y)*(pos.y-entity.pos.y ));
            return dist;
        }

        public boolean isEntityCollide(Entity entity, int turns) {
            Entity thisFake = new Entity(id, pos.x, pos.y, vx,vy, r);
            Entity otherFake = new Entity(entity.id, entity.pos.x, entity.pos.y, entity.vx,entity.vy,entity.r);
            for (int i = 1; i <= turns; i++) {
                thisFake.pos = this.getPositionAfterTurns(i);
                otherFake.pos = entity.getPositionAfterTurns(i);
                boolean res = thisFake.isIntersect(otherFake);
                System.err.println("i=" + i +" pos=" + thisFake.pos.toString() + " pos=" + otherFake.pos.toString() + " " + res) ;
                if (res) {
                    return true;
                }

            }
            return false;
        }

        private boolean isIntersect(Entity entity) {
            int dist = getDistance(entity);
            if (dist < (r + entity.r )*1.2) {
                return true;
            }
            else return false;
        }

        Position getPositionAfterTurns(int turns) {
            int x2 = pos.x + vx*turns;
            int y2 = pos.y + vy*turns;
            return new Position(x2, y2);
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x= x;
            this.y = y;
        }

        Position() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static class WState {
        States state;
        Entity goal;
        Entity enemy;



        public WState() {}

    }

    static class Wizard extends Entity {

        WState state = new WState();

        AttackSubStates subState = AttackSubStates.MOVING;

        boolean hasBall;

        public Wizard(int id, int state, int x, int y, int vx, int vy) {
            super(id, x, y, vx, vy, 400);
            this.id = id;
            hasBall = state==1;
        }

        Entity getNearestSnaff() {
            Snaffle near = null;
            int minDist = Integer.MAX_VALUE;
            for (Snaffle snaff :
                    snaffles) {
                int dist = snaff.getDistance(Wizard.this);
                if (dist < minDist) {
                    minDist = dist;
                    near = snaff;
                }
            }
            return near;
        }

        Entity getNearestBludg() {
            Bludger near = null;
            int minDist = Integer.MAX_VALUE;
            for (Bludger bludger :
                    bludgers) {
                int dist = bludger.getDistance(Wizard.this);
                if (dist < minDist) {
                    minDist = dist;
                    near = bludger;
                }
            }
            return near;
        }

        String getNextMove() {

            switch (state.state) {
                case ATTACK:
                    if (!hasBall) {
                        Entity nearShaff = getNearestSnaff();
                        if (snaffles.size() > 1 && nearShaff.id == lastSnaffId) {
                            int finalLastSnaffId = lastSnaffId;
                            snaffles.removeIf(it -> it.id == finalLastSnaffId);
                            nearShaff = getNearestSnaff();
                        }
                        lastSnaffId = nearShaff.id;

                        // Edit this line to indicate the action for each wizard (0 ≤ thrust ≤ 150, 0 ≤ power ≤ 500)
                        // i.e.: "MOVE x y thrust" or "THROW x y power"
                        System.out.println("MOVE " + nearShaff.pos.x + " " + nearShaff.pos.y + " " + "150 " + subState.name());
                    } else if (hasBall) {
//                            System.err.println("Wiz:" + curWiz.id + " has a ball");
                        System.out.println("THROW " + enemyGoal.center.pos.x + " " + enemyGoal.center.pos.y + " " + "500 " + id);
                    }
                    break;
                case DEFENCE:
//                    System.out.println("OBLIVIATE " + id);
                    break;
            }
            magic++;
            return "";
        }
    }

    static class Snaffle extends Entity{

        public Snaffle(int id, int x, int y, int vx, int vy) {
            super(id,x,y,vx,vy,150);
        }
    }

    static class Bludger extends Entity {
        public Bludger(int id, int x, int y, int vx, int vy) {
            super(id,x,y,vx,vy,200);
        }
    }

    static class Goal {
        Entity top;
        Entity down;
        Entity center;

        public Goal(int id) {
            if (id == 0) {
                center = new Entity(-1,16000, 3750, 0, 0,0);
                top = new Entity(-1,center.pos.x, center.pos.y - 2000, 0, 0,300);
                down = new Entity(-1,center.pos.x, center.pos.y + 2000, 0, 0,300);
            } else {
                center = new Entity(-1, 0, 3750,0 ,0,0);
                top = new Entity(-1, center.pos.x, center.pos.y - 2000, 0 ,0,300);
                down = new Entity(-1, center.pos.x, center.pos.y + 2000, 0 ,0,300);
            }
        }
    }

}
