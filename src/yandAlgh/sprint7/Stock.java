package yandAlgh.sprint7;

import java.io.*;
import java.util.StringTokenizer;

public class Stock {

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

        long sum = 0;
        boolean buy = false;
        short buyPrice = 0;

        for (int i = 0; i < n - 1; i++) {
            short a = prices[i];
            short b = prices[i+1];
            if (!buy) {
                if (b > a) {
                    buy = true;
                    buyPrice = a;
                } else {

                }
            } else {
                if (b < a) {
                    buy = false;
                    sum += a - buyPrice;
                }
            }
        }
        if (buy) {
            sum += prices[n-1] - buyPrice;
        }
//        StringBuilder builder = new StringBuilder();

        System.out.println(sum);
    }

}
