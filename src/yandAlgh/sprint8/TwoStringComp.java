package yandAlgh.sprint8;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class TwoStringComp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)%2 == 0) {
                builder1.append(s1.charAt(i));
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i)%2 == 0) {
                builder2.append(s2.charAt(i));
            }
        }
        int comp = builder1.toString().compareTo(builder2.toString());
        if (comp < 0) System.out.println(-1);
        else if (comp > 0) System.out.println(1);
        else System.out.println(0);

        
    }

}
