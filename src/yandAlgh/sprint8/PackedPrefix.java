package yandAlgh.sprint8;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.*;
import java.util.*;

public class PackedPrefix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        int n = Integer.parseInt(reader.readLine());
        String[] unpacked = new String[n];
        for (int i = 0; i < n; i++) {
            unpacked[i] = unpack(reader.readLine());
        }



//        for (int i = 0; i < pack.length; i++) {
//            unpacked[i] = unpack(pack[i]);
//        }

//        Trie trie = new Trie();
//        for (int i = 0; i < unpacked.length; i++) {
//            trie.put(unpacked[i],i);
//        }
        String longest = longestCommonPrefix2(unpacked);
        System.out.println(longest);
    }

    private static String unpack(String packed) {
        StringBuilder unpacked = new StringBuilder();
        StringBuilder cash = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < packed.length(); i++) {
            if (packed.charAt(i) == '[') {
                if (stack.size() == 0 )cash = new StringBuilder();
            } else if (packed.charAt(i) == ']') {
                String mul = cash.toString();
                int m = stack.pop();
                for (int j = 0; j < m-1; j++) {
                    cash.append(mul);
                }
                if (stack.size() == 0) {
                    unpacked.append(cash);
                    cash = new StringBuilder();
                }
            } else if (packed.charAt(i) >= '1'  && packed.charAt(i) <= '9' ) {
                int mult = Integer.parseInt(String.valueOf(packed.charAt(i)));
                stack.push(mult);
            } else {
                if (stack.size() == 0)unpacked.append(packed.charAt(i));
                else cash.append(packed.charAt(i));
            }
        }
        return unpacked.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


}
