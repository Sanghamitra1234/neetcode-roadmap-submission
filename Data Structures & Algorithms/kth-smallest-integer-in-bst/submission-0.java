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
    int counter = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        counter = k;
        kthSmallestUtill(root, k);
        return ans;
    }

    public void kthSmallestUtill(TreeNode root, int k) {
        System.out.println(counter);
        if (root == null) {
            return;
        }
        kthSmallestUtill(root.left, k);
        counter--;
        if (counter == 0) {
            ans = root.val;
            return;
        }
        kthSmallestUtill(root.right, k);
    }
}
