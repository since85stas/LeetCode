package hackerrank;

import java.util.HashMap;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Byte, Byte> store = new HashMap<>();
        for (int num: ar
             ) {
            byte bNum = (byte)num;
            if (!store.containsKey(bNum)) {
                store.put(bNum, (byte) 1);
            } else {
                byte oldNum = store.get(bNum);
                store.put(bNum,(byte)(oldNum+1));
            }
        }
        byte pairs = 0;
        for (Byte pair: store.values()
             ) {
            int half = pair/2;
            pairs = (byte) (pairs + (byte)half);
        }
        return pairs;
    }

}
