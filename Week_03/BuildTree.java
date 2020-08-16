import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preIndex, int preLast,
                              Map<Integer, Integer> map, int inIndex, int inLast) {
        if(preIndex > preLast || inIndex > inLast) {
            return null;
        }
        int rootValue = preorder[preIndex];
        int pIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(preorder, preIndex + 1, pIndex - inIndex + preIndex,
                map, inIndex, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inIndex + preIndex + 1, preLast,
                map, pIndex + 1, inLast);
        return root;
    }
}
