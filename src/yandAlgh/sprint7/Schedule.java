package yandAlgh.sprint7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Schedule {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());

        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String startStr = tokenizer.nextToken();
            String endStr = tokenizer.nextToken();
            short hS;
            short mS;
            short hE;
            short mE;

            if (startStr.contains(".")) {
                String[] strings = startStr.split("\\.");
                hS = Short.parseShort(strings[0]);
                mS = Short.parseShort(strings[1]);
            } else {
                hS = Short.parseShort(startStr);
                mS = 0;
            }

            if (endStr.contains(".")) {
                String[] strings = endStr.split("\\.");
                hE = Short.parseShort(strings[0]);
                mE = Short.parseShort(strings[1]);
            } else {
                hE = Short.parseShort(endStr);
                mE = 0;
            }
            Interval interval = new Interval(hS, mS,hE,mE);
            intervals[i] = interval;
        }

        Arrays.sort(intervals);
//        StringBuilder builder = new StringBuilder();
        List<Interval> res = new ArrayList<>();
        short lastEnd = 0;
        if (intervals.length > 0) {
            res.add(intervals[0]);
            lastEnd = intervals[0].end;
            for (int i = 1; i < n; i++) {
                if (intervals[i].start >= lastEnd) {
                    res.add(intervals[i]);
                    lastEnd = intervals[i].end;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(res.size()).append("\n");
        for (int i = 0; i < res.size(); i++) {
            Interval interval = res.get(i);

            builder.append(interval.hs);
            if (interval.ms != 0) builder.append(".").append(interval.ms);
            builder.append(" ");
            builder.append(interval.he);
            if (interval.me != 0) builder.append(".").append(interval.me);
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private static class Interval implements Comparable<Interval>{
        short start;
        short hs;
        short he;
        short ms;
        short me;
        short end;
        int dur;

        public Interval(short hS, short mS, short hE, short mE) {
            start = (short) (hS*60 + mS);
            end = (short) (hE*60 + mE);
            hs = hS;
            he = hE;
            ms = mS;
            me = mE;
            dur = end - start;
        }

        @Override
        public int compareTo(Interval interval) {
            if (end != interval.end) return Short.compare(end, interval.end);
            else return Integer.compare(interval.dur, dur);
        }

//        @Override
//        public int compareTo(Interval interval) {
//            return Short.compare(end, interval.end);
//        }
    }
}
