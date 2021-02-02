package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class BinirySum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String n1 = String.valueOf(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        String n2 = String.valueOf(tokenizer.nextToken());

        if (n2.length() > n1.length()) {
            String tmp = n1;
            n1=n2;
            n2= tmp;
        }

        StringBuilder builder = new StringBuilder();
        int last = 0;
        for (int i = 0; i < n1.length(); i++) {
            byte lastN1 = Byte.parseByte(String.valueOf(n1.charAt(n1.length()-1-i)));
            byte lastN2;
            if (n2.length() - 1 - i >=0) {
                lastN2 = Byte.parseByte(String.valueOf(n2.charAt(n2.length() - 1 - i)));
            } else {
                lastN2=0;
            }
            if (lastN1==0 && lastN2==0) {
                builder.append(last);
                last = 0;
            } else if (lastN1==1 && lastN2==1) {
                if (last == 0) {
                    builder.append(0);
                    last = 1;
                } else {
                    builder.append(1);
                    last = 1;
                }
            } else {
                if (last == 0) {
                    builder.append(1);
                    last = 0;
                } else {
                    builder.append(0);
                    last = 1;
                }
            }
        }
        if (last == 1) {
            builder.append(1);
        }
        System.out.println(builder.reverse());
    }


}
