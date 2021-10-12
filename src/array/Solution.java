package array;

import java.util.*;

class Solution {
    /**
     * https://leetcode-cn.com/problems/maximum-subarray/solution/
     * 53.最大子序和
     * #数组 #分治 #动态规划
     * @param nums 一个数组
     * @return 最大和
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num: nums) {
            //如果加了还不如不加的话就重新开始加
            pre = Math.max(pre + num, num);
            res = Math.max(res,pre);
        }
        return res;
    }

    /**
     * 原题目：https://leetcode-cn.com/problems/spiral-matrix/
     * 54.螺旋矩阵
     * #数组 #矩阵 #模拟
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

    /**
     * 原题目：https://leetcode-cn.com/problems/single-number/
     * 136. 只出现一次的数字
     * #数组 #位运算
     * @param
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num:nums){
            a = a ^ num;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumber(new int[]{1,1,2});
    }


}