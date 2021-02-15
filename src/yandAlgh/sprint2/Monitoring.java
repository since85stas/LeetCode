package yandAlgh.sprint2;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Monitoring {

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
//
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//        short n = Short.parseShort(tokenizer.nextToken());
//
//        tokenizer = new StringTokenizer(reader.readLine());
//        short m = Short.parseShort(tokenizer.nextToken());

        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        short m = scanner.nextShort();

        short[][] array = new short[n][m];

        for (short i = 0; i < n; i++) {
//            tokenizer = new StringTokenizer(reader.readLine());
            for (short j = 0; j < m; j++) {
                array[i][j] = scanner.nextShort();
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
