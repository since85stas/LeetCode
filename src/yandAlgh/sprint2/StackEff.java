package yandAlgh.sprint2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackEff {

    static private Stack<Integer> stack = new Stack<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());

            String command = tokenizerStr.nextToken();
            if (command.equals("get_max")) {
                System.out.println(getMax());
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("push")) {
                int num = Integer.parseInt(tokenizerStr.nextToken());
                push(num);
            }
        }
    }


    static void push(int val) {
        stack.push(val);
        if (val > max) {
            max = val;
        }
    }

    static void pop() {
        if (stack.empty()) {
            System.out.println( "error");
        } else {
            int val = stack.pop();
            if (val == max) {
                max = val;
            }
        }
    }

    static String getMax() {
        if (stack.empty()) {
            return "None";
        } else {
            return String.valueOf(max);
        }
    }

}
