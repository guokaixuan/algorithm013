## 学习笔记

### 被围绕的区域
- 思路

DFS: 寻找边界上的‘O’，将与边界连通的‘0’替换为字符‘A’。之后再遍历二维数组，将‘O’替换为‘X’，
将‘A’替换为‘O’。

并查集: 找连通性，寻找边界上的‘O’，然后将周围的‘O’与之连通，最后遍历二位数组，判断i、j是否连通，
如果连通替换为‘X’。

### 岛屿数量
- 思路

DFS: 遍历二维数组，遇到陆地count++并将其及与之相邻的所有陆地改为水。

### 爬楼梯
- 思路

动态规划：上n级台阶的解法等于上n-1和n-2级台阶之和，需要三个数字分别存储n-2 n-1 n的数量。
```java
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for(int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
```

### 朋友圈
- 思路

并查集：使用并查集归并朋友，最后得到朋友圈。

并查集结构包含find(int x)、union(int x, int y)、isConnected(int x, int y)。
```java
public class UnionFind {

    int count;
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq) {
            return;
        }
        parent[rootp] = rootq;
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
```
