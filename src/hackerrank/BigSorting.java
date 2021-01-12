package hackerrank;

import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.*;

public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
//        for (short i = 0; i < unsorted.length-1; i++) {
//            for (short j = (short) (i+1); j < unsorted.length; j++) {
//                if (unsorted[i].length() > unsorted[j].length()) {
//                    String temp = unsorted[i];
//                    unsorted[i] = unsorted[j];
//                    unsorted[j] = temp;
//                } else if (unsorted[i].length() == unsorted[j].length()) {
//                    BigInteger ab = new BigInteger(unsorted[i]);
//                    BigInteger bb = new BigInteger(unsorted[j]);
//                    if (ab.compareTo(bb) == 1) {
//                        String temp = unsorted[i];
//                        unsorted[i] = unsorted[j];
//                        unsorted[j] = temp;
//                    }
//                }
//            }
//        }
        TreeMap<Item,Integer> set = new TreeMap<>();
        for (short i = 0; i < unsorted.length; i++) {
            Item item = new Item(unsorted[i]);
            if (set.containsKey(item)) {
                int num = set.get(item);
                set.put(item,num+1);
            } else {
                set.put(item,1);
            }
        }
        String[] arr = new String[unsorted.length];
        short count = 0;
        for (Item item: set.keySet()
             ) {
            int num = set.get(item);
            for (int i = 0; i < num; i++) {
                arr[count] = item.val;
                count++;
            }
        }
        return arr;
    }

    static class Item implements Comparable<Item> {

        String val;

        public Item(String v) {
            val = v;
        }

        @Override
        public int compareTo(Item item) {
            if (val.length() > item.val.length()) {
                return 1;
            } else if (val.length() == item.val.length()) {
                BigInteger ab = new BigInteger(val);
                BigInteger bb = new BigInteger(item.val);
                if (ab.compareTo(bb) == 1) {
                    return 1;
                } else if (ab.compareTo(bb) == 0) {
                    return 0;
                } else  {
                    return -1;
                }
            } else if (val.length() == item.val.length()){
                return 0;
            } else {
                return -1;
            }
        }
    }

    static String[] bigSorting2(String[] unsorted) {
        Arrays.sort(unsorted, (x, y) -> x.length() == y.length() ? x.compareTo(y) : Integer.compare(x.length(), y.length()));
        return unsorted;
    }

}


