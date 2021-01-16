package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumBribesTest {

    @Test
    void minimumBribes() {
        int[] arr = new int[] {1, 2, 5, 3, 7, 8, 6, 4};
        MinimumBribes.minimumBribes(arr);

        arr = new int[] {2, 5, 1, 3, 4};
        MinimumBribes.minimumBribes(arr);
    }
}