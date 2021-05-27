package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

public class StringInsert {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder s = new StringBuilder(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        TreeSet<Insert> inserts = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String str = tokenizer.nextToken();
            int pos = Integer.parseInt(tokenizer.nextToken());
//            inserts[i] = new Insert(str, pos);
            inserts.add(new Insert(str, pos));
        }
//        Arrays.sort(inserts);
        int offs = 0;

        for (int i = 0; i < n; i++) {
            Insert insert = inserts.pollFirst();
            s.insert(insert.start + offs, insert.str);
            offs += insert.str.length;
        }

        System.out.println(s.toString());
    }

    private static class Insert implements Comparable<Insert>{
        char[] str;
        int start;

        public Insert(String str, int start) {
            this.start = start;
            this.str = str.toCharArray();
        }

        @Override
        public int compareTo(Insert insert) {
            return Integer.compare( start, insert.start);
        }
    }

}
