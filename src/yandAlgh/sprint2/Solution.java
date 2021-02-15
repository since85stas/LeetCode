//public class Solution {
//
//
//    static Node<String> solution(Node<String> head) {
//        Node<String> last = null;
//
//        while (head !=null) {
//            last = head;
//            head = head.next;
//        }
//
//
//
//        Node<String> reverseInit = last;
//
//        while (last != null) {
//            Node<String> tmp = last.prev;
//            last.prev = last.next;
//            last.next = tmp;
//            last = last.next;
//        }
//        return reverseInit;
//    }
//
//}
