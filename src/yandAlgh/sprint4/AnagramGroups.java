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
        List<List<Anagr>> anagr = groupAnagrams(strings);

        Collections.sort(anagr, new Comparator<List<Anagr>>() {
            @Override
            public int compare(List<Anagr> anagrs, List<Anagr> t1) {
                return Short.compare(anagrs.get(0).pos, t1.get(0).pos);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (List<Anagr> list:
             anagr) {
            for (Anagr an:
                 list) {
                builder.append(an.pos).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static List<List<Anagr>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        short pos = 0;
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
            ans.get(key).add(new Anagr(pos, s));

            pos++;
        }
        return new ArrayList(ans.values());
    }

    static class Anagr {

        short pos;

        String text;

        Anagr(short pos, String text) {
            this.pos = pos;
            this.text = text;
        }

    }
}
