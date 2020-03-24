package com.hyb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : hongyb
 * @Description
 * @Date Created  in 12:05 2020/3/15
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland695 {
    boolean [][] flag ;
    //方向
    int[][] orientations  = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0){
            return 0 ;
        }
        flag = new  boolean[grid.length][grid[0].length];
        //bfs广度优先遍历
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(flag[i][j]){
                    continue;
                }
                int  areaLength = bfs(grid,i,j);
                flag [i][j] = true;
                max = Math.max(areaLength,max);
            }
        }
        return max;
    }
    public int bfs(int[][] grid,int i,int j){
        if(grid[i][j] == 0){
            return 0;
        }
        //dfs的辅助队列
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{i,j});
        int areaLength = 1;
        while(!queue.isEmpty()){
            int[] posion = queue.poll();
            int x = posion[0];
            int y = posion[1];
            //移动
            for(int[] orientation : orientations){
                x = x+orientation[0];
                y = y+orientation[1];
                if(x>0&&y>0&&grid[x][y]==1){
                    ((LinkedList<int[]>) queue).add(new int[]{x,y});
                    areaLength++;
                    flag [x][y] = true;
                }
            }
        }
        return areaLength;
    }
}
