import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    TreeNode treeNode;
    TreeNode invNode;

    InvertBinaryTree(TreeNode treeNode) {
        this.treeNode = treeNode;
        invNode = new TreeNode();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode res = invertOne(root, invNode);
            return invNode;
        } else {
            return null;
        }
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree2(root.right);
        TreeNode left = invertTree2(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTreePrim(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    private TreeNode invertOne(TreeNode prim, TreeNode inv) {
        inv.val = prim.val;
        if (prim.left != null) {
            inv.right = new TreeNode();
            invertOne(prim.left, inv.right);
        }
        if (prim.right != null) {
            inv.left = new TreeNode();
            invertOne(prim.right, inv.left);
        }
        return inv;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        void print() {
           goTree(this);
        }

        void goTree(TreeNode node) {

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
