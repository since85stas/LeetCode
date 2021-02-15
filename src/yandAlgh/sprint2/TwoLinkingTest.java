package yandAlgh.sprint2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoLinkingTest {

    @Test
    void solution() {
        String[] arr = new String[] {"a", "b","c"};

        TwoLinking.Node<String> node = new TwoLinking.Node<String>(arr[0], null, null);

        TwoLinking.Node<String> init = node;

        for (int i = 1; i < arr.length; i++) {
            TwoLinking.Node<String> curr = new TwoLinking.Node<String>(arr[i], null, node);
            node.next = curr;
            curr.prev = node;

            node = curr;
        }

        TwoLinking.Node<String> res = TwoLinking.solution(init);
        System.out.println("");
    }
}