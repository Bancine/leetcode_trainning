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

    public float calculate(char[] chars){
        Stack<Character> calStack = new Stack<>();
        Stack<Float> numStack = new Stack<>();
        for (char tempChar:chars){
            if (tempChar=='+' || tempChar =='-' || tempChar == '*' || tempChar=='/'){
                calStack.push(tempChar);
            }else {
                numStack.push(Float.parseFloat(String.valueOf(tempChar)));
                if (numStack.size()>1 && (calStack.peek()=='*' || calStack.peek()=='/')){
                    float a = numStack.pop();
                    float b = numStack.pop();
                    numStack.push(calStack.pop()=='*'?a*b:b/a);
                }
            }
        }

        while (!calStack.empty()){
            float a = numStack.pop();
            float b = numStack.pop();
            numStack.push(calStack.pop()=='+'?a+b:b-a);
        }
        System.out.println(numStack.peek());
        return numStack.pop();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println("aaaaa");
//        solution.singleNumber(new int[]{1,1,2});
        char[] chars = {'4','+','5','*','7','/','2','-','1'};
        solution.calculate(chars);
    }

    public int maxProfit(int[] prices){
        int tempMax = Integer.MAX_VALUE;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0]; //持有股票
        dp[0][1] = 0;// 持有并冻结
        dp[0][2] = 0;// 持有不冻结
        for (int i = 1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            dp[i][2] = dp[i-1][1];
        }
        return -1;
    }



}