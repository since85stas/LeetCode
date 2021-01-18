package hackerrank.hashMaps;

import java.util.HashSet;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        if (s2.length()<s1.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
        final HashSet<String> set1 = new HashSet<>();
        final HashSet<String> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i+1; j < s1.length(); j++) {
                set1.add(s1.substring(i,j));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i+1; j < s2.length(); j++) {
                set2.add(s2.substring(i,j));
            }
        }
        if (set1.stream().anyMatch(str -> set2.contains(str))) return "YES";
        if (set2.stream().anyMatch(str -> set1.contains(str))) return "YES";
        return "NO";
    }

    // Complete the twoStrings function below.
    static String twoStrings2(String s1, String s2) {

        if (s2.length()<s1.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
        final HashSet<String> set1 = new HashSet<>();
        final HashSet<String> set2 = new HashSet<>();
        for (int i = 0; i < s1.length()-1; i++) {
                set1.add(s1.substring(i,i+1));
        }
        for (int i = 0; i < s2.length()-1; i++) {
                set2.add(s2.substring(i,i+1));
        }
        if (set1.stream().anyMatch(str -> set2.contains(str))) return "YES";
        if (set2.stream().anyMatch(str -> set1.contains(str))) return "YES";
        return "NO";
    }
}
