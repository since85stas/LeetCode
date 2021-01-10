import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BtreeInorder {

    public List<Integer> inorderTraversal(BSTminDifference.TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<BSTminDifference.TreeNode> stack = new Stack<>();

        BSTminDifference.TreeNode current = root;

        while (current != null || stack.size() > 0) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BSTminDifference.TreeNode node = stack.pop();
//                System.out.println(node.val);
                list.add(node.val);
                current = node.right;
            }
        }

        return list;
    }

}
