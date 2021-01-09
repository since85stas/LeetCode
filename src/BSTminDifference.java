import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTminDifference {

    public BSTminDifference() {}

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        int prev = 0;
        boolean isFirst = false;
        int mindiff = Integer.MAX_VALUE;
        BSTminDifference.TreeNode current = root;
        while (current != null || nodes.size() > 0) {

            if (current != null) {
                nodes.push(current);
                current = current.left;
            } else {
                TreeNode node = nodes.pop();
                if (!isFirst) {
                    isFirst = true;
                } else  {
                    int diff = Math.abs(prev-node.val);
                    if (diff < mindiff) mindiff = diff;
                }
                prev = node.val;
                System.out.printf("%s ", node.val);
                current = node.right;
            }

        }
        return mindiff;
    }


    static class TreeNode {
        int val;
        BSTminDifference.TreeNode left;
        BSTminDifference.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BSTminDifference.TreeNode left, BSTminDifference.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        void print() {
            goTree(this);
        }

        void goTree(BSTminDifference.TreeNode node) {

            System.out.println(node.val);
            if (node.left != null) {
                goTree(node.left);
            }
            if (node.right != null) {
                goTree(node.right);
            }
        }

    }

}
