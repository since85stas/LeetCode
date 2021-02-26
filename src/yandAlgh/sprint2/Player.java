package yandAlgh.sprint2;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab Snaffles and try to throw them through the opponent's goal!
 * Move towards a Snaffle and use your team id to determine where you need to throw it.
 **/
class Player {

    static List<Snaffle> snaffles;
    static List<Wizard> myTeam;
    static List<Wizard> enemyTeam;
    static EnemGoal enemGoal;
    static List<Bludger> bludgers;

    static int magic;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int myTeamId = in.nextInt(); // if 0 you need to score on the right of the map, if 1 you need to score on the left
        enemGoal = new EnemGoal(myTeamId);
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
                int wizCount = 0;
                if (entityType.equals("WIZARD")) {
                    Wizard wizard = new Wizard(wizCount,state,x,y,vx,vy);
                    myTeam.add(wizard);
                    wizCount++;
                } else if (entityType.equals("SNAFFLE")) {
                    Snaffle snaffle = new Snaffle(entityId,x,y,vx,vy);
                    snaffles.add(snaffle);
                } else if (entityType.equals("OPPONENT_WIZARD")) {
                    Wizard wizard = new Wizard(wizCount,state,x,y,vx,vy);
                    enemyTeam.add(wizard);
                    wizCount++;
                } else if (entityType.equals("BLUDGER")) {
                    Bludger bludger = new Bludger(entityId,x,y,vx,vy);
                    bludgers.add(bludger);
                }

            }

            int lastSnaffId  = -1;
            for (int i = 0; i < 2; i++) {

                // Write an action using System.out.println()
                // To debug: System.err.println("Debug messages...");
                Wizard curWiz = myTeam.get(i);
                if (curWiz.state == 0) {
                    Entity nearShaff = curWiz.getNearestSnaff();
                    if (snaffles.size() > 1 && nearShaff.id == lastSnaffId) {
                        int finalLastSnaffId = lastSnaffId;
                        snaffles.removeIf(it -> it.id == finalLastSnaffId);
                        nearShaff = curWiz.getNearestSnaff();
                    }
                    lastSnaffId = nearShaff.id;

                    // Edit this line to indicate the action for each wizard (0 ≤ thrust ≤ 150, 0 ≤ power ≤ 500)
                    // i.e.: "MOVE x y thrust" or "THROW x y power"
                    System.out.println("MOVE " + nearShaff.x + " " + nearShaff.y + " " + "150 " + curWiz.id);
                } else if (curWiz.state == 1) {
                    System.err.println("Wiz:" + curWiz.id + " has a ball");
                    System.out.println("THROW " + enemGoal.center.x + " " + enemGoal.center.y + " " + "500 " + curWiz.id);
                }
            }

            magic++;
        }
    }

    static class Entity {
        int id;
        int x;
        int y;
        int vx;
        int vy;

        public Entity(int id, int x, int y, int vx, int vy) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
        }

        public int getDistance(Entity entity) {
            int dist = (int)Math.sqrt( (x-entity.x)*(x-entity.x) + (y-entity.y)*(y-entity.y ));
            return dist;
        }
    }

    static class Wizard extends Entity {
        int id;

        int state;

        public Wizard(int id, int state,int x, int y, int vx, int vy) {
            super(id,x,y,vx,vy);
            this.id = id;
            this.state = state;
        }

        Entity getNearestSnaff() {
            Snaffle near = null;
            int minDist = Integer.MAX_VALUE;
            for (Snaffle snaff:
                 snaffles) {
                int dist = snaff.getDistance(Wizard.this);
                if (dist < minDist) {
                    minDist = dist;
                    near = snaff;
                }
            }
            return near;
        }
    }

    static class Snaffle extends Entity{

        public Snaffle(int id, int x, int y, int vx, int vy) {
            super(id,x,y,vx,vy);
        }
    }

    static class Bludger extends Entity {
        public Bludger(int id, int x, int y, int vx, int vy) {
            super(id,x,y,vx,vy);
        }
    }

    static class EnemGoal {
        Entity top;
        Entity down;
        Entity center;

        public EnemGoal(int id) {
            if (id == 0) {
                center = new Entity(-1,16000, 3750, 0, 0);
                top = new Entity(-1,center.x, center.y - 2000, 0, 0);
                down = new Entity(-1,center.x, center.y + 2000, 0, 0);
            } else {
                center = new Entity(-1, 0, 3750,0 ,0);
                top = new Entity(-1, center.x, center.y - 2000, 0 ,0);
                down = new Entity(-1, center.x, center.y + 2000, 0 ,0);
            }
        }
    }

}
