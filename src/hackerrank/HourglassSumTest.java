package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourglassSumTest {

    @Test
    void hourglassSum() {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0,},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        assertEquals(19, HourglassSum.hourglassSum(arr));
    }
}