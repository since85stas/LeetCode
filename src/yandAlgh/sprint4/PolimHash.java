package yandAlgh.sprint4;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PolimHash {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short a = Short.parseShort(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        if (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
//        long h = 0;
//        long mi = 1;
//        for (char c : s) {
//            int x = (int) (c - 'a' + 1);
//            h = (h + m * x) % mod;
//            m = (m * k) % mod;
//        }
            long power_of_p = 1;
            long hash_val = 0;

            // Loop to calculate the hash value
            // by iterating over the elements of String
            for (int i = s.length() - 1; i >= 0; i--) {
                hash_val = (hash_val + (s.charAt(i)) * power_of_p) % m;
                power_of_p = (power_of_p * a) % m;
            }

            System.out.println(hash_val);
        } else {
            System.out.println(0);
        }
    }

    static int getPoplimHash(short a, int m, String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            short si = (short) s.charAt(i);
            int ai = getA(a,s.length() - i,m, si);
            sum = sum + ai;
        }

        return sum;
    }

    static int getA(short a,int i, int m, short si) {
        int res = 1;
        if (i == 0) {
            res =1;
        } else {
            BigInteger init = BigInteger.ONE;
            for (int j = 1; j < i; j++) {
                init = init.multiply(BigInteger.valueOf(a));
            }
            init = init.multiply(BigInteger.valueOf(si));
            res = (init.mod(BigInteger.valueOf(m))).intValue();
            return res;
        }
        return res;
    }
}
