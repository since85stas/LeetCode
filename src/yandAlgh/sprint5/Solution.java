package yandAlgh.sprint5;

public class Solution {

    public static int siftUp(int[] heap, int idx) {



        return 0;
    }

//    public static boolean treeSolution(Node head) {
//        return isBalanced(head);
//    }
//
//    /* Возвращает true, если двоичное дерево с корнем в качестве корня сбалансировано по высоте */
//
//    static boolean isBalanced(Node node)
//    {
//        int lh; /* для высоты левого поддерева */
//
//        int rh; /* для высоты правого поддерева */
//
//        /* Если дерево пусто, вернуть true */
//        if (node == null)  return true;
//
//        /* Получить высоту левого и правого поддеревьев */
//        lh = height(node.left);
//        rh = height(node.right);
//        if (Math.abs(lh - rh) <= 1
//                && isBalanced(node.left)
//                && isBalanced(node.right))
//
//            return true;
//        /* Если мы достигаем здесь, то дерево не сбалансировано по высоте */
//        return false;
//    }
//
//
//
//    /* ПОЛЕЗНЫЕ ФУНКЦИИ ДЛЯ ТЕСТИРОВАНИЯ isBalanced () ФУНКЦИЯ */
//            /* Функция вычисляет «высоту» дерева. Высота это
//    количество узлов вдоль самого длинного пути от корневого узла
//    вплоть до самого дальнего листового узла. */
//    static int height(Node node)
//    {
//        /* базовое дерево пусто */
//        if (node == null)
//            return 0;
//
//        /* Если дерево не пустое, то высота = 1 + максимум слева
//        высота и правая высота */
//        return 1 + Math.max(height(node.left), height(node.right));
//
//    }


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
