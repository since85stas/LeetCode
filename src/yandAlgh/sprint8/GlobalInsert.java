package yandAlgh.sprint8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GlobalInsert {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        String str = reader.readLine();
        String sh = reader.readLine();
        String t = reader.readLine();

        int shLen = sh.length();

        StringBuilder app = new StringBuilder(sh);
        app.append("#").append(str);

        int[] pre = countPref(app.toString());
        List<Integer> insr = new ArrayList<>();
        for (int i = 0; i < pre.length -shLen -1; i++) {
            if (pre[i+shLen+1] == shLen) {
                insr.add(i-shLen+1);
            }
        }

        StringBuilder res = new StringBuilder();
        int start = 0;
        for (Integer pos :
                insr) {
            res.append(str, start, pos);
            res.append(t);
            start = pos+sh.length();
        }
        if (start < str.length() && start > 0) res.append(str, start, str.length());
        System.out.println(res.toString());
    }

    private static int[] countPref(String s) {
        int[] pi = new int[s.length()];
        pi[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int k = pi[i-1];
            while (k >0 && s.charAt(k) != s.charAt(i)) {
                k = pi[k-1];
            }
            if (s.charAt(i) == s.charAt(k)) {
                k +=1;
            }
            pi[i] = k;
        }

        return pi;
    }

}
