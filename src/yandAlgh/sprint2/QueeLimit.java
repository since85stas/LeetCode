package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class QueeLimit {

    private static int sizeMax;

    private static int size;

    private static Node first = null;

    private static Node last = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int nCom = Integer.parseInt(tokenizerStr.nextToken());

        tokenizerStr = new StringTokenizer(reader.readLine());
        sizeMax = Integer.parseInt(tokenizerStr.nextToken());

        for (int i = 0; i < nCom; i++) {
            StringTokenizer tokenizerStrC = new StringTokenizer(reader.readLine());

            String command = tokenizerStrC.nextToken();
            if (command.equals("peek")) {
                if (size > 0) {
                    System.out.println(first.val);
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("size")) {
                System.out.println(size);
            } else if (command.equals("push")) {
                int num = Integer.parseInt(tokenizerStrC.nextToken());
                if (first==null && last == null) {
                    Node newNode = new Node(num, null);
                    first = newNode;
                    last = newNode;
                    size++;
                } else {
                    if (size < sizeMax) {
                        if (size == 1) {
                            Node newNode = new Node(num, null);
                            first.prev = newNode;
                            last = newNode;
                            size++;
                        } else {
                            Node newNode = new Node(num, null);
                            last.prev = newNode;
                            last = newNode;
                            size++;
                        }
                    } else {
                        System.out.println("error");
                    }
                }
            } else if (command.equals("pop")) {
                if (size == 0) {
                    System.out.println("None");
                } else if (size == 1) {
                    System.out.println(first.val);
                    first = null;
                    last = null;
                    size--;
                } else {
                    System.out.println(first.val);
                    first = first.prev;
                    size--;
                }
            }
        }
//        System.out.println("end");
    }

    static class Node {

        Node prev;

        int val;

        public Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }

    }

}
