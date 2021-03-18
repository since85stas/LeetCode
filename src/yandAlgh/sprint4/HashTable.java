package yandAlgh.sprint4;

import yandAlgh.sprint2.QueeLimit;

import java.io.*;
import java.util.StringTokenizer;

public class HashTable {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizerStrC = new StringTokenizer(reader.readLine());
            String command = tokenizerStrC.nextToken();

        }
    }
//        System.out.println("end");

}
