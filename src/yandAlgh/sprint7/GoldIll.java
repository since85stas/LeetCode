package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class GoldIll {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] prices = new int[n];
        int[] masses = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());
            masses[i] = m;
            prices[i] = p;
        }

        for (int i = 0; i < n - 1; i++) {

        }


        System.out.println();
    }

}
