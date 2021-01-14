package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SockMerchantTest {

    @Test
    void sockMerchant() {
        int[] array = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
        assertEquals(3, SockMerchant.sockMerchant(6, array));
    }
}