package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class FibonachRecurs {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        byte n = Byte.parseByte(tokenizerStr.nextToken());
        if (n>1) {
            long res = fib(1, 1, n, (byte) 2);
            System.out.println(res);
        } else {
            System.out.println(1);
        }
    }

    private static long fib (int nMinus1, int nMinus2, byte limit, byte count) {
        if (count < limit) {
            return fib(nMinus1+ nMinus2, nMinus1, limit, ++count);
        }
        return nMinus1+nMinus2;
    }

}
