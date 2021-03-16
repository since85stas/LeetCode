package yandAlgh.sprint4;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class StrangeEquals {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s1 = tokenizer.nextToken();

        tokenizer = new StringTokenizer(reader.readLine());
        String s2 = tokenizer.nextToken();

        if (s1.length() != s2.length()) {
            System.out.println("NO");
        } else {

        }
    }


}
