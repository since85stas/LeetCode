package yandAlgh.sprint4;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

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
//            idx = siftUp(heap, parent);
//        }
//        return idx;
//    }

    public static int siftDown(int[] heap, int idx) {
        // your code
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int index_largest = idx;
        if (heap.length <= left || heap.length == 2) {
            return idx;
        }
        if ( right < heap.length && heap[left] < heap[right]) {
            index_largest = right;
        } else {
            index_largest = left;
        }

        if (heap[idx] < heap[index_largest]) {
            int temp = heap[index_largest];
            heap[index_largest] = heap[idx];
            heap[idx] = temp;
            idx = siftDown(heap, index_largest);
        }
        return idx;
    }

//    public static boolean treeSolution(Node head) {
//
//        return anagr(head);
//    }

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
//    static List<Integer> lefta = new ArrayList<>();
//    static List<Integer> righta = new ArrayList<>();
//
//    static boolean anagr(Node head) {
//        if (head.left != null) LMR(head.left);
//        if (head.right != null) RMR(head.right);
//        return lefta.equals(righta);
//    }
//
//    static void LMR(Node node) {
//        if (node.left != null) LMR(node.left);
////        System.out.println(node.value);
//        lefta.add(node.value);
//        if (node.right != null) LMR(node.right);
//    }
//
//    static void RMR(Node node) {
//        if (node.right != null) RMR(node.right);
////        System.out.println(node.value);
//        righta.add(node.value);
//        if (node.left != null) RMR(node.left);
//    }

    /* ПОЛЕЗНЫЕ ФУНКЦИИ ДЛЯ ТЕСТИРОВАНИЯ isBalanced () ФУНКЦИЯ */
            /* Функция вычисляет «высоту» дерева. Высота это
    количество узлов вдоль самого длинного пути от корневого узла
    вплоть до самого дальнего листового узла. */
//    static int height(Node node)
//    {
//        /* базовое дерево пусто */
//        if (node == null)
//            return 0;
//
//        int hl = height(node.left);
//        int hr = height(node.right);
//        /* Если дерево не пустое, то высота = 1 + максимум слева
//        высота и правая высота */
//        return 1 + Math.max(hl, hr);
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
