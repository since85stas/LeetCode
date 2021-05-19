package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class Lepricons {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());
        short m = Short.parseShort(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        short[] c = new short[n];
        for (int i = 0; i < n; i++) {
            short p = Short.parseShort(tokenizer.nextToken());
            c[i] = p;
        }

        long sum = 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            if (i >= c[0]) dp[0][i] = c[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ( j-c[i] >=0) dp[i][j] = Math.max(dp[i-1][j],c[i] + dp[i-1][j-c[i]]);
                else dp[i][j] = 0;
            }
            System.out.println();
        }

        System.out.println(dp[n-1][m-1]);
    }

}
