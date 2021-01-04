import java.util.*;

public class ProblemsEasy01 {

    public static void main(String[] args) {
//        int[] res =twoSumHash(new int[]{2, 7, 11, 15},9);
        int res =reverse(1534236469);
//        int res =reverse(123);
    }

    // Возможно немного громоздкий код получился
    public static boolean isValid(String s) {
        final int SQUARE = 1;
        final int ROUND = 2;
        final int CURLY = 3;
        final char SQUARE_OPEN = '[';
        final char SQUARE_CLOSE = ']';
        final char ROUND_OPEN = '(';
        final char ROUND_CLOSE = ')';
        final char CURLY_OPEN = '{';
        final char CURLY_CLOSE = '}';
        if (s != null) {
            if (s.length() == 0) return true;
            if (s.length() % 2 != 0) return false;
            int squareOpen = 0;
            int roundOpen = 0;
            int curlyOpen = 0;
            LinkedList<Integer> lastOpen = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == SQUARE_OPEN) {
                    squareOpen++;
                    lastOpen.addLast(SQUARE);
                } else if (s.charAt(i) == SQUARE_CLOSE){
                    if (squareOpen > 0 && lastOpen.size() > 0 && lastOpen.getLast() == SQUARE) {
                        squareOpen--;
                        lastOpen.removeLast();
                    } else {
                        return false;
                    }
                }
                if (s.charAt(i) == ROUND_OPEN) {
                    roundOpen++;
                    lastOpen.addLast(ROUND);
                } else if (s.charAt(i) == ROUND_CLOSE && lastOpen.size() > 0 && lastOpen.getLast() == ROUND){
                    if (roundOpen > 0) {
                        roundOpen--;
                        lastOpen.removeLast();
                    } else {
                        return false;
                    }
                }
                if (s.charAt(i) == CURLY_OPEN) {
                    curlyOpen++;
                    lastOpen.addLast(CURLY);
                } else if (s.charAt(i) == CURLY_CLOSE && lastOpen.size() > 0 && lastOpen.getLast() == CURLY){
                    if (curlyOpen > 0) {
                        curlyOpen--;
                        lastOpen.removeLast();
                    } else {
                        return false;
                    }
                }
            }
            if (squareOpen == 0 && roundOpen == 0 && curlyOpen == 0 )  return true;
        }
        return false;
    }

    // с использованием чисел Фибоначчи
    public int climbStairsFib(int n) {
        int ways = 0;
        int nMinTwo = 0;
        int nMinOne = 1;
//        count = nMinOne + nMinTwo;
        for (int i = 1; i < n+1; i++) {
            ways = nMinOne + nMinTwo;
            nMinTwo = nMinOne;
            nMinOne = ways;
        }
        return ways;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) return new int[]{nums[i],nums[j]};
            }
        }
        return new int[] {};
    }

    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i,map.get(diff)};
            }
        }
        return new int[] {};
    }

    public static int reverse(int x) {
        String xStr = String.valueOf(x);
        List<String> list = Arrays.asList(xStr.split(""));
        LinkedList<String> linkList = new LinkedList<>(list);
        boolean neg;
        if(linkList.getFirst().equals("-")) {
            neg = true;
            linkList.removeFirst();
        } else {
            neg = false;
        }
        Collections.reverse(linkList);
        String max =String.valueOf(Integer.MAX_VALUE) ;
        String strReverse = linkList.stream().reduce((s1,s2)-> s1+s2).get();
        if (strReverse.length() > max.length() ) return 0;
        int compare = strReverse.compareTo(max);
        if ( compare >  0 && strReverse.length() == max.length()) return 0;
        int val = Integer.valueOf(strReverse);
        if (neg) val = val*(-1);
        return val;
    }
}
