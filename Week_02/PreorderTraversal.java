import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    /**
     * 递归
     * @param node
     * @param list
     */
    public void traversal(TreeNode node, List<Integer> list) {
        if(null == node) {
            return;
        }
        list.add(node.val);
        traversal(node.left, list);
        traversal(node.right, list);
    }

    /**
     * 迭代
     * @param node
     * @param list
     */
    public void traversal1(TreeNode node, List<Integer> list) {
        if(null == node) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            TreeNode item = stack.pollLast();
            list.add(item.val);
            if(null != item.right) {
                stack.add(item.right);
            }
            if(null != item.left) {
                stack.add(item.left);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
