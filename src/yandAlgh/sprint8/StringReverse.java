package yandAlgh.sprint8;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class StringReverse {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            stack.add(tokenizer.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        System.out.println(builder.toString());
    }

}
