package yandAlgh.sprint4;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SumFours {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(tokenizer.nextToken());

        int[] array = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        findTriplets(array, array.length);
        System.out.println();
    }

    // function to print triplets with 0 sum
    static void findTriplets(int arr[], int n)
    {
        boolean found = false;

        for (int i = 0; i < n - 1; i++)
        {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++)
            {

                int x = -(arr[i] + arr[j]);
                if (s.contains(x))
                {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                }
                else
                {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false)
        {
            System.out.printf(" No Triplet Found\n");
        }
    }

}
