package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

public class Shrarg {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringBuilder sb = new StringBuilder(reader.readLine());
//        sb.append("#");
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

        int start = 0;
        boolean check = false;
        boolean isOk = true;

        List<String> result = new ArrayList<>();

        trie.testWord(s,0, new String(), result);

        if (result.size() == 0) System.out.println("NO");
        else System.out.println("YES");

//        for (int i = 0; i < s.length(); i++) {
//
//            String pref = s.substring(start,i+1);
//            if (pref.equals("#")) break;
////            Queue<String > qu =  trie.keysWithPrefix(pref);
//            if (!trie.containsP(pref)) {
//                if (check) {
//                    isOk = false;
//                    break;
//                } else {
//                    check = true;
//                    i = i-2;
//                }
//            } else {
//                if (check) {
//                    if (trie.contains(pref)) {
////                        builder.append(pref);
//                        start = i + 1;
//                        check = false;
//                    } else {
//                        isOk = false;
//                        break;
//                    }
//                }
//            }
//        }
//        if (isOk) System.out.println("YES");
//        else System.out.println("NO");
//        System.out.println();
    }




    static class Trie {

        private static final int R = 256;
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

        public boolean containsP(String key)
        { return containshPrefix(key) != null; }

        public Node containshPrefix(String prefix)
        {
            Node x = get(root, prefix, 0);
            if (x == null) return null;
            else return  x;
        }

        public void testWord(String word, int index, String s, List<String> result)
        {
            Node curr = root;

            for(int i=index; i<word.length();i++)
            {
                if(curr.next[word.charAt(i)]==null)
                    return;
                if(curr.next[word.charAt(i)].value !=null)
                {
                    if(i==word.length()-1)
                    {
                        result.add(new String(s) + word.substring(index, i+1));
                        return;
                    }

                    testWord(word, i+1, s + word.substring(index, i+1) + " ", result);
                }
                curr = curr.next[word.charAt(i)];
            }
        }

    }

}
