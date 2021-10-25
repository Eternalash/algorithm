package per.rost.pom.algorithm.floodfill;

import java.util.Arrays;

/**
 * Author:bryan.c
 * Date:2021/10/25
 */
public class LeetCode733 {
    private static final LeetCode733 INSTANCE = new LeetCode733();

    public static void main(String... args) {
        System.out.println(Arrays.deepToString(INSTANCE.floodFill(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        fill(image, sr, sc, originColor, newColor);
        return image;
    }

    private void fill(int[][] image, int x, int y, int originColor, int newColor) {
        if (!inArea(image, x, y)) return;
        if (image[x][y] != originColor) return;
        if (image[x][y] == -1) return;

        image[x][y] = -1;
        //up
        fill(image, x, y + 1, originColor, newColor);
        //down
        fill(image, x, y - 1, originColor, newColor);
        //left
        fill(image, x - 1, y, originColor, newColor);
        //right
        fill(image, x + 1, y, originColor, newColor);
        image[x][y] = newColor;

    }

    private boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length
                && y >= 0 && y < image[0].length;
    }
}
