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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            String st = "";
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    st += "N,";
                } else {
                    st += temp.val+",";
                    q.add(temp.left);
                    q.add(temp.right);
                }
                
            }
            ans += st;
            level++;
        }
        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();

        int index = 0;
        String[] st = data.split(","); 
        TreeNode root = new TreeNode(Integer.parseInt(st[index]));
        q.add(root);
        index++;

        while (!q.isEmpty()) {
            // if (st == "L") index++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                // Evaluate Left
                if (!st[index].equals("N")) {
                   temp.left = new TreeNode(Integer.parseInt(st[index]));
                   q.add(temp.left);
                }
                index++;
                // Evaluate right
                System.out.println(st[index]);
                if (!st[index].equals("N")) {
                    temp.right = new TreeNode(Integer.parseInt(st[index]));
                    q.add(temp.right);
                }
                index++;
            }
        }
        return root;
    }
}
