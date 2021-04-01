package yandAlgh.sprint4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Competition {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

//        if(n >0) {
//            StringBuilder builder = new StringBuilder();
//            tokenizer = new StringTokenizer(reader.readLine());
//            for (int i = 0; i < n; i++) {
//                builder.append(tokenizer.nextToken());
//            }
//            String string = builder.toString();
//            int sum = 0;
//            int max = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = i; j < n; j++) {
////                    String sub string.sub
//                }
//            }
//            System.out.println();
//        } else {
//            System.out.println(0);
//        }
        if(n >0) {
            int[] array = new int[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(tokenizer.nextToken());

                array[i] = determineValue(val);
            }
            System.out.println(computeWinner(array));
        } else {
            System.out.println(0);
        }
    }

    public static int computeWinner(int[] values) {

        int maxLongestPeriod = 0;
        int localMaxLongestPeriod = 0;
        HashMap<Integer, Integer> historySumRound = new HashMap<>();

        int resultSumm = 0;
        if (values.length == 0) {
            return 0;
        }
        if (values.length == 1) {
            return 0;
        }
        if (values.length == 2) {
            if (values[0] + values[1] == 0) {
                return 2;
            } else {
                return 0;
            }
        }
        historySumRound.put(0, 0);
        for (int i = 0; i <= values.length - 1; i++) {
            resultSumm += values[i];
            if (historySumRound.containsKey(resultSumm)) {
                localMaxLongestPeriod = i - historySumRound.get(resultSumm);
            } else {
                historySumRound.put(resultSumm, i + 1);
            }
            if (localMaxLongestPeriod > maxLongestPeriod) {
                maxLongestPeriod = localMaxLongestPeriod;
            }
        }
        if (maxLongestPeriod != 0) return maxLongestPeriod + 1;
        else return 0;
    }

    public static int determineValue(int value) {
        return value == 0 ? -1 : 1;
    }

}
