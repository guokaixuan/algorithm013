import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurs(root, result);
        return result;
    }

    /**
     * 递归
     * @param node
     * @param list
     */
    public void recurs(TreeNode node, List<Integer> list) {
        if(null == node) {
            return;
        }
        recurs(node.left, list);
        list.add(node.val);
        recurs(node.right, list);
    }

    /**
     * 迭代
     * @param node
     * @param list
     */
    public void recurs1(TreeNode node, List<Integer> list) {
        if(null == node) {
            return;
        }
        TreeNode current = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()) {
            while (null != current) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pollLast();
            list.add(current.val);
            current = current.right;
        }
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
