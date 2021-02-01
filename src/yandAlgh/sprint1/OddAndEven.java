package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class OddAndEven {

    public static void main(String[] args) throws IOException {
//        StringBuilder output_buffer = new StringBuilder();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        if (isAllEquals(a,b,c)) System.out.println("WIN");
        else System.out.println("FAIL");
    }

    static boolean isAllEquals(int a, int b, int c) {
        boolean aType = isNumberEven(a);
        boolean bType = isNumberEven(b);
        if (bType != aType) return false;
        boolean cType = isNumberEven(c);
        if (cType != bType) return false;
        return true;
    }

    static boolean isNumberEven(int num) {
        return num%2 == 0;
    }
}
