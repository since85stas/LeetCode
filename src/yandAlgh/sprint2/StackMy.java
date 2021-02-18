package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackMy {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StackMy stackMy = new StackMy();

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizerStrC = new StringTokenizer(reader.readLine());

            String command = tokenizerStrC.nextToken();
            if (command.equals("get_max")) {
                System.out.println(stackMy.getMax());
            } else if (command.equals("pop")) {
                stackMy.pop();
            } else if (command.equals("push")) {
                int num = Integer.parseInt(tokenizerStrC.nextToken());
                stackMy.push(num);
            }
        }
    }

    private Stack<Integer> stack = new Stack<>();

    public StackMy() {

    }

    void push(int val) {
        stack.push(val);
//        if (max == null) {
//            max = val;
//        } else {
//            if (val > max) {
//                max = val;
//            }
//        }
    }

    void pop() {
        if (stack.empty()) {
            System.out.println( "Error");
        } else {
            long val = stack.pop();
        }
    }

    String getMax() {
//        if (max != null) {
//            return max.toString();
//        } else {
//            return "None";
//        }
        if (stack.empty()) {
            return "None";
        } else {
            int max = Integer.MIN_VALUE;
            for (int num:
                 stack) {
                if (num > max) {
                    max = num;
                }
            }
            return String.valueOf(max);
        }
    }

}
