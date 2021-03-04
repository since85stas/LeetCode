package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class GoldenMid {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        tokenizerStr = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizerStr.nextToken());

        int[] south = new int[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            south[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        int[] north = new int[m];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            north[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        System.out.println("енд");
    }

}
