package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class FibonachMod2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int n = Integer.parseInt(tokenizerStr.nextToken());
        long k = 9;
        int div = 1;
        for (int i = 0; i < k; i++) {
            div = div * 10;
        }
        div += 7;
        System.out.println(getFibonVal(n, k, div));
    }

    static private long getFibonVal(int n, long k, int div) {
        long number = 0;
        long nMin1 = 1;
        long nMin2 = 1;
//        int fib = 0;
        for (int i = 0; i < n - 1; i++) {
            number = (nMin1 + nMin2) % div;
            nMin2 = nMin1;
            nMin1 = number;
        }

        return number;
    }

}