package yandAlgh.sprint1;

import java.io.*;
import java.util.*;

public class Near {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        short m = Short.parseShort(tokenizer.nextToken());

        short[][] array = new short[n][m];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Short.parseShort(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        short goalN = Short.parseShort(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        short goalM = Short.parseShort(tokenizer.nextToken());

        List<Short> naerest = new ArrayList<>();

        if (goalN != 0) {
            naerest.add(array[goalN-1][goalM]);
        }
        if (goalN != n-1) {
            naerest.add(array[goalN+1][goalM]);
        }
        if (goalM != 0) {
            naerest.add(array[goalN][goalM-1]);
        }
        if (goalM != m-1) {
            naerest.add(array[goalN][goalM+1]);
        }
        Collections.sort(naerest);

        StringBuilder result = new StringBuilder();
        for (Short s:
             naerest) {
            result.append(s);
            result.append(" ");
        }
        System.out.println(result.toString().trim());
    }

}
