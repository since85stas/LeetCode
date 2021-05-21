package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Идея заключается в том чтобы рассотреть
 * <p>
 * сложность алгоритма n*sum(ni) - sum(ni) сумма всех элементов в последовательности
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class EqualSums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        final short n = Short.parseShort(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        final int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(tokenizer.nextToken());
            c[i] = p;
        }
        if (partition(c)) System.out.println("True");
        else System.out.println("False");
    }


    private static boolean partition (int arr[])
    {
        final int n = arr.length;
        int sum = 0;

        // находим сумму всех элементов
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // для нечетных невозможно
        if (sum % 2 != 0)
            return false;

        final boolean[][] dp = new boolean[n + 1][sum / 2 + 1];

        // для верхнего у насвсегда false
        for (int i = 0; i <= sum/2; i++)
            dp[0][i] = false;

        // для левого true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // далее рассматриваем все возможные варианты разбиения
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum/2; j++)
            {
                dp[i][j] = dp[i-1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }

            }
        }

        return dp[n][sum/2];
    }
}
