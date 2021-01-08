import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvertBinaryTreeTest {

    InvertBinaryTree.TreeNode node;

    @Before
    public void init() {
        node = new InvertBinaryTree.TreeNode();
        node.val = 4;
        node.left = new InvertBinaryTree.TreeNode(2);
        node.left.left = new InvertBinaryTree.TreeNode(1);
        node.left.right = new InvertBinaryTree.TreeNode(3);
        node.right = new InvertBinaryTree.TreeNode(7);
        node.right.left = new InvertBinaryTree.TreeNode(6);
        node.right.right = new InvertBinaryTree.TreeNode(9);
    }

    @Test
    public void test1() {
        InvertBinaryTree invert = new InvertBinaryTree(node);
        InvertBinaryTree.TreeNode inv = invert.invertTree2(node);
        node.print();
        inv.print();
    }

}