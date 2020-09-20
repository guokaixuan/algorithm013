学习笔记

## 初级排序

- 选择排序

```java
public int[] selectionSort(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        int minIndex = i;
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
    }
    return nums;
}
``` 

- 插入排序

```java
public int[] insertionSort(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        for(int j = i; j > 0; j--) {
            if(nums[j] < nums[j - 1]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
            }
        }
    }
    return nums;
}
```

- 冒泡排序

```java
public int[] bubbleSort(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        for(int j = 0; j < nums.length - 1 - i; j++) {
            if(nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
    return nums;
}
```

