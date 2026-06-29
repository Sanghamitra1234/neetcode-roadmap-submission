/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int max = Integer.MAX_VALUE;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthUtil(root);
    }

    public int maxDepthUtil(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthUtil(root.left) + 1, maxDepthUtil(root.right) + 1);
    }
}
