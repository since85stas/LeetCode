package yandAlgh.sprint8;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class CountPrefix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        String s = (reader.readLine());
        int[] res = countPref(s);
        StringBuilder builder = new StringBuilder();
        for (Integer i:
                res) {
            builder.append(i).append(" ");
        }
        System.out.println(builder.toString());
    }

    private static int[] countPref(String s) {
        int[] pi = new int[s.length()];
        pi[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int k = pi[i-1];
            while (k >0 && s.charAt(k) != s.charAt(i)) {
                k = pi[k-1];
            }
            if (s.charAt(i) == s.charAt(k)) {
                k +=1;
            }
            pi[i] = k;
        }

        return pi;
    }

}
