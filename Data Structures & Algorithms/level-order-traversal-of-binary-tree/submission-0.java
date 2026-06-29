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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int elements = q.size();
            while (elements > 0) {
               TreeNode t = q.poll();
                level.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                elements--;
            }
           // Collections.reverse(level);
            list.add(level);
        }
        return list;


    }
}
