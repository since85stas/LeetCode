package hackerrank.sorting;

import java.util.Arrays;

public class ActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        float lastMedian = 0.0F;
        int count = 0;
        for (int i = d; i < expenditure.length; i++) {
            int[] selectArr = new int[d];
            System.arraycopy(expenditure,i-d,selectArr,0,d);
            Arrays.sort(selectArr);
            if (d%2 ==1) {
                lastMedian = selectArr[d/2];
            } else if (d%2 == 0) {
                lastMedian = (float) (((float)(selectArr[d/2])+(float) (selectArr[d/2 -1]))/2.F);
            }
            if (expenditure[i] >= 2*lastMedian) {
                count++;
            }
        }
        return count;
    }

}
