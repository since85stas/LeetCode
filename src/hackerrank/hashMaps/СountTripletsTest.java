package hackerrank.hashMaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class СountTripletsTest {

    @Test
    void countTriplets() {
        long[] arr = new long[] {1,1,2,4,5,7};
//        List<Long> list = Arrays.asList(1,1,2,4);
        List<Long> list = new ArrayList<>();
        for (long num: arr
             ) {
            list.add(num);
        }
        assertEquals(2,СountTriplets.countTriplets(list,2));
    }
}