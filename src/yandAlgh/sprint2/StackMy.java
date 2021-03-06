package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackMy {

    static private Stack<Long> stack = new Stack<>();

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
                long num = Long.parseLong(tokenizerStr.nextToken());
                push(num);
            }
        }
    }


    static void push(long val) {
        stack.push(val);
    }

    static void pop() {
        if (stack.empty()) {
            System.out.println( "error");
        } else {
            long val = stack.pop();
        }
    }

    static String getMax() {
        if (stack.empty()) {
            return "None";
        } else {
            long max = Long.MIN_VALUE;
            for (long num:
                 stack) {
                if (num > max) {
                    max = num;
                }
            }
            return String.valueOf(max);
        }
    }

}
