package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringBuilder initString = new StringBuilder();
        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine(), " ");
        while (tokenizerStr.hasMoreTokens()) {
            initString.append(tokenizerStr.nextToken().toLowerCase());
        }

        String letters = initString.toString().replaceAll("[\\W_]+", "");
        String reverse = new StringBuilder(letters).reverse().toString();
        if (letters.equals(reverse)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}
