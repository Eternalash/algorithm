package per.rost.pom.algorithm.binarytree;

/**
 * Author:bryan.c
 * Date:2021/10/26
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class LeetCode240 {
    private static final LeetCode240 INSTANCE = new LeetCode240();


    public static void main(String... args) {
        System.out.println(INSTANCE.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
    }

    //抽象BST
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length, w = matrix[0].length;
        int r = 0, c = w - 1;
        while (r < h && c >= 0) {
            //当前节点「小于」目标值，搜索当前节点的「右子树」，也就是当前矩阵位置的「下方格子」，即 r++
            if (matrix[r][c] < target) r++;
            //当前节点「大于」目标值，搜索当前节点的「左子树」，也就是当前矩阵位置的「左方格子」，即 c--
            else if (matrix[r][c] > target) c--;
            else return true;
        }
        return false;
    }
}
