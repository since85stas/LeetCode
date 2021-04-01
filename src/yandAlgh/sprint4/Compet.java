package yandAlgh.sprint4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Compet {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader;
        FileReader fileReader = new FileReader("input.txt");
        bufferedReader = new BufferedReader(fileReader);
        String readLine;
        int count = 0;
        int quantityRounds = 0;
        int[] rounds = new int[0];
        int i = 0;
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                if (count == 0 && !readLine.equals("")) {
                    quantityRounds = Integer.parseInt(readLine);
                }
                if (count == 1) {
                    rounds = new int[quantityRounds];
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    while (stringTokenizer.hasMoreTokens() && i <= quantityRounds) {
                        rounds[i] = determineValue(Integer.parseInt(stringTokenizer.nextToken()));
                        i++;
                    }
                }
                count++;
            }
            System.out.println(computeWinner(rounds));
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int determineValue(int value) {
        return value == 0 ? -1 : 1;
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
}

