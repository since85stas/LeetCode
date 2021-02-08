package yandAlgh.sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NearestNull2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int len = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[len];
        List<Integer> nullPositions= new ArrayList<>();

        tokenizer = new StringTokenizer(reader.readLine()," ");
        for (int i = 0; i < len; i++) {
            int val = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = val;
            if (val ==0) {
                nullPositions.add(i);
            }
        }

    }

}
