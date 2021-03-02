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
        Integer[] massive;
        if (test) {
            n = masIn.length;
            massive = masIn;
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

            StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(tokenizerStr.nextToken());

            massive = new Integer[n];
            tokenizerStr = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                massive[i] = Integer.parseInt(tokenizerStr.nextToken());
            }
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer int1in, Integer int2in) {
                String str1 = String.valueOf(int1in);
                String str2 = String.valueOf(int2in);
                StringBuilder int1 =new StringBuilder(String.valueOf(int1in));
                StringBuilder int2 =new  StringBuilder(String.valueOf(int2in));
                if (str1.length() > str2.length()) {
                    for (int i = 0; i < str1.length() - str2.length(); i++) {
                        int2.append(str2.charAt(str2.length()-1));
                    }
                } else if (str2.length() > str1.length()) {
                    for (int i = 0; i < str2.length() - str1.length(); i++) {
                        int1.append(str1.charAt(str1.length()-1));
                    }
                }
                for (int i = 0; i < int1.length(); i++) {
                    if (int1.charAt(i) > int2.charAt(i)) {
                        return -1;
                    } else if (int1.charAt(i) < int2.charAt(i)) {
                        return 1;
                    }
                }

                if (str1.equals(str2)) return 0;
                if (str1.length() < str2.length()) {
                    if (str1.charAt(0) < str1.charAt(str1.length()-1)) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (str1.length() > str2.length()) {
                    if (str2.charAt(0) < str2.charAt(str2.length()-1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 0;
            }
        };
        StringBuilder builder = new StringBuilder();
//        Arrays.stream(massive).mapToObj(it -> Integer.valueOf(it)).sorted(comp).forEach(it -> builder.append(it));
        Arrays.sort(massive, comp);
        for (Integer i: massive
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
