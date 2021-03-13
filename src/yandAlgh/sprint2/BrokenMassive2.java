package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * сложность алгоритма log(n)
 *
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49305996/
 */
public class BrokenMassive2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        int[] mass = new int[n];

        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(tokenizerStr.nextToken());
            mass[i] = val;
        }

        int res = brokBinSearch(mass ,k, 0, mass.length-1);
        System.out.println(res);
    }

    private static int brokBinSearch( int[] mass, int key, int low, int high )
    {
        // если все прошли то нет
        if (low > high)
        {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mass[mid] == key)
        {
            return mid;
        }
        else if (key < mass[mid])
        {
            // проверяем отсортирована ли левая часть, и если меньший элемент больше ключа, значит точно в правой
            if ((mass[low] <= mass[mid]) && (mass[low] > key)) {
                return brokBinSearch(mass,key, mid + 1, high);
            } else {
                // иначе в левой
                return brokBinSearch(mass,key, low, mid - 1);
            }
        }
        else // key > A[mid]
        {
            // проверяем правую часть, и если ключ больше максимума, то точно в левой
            if ((mass[mid] <= mass[high]) && (key > mass[high])) {
                return brokBinSearch(mass,key, low, mid - 1);
            } else {
                return  brokBinSearch(mass,key, mid + 1, high);
            }
        }
    }

}
