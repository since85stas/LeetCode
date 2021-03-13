package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Здесь не очень понял, что не так с объявлением класса?
 * Создаем вспомогательный класс для игроков далее как написано в описании
 *
 * сложность алгоритма n*log(n)
 *
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class QuickSortEff {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            players[i] = new Player(tokenizerStr.nextToken(),
                    Integer.parseInt(tokenizerStr.nextToken()),
                    Integer.parseInt(tokenizerStr.nextToken()));
        }

        sort(players);

        StringBuilder result = new StringBuilder();
        for (int i = players.length-1; i >= 0 ; i--) {

            result.append(players[i].name).append("\n");
        }

        System.out.println(result.toString());
    }

    private static void sort (Player[] players) {
        quickSort(players, 0, players.length - 1);
    }

    /**
     *
     * @param players массив
     * @param start начало сортировки
     * @param end конец сортировки
     */
    private static void quickSort (Player[] players, int start, int end) {

        // в качестве опорного берем серидину
        int pos = start + (end- start)/2;
        Player pivot = players[pos];

        // внутренние указатели прохода
        int left = start;
        int right = end;

        do  {

            Player lP = players[left];
            Player rP = players[right];

            // ищем элемент слева который больше опорного
            while (lP.compareTo(pivot) > 0) {
                left++;
                lP = players[left];
            }

            // ищем элемент справа который больше опорного
            while (rP.compareTo(pivot) < 0) {
                right--;
                rP = players[right];
            }

            // если такие есть то меняем местами
            if (left <= right) {
                Player temp = players[left];
                players[left] = players[right];
                players[right] = temp;
                left++;
                right--;
            }
        } while ((left <= right));

        // рекурсивно запускаем для левой части
        if (start < right) {
            quickSort(players, start, right);
        }

        // рекурсивно запускаем для правой части
        if (left < end) {
            quickSort(players, left, end);
        }
    }

    /**
     * вспомогательный класс для игроков
     * Сравниваем сначала по очкам, затем по штрафным очкам и потом уже по имени
     */
    private static class Player implements Comparable<Player>{
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
