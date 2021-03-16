package yandAlgh.sprint2;

import java.io.*;
import java.util.*;

public class TrashIndexes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        int[] squares = new int[n];

        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(tokenizerStr.nextToken());
            squares[i] = val;
        }

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        Arrays.sort(squares);

        System.out.println(kthDiff(squares, squares.length, k));
    }

    static int countPairs(int[] a, int n, int mid)
    {
        int res = 0, value;
        for(int i = 0; i < n; i++)
        {
            // Upper bound returns pointer to position
            // of next higher number than a[i]+mid in
            // a[i..n-1]. We subtract (ub + i + 1) from
            // this position to count
            int ub = upperbound(a, n, a[i]+mid);
            res += (ub- (i-1));
        }
        return res;
    }

    // returns the upper bound
    static int upperbound(int a[], int n, int value)
    {
        int low = 0;
        int high = n;
        while(low < high)
        {
            final int mid = (low + high)/2;
            if(value >= a[mid])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static int kthDiff(int a[], int n, int k)
    {

        // Minimum absolute difference
        int low = a[1] - a[0];
        for (int i = 1; i <= n-2; ++i)
            low = Math.min(low, a[i+1] - a[i]);

        // Maximum absolute difference
        int high = a[n-1] - a[0];

        // Do binary search for k-th absolute difference
        while (low < high)
        {
            int mid = (low + high) >> 1;
            if (countPairs(a, n, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

}
