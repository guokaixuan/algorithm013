#学习笔记

本周的算法学习课程中接触了分治法、回溯法。

- 分治法

将一个难以直接解决的大问题，分割成一些规模较小的相同问题，以便各个击破，分而治之。

- 回溯法

一种通过探索所有可能的候选解来找出所有的解的算法。如果候选解被确认不是一个解的话（或者至少不是最后一个解），回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试。

如作业题目中的题目”组合“，就可用分治、回溯方法来解决。
题目：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
解题步骤：

1、分治，将问题分解为求i~n与(i, n]的组合。

2、回溯，组合过程中如果确定元素的数量等于k，则讲该次求解保存到结果中。

```java
class Solution {
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
```
