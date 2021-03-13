package yandAlgh.sprint2;

import java.io.*;
import java.util.*;

public class Combin {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        String command = tokenizerStr.nextToken();

        gener(command);
    }

    private static void gener(String commands) {
        commandsRec(commands.split(""), 0, "");
    }

    private static void commandsRec(String[] comm, int posit, String comb) {
        if (posit == comm.length) {
            System.out.print(comb);
            System.out.print(" ");
            return;
        } else {
            char[] chars = getCommandSymbols(comm[posit]);
            posit = posit + 1;
            for (int i = 0; i < chars.length; i++) {
                commandsRec(comm, posit,comb + String.valueOf(chars[i]));
            }
        }
    }



    private static char[] getCommandSymbols(String com) {
        char[] chars;
        switch (com) {
            case "2": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (97 + i);
                }
                break;
            }

            case "3": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (100 + i);
                }
                break;
            }

            case "4": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (103 + i);
                }
                break;
            }

            case "5": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (106 + i);
                }
                break;
            }

            case "6": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (109 + i);
                }
                break;
            }

            case "7": {
                chars = new char[4];
                for (int i = 0; i < 4; i++) {
                    chars[i] = (char) (112 + i);
                }
                break;
            }

            case "8": {
                chars = new char[3];
                for (int i = 0; i < 3; i++) {
                    chars[i] = (char) (116 + i);
                }
                break;
            }

            case "9": {
                chars = new char[4];
                for (int i = 0; i < 4; i++) {
                    chars[i] = (char) (119 + i);
                }
                break;
            }

            default:
                chars = new char[4];
                break;
        }
        return chars;
    }

}
