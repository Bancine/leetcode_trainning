package tree;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTree(Integer[] nums) {
        int length = nums.length;
        TreeNode root = new TreeNode();
        root.val = nums[0];
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int idx = 0;

        while (!dq.isEmpty()) {

            TreeNode node = dq.pop();
            if (++idx < length && nums[idx] != (null)) {
                node.left = new TreeNode(nums[idx]);
                dq.add(node.left);
            }
            if (++idx < length && nums[idx] != (null)) {
                node.right = new TreeNode(nums[idx]);
                dq.add(node.right);
            }
        }
        return root;
    }


    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                ", \"l\":" + left +
                ", \"r\":" + right +
                '}';
    }
}
