package yandAlgh.mobileCup2021;

import java.io.*;
import java.util.*;

public class CovidBar3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        int s = Integer.parseInt(tokenizer.nextToken());

        int t  = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        HashMap<Integer, Long> map = new HashMap<>();

        Pair[] mass = new Pair[n];

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(tokenizer.nextToken());
            mass[i] = new Pair(next, i);
        }

        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return Integer.compare(pair.val, t1.val);
            }
        };

        Arrays.sort(mass, comp);

        TreeMap<Integer, String> res = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int next = mass[i].val;
            boolean isBreak = false;
            for (int j = next; j < next + t; j++) {
                if (map.containsKey(j)) {
                    if (map.get(j) == s) {
//                        System.out.println("NO");
                        res.put(mass[i].num, "NO");
                        isBreak = true;
                        break;
                    }
                    map.put(j, map.get(j)+1L);
                } else {
                    map.put(j, 1L);
                }
            }
            if (!isBreak) res.put(mass[i].num, "YES");
        }
        for (String ss: res.values()
             ) {
            System.out.println(ss);
        }
    }

}

class Pair {
    int val;
    int num;

    public Pair(int val, int num) {
        this.val = val;
        this.num = num;
    }

//    @Override
//    public int compareTo(Pair pair) {
//        return Integer.compare(this.val, pair.val);
//    }
}
