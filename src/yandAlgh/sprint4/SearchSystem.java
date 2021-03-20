package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class SearchSystem {

    static HashMap<Integer, HashMap<String, Integer>> docs;
    static HashMap<String, List<Integer>> words;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input2.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Integer n = Integer.parseInt(tokenizer.nextToken());

        // создаем поисковую систему
        docs = new HashMap<>();
        words = new HashMap<>();
        for (Integer i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            docs.put(i, new HashMap<>());
            while (tokenizer.hasMoreTokens()) {
                String str = tokenizer.nextToken();
                if (docs.get(i).containsKey(str)) {
                    Integer num = docs.get(i).get(str);
                    docs.get(i).put(str,(Integer) (num+1));
                } else {
                    docs.get(i).put(str, (Integer)1);
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
        Integer m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            HashMap<Integer, Integer> relevance = new HashMap<>();

            HashSet<String> uniqe = new HashSet<>();
            while (tokenizer.hasMoreTokens()) {
                String req = tokenizer.nextToken();
//                TreeSet<Integer> relev = new TreeSet<>();
                if (!uniqe.contains(req)) {
                    uniqe.add(req);
                    List<Integer> buckets = words.get(req);
                    byte limit = 5;
                    if (buckets != null) {
                        for (Integer buckId :
                                buckets) {
                            Integer count = docs.get(buckId).get(req);
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
            }
            List<Pair> result = new ArrayList<>();

            for (Integer id:
            relevance.keySet()) {
                result.add(new Pair(id, relevance.get(id)));
            }

            Collections.sort(result);

            StringBuilder builder = new StringBuilder();
            byte coont = 0;
            for (Pair pair :
                    result) {
                builder.append(pair.id).append(" ");
                coont++;
                if (coont >=5) {
                    break;
                }
            }
            if (builder.length() > 0) System.out.println(builder.toString());

        }




//        System.out.println();
    }

    static class Pair implements Comparable<Pair>{
        Integer id;

        int num;

        Pair(Integer id, int num) {
            this.id = id;
            this.num = num;
        }

        @Override
        public int compareTo(Pair pair) {
            if (num != pair.num) return Integer.compare(pair.num, num);
            else return Integer.compare(id, pair.id);
        }
    }

}
