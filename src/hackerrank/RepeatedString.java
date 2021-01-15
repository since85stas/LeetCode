package hackerrank;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aInInit = numAinStr(s);
        long len = s.length();
        long prim = n/len;
        long ost = n%len;
        long numOst = numAinStr(s.substring(0,(int)ost));
        long num = prim*aInInit + numOst;
        return num;
    }

    static long numAinStr(String s) {
        long num =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') num++;
        }
        return num;
    }

}
