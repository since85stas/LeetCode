package yandAlgh.sprint5;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void treeSolution() {

        Solution.Node head = new Solution.Node(null, null,8);

        head.left = new Solution.Node(null, null,4);
//
        head.right = new Solution.Node(null, null,11);
//
        head.left.left = new Solution.Node(null, null,2);
//
        head.left.right = new Solution.Node(null, null,6);

        head.right.left = new Solution.Node(null, null,10);

        head.right.right = new Solution.Node(null, null,14);

        head.right.left.left = new Solution.Node(null, null,9);

        head.right.right.left = new Solution.Node(null, null,13);

        head.right.right.right = new Solution.Node(null, null,15);

//        Solution.Node n = Solution.RMR(head);

        Solution.Node res =Solution.remove(head, 8);

//        int[] arr = new int[] {0, 12, 6, 8,3,15,7};

//        int[] arr = new int[] {0,12, 1, 8,3,4,7};

        System.out.println(res);
//        System.out.println(Arrays.toString(arr));

    }

    @Test
    void treeSolution2() {

        Solution.Node head = new Solution.Node(null, null,9);

        head.left = new Solution.Node(null, null,8);
//
        head.right = new Solution.Node(null, null,10);


        Solution.Node res =Solution.remove(head, 10);

//        int[] arr = new int[] {0, 12, 6, 8,3,15,7};

//        int[] arr = new int[] {0,12, 1, 8,3,4,7};

        System.out.println(res);
//        System.out.println(Arrays.toString(arr));

    }

    @Test
    void treeSolution3() {

        Solution.Node head = new Solution.Node(null, null,9);

        head.left = new Solution.Node(null, null,6);

        head.left.right = new Solution.Node(null, null,8);
//
        head.left.left = new Solution.Node(null, null,5);


        Solution.Node res =Solution.remove(head, 6);

//        int[] arr = new int[] {0, 12, 6, 8,3,15,7};

//        int[] arr = new int[] {0,12, 1, 8,3,4,7};

        System.out.println(res);
//        System.out.println(Arrays.toString(arr));

    }


}