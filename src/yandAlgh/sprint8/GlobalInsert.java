package yandAlgh.sprint8;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GlobalInsert {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder s = new StringBuilder(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        System.out.println(s.toString());
    }

}
