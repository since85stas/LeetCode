package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Shkaf {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        int n = 0;
        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        if (tokenizerStr.hasMoreTokens()) {
            n = Integer.parseInt(tokenizerStr.nextToken());
        }
        if (n > 0) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            if (tokenizerStr.hasMoreTokens()) {
                int[] counter = new int[3];
                for (int i = 0; i < n; i++) {
                    byte val = Byte.parseByte(tokenizerStr.nextToken());
                    if (val == 0) {
                        counter[0] = counter[0] + 1;
                    } else if (val == 1) {
                        counter[1] = counter[1] + 1;
                    } else if (val == 2) {
                        counter[2] = counter[2] + 1;
                    }
                }
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < counter.length; i++) {
                    for (int j = 0; j < counter[i]; j++) {
                        builder.append(i).append(" ");
                    }
                }
                System.out.println(builder.toString());
            }
        }
    }


}
