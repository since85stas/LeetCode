package yandAlgh.sprint4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MnogoGosha {

    static Map<String, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        String s = tokenizer.nextToken();

        findOccurences(s,n);

        StringBuilder builder = new StringBuilder();
        for (String key :
                countMap.keySet()) {
                if (countMap.get(key) >= k) {
                    builder.append(s.indexOf(key)).append(" ");
                }
        }

        System.out.println(builder.toString());
    }

    public static void findOccurences(String str, int length) {
        int limit = str.length() - length + 1;
        for (int i = 0; i < limit; i++) {
            String sub = str.substring(i, i + length);
            Integer counter = countMap.get(sub);
            if (counter == null) {
                counter = 0;
            }
            countMap.put(sub, ++counter);
//            if (!beginMap.containsKey(sub)) {
//                beginMap.put(sub, i);
//            }
//            if (counter >= count) {
//                beginMap.put(sub, i - length);
//            }
        }
    }

    static int numberOccur(String text, String match) {
        int index = text.indexOf(match);
        int matchLength = match.length();
        int count = 0;
        while (index >= 0) {  // indexOf returns -1 if no match found
            index = text.indexOf(match, index + matchLength);
            count++;
        }
        return count;
    }

    public static int findFirst(String str, String find) {
        int limit = str.length() - find.length() + 1;
        for (int i = 0; i < limit; i++) {
            String sub = str.substring(i, i + find.length());
            if (sub.equals(find)) return i;
        }
        return -1;
    }

}
