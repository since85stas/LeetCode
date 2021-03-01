package yandAlgh.sprint1;

import java.io.*;
import java.util.*;

// исключающее или
public class MissingLetter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        String wordA = tokenizerStr.nextToken();

        tokenizerStr = new StringTokenizer(reader.readLine());
        String wordB = tokenizerStr.nextToken();

        HashMap<String, Short> dict = new HashMap<>();
        for (String let: Arrays.asList(wordB.split(""))) {
            if (!dict.containsKey(let)) {
                dict.put(let, (short) 1);
            } else {
                short val = dict.get(let);
                dict.put(let, (short) (val+1));
            }
        }

        for (String letter:
             wordA.split("")) {
            if (dict.containsKey(letter)) {
                short val = dict.get(letter);
                if (val > 1) {
                    dict.put(letter, (short) (val-1));
                } else {
                    dict.remove(letter);
                }
            }
        }

        for (String last:
             dict.keySet()) {
            System.out.println(last);
        }
    }

}
