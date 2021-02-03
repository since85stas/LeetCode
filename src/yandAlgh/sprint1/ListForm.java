package yandAlgh.sprint1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ListForm {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short len = Short.parseShort(tokenizer.nextToken());

        StringBuilder numb1Str = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine()," ");
        for (int i = 0; i < len; i++) {
            numb1Str.append(tokenizer.nextToken());
        }
        short numb1 = Short.parseShort(numb1Str.toString());

        tokenizer = new StringTokenizer(reader.readLine()," ");
        short numb2 = Short.parseShort(tokenizer.nextToken());

        int sum = numb1 + numb2;
        String sumStr = String.valueOf(sum);

        Arrays.stream(sumStr.split("")).forEach(it -> System.out.print(it + " "));

//        System.out.println("e");
    }


}
