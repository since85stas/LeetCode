package yandAlgh.sprint5;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountTrees {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

//        int n = 3;
        int res =countTrees(n);
        System.out.println(res);
    }

    static int countTrees(int numKeys) {

        if (numKeys <=1) {
            return(1);
        }
        else {
            // there will be one value at the root, with whatever remains
            // on the left and right each forming their own subtrees.
            // Iterate through all the values that could be the root...
            int sum = 0;
            int left, right, root;

            for (root=1; root<=numKeys; root++) {
                left = countTrees(root - 1);
                right = countTrees(numKeys - root);

                // number of possible trees with this root == left*right
                sum += left*right;
            }

            return(sum);
        }
    }
}
