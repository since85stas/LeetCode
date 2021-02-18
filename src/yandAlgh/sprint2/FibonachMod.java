package yandAlgh.sprint2;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class FibonachMod {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int n = Integer.parseInt(tokenizerStr.nextToken());
        final byte k = Byte.parseByte(tokenizerStr.nextToken());

        System.out.println(getFibonVal(n, k));
    }

    static private int getFibonVal(int n, byte k) {
        BigInteger number = BigInteger.ZERO;
        BigInteger nMin1 = BigInteger.ONE;
        BigInteger nMin2 = BigInteger.ONE;
//        int fib = 0;
        for (int i = 0; i < n-1; i++) {
            number = nMin1.add(nMin2);
            nMin2 = nMin1;
            nMin1 = number;
        }
        int div = 1;
        for (int i = 0; i < k; i++) {
            div = div*10;
        }

        int rem = number.remainder(BigInteger.valueOf(div)).intValue();
        return rem;
    }
}
