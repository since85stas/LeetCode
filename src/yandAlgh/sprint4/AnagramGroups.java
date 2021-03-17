package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class AnagramGroups {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short a = Short.parseShort(tokenizer.nextToken());
        String[] strings = new String[a];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < a; i++) {
            strings[i] = tokenizer.nextToken();
        }
        List<List<String>> anagr = groupAnagrams(strings);
        System.out.println();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    static class Anagr {

        short pos;

        String text;



    }
}
