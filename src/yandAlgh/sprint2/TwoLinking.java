package yandAlgh.sprint2;

public class TwoLinking {

    static Node<String> solution(Node<String> head) {
        Node<String> last = null;

        while (head !=null) {
            last = head;
            head = head.next;
        }



        Node<String> reverseInit = last;

        while (last != null) {
            Node<String> tmp = last.prev;
            last.prev = last.next;
            last.next = tmp;
            last = last.next;
        }
        return reverseInit;
    }

    static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> prev;

        public Node(V value, Node<V> next, Node<V> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
