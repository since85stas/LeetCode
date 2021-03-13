package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class TwoBikes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        int[] money = new int[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        tokenizerStr = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(tokenizerStr.nextToken());

        buyBicicles(money, s);
    }

    private static void buyBicicles(int[] money, int pr) {

//        pr = 5;

        int res = binaryRecurs(money, pr, 0, money.length);
        System.out.print(res+1 + " ");

        res = binaryRecurs(money, pr*2, 0, money.length);
        System.out.print(res+1);
    }

    private static int binaryRecurs(int[] money, int goal, int leftI, int rightI) {
        if (rightI == leftI) {
            if (rightI < money.length && money[leftI] >=goal) {
                return leftI;
            } else {
                return -2;
            }
        } else if (rightI < leftI) {
            return -2;
        }
        int mid = (rightI + leftI)/2;
        if (goal <= money[mid]) {
            return binaryRecurs(money, goal, leftI, mid);
        } else if (goal > money[mid]) {
            return binaryRecurs(money, goal, mid + 1, rightI);
        }
        return 0;
    }
}
