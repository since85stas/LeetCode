package yandAlgh.sprint7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoldIll {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long v = Long.parseLong(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] prices = new int[n];
        int[] masses = new int[n];
        Ore[] ores = new Ore[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int p = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            masses[i] = m;
            prices[i] = p;
            Ore ore = new Ore(m,p);
            ores[i] = ore;
        }

        Arrays.sort(ores);

        long countV = 0;
        long price = 0;
        for (int i = 0; i < n; i++) {
            Ore ore = ores[i];
            if (v-countV >= ore.mas) {
                countV +=ore.mas;
                price += ore.price*ore.mas;
            } else {
                price +=ore.price* (v-countV);
                countV = v;
            }
        }


        System.out.println(price);
    }

    private static class Ore implements Comparable<Ore> {

        int mas;
        int price;

        public Ore (int mas, int price) {
            this.price = price;
            this.mas = mas;
        }

        @Override
        public int compareTo(Ore ore) {
            if (ore.price != price) return Integer.compare(ore.price, price);
            else return Integer.compare(mas, ore.mas);
        }
    }

}
