package hackerrank.hashMaps;

import java.util.HashMap;
import java.util.HashSet;

public class CheckMagazine {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String,Short> set = new HashMap<>();
        for (String word: magazine
             ) {
            if (!set.containsKey(word)){
                set.put(word, (short) 1);
            } else {
                short num = set.get(word);
                set.put(word, (short) (num+1));
            }
        }

        boolean ok = true;
        for (String word: note
             ) {
            if (set.containsKey(word)) {
                short num = set.get(word);
                if (num > 1) {
                    num--;
                    set.put(word,num);
                } else if (num==1) {
                    set.remove(word);
                }
            } else {
                System.out.println("No");
                ok = false;
                break;
            }
        }
        if (ok) System.out.println("Yes");
    }
}
