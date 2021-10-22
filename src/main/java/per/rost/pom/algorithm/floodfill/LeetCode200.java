package per.rost.pom.algorithm.floodfill;

/**
 * Author:bryan.c
 * Date:2021/10/18
 */
public class LeetCode200 {
    private static final LeetCode200 INSTANCE = new LeetCode200();

    public static void main(String... args){
        System.out.println(INSTANCE.numIslands(new char[][]{{'1','1','0','1','1'},{'1','0','0','0','0'},{'0','0','0','0','1'},{'1','1','0','1','1'}}));
    }

    // 主函数，计算岛屿数量
    int numIslands(char[][] grid) {
        int res = 0;
        int h = grid.length, w = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(char[][] grid, int i, int j) {
        int h = grid.length, w = grid[0].length;
        if (i < 0 || j < 0 || i >= h || j >= w) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
