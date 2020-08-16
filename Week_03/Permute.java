import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {

    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(null == nums || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {list.add(i);}
        permute(nums.length, 0, list);
        return result;
    }
    public void permute(int n, int start, List<Integer> list) {
        if(start == n - 1) {
            result.add(new ArrayList(list));
        }
        for(int i = start; i < n; i++) {
            Collections.swap(list, i, start);
            permute(n, start + 1, list);
            Collections.swap(list, i, start);
        }
    }
}
