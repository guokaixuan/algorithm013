# 学习笔记

## 删除排序数组中的重复项
思考点：
- 数组长度等于0
- 数组长度大于0

结题思路是设置快慢两个指针，慢指针slow=0，快指针quick从1开始循环至数组最后，每次检查快指针数组值
是否与慢指针对应值不同，如果不满足条件则quick指针后移，满足条件则移动slow指针并将quick的值赋给slow。
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[slow] != nums[i]) {
                nums[++slow] = nums[i];
            }            
        }
        return slow + 1;
    }
}
```
## 旋转数组
解题方法：
- 暴力解题：每次取最后一个元素然后剩余元素整体后移
- 新建数组：新建一个同长数组，将原数组中的元素按要求整理到新数组中
- 循环跳跃：每次保留前一个元素值，然后向后跳k个位置，将保留值放入该位置并将保留值改为替换前的该位置的值，依次执行直到整个数组执行完毕

这里只列举最后一种方式：
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++) {
            int currentIndex = i;
            int tempValue = nums[currentIndex];
            do{
                int nextIndex = (currentIndex + k) % nums.length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = tempValue;
                tempValue = nextValue;
                currentIndex = nextIndex;
                count++;
            }while(i != currentIndex);
        }
    }
}
```

## 合并两个有序链表
给定两个有序链表，进行有序整合，使用递归即可：
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

## 合并两个有序数组
题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

从后置开始往nums1中填充m + n个值，分别从后面检查nums1和nums2, 遇到大的值则填充到nums1后面，并前移下标，直到有一方结束后将nums2中未检查的元素移到nums1前面。

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n -1;
        while(m > 0 && n > 0) {
            nums1[len--] = nums1[m-1] > nums2[n-1] ? nums1[--m] : nums2[--n];
        }
        System.arraycopy(nums2, 0, nums1, 0, n);
    }
}
```

## 两数之和
借助hash检查
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(table.containsKey(target - nums[i])) {
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

## 移动零
采用快慢双指针方法解决
```java
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
```

## 加一
数字加一考虑两种情况：
- 小于9直接加1
- 等于9需要进位

给定一个数组进行末位加1的话，从数组后向前遍历。如果当前数字等于9将其置为0，进位1加到前一个数组位置；如果当前数字小于9将其加1后直接返回。
遇到数组元素全部是9的情况，只需new一个元数组长度+1的新数组，将第一个元素置为1即可。
```java
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```




