package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

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

    private static void quickSort (Player[] players, int start, int end) {
        Random rand =new Random();
        int pos = start + rand.nextInt(end- start);
//        int pos = 2;
        Player pivot = players[pos];
        int left = start;
        int right = end;
        while (left <= right) {
            Player lP = players[left];
            Player rP = players[right];
            if (lP.compareTo(pivot) != 1 && rP.compareTo(pivot) != -1) {
                Player temp = players[left];
                players[left] = players[right];
                players[right] = temp;
                left++;
                right--;
            } else {
                if (lP.compareTo(pivot) == 1) {
                    left++;
                }
                if (rP.compareTo(pivot) == -1) {
                    right--;
                }
            }
        }

        if (pos - start > 1) {
            quickSort(players, start, pos-1);
        }

        if (end - pos > 1) {
            quickSort(players, pos, end);
        }
    }

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
                    return this.name.compareTo(other.name);
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

        @Override
        public int hashCode() {
            return Objects.hash(name, score, fail);
        }
    }

}
