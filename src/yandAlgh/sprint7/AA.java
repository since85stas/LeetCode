package yandAlgh.sprint7;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sum = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        Integer[] prices = new Integer[k];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            int p = Integer.parseInt(tokenizer.nextToken());
            prices[i] = p;
        }

        Arrays.sort(prices, (integer, t1) ->Integer.compare(t1, integer));
        int curSum = 0;
        int cup = 0;
        for (int i = 0; i < k && curSum < sum; i++) {
            int cel = (sum-curSum)/prices[i];
            curSum = cel*prices[i];
            cup += Math.max(cel,1);
        }
        System.out.println(cup);
    }

}
