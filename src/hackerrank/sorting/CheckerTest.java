package hackerrank.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void compare() {
        String a = "smith";
        String b = "jones";
        Checker check = new Checker();
        check.compStringAlphabet(a,b);
    }

    @Test
    void compStringAlphabet() {
    }
}