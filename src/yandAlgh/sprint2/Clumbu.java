package yandAlgh.sprint2;

import java.io.*;
import java.util.*;

public class Clumbu {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Elem[] massive = new Elem[n];

        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            Elem elem = new Elem(Integer.parseInt(tokenizerStr.nextToken()),Integer.parseInt(tokenizerStr.nextToken()));
            massive[i] = elem;
        }
        Arrays.sort(massive);

        LinkedList<Elem> out = new LinkedList<>();
        if (massive.length > 1) {
            out.push(massive[0]);
            for (int i = 1; i < massive.length; i++) {
                Elem last = out.peekLast();
                if (last.start > massive[i].start && last.end > massive[i].end) {
                    break;
                } else if (massive[i].start > last.end) {
                    out.add(massive[i]);
                } else {
                    out.pollLast();
                    out.add(new Elem(last.start, Math.max(massive[i].end, last.end)));
                }
            }
            StringBuilder builder = new StringBuilder();
            int size = out.size();
            for (int i = 0; i <size; i++) {
                Elem el = out.pollFirst();
                builder.append(el.start).append(" ").append(el.end);
                builder.append("\n");
            }
            System.out.println(builder.toString());
        } else if (massive.length == 1) {
            System.out.println(massive[0].start + " " + massive[0].end);
        }
    }


    private static class Elem implements Comparable<Elem> {
        int start;
        int end;

        public Elem(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Elem elem) {
            if (this.start < elem.start) {
                return -1;
            } else if (this.start > elem.start) {
                return 1;
            } else {
                if (this.end < elem.end) {
                    return -1;
                } else if (this.end > elem.end) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

}
