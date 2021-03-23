package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

/**
 * успешная посылка https://contest.yandex.ru/contest/24414/run-report/49722871/
 */
public class SearchSystem {

    /**
     * Докенты храним по ключу номера документа. внутри тоже словать, где для каждого слова количество его
     * вхождения в данный доккумент
     */
    static HashMap<Integer, HashMap<String, Integer>> docs;

    /**
     * Для быстрого нахождения слова храним список всех уникальных слов во всех документах.
     * И список документов в которых оно встречается
     */
    static HashMap<String, HashSet<Integer>> words;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
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

                // заполняем документы
                if (docs.get(i).containsKey(str)) {
                    Integer num = docs.get(i).get(str);
                    docs.get(i).put(str, num + 1);
                } else {
                    docs.get(i).put(str, 1);
                }

                // заполняем список слов
                if (words.containsKey(str)) {
                    words.get(str).add(i);
                } else {
                    words.put(str, new HashSet<>());
                    words.get(str).add(i);
                }
            }
        }

        // считываем запросы
        StringBuilder builder = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        Integer m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            // словарь для общей релевантности корзин
            HashMap<Integer, Integer> relevance = new HashMap<>();

            // словарь для учитывания уникальности слов
            HashSet<String> uniqe = new HashSet<>();

            while (tokenizer.hasMoreTokens()) {
                String req = tokenizer.nextToken();

                if (!uniqe.contains(req)) {
                    uniqe.add(req);
                    List<Integer> buckets = new ArrayList<>();

                    // получаем список вхождения слова
                    if (words.get(req) != null) buckets.addAll(words.get(req));

                    // проходимся по списку и суммируем
                    for (Integer buckId :
                            buckets) {
                        Integer count = docs.get(buckId).get(req);
                        if (relevance.containsKey(buckId)) {
                            int oldc = relevance.get(buckId);
                            relevance.put(buckId, oldc + count);
                        } else {
                            relevance.put(buckId, (int) count);
                        }
                    }
                }
            }

            // представляем рез в виде пар номер документа-его релевантность
            List<Pair> result = new ArrayList<>();
            for (Integer id :
                    relevance.keySet()) {
                result.add(new Pair(id, relevance.get(id)));
            }

            // сортируем
            Collections.sort(result);

            // берем пять первых
            byte coont = 0;
            for (Pair pair :
                    result) {
                builder.append(pair.id).append(" ");
                coont++;
                if (coont >= 5) {
                    break;
                }
            }
            if (builder.length() > 0) builder.append("\n");

        }
        System.out.println(builder.toString());
    }

    static class Pair implements Comparable<Pair> {
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
