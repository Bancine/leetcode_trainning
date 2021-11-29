package array;

import java.util.*;

class Solution {
    /**
     * https://leetcode-cn.com/problems/maximum-subarray/solution/
     * 53.最大子序和
     * #数组 #分治 #动态规划
     *
     * @param nums 一个数组
     * @return 最大和
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            //如果加了还不如不加的话就重新开始加
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    /**
     * 原题目：https://leetcode-cn.com/problems/spiral-matrix/
     * 54.螺旋矩阵
     * #数组 #矩阵 #模拟
     *
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
     *
     * @param
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a = a ^ num;
        }
        return a;
    }

    public float calculate(char[] chars) {
        Stack<Character> calStack = new Stack<>();
        Stack<Float> numStack = new Stack<>();
        for (char tempChar : chars) {
            if (tempChar == '+' || tempChar == '-' || tempChar == '*' || tempChar == '/') {
                calStack.push(tempChar);
            } else {
                numStack.push(Float.parseFloat(String.valueOf(tempChar)));
                if (numStack.size() > 1 && (calStack.peek() == '*' || calStack.peek() == '/')) {
                    float a = numStack.pop();
                    float b = numStack.pop();
                    numStack.push(calStack.pop() == '*' ? a * b : b / a);
                }
            }
        }

        while (!calStack.empty()) {
            float a = numStack.pop();
            float b = numStack.pop();
            numStack.push(calStack.pop() == '+' ? a + b : b - a);
        }
        System.out.println(numStack.peek());
        return numStack.pop();
    }

    /**
     * leetcode 200
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i, j + 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m==0) nums1=nums2;
        // if(n==0){ return;}
        int i = m - 1, j = n - 1;
        int pos = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[pos] = nums1[i];
                i--;
            } else {
                nums1[pos] = nums2[j];
                j--;
            }
            pos--;
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);
        return nums1;

    }

    /**
     * leetcode 350
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> conatiner = new HashMap<Integer, Integer>();
        int[] temp = new int[nums2.length];
        int pos = 0;
        for (int i = 0; i < nums1.length; i++) {
            Integer val = conatiner.put(nums1[i], 1);
            if (val != null) {
                conatiner.put(nums1[i], val + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (conatiner.get(nums2[i]) != null && conatiner.get(nums2[i]) > 0) {
                conatiner.put(nums2[i], conatiner.get(nums2[i]) - 1);
                temp[pos] = nums2[i];
                pos++;
            }
        }
        int[] a = new int[pos];
        System.arraycopy(temp, 0, a, 0, pos);
        return a;

    }

    /**
     * leetcode 556
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int orginr = mat.length;
        if (orginr == 0) return mat;
        int orginc = mat[0].length;
        if (orginr * orginc != r * c) return mat;

        int[][] res = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / orginc][i % orginc];
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
//        System.out.println(Arrays.toString(solution.merge(new int[]{0}, 0, new int[]{1}, 1)));
//        System.out.println(Arrays.toString(solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println(Arrays.deepToString(solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        new ArrayList(2);
    }


}