package hackerrank.sorting;

import java.util.Arrays;

public class MarkToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (sum + prices[i] <= k) {
                count++;
                sum+=prices[i];
            }
        }
        return count;
    }

}
