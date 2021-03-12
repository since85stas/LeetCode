package yandAlgh.sprint2;

import java.io.*;
import java.util.*;

public class TrashIndexes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Integer[] squares = new Integer[n];

        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(tokenizerStr.nextToken());
            squares[i] = val;
        }

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        
    }

}
