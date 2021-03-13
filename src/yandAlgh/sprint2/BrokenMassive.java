package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Так как мы знаем что массив был отсортирован то теперь в нем есть две отсортированные части, осталось найти их положение
 *
 * сложность алгоритма log(n)
 *
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289965/
 */
public class BrokenMassive {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        int[] mass = new int[n];

        // минимальное значение и его позиция
        int min = Integer.MAX_VALUE;
        int pos = 0;

        tokenizerStr = new StringTokenizer(reader.readLine());
        if (tokenizerStr.hasMoreTokens()) {
            mass[0] = Integer.parseInt(tokenizerStr.nextToken());
            min = mass[0];
        }
        // результат
        int out = -1;

        if (tokenizerStr.hasMoreTokens()) {
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(tokenizerStr.nextToken());
                mass[i] = val;

                // ищем где нарушается монотонность, значит там граница отсортированных частей
                if (val >= min) {
                    min = val;
                } else {
                    if (pos == 0) pos = i;
                }
            }

            // далее запускаем поиск сначала по одной части, если не найден то по второй
            int[] subMass = Arrays.copyOfRange(mass, 0, pos);
            int first = 0;
            if (subMass.length > 0) {
                first = binarySearch(subMass, k);
            } else {
                first = -1;
            }
            if (first != -1) {
                out = first;
            } else {
                subMass = Arrays.copyOfRange(mass, pos, mass.length);
                int second = 0;
                if (subMass.length > 0) {
                    second = binarySearch(subMass, k);
                } else {
                    second = -1;
                }
                if (second != -1) {
                    out = pos + second;
                }
            }
            System.out.println(out);
        } else {
            if (mass.length > 0) {
                if (mass[0] == k) System.out.println(0);
                else System.out.println(-1);
            }
        }
    }

    // простейший бинарный поиск
    private static int binarySearch(int[] mass, int el) {
        int left = 0;
        int right = mass.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (el == mass[mid]) {
                return mid;
            } else if (el < mass[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (mass[left] == el) return left;
        if (mass[right] == el) return right;
        return -1;
    }

}
