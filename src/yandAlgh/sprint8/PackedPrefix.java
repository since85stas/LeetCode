package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

/**
 *
 * <p>
 * сложность распаковки линейная по идее. Сложность нахождения префикса O (m * n) n - число строк, m - мин размер строки
  * <p>
 * успешная посылка  https://contest.yandex.ru/contest/25597/run-report/51582252/
 */
public class PackedPrefix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        int n = Integer.parseInt(reader.readLine());
        String[] unpacked = new String[n];
        for (int i = 0; i < n; i++) {
            unpacked[i] = unpack(new StringBuilder(reader.readLine()));
        }

        String longest = longestCommonPrefix2(unpacked);
        System.out.println(longest);
    }

    private static String unpack(StringBuilder packed) {
        StringBuilder unpacked = new StringBuilder();
//        StringBuilder cash = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> mult = new Stack<>();
        stack.push(unpacked);
        for (int i = 0; i < packed.length(); i++) {
            char elem  =packed.charAt(i);
            if (elem == '[') {
                StringBuilder sub = new StringBuilder();
                stack.push(sub);
            } else if (elem == ']') {
                int m = mult.pop();
                StringBuilder ss = stack.pop();
                for (int j = 0; j < m; j++) {
                    stack.peek().append(ss);
                }
            } else if (elem >= '1'  && elem <= '9' ) {
//                stack.peek().append(elem);
                mult.push(Character.getNumericValue((elem)));
            } else {
                stack.peek().append(elem);
            }
        }
        return unpacked.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


}
