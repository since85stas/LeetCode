package yandAlgh.sprint2;

public class Solution1 {




    /**
     * B
     * @param head
     * @param index
     * @return
     */
//    public static void solution(Node<String> head) {
//        Node<String> current = head;
//        while (current != null) {
//            System.out.println(current.value);
//            current = current.next;
//        }
//    }

    /**
     * B
     * @param <V>
     */
//    public static Node<String> solution(Node<String> head, int index) {
//        Node<String> init = head;
//        short count = 0;
//        while (head.next != null) {
//            if (count == index-1) {
////                newArr = newArr.next;
//                if (head.next.next != null) {
//                    head.next = head.next.next;
//                } else {
//                    head.next = null;
//                }
//            } else {
////                newArr = head;
//                head = head.next;
//            }
//            count++;
//        }
//
//
//        if (count ==0 && index == 0) {
//            return null;
//        } else if (count ==0 && index != 0) {
//            return head;
//        }
//        else if (index != 0) {
//            return init;
//        }
//        else {
//            return init.next;
//        }
//
//
//    }

    static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }
}
