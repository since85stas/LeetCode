package hackerrank.tekkerey;

import yandAlgh.sprint8.CaseB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tekkery {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("book.txt"))));
        List<String> list = new ArrayList<>();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ,.;!?'\"");
            while (tokenizer.hasMoreTokens()) {
                list.add(tokenizer.nextToken().toLowerCase());
            }
        }
        System.out.println("");


    }

}
