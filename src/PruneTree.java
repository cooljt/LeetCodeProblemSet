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

/***
814 Medium
***/

class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        boolean remove = dfs(root);
        if (remove) return null;
        return root;
    }
    
    public boolean dfs(TreeNode node) {
        if (node == null) return true;
        boolean leftRemove = dfs(node.left);
        boolean rightRemove = dfs(node.right);
        if (leftRemove) {
            node.left = null;
        }
        if (rightRemove) {
            node.right = null;
        }
        
        if (leftRemove && rightRemove && node.val == 0) {
            return true;
        }
        return false;
        
    }
    
}