/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles2 {

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
