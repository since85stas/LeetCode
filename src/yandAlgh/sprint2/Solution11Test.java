package yandAlgh.sprint2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11Test {

    @Test
    void solution() {

        String[] arr = new String[] {"a", "b","c"};

        Solution1.Node<String> head = new Solution1.Node<String>(arr[0], null);
        Solution1.Node<String> init = head;
        for (int i = 1; i < arr.length; i++) {
            head.next = new Solution1.Node<String>(arr[i], null);
            head = head.next;
        }

        int res = Solution1.solution(init,"dfdfa");
        System.out.println("");
    }
}