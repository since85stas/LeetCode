package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cookies {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        final int n = Integer.parseInt(tokenizerStr.nextToken());

        Integer[] kids = new Integer[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            kids[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        tokenizerStr = new StringTokenizer(reader.readLine());
        final int m = Integer.parseInt(tokenizerStr.nextToken());

        Integer[] cook = new Integer[m];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            cook[i] = Integer.parseInt(tokenizerStr.nextToken());
        }

        Arrays.sort(kids);
        Arrays.sort(cook);

        int countKids = 0;
        int countCook = 0;
        int happy  = 0;
        while (countKids < kids.length && countCook < cook.length) {
            if (kids[countKids] <= cook[countCook]) {
                happy = happy + 1;
                countKids = countKids + 1;
                countCook = countCook + 1;
            } else {
                countCook = countCook + 1;
            }
        }
        System.out.println(happy);
    }

}
