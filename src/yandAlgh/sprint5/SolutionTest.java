package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void treeSolution() {

         head = new Solution.Node(3);

        head.left = new Solution.Node(5);

        head.right = new Solution.Node(11);

        head.left.left = new Solution.Node(0);

        head.left.right = new Solution.Node(55);

        Solution.treeSolution(head);

    }
}