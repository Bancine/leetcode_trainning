package tree.binary_tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     * 124. 二叉树中的最大路径和
     * #树 #深度优先搜索 #动态规划 #二叉树
     * @param root 根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        int res = 0;

        return res;
    }

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
}
