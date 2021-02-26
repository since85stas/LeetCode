package yandAlgh.sprint2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Складываем комманды стек так как для правильной работы необходимо выполнять с конца
 *
 * сложность операций O(n)
 *
 * успешня посылка https://contest.yandex.ru/contest/22781/run-report/48791249/
 */
public class Calculator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());

        // стек для хранения комманд
        Stack<Integer> stack = new Stack<>();

        while (tokenizerStr.hasMoreTokens()) {
            String elem = tokenizerStr.nextToken();
            if (elem.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                int sum = num1 + num2;
                stack.add(sum);
            } else if (elem.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                int minus = num2 - num1;
                stack.add(minus);
            } else if (elem.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                int mult = num1 * num2;
                stack.add(mult);
            } else if (elem.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                double del = (float) num2 / (float) num1;
                double res = Math.floor(del);
                stack.add((int) res);
            } else {
                stack.add(Integer.parseInt(elem));
            }
        }

        System.out.println(stack.pop());
    }

}
