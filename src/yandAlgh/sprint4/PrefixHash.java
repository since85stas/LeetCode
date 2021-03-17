package yandAlgh.sprint4;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class PrefixHash {

    static int[] hashes;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short a = Short.parseShort(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        String s = (tokenizer.nextToken());

        hashes = new int[s.length()];

        calcHash(a,m,s);

        tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        if (tokenizer.hasMoreTokens()) {
//            String s = tokenizer.nextToken();

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
            hashes[i] = hash_val;
        }
        return hash_val;
    }

    class Test {

        String string;

        Test(String string) {
            this.string = string;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Test)) return false;
            Test test = (Test) o;
            return Objects.equals(string, test.string);
        }

        @Override
        public int hashCode() {
            return Objects.hash(string);
//            Objects.
        }
    }

}
