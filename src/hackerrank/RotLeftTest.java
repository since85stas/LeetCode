package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotLeftTest {

    @Test
    void rotLeft() {

        int[] arr = new int[] {1, 2, 3, 4, 5};
        int[] arrR = new int[] {3, 4, 5,1,2};

//        assertArrayEquals(arrR, RotLeft.rotLeft(arr,2));

        arr = new int[] {1, 2, 3, 4, 5};
        arrR = new int[] {5,1,2,3,4};

//        assertArrayEquals(arrR, RotLeft.rotLeft(arr,4));

        arr = new int[] {1, 2, 3, 4, 5};
        arrR = new int[] {2,3,4,5,1};

        assertArrayEquals(arrR, RotLeft.rotLeft(arr,6));
    }
}