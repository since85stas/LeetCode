package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        TreeSet<Byte> sums = new TreeSet<>();
//        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j+1] +arr[i][j+2]+ arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                sums.add((byte) sum);
//                list.add((byte)sum);
            }

        }
        return sums.last();
    }

}
