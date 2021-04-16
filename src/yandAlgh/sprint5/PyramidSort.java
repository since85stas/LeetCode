package yandAlgh.sprint5;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Создаем вспомогательный класс для игроков далее как написано в описании
 * Сам алгорим описан в теории. Вкратце. Сначала добавляем в массив и следим за сохранением свойств пирамиды. Т.е.
 * чтобы потомки были меньше родителя, просеиваем вверх. Затем начинаем забирать элементы от самого большого и на каждом шагу,
 * возвращяем элементы в положение требуемое своиствами пирамиды, тоесть просеиваем вниз.
 * <p>
 * сложность алгоритма n*log(n)
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class PyramidSort {

    // массив в котором храним элементы
    static Player[] heap;

    // начальное положение
    static int start = 1;

    // текущий размер значущих элементов
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());
        size = n;
        heap = new Player[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            Player player = new Player(tokenizerStr.nextToken(),
                    Integer.parseInt(tokenizerStr.nextToken()),
                    Integer.parseInt(tokenizerStr.nextToken()));

            // добавляем элементы в массив
            add(player, i);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            // берем наиболее приоритетный и добавляем в результат
            Player max = removeMax();
            result.append(max.name).append("\n");
        }

        System.out.println(result.toString());
    }

    public static void add(Player player, int idx) {
        // добавляем элемент в массив
        heap[idx] = player;

        // просеиваем вверх, тоесть находим положение для данного элемента, чтобы сохранялись свойства пирамиды
        siftUp(idx);
    }

    // берем наибольший элемент
    public static Player removeMax() {
        // наибольший элемент в начале
        Player plMax = heap[start];

        // меняем первый и последний
        heap[start] = heap[size];
        heap[size] = null;

        // уменьшаем размер кучи и просеиваем вниз
        size = size - 1;
        siftDown(start);

        return plMax;
    }

    public static int siftDown(int idx) {
        // находим положения потомков
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int index_largest = idx;

        // если потомков нет то конец
        if (size < left || size == 1) {
            return idx;
        }

        // находим положение максимального элемента
        if (right <= size && heap[left].compareTo(heap[right]) > 0) {
            index_largest = right;
        } else {
            index_largest = left;
        }

        // если их порядок не верный то меняем местами и просеиваем дальше
        if (heap[idx].compareTo(heap[index_largest]) > 0) {
            Player temp = heap[index_largest];
            heap[index_largest] = heap[idx];
            heap[idx] = temp;
            idx = siftDown(index_largest);
        }
        return idx;
    }

    public static int siftUp(int idx) {

        if (idx == 1) {
            return idx;
        }

        // находим положение родителя
        int parent = idx / 2;

        // смотрим больше или меньше наш элемент родителя, если не праильно то меняем местами и просеиваем на новом месте
        if (heap[parent].compareTo(heap[idx]) > 0) {
            Player temp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = temp;
            idx = siftUp(parent);
        }
        return idx;
    }

    /**
     * вспомогательный класс для игроков
     * Сравниваем сначала по очкам, затем по штрафным очкам и потом уже по имени
     */
    private static class Player implements Comparable<Player> {
        String name;
        int score;
        int fail;

        public Player(String name, int score, int fail) {
            this.name = name;
            this.score = score;
            this.fail = fail;
        }

        @Override
        public int compareTo(Player other) {
            if (this.equals(other)) {
                return 0;
            } else if (this.score > other.score) {
                return -1;
            } else if (this.score < other.score) {
                return 1;
            } else if (this.score == other.score) {
                if (this.fail < other.fail) {
                    return -1;
                } else if (this.fail > other.fail) {
                    return 1;
                } else if (this.fail == other.fail) {
                    int comp = this.name.compareTo(other.name);
                    return comp;
                }
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Player)) return false;
            Player player = (Player) o;
            return score == player.score &&
                    fail == player.fail &&
                    Objects.equals(name, player.name);
        }
    }

}
