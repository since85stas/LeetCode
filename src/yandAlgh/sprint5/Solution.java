package yandAlgh.sprint5;

/**
 * Сам алгорим описан в теории. Сначала рассматриваем крайние случаи с вырожденными деревьями.
 * Затем, ищем замену для узла который надо удалить. Либо мамый правый элемент в левом поддереве, либо
 * если его нет то самый левый в правом поддереве. Заменяем на него удаляемый и если у заменяемого остались
 * дети то прибвляем его к родителю замены.
 *
 * сложность алгоритма O(k) - глубины дерева
 *
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
public class Solution {

    // ссылка на родителя для удаляемого
    static Node delParent;

    static Node changeParent;

    public static Node remove(Node root, int key) {

        // если ничего нет то возвращаем null
        if (root == null) return null;

        // находим узел для удаления
        Node toDel = find(root, delParent, key);

        // если такого узла в дереве нет то ничего не меняем
        if (toDel == null) return root;

        // если удаляемый это вершина и потомком нет то вернем null
        if (toDel.equals(root) && toDel.getLeft() == null && toDel.getRight() == null) return null;

        // родителя удаляемого узла
        Node delParent = Solution.delParent;

        // если у удаляемого нет потомков, значит мы можем просто удалить его, для этого у родителя заменяем его ссылку на null
        if (delParent != null && toDel.getLeft() == null && toDel.getRight() == null) {
            if (delParent.getLeft() != null && delParent.getLeft().getValue() == key) delParent.setLeft(null);
            else delParent.setRight(null);
            return root;
        }

        // в противном случае ищем ему замену
        // находим замену узлу
        if (toDel.getLeft() != null) {

                // находим замену
                Node change = findChange(toDel, changeParent);

                // находим родителя замены
                Node changeParent = Solution.changeParent;
//                        = findParent(root, change.getValue());

                // если получится что удаляемый элемент является родителем замены
                // то в таком случае можем просто переопределить левое поддерево замены удаляемому
                // все потомки будут там
                if (changeParent == toDel) {
                    toDel.setValue(change.getValue());
                    toDel.setLeft(change.getLeft());
                } else {
                    // если у замены нет потомков то просто заменяем
                    if (change.getLeft() == null) {
                        changeParent.setRight(null);

                        // меняем згачение
                        toDel.setValue(change.getValue());
                    } else {
                        // если они есть, то вставляем их в правую ветвь родителя
                        changeParent.setRight(change.getLeft());

                        // меняем згачение
                        toDel.setValue(change.getValue());
                    }
                }
        } else if (toDel.getRight() != null) {
            Node change = findChange(toDel, changeParent);

            // находим родителя замены
            Node changeParent = Solution.changeParent;
//                    = findParent(root, change.getValue());

            if (changeParent == toDel) {
                toDel.setValue(change.getValue());
                toDel.setRight(change.getRight());
            } else {
                // если у замены нет потомков то просто заменяем
                if (change.getRight() == null) {
                    changeParent.setLeft(null);

                    // меняем згачение
                    toDel.setValue(change.getValue());
                } else {
                    changeParent.setLeft(change.getRight());

                    // меняем згачение
                    toDel.setValue(change.getValue());
                }
            }
        }
        return root;
    }

    /**
     * Здесь не знаю может есть более эллегантный способ получить еще и родителя вершино,
     * но я сделал через статичепское поле класса, которое указывает на след элемент
     * @param root ссылка на вершину
     * @param parent ссылка на родителя вершины
     * @param key ключ который ищем
     */
    private static Node find(Node root, Node parent, int key) {
        if (root.getValue() == key) {
            delParent = parent;
            return root;
        }
        if (root.getLeft() != null && key < root.getValue()) {
            delParent = parent;
            return find(root.getLeft(), root, key);
        }
        if (root.getRight() != null && key >= root.getValue()) {
            delParent = parent;
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

    private static Node findChange(Node toDel, Node parent) {
       if (toDel.getLeft() != null) {
//           changeParent = toDel;
           return getRightest(toDel.getLeft(), parent);
       } else {
//           changeParent = toDel;
           return getLeftest(toDel.getRight(), parent);
       }
    }

    static Node getRightest(Node node, Node parent) {
        if (node.getRight() != null) {
            changeParent = node;
            node = getRightest(node.getRight(), parent);
        }
        return node;
    }

    static Node getLeftest(Node node, Node parent) {
        if (node.getLeft() != null) {
            changeParent = node;
            parent = node;
            node = getLeftest(node.getLeft(), parent);
        }
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
