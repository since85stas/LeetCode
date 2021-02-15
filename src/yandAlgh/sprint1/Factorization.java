package yandAlgh.sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Factorization {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        List<Integer> mult = new ArrayList<>();
        int i = 2;
        int numN = n;
        int ost = 0;
        while (i*i < n) {
            if (numN < i) break;
            ost = numN%i;
            if (ost == 0) {
                mult.add(i);
                numN = numN/i;
            } else {
                i++;
            }
        }
        if (ost != 0 || n == 2) mult.add(numN);
        mult.stream().forEach(it -> System.out.print(it + " "));
    }

}
