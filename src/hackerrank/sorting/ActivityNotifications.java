package hackerrank.sorting;

import java.util.Arrays;

public class ActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        float lastMedian = 0.0F;
        int count = 0;
        if (expenditure.length > d) {
            int[] selectArr = new int[d];
            System.arraycopy(expenditure, 0, selectArr, 0, d);
            Arrays.sort(selectArr);
            for (int i = d; i < expenditure.length; i++) {
                if (d % 2 == 1) {
                    lastMedian = selectArr[d / 2];
                } else if (d % 2 == 0) {
                    lastMedian = (float) (((float) (selectArr[d / 2]) + (float) (selectArr[d / 2 - 1])) / 2.F);
                }
                if (expenditure[i] >= 2 * lastMedian) {
                    count++;
                }
                if (d != 1)selectArr = deleteFromSortArra(selectArr,expenditure[i-d]);
                if (d != 1)selectArr = addToSortArra(selectArr, expenditure[i]);
//                System.out.println("arr");
            }
        }
        return count;
    }

    static int[] deleteFromSortArra(int[] arr, int val) {
        int[] newArr = new int[arr.length-1];
        int leftV = 0;
        int rightVal = arr.length-1;
        while ( rightVal - leftV>= 1) {
            if (arr[leftV] == val) {
                newArr = removeElemFromArr(arr, leftV);
                return newArr;
            }
            if (arr[rightVal] == val) {
                newArr = removeElemFromArr(arr, leftV);
                return newArr;
            }
            int middle = (rightVal-leftV)/2;
            if ( arr[middle] < val ) {
                leftV = middle;
            } else {
                rightVal = middle;
            }
         }
        return newArr;
    }

    static int[] addToSortArra(int[] arr, int val) {
        int[] newArr = new int[arr.length-1];
        int leftV = 0;
        int rightVal = arr.length-1;
        while ( rightVal - leftV> 1) {
            int middle = leftV + (rightVal-leftV)/2;
            if ( arr[middle] < val ) {
                leftV = middle;
            } else {
                rightVal = middle;
            }
        }
        if (val < arr[rightVal] && val > arr[leftV]) {
            return addElemToArr(arr,leftV,val);
        } else if (val < arr[leftV]) {
            return addElemToArr(arr,leftV-1,val);
        } else {
            return addElemToArr(arr, rightVal+1,val);
        }
    }

    static int[] removeElemFromArr(int[] arr, int position) {
        int[] resArr = new int[arr.length-1];

        System.arraycopy(arr, 0, resArr, 0, position);
        System.arraycopy(arr, position+1, resArr, position, arr.length - position - 1);
        return resArr;
    }

    static int[] addElemToArr(int[] arr, int positionAft, int val) {
        int[] resArr = new int[arr.length+1];
        System.arraycopy(arr, 0, resArr, 0, positionAft);
        resArr[positionAft] = val;
        if (positionAft < arr.length-1) System.arraycopy(arr, positionAft, resArr, positionAft+1, arr.length - positionAft );
        return resArr;
    }
}
