package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class FlowerFieldComp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int m = Integer.parseInt(tokenizerStr.nextToken());
        final int n = Integer.parseInt(tokenizerStr.nextToken());

        byte[][] field= new byte[m+1][n+1];
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            String string = reader.readLine();
            for (int j = 0; j < n+1; j++) {
                if ( i < m  && j > 0) {
                    if (string.charAt(j-1)==('1')) field[i][j] = 1;
                    else field[i][j] = 0;
                } else {
                    field[i][j] = Byte.MIN_VALUE;
                }
            }
        }

        dp[1][n] = field[1][n];

        for (int i = 1; i <= n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                dp[j][i] = field[j][i] + Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }

        System.out.println(dp[0][n]);
        StringBuilder res = new StringBuilder();
        int is = n;
        int js = 0;
        for (int i = 0; i < n + m -2; i++) {
            if (dp[js+1][is] > dp[js][is-1]) {
                res.append("U");
                js = js+1;
            } else {
                res.append("R");
                is = is-1;
            }
        }
        System.out.println(res.reverse().toString());
    }

}
