package hackerrank;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = i+1;
            if (arr[i] != num) {
               int goalPos = getElemPos(arr,num);
               int temp = arr[i];
               arr[i]=arr[goalPos];
               arr[goalPos] = temp;
               swaps++;
               i=0;
            }
        }
        return swaps;
    }

    static int getElemPos(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
}
