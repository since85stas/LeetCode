package yandAlgh.sprint4;

import java.util.HashMap;

public class Webin {

    Webin() {

    }

    boolean palindrChange(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        if (str.length() % 2 == 0) {
            boolean isOk = true;
            for (Integer num :
                    map.values()) {
                if (num % 2 != 0) {
                    isOk = false;
                    break;
                }
            }
        } else {
            boolean even = false;
            for (Integer num :
                    map.values()) {
                if (num % 2 == 0) {

                } else {


                }
            }
        }

        return true;
    }
}
