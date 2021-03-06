import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTminDifferenceTest {

    BSTminDifference.TreeNode node;

    @Before
    public void init() {
        node = new BSTminDifference.TreeNode();
        node.val = 4;
        node.left = new BSTminDifference.TreeNode(2);
        node.left.left = new BSTminDifference.TreeNode(1);
        node.left.right = new BSTminDifference.TreeNode(3);
        node.right = new BSTminDifference.TreeNode(7);
        node.right.left = new BSTminDifference.TreeNode(6);
        node.right.right = new BSTminDifference.TreeNode(9);
    }

    @Test
    public void minDiffInBST() {
        node = new BSTminDifference.TreeNode();
        node.val = 4;
        node.left = new BSTminDifference.TreeNode(2);
        node.left.left = new BSTminDifference.TreeNode(1);
        node.left.right = new BSTminDifference.TreeNode(3);
        node.right = new BSTminDifference.TreeNode(7);
        node.right.left = new BSTminDifference.TreeNode(6);
        node.right.right = new BSTminDifference.TreeNode(9);
        BSTminDifference difference = new BSTminDifference();
        int min = difference.minDiffInBST(node);
    }
}