package yandAlgh.sprint8;

import java.io.*;
import java.util.*;

public class StringInsert {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s = (tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

//        int[] pos = new int[n];
//        String[] strings = new String[n];
//        Insert[] inserts = new Insert[n];
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

        StringBuilder builder = new StringBuilder();

        int start = 0;
        for (int i = 0; i < n; i++) {
            Insert insert = inserts.pollFirst();
//            s.insert(insert.start + offs, insert.str);
//            offs += insert.str.length;
            builder.append(s, start, insert.start).append(insert.str);
            start = insert.start;
        }
        if (start < s.length() && start > 0) builder.append(s, start, s.length());
        System.out.println(builder.toString());
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
