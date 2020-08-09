import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :

 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class Preorder {

    public List<Integer> preorder(Node root) {
        /* 递归
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
        */

        /*迭代*/
        return iterate(root);
    }

    /**
     * 递归
     * @param node
     * @param list
     */
    public void recursive(Node node, List<Integer> list) {
        if(null == node) {
            return;
        }
        list.add(node.val);
        if(null != node.children) {
            node.children.forEach(v -> {
                recursive(v, list);
            });
        }
    }

    /**
     * 迭代
     * @param node
     * @param
     */
    public List<Integer> iterate(Node node) {
        if(null == node) {
            return new ArrayList<>();
        }
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            Node item = stack.pollLast();
            result.add(item.val);
            if(null != item.children) {
                Collections.reverse(item.children);
                item.children.forEach(v -> {
                    stack.add(v);
                });
            }
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
