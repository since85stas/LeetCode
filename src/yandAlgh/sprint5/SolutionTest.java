package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static List<Integer> lefta = new ArrayList<>();
    static List<Integer> righta = new ArrayList<>();

    static boolean equals(Solution.Node head, Solution.Node head2) {
        if (head != null) LMR(head, lefta);
        if (head2 != null) LMR(head2, righta);
        return lefta.equals(righta);
    }

    static void LMR(Solution.Node node, List<Integer> list) {
        if (node.left != null) LMR(node.left, list);
//        System.out.println(node.value);
        list.add(node.value);
        if (node.right != null) LMR(node.right, list);
    }

    @Test
    void treeSolution() {

        Solution.Node head = new Solution.Node(null, null,8);
        head.left = new Solution.Node(null, null,4);
        head.right = new Solution.Node(null, null,11);
        head.left.left = new Solution.Node(null, null,2);
        head.left.right = new Solution.Node(null, null,6);
        head.right.left = new Solution.Node(null, null,10);
        head.right.right = new Solution.Node(null, null,14);
        head.right.left.left = new Solution.Node(null, null,9);
        head.right.right.left = new Solution.Node(null, null,13);
        head.right.right.right = new Solution.Node(null, null,15);

        Solution.Node res =Solution.remove(head, 11);

        Solution.Node exp = new Solution.Node(null, null,8);
        exp.left = new Solution.Node(null, null,4);
        exp.right = new Solution.Node(null, null,10);
        exp.left.left = new Solution.Node(null, null,2);
        exp.left.right = new Solution.Node(null, null,6);
        exp.right.right = new Solution.Node(null, null,14);
        exp.right.left = new Solution.Node(null, null,9);
        exp.right.right.left = new Solution.Node(null, null,13);
        exp.right.right.right = new Solution.Node(null, null,15);

        System.out.println(res);
        assertTrue(equals(res, exp));

    }

    @Test
    void treeSolution2() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,10);

        Solution.Node res =Solution.remove(head, 10);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.left = new Solution.Node(null, null,8);

        assertTrue(equals(res, exp));

        System.out.println(res);
    }

    @Test
    void treeSolution22() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,10);

        Solution.Node res =Solution.remove(head, 9);

        Solution.Node exp = new Solution.Node(null, null,8);
        exp.right = new Solution.Node(null, null,10);

        assertTrue(equals(res, exp));

        System.out.println(res);
    }

    @Test
    void treeSolution23() {

        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,10);

        Solution.Node res =Solution.remove(head, 8);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.right = new Solution.Node(null, null,10);

        assertTrue(equals(res, exp));

        System.out.println(res);

    }

    @Test
    void treeSolution3() {

        Solution.Node head = new Solution.Node(null, null,9);

        head.left = new Solution.Node(null, null,6);

        head.left.right = new Solution.Node(null, null,8);
//
        head.left.left = new Solution.Node(null, null,5);


        Solution.Node res =Solution.remove(head, 6);

//        int[] arr = new int[] {0, 12, 6, 8,3,15,7};

//        int[] arr = new int[] {0,12, 1, 8,3,4,7};

        System.out.println(res);
//        System.out.println(Arrays.toString(arr));

    }


}