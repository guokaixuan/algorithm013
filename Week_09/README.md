#学习笔记

## 解题思路：

### 1、字符串中的第一个唯一字符

- 描述：
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

- 思路：
遍历字符串的每个字符，计数到一个26长度的数组中。再次遍历字符串，检查当前字符在数组中的计数，如果计数为1则返回当前下标。

- 代码：

```java
class Solution {
    public int firstUniqChar(String s) {
        if(null == s || s.length() == 0) {
            return -1;
        }
        int[] counter = new int[26];
        for(char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```
### 2、反转字符串 II

- 描述：
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

- 思路：
设定两个指针begin、end分别指向每次需要交换的字符起始位置，开始begin=0,end=k-1，执行字符交换，然后begin=begin+2k, end=begin+k-1，直到begin>length-1为止。

- 代码：

```java
class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() < 1) {
            return s;
        }
        int begin = 0, end = k - 1;
        char[] chars = s.toCharArray();
        while(begin < chars.length) {
            reverse(chars, begin, end);
            begin += k * 2;
            end = begin + k - 1;
        }
        return new String(chars);
    }
    public void reverse(char[] chars, int begin, int end) {
        if(end > chars.length - 1) {
            end = chars.length - 1;
        }
        while(begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
}
```

### 3、翻转字符串里的单词

- 思路：将单词按空格分隔成字符串数组，然后后置遍历数组，将有效字符串（非空串）用空格连接起来，最后去掉末置位空格。

- 代码：

```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i].equals("")) {
                continue;
            }
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}
```

### 4、不同路径 II

- 思路：每次移动只能往右或者往下移动，用f(i, j)表示坐标i, j到终点的不同路径数，当坐标中有石头则当前坐标点路径数为0。

- dp方程：

dp[i][j] = dp[i+1][j] + dp[i][j+1]

- 代码：

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int s = n - 1; s >= 0; s--) {
            if(obstacleGrid[m-1][s] == 1) {
                break;
            }
            dp[m-1][s] = 1;
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(j + 1 > n - 1) {
                    dp[i][j] = dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
```