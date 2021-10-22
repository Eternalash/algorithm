package per.rost.pom.algorithm.floodfill;

/**
 * Author:bryan.c
 * Date:2021/10/22
 */
public class LeetCode1020 {
    private static final LeetCode1020 INSTANCE = new LeetCode1020();

    public static void main(String... args){
        System.out.println(INSTANCE.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,0,1,0},{0,0,0,0}}));
        System.out.println(INSTANCE.numEnclaves(new int[][]{{0},{1},{1},{0},{0}}));
    }

    public int numEnclaves(int[][] grid) {
        int res=0;
        int h=grid.length,w=grid[0].length;

        for (int i = 0; i < w; i++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, i);
            // 把靠下边的岛屿淹掉
            dfs(grid, h - 1, i);
        }
        for (int i = 0; i < h; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, w - 1);
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if (grid[i][j]==1){
                    res+=1;
                }
            }
        }

        return  res;
    }

    private void dfs(int[][] grid,int h,int l){
        int m = grid.length, n = grid[0].length;
        if (h < 0 ||l < 0 || h >= m || l >= n) {
            return;
        }
        if (grid[h][l] == 0) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[h][l] = 0;
        // 淹没上下左右的陆地
        dfs(grid, h + 1, l);
        dfs(grid, h, l + 1);
        dfs(grid, h - 1, l);
        dfs(grid, h, l - 1);
    }
}
