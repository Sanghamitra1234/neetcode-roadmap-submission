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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        goodNodesUtil(root, Integer.MIN_VALUE);
        return ans;
    }

    public void goodNodesUtil(TreeNode root, int prevMax) {
        if (root == null) return;
        if (root.val >= prevMax) ans++;
        goodNodesUtil(root.left, Math.max(prevMax, root.val));
        goodNodesUtil(root.right, Math.max(prevMax, root.val));
    }


}
