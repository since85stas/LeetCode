package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {

    @Test
    void repeatedString() {
        String str = "aba";
        int num = 10;
        assertEquals(7,RepeatedString.repeatedString(str,num));

        str = "a";
        long numl;
        numl = 1_000;
        assertEquals(numl,RepeatedString.repeatedString(str,numl));
    }
}