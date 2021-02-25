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
        short sizeMax = Short.parseShort(tokenizerStr.nextToken());

        short size = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            String command = tokenizerStr.nextToken();
            if (command.equals("push_back")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                if (size < sizeMax) {
                    if (isEmpty()) {
                        Node node = new Node(val, null, null);
                        size++;
                        first = node;
                        last = node;
                    } else {
                        Node node = new Node(val, last, null);
                        last.prev = node;
                        last = node;
                        size++;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("push_front")) {
                if (size < sizeMax) {
                    short val = Short.parseShort(tokenizerStr.nextToken());
                    if (isEmpty()) {
                        Node node = new Node(val, null, null);
                        first = node;
                        last = node;
                        size++;
                    } else {
                        Node node = new Node(val, null, first);
                        first.next = node;
                        first = node;
                        size++;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_back")) {
                if (size > 0) {
                    if (size == 1) {
                        builder.append(last.val + "\n");
//                        System.out.println();
                        size--;
                        first = null;
                        last = null;
                    } else if (size == 2) {
                        builder.append(last.val + "\n");
//                        System.out.println(last.val);
                        size--;
                        last = last.next;
                        first = last;
                    } else {
                        builder.append(last.val + "\n");
//                        System.out.println(last.val);
                        size--;
                        last = last.next;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_front")) {
                if (size > 0) {
                    if (size == 1) {
                        builder.append(first.val + "\n");
//                        System.out.println();
                        size--;
                        first = null;
                        last = null;
                    } else if (size == 2) {
                        builder.append(first.val + "\n");
                        size--;
                        first = first.prev;
                        last = first;
                    } else {
                        builder.append(first.val + "\n");
                        size--;
                        first = first.prev;
                    }
                } else {
                    builder.append("error\n");
                }
            }
        }
        System.out.println(builder.toString().trim());
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
