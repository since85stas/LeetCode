package yandAlgh.sprint2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Combin {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        String command = tokenizerStr.nextToken();

        gener(command);
    }

    private static void gener(String commands) {
        LinkedList<String> list = new LinkedList<>();

        list.addAll(Arrays.asList(commands.split("")));
        System.out.println("test");
    }

    private static void commands(LinkedList<String> comm) {
        
    }

}
