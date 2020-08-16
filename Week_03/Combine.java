import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n < 1 || k > n) {
            return result;
        }
        combine(n, k, 1, new Stack<Integer>());
        return result;
    }
    public void combine(int n, int k, int start, Stack<Integer> stack) {
        if(stack.size() == k) {
            result.add(new ArrayList(stack));
        }
        for(int i = start; i <= n; i++) {
            stack.push(i);
            combine(n, k, i + 1, stack);
            stack.pop();
        }
    }
}
