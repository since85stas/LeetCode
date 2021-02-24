package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class Deck {

    private static Node first;
    private static Node last;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizerStr.nextToken());
        tokenizerStr = new StringTokenizer(reader.readLine());
        short m = Short.parseShort(tokenizerStr.nextToken());



        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            String command = tokenizerStr.nextToken();
            if (command.equals("push_back")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                if (isEmpty()) {
                    Node node = new Node(val,null,null);
                    first = node;
                    last = node;
                } else {
                    Node node = new Node(val,last,null);
                    last.prev = node;
                    last = node;
                }
            } else if (command.equals("push_front")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                if (isEmpty()) {
                    Node node = new Node(val,null,null);
                    first = node;
                    last = node;
                } else {
                    Node node = new Node(val,null,first);
                    first.next = node;
                    first = node;
                }
            } else if (command.equals("pop_back")) {

            } else if (command.equals("pop_front")) {

            }
        }
    }

    private static boolean isEmpty() {
        return first==null && last == null;
    }

    private static class Node {

        private short val;

        private Node next;

        private Node prev;

        public Node(short val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

}
