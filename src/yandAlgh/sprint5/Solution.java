/**
 * Сам алгорим описан в теории. Сначала рассматриваем крайние случаи с вырожденными деревьями.
 * Затем, ищем замену для узла который надо удалить. Либо мамый правый элемент в левом поддереве, либо
 * если его нет то самый левый в правом поддереве. Заменяем на него удаляемый и если у заменяемого остались
 * дети то прибвляем его к родителю замены.
 *
 * сложность алгоритма O(k) - глубины дерева
 *
 * успешная посылка https://contest.yandex.ru/contest/24810/run-report/50691515/
 */
public class Solution {

    // ссылка на родителя для удаляемого
    static Node delParent;

    // ссылка на родителя для замены
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

        // для удобства переопределяем родителя удаляемого узла
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

                // для удобства переопределяем родителя замены
                Node changeParent = Solution.changeParent;

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
            // Здесь все аналогично только для правого поддерева

            // находим замену
            Node change = findChange(toDel, changeParent);

            // для удобства переопределяем
            Node changeParent = Solution.changeParent;

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

    /**
     * Если есть левое поддерево то ищем там иначе в правой
     * @param toDel - элемент которому ищем замену
     * @param parent - ссылка на родителя
     */
    private static Node findChange(Node toDel, Node parent) {
       if (toDel.getLeft() != null) {
           changeParent = toDel;
           return getRightest(toDel.getLeft(), parent);
       } else {
           changeParent = toDel;
           return getLeftest(toDel.getRight(), parent);
       }
    }

    /**
     * возвращает самую правуб вершину
     */
    static Node getRightest(Node node, Node parent) {
        if (node.getRight() != null) {
            changeParent = node;
            node = getRightest(node.getRight(), parent);
        }
        return node;
    }

    /**
     * возвращает самую левую вершину
     */
    static Node getLeftest(Node node, Node parent) {
        if (node.getLeft() != null) {
            changeParent = node;
            parent = node;
            node = getLeftest(node.getLeft(), parent);
        }
        return node;
    }

    // для тестирования
//    public static class Node {
//        Node left;
//        Node right;
//        int value;
//
//        public int getValue() {
//            return value;
//        }
//
//        public Node getRight() {
//            return right;
//        }
//
//        public Node getLeft() {
//            return left;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public void setRight(Node right) {
//            this.right = right;
//        }
//
//        public void setLeft(Node left) {
//            this.left = left;
//        }
//
//        public Node(Node left, Node right, int value) {
//            this.left = left;
//            this.right = right;
//            this.value = value;
//        }
//    }

}
