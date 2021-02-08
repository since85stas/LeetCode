package yandAlgh.sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class NearestNull {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int len = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[len];
        List<Integer> nullPositions= new ArrayList<>();

        tokenizer = new StringTokenizer(reader.readLine()," ");
        for (int i = 0; i < len; i++) {
            int val = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = val;
            if (val ==0) {
                nullPositions.add(i);
            }
        }

        List<Diapozone> diapozones = new ArrayList<>();
        if (nullPositions.get(0) != 0) {
            Diapozone diapozone = new Diapozone(null, nullPositions.get(0));
            diapozones.add(diapozone);
        }
        for (int i = 0; i < nullPositions.size()-1; i++) {
            Diapozone diapozone = new Diapozone(nullPositions.get(i), nullPositions.get(i+1));
            diapozones.add(diapozone);
        }
        if (nullPositions.get(nullPositions.size()-1) != len-1) {
            Diapozone diapozone = new Diapozone(nullPositions.get(nullPositions.size()-1), null);
            diapozones.add(diapozone);
        }

        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Diapozone currDiapoz = diapozones.get(0);
            for (Diapozone d:
                 diapozones) {
                if (d.contains(i)) {
                    currDiapoz = d;
                    break;
                }
            }
            dist.add(currDiapoz.minDistance(i));
        }
        dist.stream().forEach(it -> System.out.print(it  +" "));
    }


    static class Diapozone {
        Integer leftB;
        Integer righB;

        Diapozone(Integer leftB, Integer righB) {
            this.leftB = leftB;
            this.righB = righB;
        }

        boolean contains(int num) {
            if (leftB != null && righB != null) {
                if (num >= leftB && num <= righB) {
                    return true;
                }
            } else if (leftB == null) {
                return num <= righB;
            } else {
                return num >= leftB;
            }
            return false;
        }

        int minDistance (int val) {
            if (leftB != null && righB != null) {
                int distL = val - leftB;
                int distR = righB - val;
                if (distL > 0 && distL < distR) return distL;
                else return distR;
            } else if (leftB == null) {
                return righB - val;
            } else {
                return val - leftB;
            }
        }
    }

}
