package yandAlgh.sprint4;

import java.io.*;
import java.util.*;

public class SumFours {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        short s = Short.parseShort(tokenizer.nextToken());

        int[] array = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(array);

        findTriplets(array, array.length, s);
    }

    static void findTriplets(int arr[], int n, int s)
    {
        HashSet<Four> resSet = new HashSet<>();

        for (int i = 0; i < n - 2; i++)
        {
//            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = i + 1; j < n - 1; j++)
            {
                // Find all pairs with sum equals to
                // "-arr[i]"
                HashSet<Integer> set = new HashSet<Integer>();
                for (int k = j+1; k < n; k++) {
                    int x = (s - arr[i] - arr[j] - arr[k]);
                    if (set.contains(x))
                    {
//                        System.out.printf("%d %d %d %d\n", x, arr[i], arr[j], arr[k]);
                        if (x < arr[i]) {
                            resSet.add(new Four(x, arr[i], arr[j], arr[k]));
                        } else if (x < arr[j]) {
                            resSet.add(new Four(arr[i],x, arr[j], arr[k]));
                        } else if (x < arr[k]) {
                            resSet.add(new Four(arr[i],arr[j], x, arr[k]));
                        } else {
                            resSet.add(new Four(arr[i],arr[j], arr[k],x));
                        }
                    }
                    else
                    {
                        set.add(arr[k]);
                    }
                }

            }
        }

        List<Four> list = new ArrayList<>(resSet);
//
        Collections.sort(list);
        System.out.println(list.size());
        for (Four f:
             list) {
            System.out.println(f.comp);
        }

//        if (found == false)
//        {
//            System.out.printf(" No Triplet Found\n");
//        }
    }

    static class Four implements Comparable<Four> {

        int a;
        int b;
        int c;
        int d;

        String comp;

        public Four (int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
//            int[] arr = new int[4];
//            arr[0] = a;
//            arr[1] = b;
//            arr[2] = c;
//            arr[3] = d;
//
//            Arrays.sort(arr);
//
//            this.a = arr[0];
//            this.b = arr[1];
//            this.c = arr[2];
//            this.d = arr[3];
            StringBuilder builder = new StringBuilder();
            builder.append(this.a).append(" ").append(this.b).append(" ").append(this.c).append(" ").append(this.d);
            comp = builder.toString();
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

}
