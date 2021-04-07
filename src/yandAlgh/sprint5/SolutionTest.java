package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void treeSolution() {

        Solution.Node head = new Solution.Node(7);

        head.left = new Solution.Node(1);

        head.right = new Solution.Node(8);

//        head.right.left = new Solution.Node(8);

        boolean res =Solution.treeSolution(head);

        System.out.println(res);

    }
}