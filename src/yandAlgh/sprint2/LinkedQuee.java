package yandAlgh.sprint2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LinkedQuee {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        LinkedQuee quee = new LinkedQuee();

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizerStrC = new StringTokenizer(reader.readLine());

            String command = tokenizerStrC.nextToken();
            if (command.equals("get")) {
                System.out.println(quee.get());
            } else if (command.equals("size")) {
                System.out.println(quee.size());
            } else if (command.equals("put")) {
                String num = String.valueOf(tokenizerStrC.nextToken());
                quee.put(num);
            }
        }
    }

    private LinkedList<String> list;

    public LinkedQuee() {
        list = new LinkedList<>();
    }

    public void put(String num) {
        list.push(num);
    }

    public String get() {

        if (list.size() == 0) {
            return "Error";
        } else {
            String num = list.pollFirst();
            return num;
        }

    }

    public int size() {
        return list.size();
    }

}
