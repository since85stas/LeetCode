package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class SearchSystem {

    static HashMap<Short, HashMap<String, Short>> docs;
    static HashMap<String, List<Short>> words;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());


        // создаем поисковую систему
        docs = new HashMap<>();
        words = new HashMap<>();
        for (short i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            docs.put(i, new HashMap<>());
            while (tokenizer.hasMoreTokens()) {
                String str = tokenizer.nextToken();
                if (docs.get(i).containsKey(str)) {
                    short num = docs.get(i).get(str);
                    docs.get(i).put(str,(short) (num+1));
                } else {
                    docs.get(i).put(str, (short)1);
                }

                if (words.containsKey(str)) {
                    words.get(str).add(i);
                } else {
                    words.put(str, new ArrayList<>());
                    words.get(str).add(i);
                }
            }
        }

        // считываем запросы
        tokenizer = new StringTokenizer(reader.readLine());
        short m = Short.parseShort(tokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            HashMap<Short, Integer> relevance = new HashMap<>();

            int max = 0;
            while (tokenizer.hasMoreTokens()) {
                String req = tokenizer.nextToken();
//                TreeSet<Short> relev = new TreeSet<>();
                List<Short> buckets = words.get(req);
                byte limit = 5;
                if (buckets != null) {
                    for (Short buckId :
                            buckets) {
                        short count = docs.get(buckId).get(req);
//                    max = max + count;
                        if (relevance.containsKey(buckId)) {
                            int oldc = relevance.get(buckId);
                            relevance.put(buckId, oldc + count);
                        } else {
                            relevance.put(buckId, (int) count);
                        }
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
//            for (Short id:
//                 re) {
//
//            }
        }

        System.out.println();
    }

}