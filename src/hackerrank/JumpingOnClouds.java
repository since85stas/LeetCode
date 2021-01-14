package hackerrank;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int jumps = 0;
        int curr = c[0];
        int in=0;
        if (curr == 1) in=1;
        for (int i=in; i < c.length; i++) {
            if (i==c.length-1) {
                break;
            } else if (i==c.length-2){
                jumps++;
                break;
            }
            int next = c[i+1];
            int nextnext = c[i+2];
            if (nextnext==0) {
                i=i+1;
                jumps++;
            } else if (next==1){
                i=i+1;
                jumps++;
            } else {
                jumps++;
            }
        }

        return jumps;
    }

}
