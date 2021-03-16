package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PartialSort {

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

        HashSet<Integer> set = new HashSet<>();

        int count = 0;
        int lastVal = 0;

        for (int i = 0; i < n; i++) {
            set.add(i);

            boolean isOk = true;
            for (int j = i; j >= lastVal; j--) {
                if ( !set.contains(squares[j]) ) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                set = new HashSet<>();
                lastVal = i+1;
                count++;
            }
        }
        System.out.println(count);
    }



}
