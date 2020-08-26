学习笔记

本周学习知识点：

- 深度、广度优先搜索
- 贪心算法
- 二分查找

本周印象比较深刻的三个算法是岛屿数量、扫雷，使用广度优先可以轻松解题。

## 扫雷

解题思路：

- 处理边界
- 每次点击判断当前位置是否为雷
- 不为雷则遍历八个相邻位置计算雷的数量
- 周围没雷则递归点击

```java
public class UpdateBoard {
    int[] aroudx = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
    int[] aroudy = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if('M' == board[x][y]) {
            board[x][y] = 'X';
        }else {
            dfs(board, x, y);
        }
        return board;
    }
    public void dfs(char[][] board, int x, int y) {

        int mCount = 0;
        for(int i = 0; i < 8; i++) {
            int ax = x + aroudx[i], ay = y + aroudy[i];
            if(ax < 0 || ax >= board.length || ay < 0 || ay >= board[0].length) {
                continue;
            }
            if('M' == board[ax][ay]) {
                mCount++;
            }
        }
        if(mCount > 0) {
            board[x][y] = (char) (mCount + '0');
        }else {
            board[x][y] = 'B';
            for(int i = 0; i < 8; i++) {
                int ax = x + aroudx[i], ay = y + aroudy[i];
                if(ax < 0 || ax >= board.length || ay < 0 || ay >= board[0].length || board[ax][ay] != 'E') {
                    continue;
                }
                dfs(board, ax, ay);
            }
        }
    }
}
```