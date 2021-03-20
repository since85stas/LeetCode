package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class SumFour4 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(tokenizer.nextToken());

        int[] array = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        findFours(array, array.length, s);
    }

    // function to print triplets with 0 sum
    static void findFours(int arr[], int n, int s)
    {
        boolean found = false;

        HashSet<Four> resSet = new HashSet<>();
//        List<Four> resList = new ArrayList<>();
        HashMap<Pair, Integer> pairMaps = new HashMap<>();
        for (int i = 0; i < n - 1; i++)
        {
//            HashMap<Integer, Pair> set = new HashMap<>();
            for (int j = i + 1; j < n; j++)
            {
                pairMaps.put(new Pair(i,j), arr[i] + arr[j]);
//                    int x = arr[i] + arr[j];
//                    if (set.containsKey(x))
//                    {
////                        System.out.printf("%d %d %d %d\n", x, arr[i], arr[j], arr[k]);
//                        resSet.add(new Four(arr[i], arr[j], set.get(x).i1,set.get(x).i2));
////                        resList.add(new Four(x, arr[i], arr[j], arr[k]));
//                        found = true;
//                    }
//                    else
//                    {
//                        set.put(s - arr[i] - arr[j], new Pair(arr[i],arr[i]));
//                    }
            }
        }

        List<Pair> pairs = new ArrayList<>();
        pairs.addAll(pairMaps.keySet());

        HashSet<Four> numbSet = new HashSet<>();

        for (int i = 0; i < pairs.size() - 1; i++) {
            for (int j = i+1; j < pairs.size(); j++) {
                int pi1 = pairs.get(i).i1;
                int pi2 = pairs.get(i).i2;
                int pj1 = pairs.get(j).i1;
                int pj2 = pairs.get(j).i2;
                int sum = pairMaps.get(pairs.get(i)) + pairMaps.get(pairs.get(j));
                if (pi1 != pi2 && pi1 != pj1 && pi1 != pj2 &&pi2!= pj1 && pi2 != pj2 && pi2 != pj2 &&pj1 != pj2 && sum == s) {
                    numbSet.add(new Four(pi1,pi2,pj1,pj2));
                }
            }
        }

        for (Four four :
                numbSet) {
            resSet.add(new Four(arr[four.a], arr[four.b], arr[four.c], arr[four.d] ));
        }

        List<Four> list = new ArrayList<>();
        list.addAll(resSet);

        Collections.sort(list);
        System.out.println(list.size());
        StringBuilder builder = new StringBuilder();
        for (Four f:
                list) {
            builder.append(f.getName()).append("\n");
//            System.out.println(f.getName());
        }
        System.out.println(builder.toString());
    }

    static class Four implements Comparable<Four> {

        int a;
        int b;
        int c;
        int d;

        String comp;

        public Four (int a, int b, int c, int d) {

            int[] arr = new int[4];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            arr[3] = d;

            Arrays.sort(arr);

            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
            this.d = arr[3];

        }

        String getName() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.a).append(" ").append(this.b).append(" ").append(this.c).append(" ").append(this.d);
            comp = builder.toString();
            return comp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Four)) return false;
            Four four = (Four) o;
            return a == four.a &&
                    b == four.b &&
                    c == four.c &&
                    d == four.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }

        @Override
        public int compareTo(Four four) {
            if (this.equals(four)) return 0;
            else {
                if (a < four.a) return -1;
                else if(a > four.a) return 1;
                else {
                    if (b < four.b) return -1;
                    else if(b > four.b) return 1;
                    else {
                        if (c < four.c) return -1;
                        else if(c > four.c) return 1;
                        else {
                            if (d < four.d) return -1;
                            else if(d > four.d) return 1;
                            else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int i1;
        int i2;

        Pair(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return i1 == pair.i1 &&
                    i2 == pair.i2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2);
        }
    }

}
