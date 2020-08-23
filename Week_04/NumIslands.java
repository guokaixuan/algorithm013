/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if(grid.length < 1) {
            return 0;
        }
        int result = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                if(grid[x][y] == '1') {
                    result++;
                    dfs(grid, x, y);
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int x, int y) {
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x, y + 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x - 1, y);
        }
    }
}
