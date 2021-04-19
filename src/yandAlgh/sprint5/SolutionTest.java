package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static List<Integer> resArr = new ArrayList<>();
    static List<Integer> expArr = new ArrayList<>();

    static boolean equals(Solution.Node result, Solution.Node exp) {
        if (result != null) LMR(result, resArr);
        if (exp != null) LMR(exp, expArr);
        return resArr.equals(expArr);
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
    void treeSolution0() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);

        Solution.Node res =Solution.remove(head, 10);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.left = new Solution.Node(null, null,8);

        assertTrue(equals(res, exp));

        System.out.println(res);
    }

    @Test
    void treeSolution01() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);

        Solution.Node res =Solution.remove(head, 8);

        Solution.Node exp = new Solution.Node(null, null,9);

        assertTrue(equals(res, exp));

        System.out.println(res);
    }

    @Test
    void treeSolution02() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.left = new Solution.Node(null, null,8);

        Solution.Node res =Solution.remove(head, 9);

        Solution.Node exp = new Solution.Node(null, null,8);

        assertTrue(equals(res, exp));

        System.out.println(res);
    }

    @Test
    void treeSolution03() {
        Solution.Node head = new Solution.Node(null, null,9);
        Solution.Node res =Solution.remove(head, 9);

        Solution.Node exp = null;

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
        head.left.left = new Solution.Node(null, null,5);

        Solution.Node res =Solution.remove(head, 6);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.left = new Solution.Node(null, null,8);
        exp.left.left = new Solution.Node(null, null,5);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution32() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.right = new Solution.Node(null, null,11);
        head.left = new Solution.Node(null, null,6);
        head.left.right = new Solution.Node(null, null,8);
        head.left.left = new Solution.Node(null, null,5);

        Solution.Node res =Solution.remove(head, 9);

        Solution.Node exp = new Solution.Node(null, null,8);
        exp.right = new Solution.Node(null, null,11);
        exp.left = new Solution.Node(null, null,6);
        exp.left.left = new Solution.Node(null, null,5);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution33() {
        Solution.Node head = new Solution.Node(null, null,9);
        head.right = new Solution.Node(null, null,11);
        head.left = new Solution.Node(null, null,6);
        head.left.right = new Solution.Node(null, null,8);
        head.left.left = new Solution.Node(null, null,5);

        Solution.Node res =Solution.remove(head, 11);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.left = new Solution.Node(null, null,6);
        exp.left.right = new Solution.Node(null, null,8);
        exp.left.left = new Solution.Node(null, null,5);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution4() {
        Solution.Node head = new Solution.Node(null, null,5);
        head.right = new Solution.Node(null, null,9);
        head.right.left = new Solution.Node(null, null,7);
        head.right.left.left = new Solution.Node(null, null,6);
        head.right.left.right = new Solution.Node(null, null,8);
        head.right.right = new Solution.Node(null, null,13);
        head.right.right.right = new Solution.Node(null, null,15);

        Solution.Node res =Solution.remove(head, 7);

        Solution.Node exp = new Solution.Node(null, null,5);
        exp.right = new Solution.Node(null, null,9);

        exp.right.left = new Solution.Node(null, null,8);
        exp.right.left.left = new Solution.Node(null, null,6);

        exp.right.right = new Solution.Node(null, null,13);
        exp.right.right.right = new Solution.Node(null, null,15);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution5() {
        Solution.Node head = new Solution.Node(null, null,10);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,12);

        head.left.left = new Solution.Node(null, null,5);
        head.left.right = new Solution.Node(null, null,9);

        head.right.left = new Solution.Node(null, null,11);
        head.right.right = new Solution.Node(null, null,13);

        Solution.Node res =Solution.remove(head, 10);

        Solution.Node exp = new Solution.Node(null, null,9);
        exp.left = new Solution.Node(null, null,8);
        exp.right = new Solution.Node(null, null,12);

        exp.left.left = new Solution.Node(null, null,5);

        exp.right.left = new Solution.Node(null, null,11);
        exp.right.right = new Solution.Node(null, null,13);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution51() {
        Solution.Node head = new Solution.Node(null, null,10);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,12);

        head.left.left = new Solution.Node(null, null,5);
        head.left.right = new Solution.Node(null, null,9);

        head.left.left.left = new Solution.Node(null, null,4);
        head.left.left.right = new Solution.Node(null, null,7);
        head.left.left.right.left = new Solution.Node(null, null,6);

        head.right.left = new Solution.Node(null, null,11);
        head.right.right = new Solution.Node(null, null,13);

        Solution.Node res =Solution.remove(head, 8);

        Solution.Node exp = new Solution.Node(null, null,10);
        exp.left = new Solution.Node(null, null,7);
        exp.right = new Solution.Node(null, null,12);

        exp.left.left = new Solution.Node(null, null,5);
        exp.left.right = new Solution.Node(null, null,9);
        exp.left.left.left = new Solution.Node(null, null,4);
        exp.left.left.right = new Solution.Node(null, null,6);

        exp.right.left = new Solution.Node(null, null,11);
        exp.right.right = new Solution.Node(null, null,13);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution52() {
        Solution.Node head = new Solution.Node(null, null,10);
        head.left = new Solution.Node(null, null,8);
        head.right = new Solution.Node(null, null,12);

        head.left.left = new Solution.Node(null, null,5);
        head.left.right = new Solution.Node(null, null,9);

        head.left.left.left = new Solution.Node(null, null,4);
        head.left.left.right = new Solution.Node(null, null,7);
        head.left.left.right.left = new Solution.Node(null, null,6);

        head.right.left = new Solution.Node(null, null,11);
        head.right.right = new Solution.Node(null, null,13);

        Solution.Node res =Solution.remove(head, 8);

        Solution.Node exp = new Solution.Node(null, null,10);
        exp.left = new Solution.Node(null, null,7);
        exp.right = new Solution.Node(null, null,12);

        exp.left.left = new Solution.Node(null, null,5);
        exp.left.right = new Solution.Node(null, null,9);
        exp.left.left.left = new Solution.Node(null, null,4);
        exp.left.left.right = new Solution.Node(null, null,6);

        exp.right.left = new Solution.Node(null, null,11);
        exp.right.right = new Solution.Node(null, null,13);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }

    @Test
    void treeSolution6() {
        Solution.Node head = new Solution.Node(null, null,100);
        head.left = new Solution.Node(null, null,50);
//        head.right = new Solution.Node(null, null,125);

        head.left.left = new Solution.Node(null, null,25);
        head.left.right = new Solution.Node(null, null,75);
//        head.right.left = new Solution.Node(null, null,112);

        head.left.left.left = new Solution.Node(null, null,12);
        head.left.left.right = new Solution.Node(null, null,35);
        head.left.left.right.left = new Solution.Node(null, null,30);

        head.left.left.right.left.left = new Solution.Node(null, null,29);
        head.left.left.right.left.right = new Solution.Node(null, null,31);

        head.left.left.right.left.right.right = new Solution.Node(null, null,32);
//
//        head.right.left = new Solution.Node(null, null,11);
//        head.right.right = new Solution.Node(null, null,13);

        Solution.Node res =Solution.remove(head, 100);

        Solution.Node exp = new Solution.Node(null, null,75);
        exp.left = new Solution.Node(null, null,50);
//        exp.right = new Solution.Node(null, null,125);
//        exp.right = new Solution.Node(null, null,12);

        exp.left.left = new Solution.Node(null, null,25);
//        exp.left.right = new Solution.Node(null, null,75);
//        exp.right.left = new Solution.Node(null, null,112);

        exp.left.left.left = new Solution.Node(null, null,12);
        exp.left.left.right = new Solution.Node(null, null,35);
        exp.left.left.right.left = new Solution.Node(null, null,30);

        exp.left.left.right.left.left = new Solution.Node(null, null,29);
        exp.left.left.right.left.right = new Solution.Node(null, null,31);

        exp.left.left.right.left.right.right = new Solution.Node(null, null,32);

//        exp.left.left.right.left.right.right = new Solution.Node(null, null,32);

        assertTrue(equals(res, exp));
        System.out.println(res);
    }


}