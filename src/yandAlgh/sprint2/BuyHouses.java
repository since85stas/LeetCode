package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuyHouses {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int n = Integer.parseInt(tokenizerStr.nextToken());
        int m = Integer.parseInt(tokenizerStr.nextToken());

        Integer[] prices = new Integer[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(tokenizerStr.nextToken());
        }
        Arrays.sort(prices);
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= m) {
                count = count + 1;
                m = m - prices[i];
            } else {
                break;
            }
        }

        System.out.println(count);
    }

}
