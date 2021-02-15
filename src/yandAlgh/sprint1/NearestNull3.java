package yandAlgh.sprint1;

import java.io.*;
import java.util.*;

public class NearestNull3 {

    /**
     * Идея алгоритма состоит в последевательном проходе массива сначала слева направо,
     * потом справа налево. На каждом шаге записываем расстояние от последнего попавшегося нуля.
     * После этого, для каждого отрезка между нулями, мы можем однозначно определить минимальное расстояние,
     * оно равно минимальному значению в двух проходах. Исключение составляют крайние отрезки, до того как
     * встречается первый ноль, для них берется только обратный проход.
     *
     * Сложность алгоритма O(n)
     *
     * успешная посылка https://contest.yandex.ru/contest/22450/run-report/48083169/
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int len = Integer.parseInt(tokenizer.nextToken());

        // массив значений
        int[] array = new int[len];

        // массив растояний при проходе слева направо
        int[] leftCount = new int[len];

        // метка показываем не крайний ли это отрезок
        boolean isFirstNullFind = false;

        // счетчик расстояния
        int count = 0;

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < len; i++) {
            count++;
            int element = Integer.parseInt(tokenizer.nextToken());
            array[i] = element;

            // если встречаем ноль, то обнуляем счетчик, записываем 0, и устанавливаем флаг в на true
            if (array[i] == 0) {
                leftCount[i] = 0;
                count = 0;
                isFirstNullFind = true;
            } else {
                // ели данный элемент не ноль то может быть два случая
                if (isFirstNullFind) {
                    // если это не крайний отрезок то просто записыввем текущее расстояние
                    leftCount[i] = count;
                } else {
                    // для крайнего отрезка записываем Integer.MAX_VALUE так как прямой проход не считается
                    leftCount[i] = Integer.MAX_VALUE;
                }
            }
        }

        // для обратного прохода все идиентично, кроме того, что массив не считывается, а берется уже сохраненный
        isFirstNullFind = false;
        count = 0;

        // массив растояний при проходе справа налево
        int[] rightCount = new int[len];

        for (int i = len-1;i >= 0; i--) {
            count++;
            int element = array[i];
            if (element == 0) {
                rightCount[i] = 0;
                count = 0;
                isFirstNullFind = true;
            } else {
                if (isFirstNullFind) {
                    rightCount[i] = count;
                } else {
                    rightCount[i] = Integer.MAX_VALUE;
                }
            }
        }

        // просто находимум минимум расстояний для каждого элемента и выводим в строку
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(Math.min(leftCount[i], rightCount[i])).append(" ");
        }
        System.out.println(builder.toString());

    }

}
