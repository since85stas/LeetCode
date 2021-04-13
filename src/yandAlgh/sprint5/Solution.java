package yandAlgh.sprint5;

public class Solution {

    static Node lastParent;

    public static Node remove(Node root, int key) {

        if (root == null) return null;

        // находим узел для удаления
        Node toDel = find(root, lastParent, key);

        // если такого узла в дереве нет то ничего не меняем
        if (toDel == null) return root;

        if (toDel.equals(root) && toDel.getLeft() == null && toDel.getRight() == null) return null;

        // находим родителя узла
        Node delParent = lastParent;

        // если у удаляемого нет потомков, значит мы можем просто удалить его, для этого у родителя заменяем его ссылку на null
        if (delParent != null && toDel.getLeft() == null && toDel.getRight() == null) {
            if (delParent.getLeft() != null && delParent.getLeft().getValue() == key) delParent.setLeft(null);
            else delParent.setRight(null);
            return root;
        }

        // в противном случае ищем ему замену
        // находим замену узлу
        if (toDel.getLeft() != null && toDel.getRight() != null) {
                Node change = findChange(toDel, key);

                // находим родителя замены
                Node changeParent = findParent(root, change.getValue());

                if (changeParent == toDel) {
                    toDel.setValue(change.getValue());
                    toDel.setLeft(change.getLeft());
                } else {
                    // если у замены нет потомков то просто заменяем
                    if (change.getLeft() == null) {
                        changeParent.setRight(null);
                        toDel.setValue(change.getValue());
                    } else {
                        changeParent.setRight(change.getLeft());
                        toDel.setValue(change.getValue());
                    }
                }


        } else if (toDel.getLeft() != null || toDel.getRight() != null) {
            if (delParent != null) {
                if (toDel.getLeft() != null) {
                    delParent.setLeft(toDel.getLeft());
                } else {
                    delParent.setRight(toDel.getRight());
                }
            } else {
                if (toDel.getLeft() != null) {
                    root = toDel.getLeft();
                } else {
                    root = toDel.getRight();
                }
            }
        }

        return root;

    }

    private static Node find(Node root, Node parent, int key) {
        if (root.getValue() == key) {
            lastParent = parent;
            return root;
        }
        if (root.getLeft() != null && key < root.getValue()) {
            lastParent = parent;
            return find(root.getLeft(), root, key);
        }
        if (root.getRight() != null && key >= root.getValue()) {
            lastParent = parent;
            return find(root.getRight(), root, key);
        }
        return null;
    }

    private static Node findParent(Node root, int key) {
        if (root.getValue() == key) {
            return null;
        }
        if (root.getLeft() != null && key < root.getValue()) {
            if (root.getLeft().getValue() == key) return root;
            return findParent(root.getLeft(), key);
        }
        if (root.getRight() != null && key >= root.getValue()) {
            if (root.getRight().getValue() == key) return root;
            return findParent(root.getRight(), key);
        }
        return null;
    }

    private static Node findChange(Node toDel, int key) {
       return getRightest(toDel.getLeft());
    }

    static Node getRightest(Node node) {
        if (node.getRight() != null) node = getRightest(node.getRight());
        return node;
    }

    static Node getLeftest(Node node) {
        if (node.getLeft() != null) node = getLeftest(node.getLeft());
        return node;
    }


    public static class Node {
        Node left;
        Node right;
        int value;

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

}
