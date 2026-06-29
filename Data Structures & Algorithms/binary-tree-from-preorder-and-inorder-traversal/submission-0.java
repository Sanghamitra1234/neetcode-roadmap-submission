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
    ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(
            arrayToList(preorder), 
            arrayToList(inorder)
        );
 
    }

    public TreeNode buildTreeHelper(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(preorder.get(0));
        root.left = buildTreeHelper(preorder.subList(1, mid + 1), inorder.subList(0, mid));
        root.right = buildTreeHelper(preorder.subList(mid + 1, preorder.size()), inorder.subList(mid + 1, inorder.size()));
        return root;
    }

    private List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

}
