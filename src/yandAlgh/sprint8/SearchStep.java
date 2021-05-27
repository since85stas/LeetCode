package yandAlgh.sprint8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SearchStep {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int pos = Integer.parseInt(tokenizer.nextToken());
            arr[i] = pos;
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] s = new int[m];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int pos = Integer.parseInt(tokenizer.nextToken());
            s[i] = pos;
        }

//        int[] del = new int[m-1];
//        for (int i = 1; i < m; i++) {
//            del[i-1] = s[i] - s[i-1];
//        }

        int start = 0;
        int find = 0;
        List<Integer> res = new ArrayList<>();
        while (find >= 0) {
            find = findPattern(arr, s,start);
            if (find> 0) res.add(find);
            start = find;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer i:
             res) {
            builder.append(i).append(" ");
        }
        System.out.println(builder.toString());
    }

    static int findPattern(int[] arr, int[] sh, int start) {
        if (arr.length < sh.length) return -1;

        for (int i = start; i < arr.length - sh.length+1; i++) {
            int[] minus = new int[sh.length];
            for (int j = 0; j < sh.length; j++) {
                minus[j] = arr[i+j]-sh[j];
            }
            boolean match  = true;
            for (int j = 1; j < minus.length; j++) {
                match = match&& (minus[j] == minus[j-1]);
            }
            if (match) return i+1;
        }

        return -1;
    }

}
