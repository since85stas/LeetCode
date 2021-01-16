package hackerrank;

import java.util.HashMap;
import java.util.TreeMap;

public class MinimumBribes {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] goalArr = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            goalArr[i] = i + 1;
        }
        int i = 0;
        boolean ch = false;
        for (int k = 0; k < q.length; k++) {
            for (i = 0; i < q.length; i++) {
                int num = i + 1;
                if (i != q.length - 1 && q[i] != num && q[i + 1] < q[i]) {
                    for (int j = 0; j < 1; j++) {
                        if (!map.containsKey(q[i + j])) {
                            map.put(q[i + j], 1);
                        } else {
                            int br = map.get(q[i + j]);
                            map.put(q[i + j], br + 1);
                        }
                    }
                    int temp = q[i];
                    q[i] = q[i + 1];
                    q[i + 1] = temp;
//                i = 0;
                    bribes++;

                    for (Integer max : map.values()
                    ) {
                        if (max > 2) {
                            ch = true;
                            break;
                        }
                    }
                    if (ch) break;
                }
            }
        }
        if (!ch) {
            System.out.println(bribes);
        } else System.out.println("Too chaotic");


    }

    // Complete the minimumBribes function below.
    static void minimumBribes2(int[] q) {

        int count = 0 ;

        //always keep track of min three vlaues observed
        //Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree =  Integer.MAX_VALUE;
        int minOfThree =  Integer.MAX_VALUE ;

        //iterating from left to right
        for(int i=q.length-1 ; i >= 0 ; i--){
            //person has no way to move more than two positions -> wrong
            if((q[i]-i) > 3 ) {
                System.out.println("Too chaotic");
                return;
            }
            else{
                //means current value has passed at least 3 values -> wrong
                if(q[i] > maxOfThree){
                    System.out.println("Too chaotic");
                    return;
                }
                else if(q[i] > midOfThree){ //means -> current value has bribed 2 ppl
                    count=count+2;
                }
                else if(q[i] > minOfThree){ //means-> current value has bribed 1 person.
                    count=count+1;
                }

                //Now adjust minThree values comparing, taking the current vlaue to account
                if(q[i]<minOfThree){
                    maxOfThree=midOfThree;
                    midOfThree=minOfThree;
                    minOfThree = q[i];
                }
                else if(q[i]<midOfThree){
                    maxOfThree=midOfThree;
                    midOfThree = q[i];
                }
                else if(q[i]<maxOfThree){
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }


}
