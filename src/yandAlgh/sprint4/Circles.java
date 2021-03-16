package yandAlgh.sprint4;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Circles {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
//                tokenizer = new StringTokenizer(reader.readLine());
                String name = reader.readLine();
                set.add(name);
            }
        }

        Iterator<String> iter = set.iterator();
        StringBuilder builder = new StringBuilder();
        while (iter.hasNext()) {
            builder.append(iter.next()).append("\n");
        }
        System.out.println(builder.toString());
    }

}
