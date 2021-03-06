package per.rost.pom.algorithm.floodfill;

import java.util.Collections;
import java.util.HashSet;

/**
 * Author:bryan.c
 * Date:2021/10/25
 */
public class LeetCode694 {
    private static final LeetCode694 INSTANCE = new LeetCode694();

    public static void main(String... args){
        System.out.println(INSTANCE.numDistinctIslands(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }

    int numDistinctIslands(int[][] grid){
        int h = grid.length,w = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, sb, -1);
                    islands.add(sb.toString());
                }
            }
        }
        System.out.println(Collections.unmodifiableSet(islands));
        // 不相同的岛屿数量
        return islands.size();
    }

    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int h = grid.length, w = grid[0].length;
        if (i < 0 || j < 0 || i >= h || j >= w
                || grid[i][j] == 0) {
            return;
        }
        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1); // 上
        dfs(grid, i + 1, j, sb, 2); // 下
        dfs(grid, i, j - 1, sb, 3); // 左
        dfs(grid, i, j + 1, sb, 4); // 右

        // 后序遍历位置：离开 (i, j)
        sb.append(-dir).append(',');
    }
}
