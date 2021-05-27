package yandAlgh.sprint8;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder s1 = new StringBuilder(tokenizer.nextToken());
        StringBuilder s2 = new StringBuilder(tokenizer.nextToken());

        boolean res = check(s1,s2);
        if (res) System.out.println("true");
        else System.out.println("false");
    }

    private static boolean check(StringBuilder s1, StringBuilder s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '.') {
                if (i > 0) {
                    s1.delete(i - 1, i + 1);
                    i = i - 2;
                } else if (i == 0) {
                    s1.delete(0, 1);
                    i = i - 1;
                }
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '.') {
                if (i > 0) {
                    s2.delete(i-1,i+1);
                    i = i-2;
                } else if(i==0) {
                    s2.delete(0,1);
                    i = i-1;
                }
            }
        }
        return s1.toString().equals(s2.toString());
    }

}
