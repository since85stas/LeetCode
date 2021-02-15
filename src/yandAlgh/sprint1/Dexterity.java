package yandAlgh.sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


/**
 * В задаче по идее нам надо просто пересчитать все различные цифры на поле
 * этим и будет определяться максимальное количество возможных очков
 *
 * сложность алгоритма константа
 *
 * успешная посылка https://contest.yandex.ru/contest/22450/run-report/48091310/
 */
public class Dexterity {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        byte k = Byte.parseByte(tokenizer.nextToken());

        // массив для хранения строк поля
        String[] lines = new String[4];

        // считываем поле
        for (byte i = 0; i < 4; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            lines[i] = tokenizer.nextToken();
        }

        // словарь для хранения цифр и их количества
        HashMap<Byte, Byte> counter = new HashMap<>();
        for (String line:
             lines) {
            for (String el:
                 line.split("")) {
                // проходимся по строке, если элеент не '.' то увеличивем счетчик на 1
                if (!el.equals(".")) {
                    byte val = Byte.parseByte(el);
                    if (!counter.containsKey(val)) {
                        counter.put(val, (byte) 1);
                    } else {
                        int count = counter.get(val);
                        counter.put(val, (byte) (count+1));
                    }
                }
            }
        }

        // подсчитывем очки для всех возможных t
        int score = 0;
        for (byte i = 1; i < 10; i++) {
            if (counter.containsKey(i)) {
                if (counter.get(i) <= k*2) {
                    score++;
                }
            }
        }
        System.out.println(score);
    }

}
