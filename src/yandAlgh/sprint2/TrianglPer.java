package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TrianglPer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Integer[] mass = new Integer[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            mass[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        Arrays.sort(mass, Collections.reverseOrder());

        System.out.println(findPer(mass));
    }

    private static int findPer(Integer[] mass) {
        int per = 0;
        for (int i = 0; i < mass.length-2 ; i++) {
            for (int j = i+1; j < mass.length-1; j++) {
                for (int k = j+1; k < mass.length; k++) {
                    if (mass[i] < mass[j] + mass[k]) {
                        per = mass[i] + mass[j] + mass[k];
                        return per;
                    }
                }
            }
        }
        return per;
    }

}
