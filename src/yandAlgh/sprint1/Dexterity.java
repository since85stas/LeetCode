package yandAlgh.sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Dexterity {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());


        String[] lines = new String[4];
        for (int i = 0; i < 4; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            lines[i] = tokenizer.nextToken();
        }

        HashMap<Byte, Integer> counter = new HashMap<>();
        for (String line:
             lines) {
            for (String el:
                 line.split("")) {
                if (!el.equals(".")) {
                    byte val = Byte.parseByte(el);
                    if (!counter.containsKey(val)) {
                        counter.put(val,1);
                    } else {
                        int count = counter.get(val);
                        counter.put(val, count+1);
                    }
                }
            }
        }
        int score = 0;
        for (byte i = 1; i < 10; i++) {
            if (counter.containsKey(i)) {
                if (counter.get(i) <= k*2) {
                    score++;
                }
            }
        }
        System.out.println(score);
    }

}
