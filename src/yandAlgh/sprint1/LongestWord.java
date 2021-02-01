package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class LongestWord {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine(), " ");
        int len = 0;
        String word = "";
        while (tokenizerStr.hasMoreTokens()) {
//            list.add(String.valueOf(tokenizerStr.nextToken()));
            String curWord = String.valueOf(tokenizerStr.nextToken());
            if (curWord.length() > len) {
                len = curWord.length();
                word = curWord;
            }
        }
        System.out.println(word);
        System.out.println(len);
    }

}
