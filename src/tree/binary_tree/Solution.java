package tree.binary_tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Solution {


    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 94.二叉树的中序遍历
     * #栈 #树 #深度优先搜索 #广度优先搜索
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inoder(root, res);
        return res;
    }

    private void inoder(TreeNode root,List<Integer> res) {
        if (root == null) {
            return;
        }
        inoder(root.left,res);
        res.add(root.val);
        inoder(root.right,res);
    }

    /**
     * 题目：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     * 124. 二叉树中的最大路径和
     * #树 #深度优先搜索 #动态规划 #二叉树
     * @param root 根节点
     * @return 最大路径和
     */
//    int max_global = 0;
//    public int maxPathSum(TreeNode root) {
//        max_global = root.val;
//        maxGin(root);
//        return max_global;
//    }
//
//    private int maxGin(TreeNode root) {
//        if (root==null) return 0;
//        int leftMax = Math.max(maxGin(root.left),0);
//        int rightMax = Math.max(maxGin(root.right),0);
//        int maxpath = Math.max(  leftMax+ root.val, rightMax+root.val);
//        max_global = Math.max(leftMax + rightMax + root.val,max_global);
//        return maxpath;
//    }
     int max_global = Integer.MIN_VALUE;
     public int maxPathSum(TreeNode root) {
         maxGin(root);
         return max_global;
     }

     private int maxGin(TreeNode root) {
         if(root == null) return 0;
         int leftMax = Math.max(maxGin(root.left),0);
         int rightMax = Math.max(maxGin(root.right),0);
         max_global = Math.max(max_global,root.val+rightMax+leftMax);
         return Math.max(leftMax,rightMax)+root.val;
     }

    /**
     * 题目：https://leetcode-cn.com/problems/maximum-binary-tree/
     * 654. 最大二叉树
     * #树 #栈 #动态规划 #二叉树 # 数组 #分治
     * @param nums
     * @return 最大数
     */
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int maxNum = Integer.MIN_VALUE;
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                maxNum = Math.max(nums[i], maxNum);
                if (nums[i] == maxNum) {
                    idx = i;
                }
            }

            if (nums.length != 0) {
                TreeNode treeNode = new TreeNode();
                treeNode.val = maxNum;
                treeNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
                treeNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx+1, nums.length));
                return treeNode;
            }else {
                return null;
            }
        }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
        Solution solution = new Solution();
//        System.out.println(solution.maxPathSum(root));
        TreeNode treeNode = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode.toString());
    }


}
