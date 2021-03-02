package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class SubSeq {

    public static void main(String[] args) throws IOException {
        boolean res = (sub(false, null));

        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    static boolean sub(boolean test , Integer[] masIn) throws IOException {
        int n = 0;
        Integer[] massive;
        if (test) {
            n = masIn.length;
            massive = masIn;
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

            StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());

            String s = "";
            if (tokenizerStr.hasMoreTokens()) {
                s = (tokenizerStr.nextToken());
            }


            tokenizerStr = new StringTokenizer(reader.readLine());
            String  t= "";
            if (tokenizerStr.hasMoreTokens()) {
                t = (tokenizerStr.nextToken());
            }

            if (t.length() == 0) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }

            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                if (count == s.length()) {
                    return true;
                }
                if (t.charAt(i) == s.charAt(count)) {
                    count++;
                }
            }
            if (count == s.length()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

}
