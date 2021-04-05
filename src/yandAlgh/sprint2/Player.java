package yandAlgh.sprint2;

import java.util.*;

enum States {
    ATTACK, DEFENCE, FLIPENDO, ACCIO
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
        myGoal = new Goal(Math.abs(myTeamId - 1));
        // game loop
        while (true) {
            snaffles = new ArrayList<>();
            myTeam = new ArrayList<>();
            enemyTeam = new ArrayList<>();
            bludgers = new ArrayList<>();

            int myScore = in.nextInt();
            int myMagic = in.nextInt();
            int opponentScore = in.nextInt();
            int opponentMagic = in.nextInt();
            magic = myMagic;
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
                    Wizard wizard = new Wizard(entityId, state, x, y, vx, vy);
                    myTeam.add(wizard);
                } else if (entityType.equals("SNAFFLE")) {
                    Snaffle snaffle = new Snaffle(entityId, x, y, vx, vy);
                    snaffles.add(snaffle);
                } else if (entityType.equals("OPPONENT_WIZARD")) {
                    Wizard wizard = new Wizard(entityId, state, x, y, vx, vy);
                    enemyTeam.add(wizard);
                } else if (entityType.equals("BLUDGER")) {
                    Bludger bludger = new Bludger(entityId, x, y, vx, vy);
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

//            int bludgId = -1;
//            for (Bludger bludger :
//                    bludgers) {
//                if (bludger.isEntityCollide(myWizard, 10)) {
//                    bludgId = bludger.id;
//                    myWizard.subState = AttackSubStates.AVOIDING;
//                    break;
//                }
//            }
            if (!myWizard.hasBall) {
                if (magic >= 20) {
                    Line goalLine = enemyGoal.innerLine;

                    for (Snaffle snaffle :
                            snaffles) {
                        Line betweenLine = new Line(myWizard.pos, snaffle.pos).extendLine(12000);
                        Position inters = goalLine.isIntersect(betweenLine);
                        if (inters != null) {
                            myWizard.state.state = States.FLIPENDO;
                            myWizard.state.goal = snaffle;
                            myWizard.state.goalPos = inters;

//                            magic = magic - 20;

                            break;
                        }
                    }
                }
                if (magic >=30) {
                    myWizard.state.state = States.ACCIO;
                    myWizard.state.goal = myGoal.getNearestSnaffle();
                }
            }
        }

    }

    private static boolean checkFlipendo(Wizard wizard) {

        for (Snaffle snuf :
                snaffles) {

        }

        return false;
    }

    static class Entity {
        int id;
        Position pos = new Position();
        Vector v;
        //        int vx;
//        int vy;
        int r;

        public Entity(int id, double x, double y, double vx, double vy, int r) {
            this.id = id;
            this.pos.x = x;
            this.pos.y = y;
//            this.vx = vx;
//            this.vy = vy;
            v = new Vector(vx, vy);
            this.r = r;
        }

        public int getDistance(Entity entity) {
            int dist = (int) Math.sqrt((pos.x - entity.pos.x) * (pos.x - entity.pos.x) + (pos.y - entity.pos.y) * (pos.y - entity.pos.y));
            return dist;
        }

        public boolean isEntityCollide(Entity entity, int turns) {
            Entity thisFake = new Entity(id, pos.x, pos.y, v.x, v.y, r);
            Entity otherFake = new Entity(entity.id, entity.pos.x, entity.pos.y, entity.v.x, entity.v.y, entity.r);
            for (int i = 1; i <= turns; i++) {
                thisFake.pos = this.getPositionAfterTurns(i);
                otherFake.pos = entity.getPositionAfterTurns(i);
                boolean res = thisFake.isIntersect(otherFake);
//                System.err.println("i=" + i +" pos=" + thisFake.pos.toString() + " pos=" + otherFake.pos.toString() + " " + res) ;
                if (res) {
                    return true;
                }

            }
            return false;
        }

        private boolean isIntersect(Entity entity) {
            int dist = getDistance(entity);
            if (dist < (r + entity.r) * 1.2) {
                return true;
            } else return false;
        }

        Position getPositionAfterTurns(int turns) {
            double x2 = pos.x + v.x * turns;
            double y2 = pos.y + v.y * turns;
            return new Position(x2, y2);
        }
    }

    static class Position {
        double x;
        double y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }

        Position() {
        }

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

    static class Vector {

        double x;
        double y;

        Vector(Position start, Position end) {
            this.x = end.x - start.x;
            this.y = end.y - start.y;
        }

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double len() {
            return (int) Math.sqrt(x * x + y * y);
        }

        Vector plus(Vector other) {
            return new Vector(x + other.x, y + other.y);
        }

        Vector one() {
            double xx = this.x / len();
            double yy = this.y / len();
            Vector v = new Vector(xx, yy);
            return v;
        }

        boolean isIntersectLine(Line line) {

            return false;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static class Line {

        Position a;

        Position b;

        Line(Position a, Position b) {
            this.a = a;
            this.b = b;
        }

//        Line(Entity a, Entity b) {
//
//        }

        double len() {
            double dist = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
            return dist;
        }

        Line extendLine(int lentgh) {
            Vector napr = new Vector(a, b).one();

            double x2 = a.x + lentgh * napr.x;
            double y2 = a.y + lentgh * napr.y;
            return new Line(a, new Position(x2, y2));
        }

        Position isIntersectOld(Line other) {
            double a1 = this.b.y - this.a.y;

            double b1 = this.b.x - this.a.x;

            double c1 = a1 * (this.a.x) + b1 * (this.a.y);

            double c11 = a1 * (this.b.x) + b1 * (this.b.y);

            // Линия CD представлена как a2x + b2y = c2

            double a2 = other.b.y - other.a.y;

            double b2 = other.b.x - other.a.x;

            double c2 = a2 * (other.a.x) + b2 * (other.a.y);

            double determinant = a1 * b2 - a2 * b1;
            if (determinant == 0) {
                return null;
            } else {
                double x = (b2 * c1 - b1 * c2) / determinant;
                double y = (a1 * c2 - a2 * c1) / determinant;
                return new Position(x, y);
            }
        }

        Position isIntersect(Line other)
        {
            Position dir1 = new Position(b.x - a.x, b.y - a.y);
            Position dir2 = new Position(other.b.x - other.a.x, other.b.y - other.a.y);

            //считаем уравнения прямых проходящих через отрезки
            double a1 = -dir1.y;
            double b1 = +dir1.x;
            double d1 = -(a1*a.x + b1*a.y);

            double a2 = -dir2.y;
            double b2 = +dir2.x;
            double d2 = -(a2*other.a.x + b2*other.a.y);

            //подставляем концы отрезков, для выяснения в каких полуплоскотях они
            double seg1_line2_start = a2*a.x + b2*a.y + d2;
            double seg1_line2_end = a2*b.x + b2*b.y + d2;

            double seg2_line1_start = a1*other.a.x + b1*other.a.y + d1;
            double seg2_line1_end = a1*other.b.x + b1*other.b.y + d1;

            //если концы одного отрезка имеют один знак, значит он в одной полуплоскости и пересечения нет.
            if (seg1_line2_start * seg1_line2_end >= 0 || seg2_line1_start * seg2_line1_end >= 0)
                return null;

            double u = seg1_line2_start / (seg1_line2_start - seg1_line2_end);
//        *out_intersection =  start1 + u*dir1;

            return new Position(a.x + u*dir1.x,a.y + u*dir1.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Line)) return false;
            Line line = (Line) o;
            return a.equals(line.a) &&
                    b.equals(line.b);
        }

        @Override
        public String toString() {
            return "a=" + a + " b=" + b;
        }
    }

    static class WState {
        States state;
        Entity goal;
        Entity enemy;

        Position goalPos;

        public WState() {

        }

    }

    static class Wizard extends Entity {

        WState state = new WState();

        AttackSubStates subState = AttackSubStates.MOVING;

        boolean hasBall;

        public Wizard(int id, int state, int x, int y, int vx, int vy) {
            super(id, x, y, vx, vy, 400);
            this.id = id;
            hasBall = state == 1;
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
                        Line ext = new Line(pos, nearShaff.pos);

//                        System.out.println("MOVE " + nearShaff.pos.x + " " + nearShaff.pos.y + " " + "150 " + subState.name());
                        System.out.println("MOVE " + (int) ext.b.x + " " + (int) ext.b.y + " " + "150 " + magic) ;
                    } else if (hasBall) {
                        System.out.println("THROW " + (int) enemyGoal.center.pos.x + " " + (int) enemyGoal.center.pos.y + " " + "500");
                    }
                    break;
                case DEFENCE:
//                    System.out.println("OBLIVIATE " + id);
                    break;
                case FLIPENDO:
                    System.out.println("FLIPENDO " + state.goal.id + " " + state.goalPos);
//                    System.out.println("MOVE " + (int) state.goalPos.x + " " + (int) state.goalPos.y + " " + "150 " + state.goal.id) ;
//                    magic = magic - 20;
                    break;
                case ACCIO:
                    System.out.println("ACCIO " + state.goal.id + " " + state.goalPos);
                    break;
            }
            magic++;
            return "";
        }
    }

    static class Snaffle extends Entity {

        public Snaffle(int id, int x, int y, int vx, int vy) {
            super(id, x, y, vx, vy, 150);
        }
    }

    static class Bludger extends Entity {
        public Bludger(int id, int x, int y, int vx, int vy) {
            super(id, x, y, vx, vy, 200);
        }
    }

    static class Goal {
        Entity top;
        Entity down;
        Entity center;
        Line innerLine;

        public Goal(int id) {
            if (id == 0) {
                center = new Entity(-1, 16000, 3750, 0, 0, 0);
                top = new Entity(-1, (int) center.pos.x, (int) center.pos.y - 2000, 0, 0, 300);
                down = new Entity(-1, (int) center.pos.x, (int) center.pos.y + 2000, 0, 0, 300);
                innerLine = new Line(top.pos, down.pos);
            } else {
                center = new Entity(-1, 0, 3750, 0, 0, 0);
                top = new Entity(-1, (int) center.pos.x, (int) center.pos.y - 2000, 0, 0, 300);
                down = new Entity(-1, (int) center.pos.x, (int) center.pos.y + 2000, 0, 0, 300);
                innerLine = new Line(top.pos, down.pos);
            }
        }

        Snaffle getNearestSnaffle() {
            int dist = Integer.MAX_VALUE;
            Snaffle near = null;
            for (Snaffle snaffle:
                 snaffles) {
                if (snaffle.getDistance(center) < dist) {
                    dist = snaffle.getDistance(center);
                    near = snaffle;
                }
            }
            return near;
        }
    }

}
