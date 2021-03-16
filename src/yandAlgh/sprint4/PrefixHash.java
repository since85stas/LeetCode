package yandAlgh.sprint4;

import java.io.*;
import java.util.StringTokenizer;

public class PrefixHash {


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
//            long power_of_p = 1;
//            long hash_val = 0;
//
//            // Loop to calculate the hash value
//            // by iterating over the elements of String
//            for (int i = s.length() - 1; i >= 0; i--) {
//                hash_val = (hash_val + (s.charAt(i)) * power_of_p) % m;
//                power_of_p = (power_of_p * a) % m;
//            }
            int hash_val = calcHash(a,m,s);
            System.out.println(hash_val);
        } else {
            System.out.println(0);
        }
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

}
