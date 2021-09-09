package per.rost.pom.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:bryan.c
 * Date:2021/9/9
 * N皇后
 */
public class LeetCode51 {
    private static final LeetCode51 INSTANCE=new LeetCode51();

    //创建结果集res
    List<List<String>> res = new ArrayList<>();

    public static void main(String... args) {
        INSTANCE.solveNQueens(8).forEach(System.out::println);
    }

    public List<List<String>> solveNQueens(int n) {
        ArrayList<StringBuilder> track = new ArrayList<>();
        //初始化棋盘
        for(int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++){
                str.append('X');
            }
            track.add(str);
        }
        backtrace(track, 0);
        return res;
    }

    void backtrace(ArrayList<StringBuilder> track, int row){
        // 如果每一行都成功放置了皇后，记录结果
        if(row == track.size()){
            res.add(track.stream().map(StringBuilder::toString).collect(Collectors.toList()));
            return;
        }

        int n = track.get(row).length();
        for(int col = 0; col < n; col++){
            if(!isValid(track,row,col)) continue;
            //做选择
            track.get(row).setCharAt(col,'Q');
            //进入下一行放皇后
            backtrace(track, row+1);
            //撤销选择
            track.get(row).setCharAt(col,'X');
        }
    }
    // 是否可以在目标位置放皇后
    boolean isValid(ArrayList<StringBuilder> track, int row, int col){
        int  n = track.size();
        // 检查列是否有皇后冲突
        for(int i = 0; i < n; i++){
            if(track.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后冲突
        for(int i = row-1, j = col+1; i>=0 && j <n; i--,j++){
            if(track.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后冲突
        for(int i= row-1, j = col-1; i>=0 && j >=0; i--,j--){
            if(track.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
