package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

public class Shrarg {

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

        Boolean b = false;
        boolean res =  trie.testWord(s,0,result);

        if (!res) System.out.println("NO");
        else System.out.println("YES");

    }




    static class Trie {

        private static final int R = 26;
        private Node root = new Node();

        public void put(String key)
        { root = put(root, key,  0); }

        private Node put(Node x, String key, int d)
        {
            if (x == null) x = new Node();
            if (d == key.length()) { x.isEnd = true; return x; }
            char c = key.charAt(d);
            x.next[c - 'a'] = put(x.next[c- 'a'], key, d+1);
            return x;
        }

        public boolean contains(String key)
        { return get(key).isEnd; }

        public Node get(String key)
        {
            Node x = get(root, key, 0);
            if (x == null) return null;
            return  x;
        }

        private Node get(Node x, String key, int d)
        {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d);
            return get(x.next[c- 'a'], key, d+1);
        }

        private static class Node
        {
//            private Integer value;
            private Node[] next = new Node[R];
            boolean isEnd;
        }

        private void collect(Node x, String prefix, Queue<String> q)
        {
            if (x == null) return;
            if (!x.isEnd) q.add(prefix);
            for (char c = 0; c < R; c++)
                collect(x.next[c- 'a'], prefix + c, q);
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

        public boolean testWord(String word, int index, List<Integer> result)
        {
            if (result.size() > 0) return true;
            Node curr = root;

            for(int i=index; i<word.length();i++)
            {
                if(curr.next[word.charAt(i)- 'a']==null)
                    return false;
                if(curr.next[word.charAt(i)- 'a'].isEnd)
                {
                    if(i==word.length()-1)
                    {
                        result.add((index));
                        return true;
                    }
                    if (result.size() == 0) testWord(word, i+1, result);
                }
                if (result.size() > 0) return true;
                curr = curr.next[word.charAt(i)- 'a'];
            }
            return false;
        }

        public boolean testRoundTree(String word, int index, Boolean end) {
            Node curr = root;
            boolean res = false;
            for(int i=index; i<word.length();i++)
            {
                if(curr.next[word.charAt(i)- 'a']==null) {
                    end = false;
                    return false;
                }
                if(curr.next[word.charAt(i)- 'a'].isEnd)
                {
                    if(i==word.length()-1)
                    {
//                        result.add((index));
                        end = true;

                        return true;
                    }
                    res = testRoundTree(word, i+1, end);
                }
//                if (result.size() > 0) return true;
                curr = curr.next[word.charAt(i)- 'a'];
            }
            return end;
        }

        public boolean testDpc(String word, int index) {

            boolean[] visit = new boolean[R];

            for (int i = 0; i < word.length(); i++) {

            }
            return false;
        }

    }

}