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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        maxPathSumUtil(root);
        return ans;  
    }

    public int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;
        // if (root.left == null && root.right == null) return root.val;
        // maxAtRoot = Math.max(maxAtRoot + root.val, root.val);
        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));

        int pathSum = root.val + left + right;

        ans = Math.max(ans, pathSum);
        return root.val + Math.max(left, right);
    }
}
