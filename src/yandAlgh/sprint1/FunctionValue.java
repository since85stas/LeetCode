package yandAlgh.sprint1;

import java.io.*;
import java.util.StringTokenizer;

class FunctionValue {
    public static void main(String[] args) throws IOException {
//        StringBuilder output_buffer = new StringBuilder();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        double a = Double.parseDouble(tokenizer.nextToken());
        double x = Double.parseDouble(tokenizer.nextToken());
        double b = Double.parseDouble(tokenizer.nextToken());
        double c = Double.parseDouble(tokenizer.nextToken());
        System.out.println(functionValue(a,x,b,c));
    }

    static double functionValue(double a, double x, double b, double c) {
        double val = a*x*x + b*x + c;
        return val;
    }
}
