package yandAlgh.sprint5;

public class DeleteNode {

    public static Node remove(Node root, int key) {

        return null;
    }


    public static class Node {
        Node left;
        Node right;
        int value;
        public int getValue() {return value;}
        public Node getRight() {return right;}
        public Node getLeft() {return left;};
        public void setValue(int value) {this.value= value;}
        public void setRight(Node right) {this.right=right;};
        public void setLeft(Node left) {this.left= left;};
        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

}
