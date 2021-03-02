package yandAlgh.sprint2;

import java.util.Arrays;

class Solution {

    public static void main(String args[]) {
        String string = "80 85 90 100 105 115";
//        Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).forEach(it -> System.out.print(Character.toChars(it)));
        int n = 4;
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum +=i*2;
        }
        System.out.println(sum);
//        String line = "***6  666";
//        int s = 0;
//        int h = 0;
//        for (int i = 0; i < 10; i++) {
//            s += line.chars().filter(it -> it == '*').count();
//            h += line.chars().filter(it -> it == ' ').count();
////            System.out.println("");
//        }


//        System.out.println(Math.round(h/(double)s*100) + "%");
    }
}
