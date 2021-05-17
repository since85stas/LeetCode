package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class LadderJump {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int n = Integer.parseInt(tokenizerStr.nextToken());
        final int k = Integer.parseInt(tokenizerStr.nextToken());
        dp = new long[n+1];
        long mod = 9;
        int div = 1;
        for (int i = 0; i < mod; i++) {
            div = div * 10;
        }
        div += 7;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = i-1; j > 0 && j>=i-k; j--) {
                dp[i] += dp[j];
            }
            dp[i] = dp[i]%div;
        }
        System.out.println(dp[n]);
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
