package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class FourTimes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//        short n = Short.parseShort(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        boolean status = true;
        if (n > 1) {
            do {
                byte out = (byte) (n % 4);
                n = (n / 4);
                if (out != 0) {
                    System.out.println("False");
                    status = false;
                    break;
                }
            } while (n > 1);
            if (status) System.out.println("True");
        } else if (n==1) {
            System.out.println("True");;
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
//        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
////        short n = Short.parseShort(tokenizer.nextToken());
//        int n = Integer.parseInt(tokenizer.nextToken());
//
//        int curr =1;
//        while ()
//
//        if () System.out.println("True");
//    }

}


