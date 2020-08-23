import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RobotSim {

    public int robotSim(int[] commands, int[][] obstacles) {

        //1、前进或者转向
        //2、前进是否有障碍，有障碍阻断
        if(commands.length == 0) {
            return 0;
        }
        int x = 0, y = 0, faceTo = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Set<String> stores = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++) {
            stores.add(obstacles[i][0] + "." + obstacles[i][1]);
        }
        int result = 0;
        for(int i = 0; i < commands.length; i++) {
            if(commands[i] > 0) {
                for(int j = 1; j <= commands[i]; j++) {
                    int nx = x + dx[faceTo];
                    int ny = y + dy[faceTo];
                    if(stores.contains(nx + "." + ny)) {
                        break;
                    }else {
                        x = nx;
                        y = ny;
                        result = Math.max(result, x*x + y*y);
                    }
                }
            }else if(commands[i] == -2) {
                faceTo = (faceTo + 3) % 4;
            }else if(commands[i] == -1) {
                faceTo = (faceTo + 1) % 4;
            }
        }
        return result;
    }
}
