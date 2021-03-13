package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Bubble {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());

        short n = Short.parseShort(tokenizerStr.nextToken());

        short[] massive = new short[n];
        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            massive[i] = Short.parseShort(tokenizerStr.nextToken());
        }

        buubleSort(massive);
    }

    private static void buubleSort(short[] mass) {
        boolean isChanged = false;
        int counter = 0;
        for (short i = 1; i < mass.length; i++) {
            for (short j = 0; j < mass.length-1; j++) {
                if (mass[j] > mass[j+1]) {
                    short temp = mass[j];
                    mass[j] = mass[j+1];
                    mass[j+1] = temp;
                    isChanged = true;
                    counter++;
                }
            }
            if (isChanged) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < mass.length; j++) {
                    builder.append(mass[j]);
                    builder.append(" ");
//                    System.out.print(mass[j]);
//                    System.out.print(" ");
                }
                builder.append("\n");
                System.out.print(builder.toString());
                isChanged = false;
            }
        }
        if (counter == 0) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < mass.length; j++) {
                builder.append(mass[j]);
                builder.append(" ");
//                    System.out.print(mass[j]);
//                    System.out.print(" ");
            }
            builder.append("\n");
            System.out.print(builder.toString());
        }
    }
}
