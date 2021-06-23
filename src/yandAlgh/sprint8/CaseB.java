package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

public class CaseB {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input4.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s = tokenizer.nextToken();

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            trie.put(tokenizer.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        trie.checkWord(s, 0, result);

        // если в результат ничего не добавили значит разбить нельзя
        if (result.size() == 0) System.out.println("NO");
        else System.out.println("YES");

    }


    static class Trie {

        private static class Node {
            //            private Integer value;
            private Node[] next = new Node[R];
            boolean isEnd;
        }

        private static final int R = 26;
        private Node root = new Node();

        public void put(String key) {
            root = put(root, key, 0);
        }

        private Node put(Node x, String key, int d) {
            if (x == null) x = new Node();
            if (d == key.length()) {
                x.isEnd = true;
                return x;
            }
            char c = key.charAt(d);
            x.next[c - 'a'] = put(x.next[c - 'a'], key, d + 1);
            return x;
        }

        public boolean checkWord(String word, int index, List<Integer> result) {
            if (result.size() > 0) return true;
            Node curr = root;

            for (int i = index; i < word.length(); i++) {
                if (curr.next[word.charAt(i) - 'a'] == null)
                    return false;
                if (curr.next[word.charAt(i) - 'a'].isEnd) {
                    if (i == word.length() - 1) {
                        // если доходим до конца слова и оно присутствует то результат есть
                        result.add((index));
                        return true;
                    }
                    checkWord(word, i + 1, result);
                }
                if (result.size() > 0) return true;
                curr = curr.next[word.charAt(i) - 'a'];
            }
            return false;
        }


    }


}
