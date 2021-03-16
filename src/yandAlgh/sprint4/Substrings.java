package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class Substrings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s = tokenizer.nextToken();

//        setNoDubl = new HashSet<>();
        System.out.println(lengthOfLongestSubstring3(s));
//        soaddSubs2(s);

//        List<String> list = new ArrayList<>();
//
//        list.addAll(setNoDubl);
//
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                if (s.length() == t1.length()) return 0;
//                else if (s.length() < t1.length()) return 1;
//                else return -1;
//            }
//        };
//
//        list.sort( comparator );
//        if (list.size() > 0) {
//            System.out.println(list.get(0).length());
//        } else {
//            System.out.println(0);
//        }
    }

//    private static void addSubs1(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String subs = s.substring(i,j);
//                System.out.println(subs);
//                HashSet<Character> chars = new HashSet<>();
//                boolean add = true;
//                for (int k = 0; k < subs.length(); k++) {
//                    add = chars.add(subs.charAt(k));
//                    if (!add) break;;
//                }
//                if (add) {
//                    setNoDubl.add(subs);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//
//    private static void addSubs2(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String subs = s.substring(i,s.length());
//                System.out.println(subs);
//                HashSet<Character> chars = new HashSet<>();
//                boolean add = true;
//                for (int k = 0; k < subs.length(); k++) {
//                    add = chars.add(subs.charAt(k));
//                    if (!add) break;;
//                }
//                if (add) {
//                    setNoDubl.add(subs);
//                } else {
//                    break;
//                }
//            }
//        }
//    }

//    spublic static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

    public  static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

        public static int lengthOfLongestSubstring3(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
}
