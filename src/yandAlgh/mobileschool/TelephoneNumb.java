package yandAlgh.mobileschool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TelephoneNumb {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        String s = reader.readLine();

        if (s.length() >= 11) {
            StringBuilder builder = new StringBuilder();

            s = s.replaceAll("\\s+", "");

            boolean isOk = true;
            int i;
            for (i = 0; i < 2; i++) {
                if (i == 0 && s.charAt(i) == '8') {
                    builder.append(s.charAt(i));
                    i++;
                    break;
                } else if (i == 0 && s.charAt(i) == '+') {

                } else if (i == 1 && s.charAt(i) == '7') {
                    builder.append(8);
                } else {
                    isOk = false;
                }
            }

            int j = 0;
            if (isOk) {
                builder.append(" ").append("(");

                boolean isBrack = false;
                byte count = 0;
                for (j = i; j < Math.min(5 + 1, s.length() - 1); j++) {
                    if (j == i && s.charAt(j) == '(') {
                        isBrack = true;
                    } else if (isDigit(s.charAt(j))) {
                        builder.append(s.charAt(j));
                        count++;
                        if (count == 3) break;
                    } else {
                        isOk = false;
                    }
                }
                if (isBrack) {
                    j = j + 1;
                    if (s.charAt(j) != ')') {
                        isOk = false;
                    }
                    j = j + 1;
                } else {
                    j = j + 1;
                }
                builder.append(")").append(" ");
            }

            if (isOk) {
                byte count = 0;
                boolean lastIsDef = false;
                int len = s.length() - j;
                int k = 0;
                for (k = j; k < s.length(); k++) {
                    char c = s.charAt(k);

                    if (k == j && !isDigit(c)) {
                        isOk = false;
                        break;
                    } else if (lastIsDef && !isDigit(c)) {
                        isOk = false;
                        break;
                    } else if (!lastIsDef && c == '-') {
                        lastIsDef = true;
                    } else if (isDigit(c)) {
                        builder.append(c);
                        count++;
                        if (count == 3) {
                            builder.append('-');
                        } else if (count == 5) {
                            builder.append('-');
                        } else if (count == 7) {
                            break;
                        }
                        lastIsDef = false;
                    }
                }
                if (count != 7) isOk = false;
                if (s.length() > k+1) {
                    isOk = false;
                }
            }

            if (isOk) System.out.println(builder.toString());
            else System.out.println("error");
        } else {
            System.out.println("error");
        }
    }

    private static boolean isDigit(char c) {
         if (Character.isDigit(c)) return true;
         else return false;
    }
}
