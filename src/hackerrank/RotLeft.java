package hackerrank;

import java.util.Arrays;

public class RotLeft {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        if (a.length%d == 0) {
            return a;
        }
        if (d > a.length) {
            d = d%a.length;
        }

        int[] resArr = new int[a.length];
        int numLast = a.length - d;
        int[] lastArr = new int[numLast];
        System.arraycopy(a,a.length - numLast , lastArr,0,numLast);

        int numFirst = d;
        int[] firstArr = new int[d];
        System.arraycopy(a,0, firstArr,0,numFirst);

        System.arraycopy(firstArr,0,resArr,lastArr.length,firstArr.length);
        System.arraycopy(lastArr,0,resArr,0,lastArr.length);
        return resArr;
    }

}
