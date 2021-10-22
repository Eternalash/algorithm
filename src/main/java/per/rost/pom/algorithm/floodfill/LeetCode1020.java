package per.rost.pom.algorithm.floodfill;

/**
 * Author:bryan.c
 * Date:2021/10/22
 */
public class LeetCode1020 {
    private static final LeetCode1020 INSTANCE = new LeetCode1020();

    public static void main(String... args){
        System.out.println(INSTANCE.numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }

    public int numEnclaves(int[][] grid) {
        int res=0;
        int h=grid.length,l=grid[0].length;

        for (int i = 0; i < l; i++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, i);
            // 把靠下边的岛屿淹掉
            dfs(grid, h - 1, i);
        }
        for (int i = 0; i < h; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, l - 1);
        }

        for(int i=0;i<l;i++){
            for(int j=0;j<h;j++){
                if (grid[i][j]==1){
                    res+=1;
                }
            }
        }

        return  res;
    }

    public void dfs(int[][] grid,int h,int l){

    }
}
