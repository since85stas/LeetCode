package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class Monitoring2 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        final short n = Short.parseShort(reader.readLine());

//        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
        final short m = Short.parseShort(reader.readLine());

        final short[][] array = new short[n][m];

        for (short i = 0; i < n; i++) {
            StringTokenizer tokenizerL = new StringTokenizer(reader.readLine());
            for (short j = 0; j < m; j++) {
                array[i][j] = Short.parseShort(tokenizerL.nextToken());
            }
        }

//        StringBuilder builder = new StringBuilder();
        for (short i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
//                builder.append(array[j][i] + " ");
                System.out.print(array[j][i] + " ");
            }
            System.out.print("\n");
//            builder.append("\n");
        }

//        System.out.println(builder.toString());
    }

}
