package yandAlgh.sprint2;

import java.io.*;
import java.util.*;

public class Conferences {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        HashMap<Integer, College> map = new HashMap<>();

        tokenizerStr = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(tokenizerStr.nextToken());
            if (!map.containsKey(val)) {
                map.put(val, new College(val));
            } else {
                map.get(val).addStudent();
            }
        }

        tokenizerStr = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(tokenizerStr.nextToken());

        List<College> coll = new ArrayList<>();
        coll.addAll(map.values());
        Collections.sort(coll);

        Iterator<College> list = coll.iterator();

        int count = 0;
        while (list.hasNext() && count < k) {
            System.out.println(list.next().id);
            count++;
        }

    }

    private static class College implements Comparable<College>{

        private int students;

        private int id;

        public College(int id) {
            students = 1;
            this.id = id;
        }

        public void addStudent() {
            students++;
        }

        @Override
        public int compareTo(College other) {
            if (students < other.students) {
                return 1;
            } else if (students > other.students) {
                return -1;
            } else {
                if (id < other.id) return -1;
                else if (id > other.id) return 1;
                return 0;
            }
        }


    }
}
