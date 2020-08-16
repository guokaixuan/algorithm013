import java.util.*;

/**
 * 全排列II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(null == nums || nums.length < 1) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for(int v : nums) {
            list.add(v);
        }
        permuteUnique(0, nums.length, list);
        return result;
    }
    public void permuteUnique(int start, int n, List<Integer> list) {
        if(start == n - 1) {
            result.add(new ArrayList(list));
        }
        Set<Integer> temp = new HashSet<>();
        for(int i = start; i < n; i++) {

            if(temp.contains(list.get(i))) {
                continue;
            }
            temp.add(list.get(i));

            Collections.swap(list, start, i);
            permuteUnique(start + 1, n, list);
            Collections.swap(list, start, i);
        }
    }
}
