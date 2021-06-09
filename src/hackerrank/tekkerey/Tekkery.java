package hackerrank.tekkerey;

import yandAlgh.sprint8.CaseB;

import java.io.*;
import java.util.*;

public class Tekkery {

    public static void main(String[] args) throws IOException {

        prepareText();
        long start = System.currentTimeMillis();
        String[] mass = readPrepText();
        long end = System.currentTimeMillis();
        System.out.println("read in" + (end-start));

        start = System.currentTimeMillis();
        sortText(mass);
        end = System.currentTimeMillis();
        System.out.println("sort in" + (end-start));

        start = System.currentTimeMillis();
        sortText(mass);
        end = System.currentTimeMillis();
        System.out.println("sort in" + (end-start));

        start = System.currentTimeMillis();
        sortText(mass);
        end = System.currentTimeMillis();
        System.out.println("sort in" + (end-start));

        start = System.currentTimeMillis();
        sortText(mass);
        end = System.currentTimeMillis();
        System.out.println("sort in" + (end-start));
    }

    private static void prepareText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("book_part.txt"))));
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ,.;!?'\"");
            while (tokenizer.hasMoreTokens()) {
                list.add(tokenizer.nextToken().toLowerCase());
            }
            count ++;
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("prep_text_part.txt"), "utf-8"))) {
            writer.write(String.valueOf(list.size()));
            writer.write("\n");
            for (String s :
                    list) {
                writer.write(s + "\n");
            }
        }
    }

    private static String[] readPrepText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("prep_text_part.txt"))));
        String size = reader.readLine();

        int count = Integer.parseInt(size);
        String[] text = new String[count];
        for (int i = 0; i < count; i++) {
            text[i] = reader.readLine();
        }
        System.out.println();
        return text;
    }

    private static void sortText(String[] text) {
        for (int i = 0; i < text.length - 1; i++) {
            for (int j = i+1; j < text.length; j++) {
                if (text[i].compareTo(text[j]) > 0) {
                    String tmp = text[i];
                    text[i] = text[j];
                    text[j] = tmp;
                }
            }
        }
    }

    private static HashMap<String, Integer> countWords(String[] text) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (String s :
                text) {
            if (dict.containsKey(s)) {
                dict.put(s, dict.get(s) + 1);
            } else {
                dict.put(s, 1);
            }
        }
        return dict;
    }

    private static void outDict(HashMap<String, Integer> dic) {

    }

}
