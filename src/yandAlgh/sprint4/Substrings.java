package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class Substrings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s = tokenizer.nextToken();

        HashSet<String> setNoDubl = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subs = s.substring(i,j);
//                System.out.println(subs);
                HashSet<Character> chars = new HashSet<>();
                boolean add = true;
                for (int k = 0; k < subs.length(); k++) {
                    add = chars.add(subs.charAt(k));
                    if (!add) break;;
                }
                if (add) {
                    setNoDubl.add(subs);
                }
            }
        }

        List<String> list = new ArrayList<>();

        list.addAll(setNoDubl);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() == t1.length()) return 0;
                else if (s.length() < t1.length()) return 1;
                else return -1;
            }
        };

        list.sort( comparator );
        if (list.size() > 0) {
            System.out.println(list.get(0).length());
        } else {
            System.out.println(0);
        }
    }



}
