package yandAlgh.sprint7;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Travelers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(tokenizer.nextToken());
            c[i] = p;
        }
        int[] dp = new int[n];
        int[] p = new int[n];

        for (int i=0; i<n; ++i) {
            dp[i] = 1;
            p[i] = -1;
            for (int j = 0; j < i; ++j)
                if (c[j] < c[i])
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        p[i] = j;
                    }
        }

        int ans = dp[0];
        int pos = 0;
        for (int i=0; i<n; ++i) {
            if (dp[i] > ans) {
                ans = dp[i];
                pos = i;
            }
        }
        System.out.println(ans);
        LinkedList<Integer> list = new LinkedList<>();
        while (pos != -1) {
            list.push(pos);
            pos=p[pos];
        }
        StringBuilder builder = new StringBuilder();
//        Collections.reverse(list);
        for (Integer val :
                list) {
            builder.append(val+1).append(" ");
        }
        System.out.println(builder.toString());
    }

    static int startIndex = 0;
    static int maxLength;

    static void findMaxIncrSubseq(int[] a) {

    }

}
