package yandAlgh.sprint4;

import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class BreakHash {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> hashes= new HashMap<>();

        boolean isFound= false;

        while (!isFound) {
            String str = givenUsingJava8();
            int hash = calcHash(1000, 123987123, str);
            if (hashes.containsKey(hash)) {
                isFound = true;
                String oldStr = hashes.get(hash);
                System.out.println();
            } else {
                hashes.put(hash, str);
            }
        }
        System.out.println("");
    }

    private static int calcHash(int a, int m, String s) {
        long power_of_p = 1;
        int hash_val = 0;

        // Loop to calculate the hash value
        // by iterating over the elements of String
        for (int i = s.length() - 1; i >= 0; i--) {
            hash_val =(int) ((hash_val + (s.charAt(i)) * power_of_p) % m);
            power_of_p = (power_of_p * a) % m;
        }
        return hash_val;
    }

    static public String givenUsingJava8() {
        int leftLimit = 97; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}
