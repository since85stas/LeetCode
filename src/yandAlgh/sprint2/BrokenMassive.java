package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BrokenMassive {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        int[] mass = new int[n];

        int min = Integer.MAX_VALUE;
        int pos = 0;

        tokenizerStr = new StringTokenizer(reader.readLine());
        if (tokenizerStr.hasMoreTokens()) {
            mass[0] = Integer.parseInt(tokenizerStr.nextToken());
            min = mass[0];
        }
        int out = -1;
        if (tokenizerStr.hasMoreTokens()) {
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(tokenizerStr.nextToken());
                mass[i] = val;
                if (val >= min) {
                    min = val;
                } else {
                    if (pos == 0) pos = i;
                }
            }

            int first = binarySearch(Arrays.copyOfRange(mass, 0, pos), k);
            if (first != -1) {
                out = first;
            } else {
                int second = binarySearch(Arrays.copyOfRange(mass, pos, mass.length), k);
                if (second != -1) {
                    out = pos + second;
                }
            }
            System.out.println(out);
        } else {
            if (mass.length > 0) {
                if(mass[0] == k) System.out.println(0);
                else System.out.println(-1);
            }
        }

    }

    private static int binarySearch(int[] mass , int el) {
        int left = 0;
        int right = mass.length-1;
        while (right-left > 1){
            int mid = left + (right-left)/2;
            if (el == mass[mid]) {
                return mid;
            } else if (el < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (mass[left] == el) return left;
        if (mass[right] == el) return right;
        return -1;
    }

}
