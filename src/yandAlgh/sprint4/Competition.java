package yandAlgh.sprint4;

import java.io.*;
import java.util.StringTokenizer;

public class Competition {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

//        if(n >0) {
//            StringBuilder builder = new StringBuilder();
//            tokenizer = new StringTokenizer(reader.readLine());
//            for (int i = 0; i < n; i++) {
//                builder.append(tokenizer.nextToken());
//            }
//            String string = builder.toString();
//            int sum = 0;
//            int max = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = i; j < n; j++) {
////                    String sub string.sub
//                }
//            }
//            System.out.println();
//        } else {
//            System.out.println(0);
//        }
        if(n >0) {
            boolean[] array = new boolean[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = tokenizer.nextToken().equals("1");
            }

            int sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = i; j < n; j++) {
                    count++;
                    if (array[j]) sum++;
                    else sum--;
                    if (sum == 0 && count > max) {
                        max = count;
                    }
                }
            }
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }

}
