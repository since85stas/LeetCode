package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p>
 * сложность алгоритма n*log(n)
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class EqualSums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(tokenizer.nextToken());
            c[i] = p;
        }
        if (partition(c)) System.out.println("True");
        else System.out.println("False");
    }

    private static boolean partition (int arr[])
    {
        int n = arr.length;
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean[][] part = new boolean[n + 1][sum / 2 + 1];

        // initialize top row as false
        for (i = 0; i <= sum/2; i++)
            part[0][i] = false;

        // initialize leftmost column as true
        for (i = 0; i <= n; i++)
            part[i][0] = true;

        // Fill the partition table in botton up manner
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= sum/2; j++)
            {
                part[i][j] = part[i-1][j];
                if (j >= arr[i - 1])
                    part[i][j] = part[i][j] ||
                            part[i - 1][j - arr[i -1]];

            }
        }

        return part[n][sum/2];
    }
}
