//package yandAlgh.sprint5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    static int lastPos = 1;
//
//    public static int siftUp(int[] heap, int idx) {
//
//        if (idx == 1) {
//            return idx;
//        }
//        int parent = idx/2;
//
//        if (heap[parent] < heap[idx]) {
//            int temp = heap[parent];
//            heap[parent] = heap[idx];
//            heap[idx] = temp;
//            lastPos = siftUp(heap, parent);
//        }
//        return lastPos;
//    }

    public static boolean treeSolution(Node head) {

        return anagr(head);
    }

    /* Возвращает true, если двоичное дерево с корнем в качестве корня сбалансировано по высоте */

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
//                && isBalanced(node.right)) {}
//
////            return true;
//        /* Если мы достигаем здесь, то дерево не сбалансировано по высоте */
//        return Math.max(lh, rh);
//    }
    static List<Integer> lefta = new ArrayList<>();
    static List<Integer> righta = new ArrayList<>();

    static boolean anagr(Node head) {
        if (head.left != null) LMR(head.left);
        if (head.right != null) RMR(head.right);
        return lefta.equals(righta);
    }

    static void LMR(Node node) {
        if (node.left != null) LMR(node.left);
//        System.out.println(node.value);
        lefta.add(node.value);
        if (node.right != null) LMR(node.right);
    }

    static void RMR(Node node) {
        if (node.right != null) RMR(node.right);
//        System.out.println(node.value);
        righta.add(node.value);
        if (node.left != null) RMR(node.left);
    }

    /* ПОЛЕЗНЫЕ ФУНКЦИИ ДЛЯ ТЕСТИРОВАНИЯ isBalanced () ФУНКЦИЯ */
            /* Функция вычисляет «высоту» дерева. Высота это
    количество узлов вдоль самого длинного пути от корневого узла
    вплоть до самого дальнего листового узла. */
    static int height(Node node)
    {
        /* базовое дерево пусто */
        if (node == null)
            return 0;

        int hl = height(node.left);
        int hr = height(node.right);
        /* Если дерево не пустое, то высота = 1 + максимум слева
        высота и правая высота */
        return 1 + Math.max(hl, hr);

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
