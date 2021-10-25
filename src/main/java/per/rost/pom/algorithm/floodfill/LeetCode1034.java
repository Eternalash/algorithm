package per.rost.pom.algorithm.floodfill;

import java.util.Arrays;

/**
 * Author:bryan.c
 * Date:2021/10/25
 */
public class LeetCode1034 {
    private static final LeetCode1034 INSTANCE = new LeetCode1034();
    boolean[][] visited;

    public static void main(String... args) {
        System.out.println(Arrays.deepToString(INSTANCE.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2)));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originColor = grid[row][col];
        visited = new boolean[grid.length][grid[0].length];
        fill(grid, row, col, originColor, color);
        return grid;
    }

    private int fill(int[][] grid, int x, int y, int originColor, int newColor) {
        if (!inArea(grid, x, y)) return 0;
        if (visited[x][y]) return 1;
        if (grid[x][y] != originColor) return 0;

        visited[x][y] = true;
        int surround =
                //up
                fill(grid, x, y + 1, originColor, newColor)
                        //down
                        + fill(grid, x, y - 1, originColor, newColor)
                        //left
                        + fill(grid, x - 1, y, originColor, newColor)
                        //right
                        + fill(grid, x + 1, y, originColor, newColor);

        if (surround < 4) {
            grid[x][y] = newColor;
        }
        return 1;
    }

    private boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length
                && y >= 0 && y < image[0].length;
    }
}
