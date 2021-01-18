package hackerrank.hashMaps;

import java.util.*;
import java.util.stream.Collectors;

public class СountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long,Long> dict = new HashMap<>();
        HashMap<Long,Long> dictPairs = new HashMap<>();
        Collections.reverse(arr);
        long count = 0;
        for (Long num:
             arr) {
            if (dictPairs.containsKey(num*r)) {
                count+=dictPairs.get(num*r);
            }
            if (dict.containsKey(num*r)) {
                dictPairs.put(num,dictPairs.getOrDefault(num,0L) + dict.get(num*r));
            }
            if ( num%r == 0) {
                if (!dict.containsKey(num)) {
                    dict.put(num, 1L);
                } else {
                    long numD = dict.get(num);
                    dict.put(num, numD + 1);
                }
            }
        }
        return count;
    }

}
