package hackerrank.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkToysTest {

    @Test
    void maximumToys() {
        int[] arr = new int[] {1, 12, 5, 111, 200, 1000, 10};
        assertEquals(4, MarkToys.maximumToys(arr,50));
    }
}