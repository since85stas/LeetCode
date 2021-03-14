package yandAlgh.sprint2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void xParrColl1() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,100,0);

        Player.Bludger bludger = new Player.Bludger(1,1000,0,0,0);

        boolean iscol = player.isEntityCollide(bludger, 3);
        assertEquals(true, iscol);
    }

    @Test
    public void xParrColl2() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,100,0);

        Player.Bludger bludger = new Player.Bludger(1,1000,0,0,0);

        boolean iscol = player.isEntityCollide(bludger, 2);
        assertEquals(false, iscol);
    }

    @Test
    public void xParrColl3() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,0,0);

        Player.Bludger bludger = new Player.Bludger(1,1000,0,-100,0);

        boolean iscol = player.isEntityCollide(bludger, 3);
        assertEquals(true, iscol);
    }

    @Test
    public void xParrColl4() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,0,0);

        Player.Bludger bludger = new Player.Bludger(1,1000,0,-100,0);

        boolean iscol = player.isEntityCollide(bludger, 2);
        assertEquals(false, iscol);
    }

    @Test
    public void yParrColl1() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,0,100);

        Player.Bludger bludger = new Player.Bludger(1,0,1000,0,0);

        boolean iscol = player.isEntityCollide(bludger, 3);
        assertEquals(true, iscol);
    }

    @Test
    public void yParrColl2() {
        Player.Wizard player = new Player.Wizard(0, 0,0,0,0,100);

        Player.Bludger bludger = new Player.Bludger(1,0,1000,0,0);

        boolean iscol = player.isEntityCollide(bludger, 2);
        assertEquals(false, iscol);
    }

    @Test
    public void testPosition1() {
        Player.Entity entity = new Player.Entity(0, 0,0,1,1,1);

        assertEquals(true, entity.getPositionAfterTurns(2).equals(new Player.Position(2,2)));
    }

    @Test
    public void testPosition2() {
        Player.Entity entity = new Player.Entity(0, 0,0,1,-1,1);

        assertEquals(true, entity.getPositionAfterTurns(5).equals(new Player.Position(5,-5)));
    }

    @Test
    public void testPosition3() {
        Player.Entity entity = new Player.Entity(0, 0,0,1,-1,1);

        assertEquals(false, entity.getPositionAfterTurns(5).equals(new Player.Position(5,-6)));
    }

    @Test
    public void testPosition4() {
        Player.Entity entity = new Player.Entity(0, 10,2,2,-2,1);

        assertEquals(true, entity.getPositionAfterTurns(2).equals(new Player.Position(14,-2)));
    }

    @Test
    public void testVector1() {
        Player.Vector vector = new Player.Vector(new Player.Position(0,0), new Player.Position(1,0));
        assertEquals(1, vector.len());

        vector = new Player.Vector(new Player.Position(0,1), new Player.Position(0,0));
        assertEquals(1, vector.len());

        vector = new Player.Vector(new Player.Position(0,0), new Player.Position(0,0));
        assertEquals(0, vector.len());

        vector = new Player.Vector(new Player.Position(0,0), new Player.Position(4,3));
        assertEquals(5, vector.len());
    }

    @Test
    public void extendLineTest() {
        Player.Line line = new Player.Line(new Player.Position(0,0), new Player.Position(1,0));
        Player.Line ext = line.extendLine(5);
        assertEquals(true,new Player.Line(new Player.Position(0,0), new Player.Position(5,0)).equals(ext));
        System.out.println("");
    }

    @Test
    public void extendLineTest2() {
        Player.Line line = new Player.Line(new Player.Position(0,0), new Player.Position(1,1));
        Player.Line ext = line.extendLine(5);
        assertEquals(true,new Player.Line(new Player.Position(0,0), new Player.Position(5,5)).equals(ext));
        System.out.println("");
    }

    @Test
    public void extendLineTest3() {
        Player.Line line = new Player.Line(new Player.Position(0,0), new Player.Position(-1,1));
        Player.Line ext = line.extendLine(3);
        assertEquals(true,new Player.Line(new Player.Position(0,0), new Player.Position(-3,3)).equals(ext));
        System.out.println("");
    }
}