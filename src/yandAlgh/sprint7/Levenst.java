package yandAlgh.sprint7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p>
 * сложность алгоритма n*log(n)
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class Levenst {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        System.out.println(calculate(s1,s2));
    }

    private static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = minN(dp[i - 1][j - 1] + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[x.length()][y.length()];
    }

    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    /**
     * Возвращает минимум из 3 чисел
     */
    private  static int minN(int n1, int n2, int n3) {
        int min = n1;
        if (n2 < min) {
            min = n2;
        }
        if (n3 < min) {
            min = n3;
        }
        return min;
    }
}
