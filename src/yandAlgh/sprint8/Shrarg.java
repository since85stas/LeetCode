package yandAlgh.sprint8;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Shrarg {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringBuilder sb = new StringBuilder(reader.readLine());
        sb.append("#");
        String s = sb.toString();
        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Trie trie = new Trie();

//        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
//            words[i] = tokenizerStr.nextToken();
            trie.put(tokenizerStr.nextToken(), i);
        }



//        for (int i = 0; i < words.length; i++) {
//            trie.put(words[i], i);
//        }
//        System.out.println(trie.contains("a"));
//        System.out.println(trie.contains("pass"));

//        Iterable<String >pref =  trie.keysWithPrefix("e");
        int start = 0;
        boolean check = false;
        boolean isOk = true;
//        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
//            if (i == s.length() -1) break;

            String pref = s.substring(start,i+1);
            if (pref.equals("#")) break;
            Queue<String > qu =  trie.keysWithPrefix(pref);
            if (qu.size() == 0) {
                if (check) {
                    isOk = false;
                    break;
                } else {
                    check = true;
                    i = i-2;
                }
            } else {
                if (check) {
                    if (trie.contains(pref)) {
//                        builder.append(pref);
                        start = i + 1;
                        check = false;
                    } else {
                        isOk = false;
                        break;
                    }
                }
            }
        }
        if (isOk) System.out.println("YES");
        else System.out.println("NO");
//        System.out.println();
    }


    static class Trie {

        private static final int R = 150;
        private Node root = new Node();

        public void put(String key, int val)
        { root = put(root, key, val, 0); }

        private Node put(Node x, String key, int val, int d)
        {
            if (x == null) x = new Node();
            if (d == key.length()) { x.value = val; return x; }
            char c = key.charAt(d);
            x.next[c] = put(x.next[c], key, val, d+1);
            return x;
        }

        public boolean contains(String key)
        { return get(key) != null; }

        public Integer get(String key)
        {
            Node x = get(root, key, 0);
            if (x == null) return null;
            return  x.value;
        }

        private Node get(Node x, String key, int d)
        {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d);
            return get(x.next[c], key, d+1);
        }

        private static class Node
        {
            private Integer value;
            private Node[] next = new Node[R];
        }

        private void collect(Node x, String prefix, Queue<String> q)
        {
            if (x == null) return;
            if (x.value != null) q.add(prefix);
            for (char c = 0; c < R; c++)
                collect(x.next[c], prefix + c, q);
        }

        public Queue<String> keysWithPrefix(String prefix)
        {
            Queue<String> queue = new LinkedList<>();
            Node x = get(root, prefix, 0);
            collect(x, prefix, queue);
            return queue;
        }

    }

}
