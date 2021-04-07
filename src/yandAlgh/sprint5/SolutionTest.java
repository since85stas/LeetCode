package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void treeSolution() {

        Solution.Node head = new Solution.Node(1);

        head.left = new Solution.Node(2);

        head.right = new Solution.Node(2);

        head.left.left = new Solution.Node(3);

        head.left.right = new Solution.Node(4);

        head.right.left = new Solution.Node(3);

        head.right.right = new Solution.Node(4);

        boolean res =Solution.treeSolution(head);

//        int[] arr = new int[] {0, 12, 6, 8,3,15,7};
//
//        int res = Solution.siftUp(arr, 5);

        System.out.println(res);

    }
}