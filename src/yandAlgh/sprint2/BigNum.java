package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BigNum {

    public static void main(String[] args) throws IOException {
        compare(false, null);
    }

    static String compare(boolean test , Integer[] masIn) throws IOException {
        int n = 0;
        String[] massive;
        if (test) {
            n = masIn.length;
            massive = new String[n];
            int count = 0;
            for (Integer in: masIn
                 ) {
                massive[count] = String.valueOf(masIn[count]);
                count++;
            }
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

            StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(tokenizerStr.nextToken());

            massive = new String[n];
            tokenizerStr = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                massive[i] = (tokenizerStr.nextToken());
            }
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s, String s1) {
                int first = Integer.parseInt(s + s1);
                int second = Integer.parseInt(s1 + s);
                if (first > second) return -1;
                else if (first < second) return 1;
                else return 0;
            }
        };

        StringBuilder builder = new StringBuilder();
//        Arrays.stream(massive).mapToObj(it -> Integer.valueOf(it)).sorted(comp).forEach(it -> builder.append(it));
        Arrays.sort(massive, comp);
        for (String i: massive
        ) {
            builder.append(i);
        }
        if (test) {
            return builder.toString();
        } else {
            System.out.println(builder.toString());
            return "";
        }
    }


}
