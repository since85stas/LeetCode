package yandAlgh.sprint3;

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
    }

    private static void buyBicicles(int[] money, int pr) {

        System.out.println("test");
    }

}
