package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpingOnCloudsTest {

    @Test
    void jumpingOnClouds() {
        int[] arr = new int[] {0, 0, 1, 0, 0, 1, 0};
        assertEquals(4, JumpingOnClouds.jumpingOnClouds(arr));

        arr = new int[] {0, 0,0, 0, 1, 0};
        assertEquals(3, JumpingOnClouds.jumpingOnClouds(arr));

        arr = new int[] {0, 0, 0, 1, 0, 0};
        assertEquals(3, JumpingOnClouds.jumpingOnClouds(arr));

        arr = new int[] {0, 0, 0, 1, 0, 1};
        assertEquals(3, JumpingOnClouds.jumpingOnClouds(arr));
    }
}