package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class Brackets {

    static final String openS = "[";
    static final String openR = "(";
    static final String openC = "{";
    static final String closeS = "]";
    static final String closeR = ")";
    static final String closeC = "}";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        String seq = String.valueOf(tokenizerStr.nextToken());
        String[] brackets = seq.split("");

        boolean isOpen = false;
        String opened = "";
        for (int i = 0; i < seq.length(); i++) {
            String curr = brackets[i];
            if (!isOpen) {
                if (curr.equals(closeS) || curr.equals(closeR) || curr.equals(closeC)) {
                    isOpen = true;
                    break;
                } else {
                    opened = curr;
                    isOpen = true;
                }
            }
            for (int j = i+1; j < seq.length(); j++) {
                String currNext = brackets[j];
                if (isOpposite(opened, currNext)) {
                    opened = "";
                    isOpen = false;
                    break;
                }
            }
            if (isOpen) {

                break;
            }
        }
        if (isOpen) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    private  static boolean isOpposite(String opened, String curr) {
        switch (opened) {
            case openS: {
                return curr.equals(closeS);
            }
            case openC: {
                return curr.equals(closeC);
            }
            case openR: {
                return curr.equals(closeR);
            }
            default: return false;
        }
    }

    private boolean isWrong(String opened, String curr) {
//        switch (opened) {
//            case openS: {
//                return curr.equals(closeS);
//            }
//            case openC: {
//                return curr.equals(closeC);
//            }
//            case openR: {
//                return curr.equals(closeR);
//            }
//            default: return false;
        return true;
//        }
    }


}
