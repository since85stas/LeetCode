package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class ChaoticWether {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        short[] array = new short[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Short.parseShort(tokenizer.nextToken());
        }

        int  count = 0;
        for (int i = 1; i < array.length-1; i++) {
            if ( (array[i] > array[i-1]) && (array[i] > array[i+1])) {
                count++;
            }
        }
        if (array.length > 1 && array[0] > array[1]) {
            count++;
        }
        if (array.length > 1 && array[array.length-1] > array[array.length-2]) {
            count++;
        }
        if (array.length == 1) count++;
        System.out.println(count);
    }

}
