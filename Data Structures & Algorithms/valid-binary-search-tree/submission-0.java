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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode node, int left, int right) {
        if (node == null) return true;
        if (node.val > left && node.val < right) {
            return isValidBSTUtil (node.left, left, node.val)
            && isValidBSTUtil (node.right, node.val, right);
        } 
        return false; 
        
    }
}
