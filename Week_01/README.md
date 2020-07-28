# 学习笔记

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




