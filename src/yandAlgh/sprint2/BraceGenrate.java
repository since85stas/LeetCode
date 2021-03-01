package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class BraceGenrate {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());
        braceGenerate(2*n);
    }

    private static void braceGenerate(int n) {
        generator(n, "", 0);
    }

    private static void generator(int len, String prev, int count) {
        if (len == 0) {
            if (count == 0) {
                System.out.println(prev.toString());
            } else {
                return;
            }
            return;
        } else {
            if (count < 0) {
                return;
            }
            int newSize = len -1;
            generator(newSize,prev + "(", count+1);
            generator(newSize,prev + ")", count-1);
        }

    }
}
