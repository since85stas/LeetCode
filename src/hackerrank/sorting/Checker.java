package hackerrank.sorting;

import java.util.Comparator;

public class Checker implements Comparator<Checker.Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score < b.score) {
            return 1;
        } else if ( a.score > b.score) {
            return -1;
        } else {
            if (a.name.equals(b.name)) {
                return 0;
            } else return compStringAlphabet(a.name,b.name);
        }
    }

    public int compStringAlphabet(String a, String b) {
        int mult = 1;
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
            mult = -1;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return -1*mult;
            } else if (a.charAt(i) > b.charAt(i)) {
                return 1*mult;
            }
        }
        return 1*mult;
    }

    static class Player {

        int score;
        String name;

        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }

    }
}
