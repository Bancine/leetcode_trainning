package 数组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 原题目：https://leetcode-cn.com/problems/spiral-matrix/
     * 54.螺旋矩阵
     * @param matrix 矩阵
     * @return 顺时针列表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int count = 0;
        int line = 0;
        int row = 0;
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix[0] == null) {
            return res;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction_index = 0;
        while (matrix.length * matrix[0].length > count) {
            res.add(matrix[line][row]);
            visited[line][row] = true;
            int next_line = line + direction[direction_index][0];
            int next_row = row + direction[direction_index][1];
            if (next_line >= matrix.length || next_line < 0 || next_row >= matrix[0].length || next_row < 0 || visited[next_line][next_row]) {
                direction_index = (direction_index + 1) % 4;
            }
            line += direction[direction_index][0];
            row += direction[direction_index][1];
            count++;
        }
        return res;
    }




}