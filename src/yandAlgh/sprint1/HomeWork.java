package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class HomeWork {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        StringBuilder s = new StringBuilder();
        while (n > 0)
        {
            s.append  ( (n % 2 ) == 0 ? "0" : "1");
            n = n / 2;
        }
        System.out.println(s.reverse());
    }

}
