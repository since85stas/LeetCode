package yandAlgh.sprint2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    @Test
    void solution() {

        String[] arr = new String[] {"a", "b"};

        Solution1.Node<String> head = new Solution1.Node<String>(arr[0], null);
        Solution1.Node<String> init = head;
        for (int i = 1; i < arr.length; i++) {
            head.next = new Solution1.Node<String>(arr[i], null);
            head = head.next;
        }

        Solution1.Node<String> res = Solution1.solution(init,2);
        System.out.println("");
    }
}