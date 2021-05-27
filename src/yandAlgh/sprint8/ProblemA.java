package yandAlgh.sprint8;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s1 = tokenizer.nextToken();
        String s2 = tokenizer.nextToken();

        boolean res = check(s1,s2);
        if (res) System.out.println("true");
        else System.out.println("false");
    }

    private static boolean check(String s1, String s2) {
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '.') {
                if (b1.length()-1 > 0) b1.delete(b1.length()-1,b1.length());
                else if ((b1.length()-1 == 0)) b1 = new StringBuilder();
            } else {
                b1.append(s1.charAt(i));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '.') {
                if (b2.length()-1 > 0) b2.delete(b2.length()-1,b2.length());
                else if ((b2.length()-1 == 0)) b2 = new StringBuilder();
            } else {
                b2.append(s2.charAt(i));
            }
        }
        return b1.toString().equals(b2.toString());
    }

}
