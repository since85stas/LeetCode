package yandAlgh.sprint7;

import java.io.*;

/**
 * При анализе замечаем, что в подзадачах повторяются вызовы для различных суффиксов исходных строк.
 * Это означает, что может быть только m * n уникальных рекурсивных вызовов (где m и n - количество суффиксов x и y )
 * Для экономии по времени будем хранить уже посчитанные решения в массиве dp[][].
  * <p>
 * сложность алгоритма O (m * n)
 * <p>
 * успешная посылка  https://contest.yandex.ru/contest/25597/run-report/51582252/
 */
public class Levenst {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        final String s1 = reader.readLine();
        final String s2 = reader.readLine();

        System.out.println(calculate(s1,s2));
    }

    private static int calculate(String x, String y) {
        final int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    // * Реккурентную формулу я брал из статьи, доказательство там достаточно нетривиальное)
                    dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[x.length()][y.length()];
    }

    /**
     * сравниваем два символа
     */
    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    /**
     * Возвращает минимум из 3 чисел
     */
    private  static int min(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2,n3));
    }
}
