package hackerrank.hashMaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckMagazineTest {

    @Test
    void checkMagazine() {
        String[] word = "give me one grand today night".split(" ");
        String[] note = "give one grand today".split(" ");

        CheckMagazine.checkMagazine(word,note);
    }
}