package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    List<Integer> a ;
    List<Integer> b;

    @Test
    void getTotalX() {
        a = Arrays.asList(2,6);
        b = Arrays.asList(24,36);

        int num = Result.getTotalX(a,b);

    }


}