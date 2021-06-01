package yandAlgh.sprint8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PackedPrefix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        int n = Integer.parseInt(reader.readLine());
        String[] pack = new String[n];
        for (int i = 0; i < n; i++) {
            pack[i] = reader.readLine();
        }

        String[] unpacked = new String[n];

        for (int i = 0; i < pack.length; i++) {
            unpacked[i] = unpack(pack[i]);
        }

        StringBuilder res = new StringBuilder();
        System.out.println(res.toString());
    }

    private static String unpack(String packed) {
        StringBuilder unpacked = new StringBuilder();
        StringBuilder buff = new StringBuilder();
        int openCount = 0;
        int closeCount = 0;
        for (int i = packed.length()-1; i >=0; i--) {
            if (packed.charAt(i) == '[') {
                openCount = openCount -1;
            } else if (packed.charAt(i) == ']') {
                openCount= openCount + 1;
            } else if (packed.charAt(i) >= '1'  && packed.charAt(i) < '9' ) {
                int mult = Integer.parseInt(String.valueOf(packed.charAt(i)));
                String add = buff.toString();
                for (int j = 1; j < mult; j++) {
                    buff.append(add);
                }
                if (openCount == 0) {
                    unpacked.append(buff);
                    buff = new StringBuilder();
                }

            } else {
                if (openCount == 0) {
                    unpacked.append(packed.charAt(i));
                } else {
                    buff.append(packed.charAt(i));
                }
            }
        }
        return unpacked.reverse().toString();
    }

}
