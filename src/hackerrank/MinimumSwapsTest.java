package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsTest {

    @Test
    void minimumSwaps() {

        int[] arr = new int[] {1, 3, 5, 2, 4, 6, 7};
        assertEquals(3, MinimumSwaps.minimumSwaps(arr));
    }
}