import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println("test");
    }

//    public static int treeSolution(Node head) {
//
//        int max = Integer.MIN_VALUE;
//
//        Queue<Node> queue = new LinkedList<>();
//
//        queue.add(head);
//
//        while (!queue.isEmpty()) {
//            Node last = queue.poll();
//            if (last.value > max) {
//                max = last.value;
//            }
//            if (last.left != null) queue.add(last.left);
//            if (last.right != null) queue.add(last.right);
//        }
//
//        return max;
//    }

    public static boolean treeSolution(Node head) {
//                int max = Integer.MIN_VALUE;

        Queue<Node> queue = new LinkedList<>();

        queue.add(head);

        while (!queue.isEmpty()) {
            Node last = queue.poll();
            if (last.left != null && last.left.value >= last.value) {
                return false;
            }
            if (last.right != null && last.right.value <= last.value) {
                return false;
            }
            if (last.left != null) queue.add(last.left);
            if (last.right != null) queue.add(last.right);
        }
        return true;
    }

//    public static class Node {
//        int value;
//        Node left;
//        Node right;
//
//        Node(int value) {
//            this.value = value;
//            right = null;
//            left = null;
//        }
//    }
}
