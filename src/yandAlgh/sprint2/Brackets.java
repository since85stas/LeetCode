package yandAlgh.sprint2;

import java.io.*;
import java.util.Stack;
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

        if (tokenizerStr.hasMoreTokens()) {
            String seq = String.valueOf(tokenizerStr.nextToken());
            String[] brackets = seq.split("");

            Stack<String> opened = new Stack<>();
            boolean isOk = true;
            for (int i = 0; i < brackets.length; i++) {
                String curr = brackets[i];
                if (isOpen(curr)) {
                    opened.push(curr);
                } else {
                    if (!opened.empty()) {
                        String last = opened.pop();
                        if (!isOpposite(last, curr)) {
                            isOk = false;
                            break;
                        }
                    } else {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk && opened.empty()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
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

    static private boolean isOpen(String opened) {
        return (opened.equals(openC) || opened.equals(openR) || opened.equals(openS));
    }


}
