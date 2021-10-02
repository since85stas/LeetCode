package hackerrank.tekkerey;

import java.io.*;
import java.util.*;

public class Tekkery {

    public static void main(String[] args) throws IOException {

        prepareText();
//        long start = System.currentTimeMillis();
//
//        long end = System.currentTimeMillis();
//        System.out.println("read in " + (end - start));
//        long start = System.currentTimeMillis();
//        String[] mass = readPrepText("prep_text_part.txt");
//        sortText(mass);
////        sortTenTimes();
//        long end = System.currentTimeMillis();
//        System.out.println("sort in " + (end-start)/10);


        long start = System.currentTimeMillis();
        String[] massFull = readPrepText("prep_text.txt");
        HashMap<String, Integer> dict = countWords(massFull);
        outDict(dict);
        long end = System.currentTimeMillis();
        System.out.println("count in " + (end - start));
    }

    private static String[] readPrepText(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        String size = reader.readLine();

        int count = Integer.parseInt(size);
        String[] text = new String[count];
        for (int i = 0; i < count; i++) {
            text[i] = reader.readLine();
        }
        return text;
    }

    private static void sortTenTimes() throws IOException {

        for (int i = 0; i < 10; i++) {
            String[] mass = readPrepText("prep_text_part.txt");
            sortText(mass);
        }
    }

    private static void sortText(String[] text) {
        for (int i = 0; i < text.length - 1; i++) {
            for (int j = i + 1; j < text.length; j++) {
                if (text[i].compareTo(text[j]) > 0) {
                    String tmp = text[i];
                    text[i] = text[j];
                    text[j] = tmp;
                }
            }
        }
        System.out.println("");
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


    private static void outMostPop(String[] word, Integer[] numb) {
        for (int i = 0; i < 30; i++) {
            System.out.print(word[i] + " " + numb[i] + ",");
//            System.out.println("\n");
        }
    }

    private static void outDict(HashMap<String, Integer> dic) {
        String[] words = dic.keySet().toArray(new String[0]);
        Integer[] numb = dic.values().toArray(new Integer[0]);
        for (int i = 0; i < numb.length - 1; i++) {
            for (int j = i + 1; j < numb.length; j++) {
                if (numb[j] > numb[i]) {
                    String tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;

                    Integer tmpi = numb[i];
                    numb[i] = numb[j];
                    numb[j] = tmpi;
                }
            }
        }
        outMostPop(words, numb);
    }

    private static void prepareText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("book.txt"))));
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ,.;!?'\"()-”");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken().toLowerCase();
                if (
                        word.equals("a") ||
                                word.equals("is") ||
                                word.equals("on") ||
                                word.equals("as") ||
                                word.equals("in") ||
                                word.equals("the") ||
                                word.equals("of") ||
                                word.equals("and") ||
                                word.equals("to") ||
                                word.equals("was") ||
                                word.equals("he") ||
                                word.equals("her") ||
                                word.equals("his") ||
                                word.equals("with") ||
                                word.equals("that") ||
                                word.equals("this") ||
                                word.equals("she") ||
                                word.equals("i") ||
                                word.equals("for") ||
                                word.equals("at") ||
                                word.equals("had") ||
                                word.equals("it") ||
                                word.equals("you") ||
                                word.equals("which") ||
                                word.equals("not") ||
                                word.equals("but") ||
                                word.equals("have") ||
                                word.equals("him") ||
                                word.equals("be") ||
                                word.equals("by") ||
                                word.equals("when") ||
                                word.equals("all") ||
                                word.equals("an") ||
                                word.equals("so") ||
                                word.equals("my") ||
                                word.equals("were") ||
                                word.equals("from") ||
                                word.equals("they") ||
                                word.equals("there") ||
                                word.equals("who") ||
                                word.equals("very") ||
                                word.equals("been") ||
                                word.equals("their") ||
                                word.equals("one") ||
                                word.equals("no") ||
                                word.equals("me") ||
                                word.equals("are") ||
                                word.equals("if") ||
                                word.equals("how") ||
                                word.equals("them") ||
                                word.equals("or") ||
                                word.equals("would") ||
                                word.equals("what") ||
                                word.equals("we") ||
                                word.equals("will") ||
                                word.equals("upon") ||
                                word.equals("could") ||
                                word.equals("more") ||
                                word.equals("did") ||
                                word.equals("mr") ||
                                word.equals("mrs") ||
                                word.equals("up") ||
                                word.equals("after") ||
                                word.equals("your") ||
                                word.equals("over") ||
                                word.equals("made") ||
                                word.equals("some") ||
                                word.equals("never") ||
                                word.equals("into") ||
                                word.equals("has") ||
                                word.equals("before") ||
                                word.equals("day") ||
                                word.equals("any") ||
                                word.equals("sir")
                ) {

                } else {
                    list.add(word);
                }
            }
            count++;
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("prep_text.txt"), "utf-8"))) {
            writer.write(String.valueOf(list.size()));
            writer.write("\n");
            for (String s :
                    list) {
                writer.write(s + "\n");
            }
        }
    }

}
