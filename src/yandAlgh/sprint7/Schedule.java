package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class Schedule {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        short[] prices = new short[n];
        for (int i = 0; i < n; i++) {
            short p = Short.parseShort(tokenizer.nextToken());
            prices[i] = p;
        }

//        StringBuilder builder = new StringBuilder();

        System.out.println();
    }

}
