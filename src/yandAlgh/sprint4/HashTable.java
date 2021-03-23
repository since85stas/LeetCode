package yandAlgh.sprint4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * сложность операций O(1)
 *
 * успешная посылка https://contest.yandex.ru/contest/24414/run-report/49723483/
 */
public class HashTable {

    // размер таблицы
    static int M = 100019;

    // массив для
    static LinkedList<Pair>[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        table = new LinkedList[M];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {

            // считываем комманды
            StringTokenizer tokenizerStrC = new StringTokenizer(reader.readLine());
            String command = tokenizerStrC.nextToken();

            if (command.equals("put")) {
                int key = Integer.parseInt(tokenizerStrC.nextToken());
                int val = Integer.parseInt(tokenizerStrC.nextToken());
                put(key, val);
            } else if (command.equals("get")) {
                int key = Integer.parseInt(tokenizerStrC.nextToken());
                Integer res = get(key);
                if (res == null) builder.append("None").append("\n");
                else builder.append(res).append("\n");
            } else if (command.equals("delete")) {
                int key = Integer.parseInt(tokenizerStrC.nextToken());
                Integer res = delete(key);
                if (res == null) builder.append("None").append("\n");
                else builder.append(res).append("\n");
            }
        }
        System.out.println(builder.toString());
    }

    private static void put(int key, int val) {
        // проверяем есть ли уже такой ключ, если нет, то инициализируем бкет и добавляем значение
        if (!contains(key)) {
            int buck = bucket(key);
            if (table[buck] == null) {
                table[buck] = new LinkedList<>();
            }
            table[buck].addFirst(new Pair(key, val));
        } else {
            // если уже есть находим нужные элемент и переписываем значение
            int buck = bucket(key);
            for (Pair pair :
                    table[buck]) {
                if (pair.key == key) {
                    pair.val = val;
                }
            }
        }
    }

    private static Integer get(int key) {
        // номер корзины
        int buck = bucket(key);

        // проходимся по списку и получаем значение
        if (table[buck] != null) {
            for (Pair pair :
                    table[buck]) {
                if (pair.key == key) {
                    return pair.val;
                }
            }
        }
        return null;
    }

    private static Integer delete(int key) {
        // номер корзины
        int buck = bucket(key);
        Integer res = null;
        int count = 0;

        // находим номер элемента и удаляем его
        if (table[buck] != null) {
            for (Pair pair :
                    table[buck]) {
                if (pair.key == key) {
                    res = pair.val;
                    table[buck].remove(count);
                }
                count++;
            }
        }
        return res;
    }

    // проверяем есть ли ключ в корзине
    private static boolean contains(int key) {
        int buck = bucket(key);
        if (table[buck] !=null) {
            for (Pair pair :
                    table[buck]) {
                if (pair.key == key) {
                    return true;
                }
            }
        }
        return false;
    }

    // получаем хэш ключа
    private static int hash(int key) {
        return Integer.hashCode(key);
    }

    // получаем номер корзины по
    private static int bucket(int key) {
        return hash(key)%M;
    }

    static class Pair {
        int key;

        int val;

        Pair(int key, int num) {
            this.key = key;
            this.val = num;
        }

    }
}
