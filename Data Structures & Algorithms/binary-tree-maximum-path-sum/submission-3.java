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
    int answer = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumUtil(root);
        return answer;
    }
    public int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;
        int leftSum =  maxPathSumUtil(root.left);
        int rightSum = maxPathSumUtil(root.right);
        int returnSum = Math.max(root.val,  root.val + Math.max(leftSum, rightSum));
        answer = Math.max(answer, Math.max(returnSum, root.val + leftSum + rightSum));
        return returnSum;
    }
}
