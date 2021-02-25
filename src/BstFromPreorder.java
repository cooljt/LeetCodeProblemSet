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
    public TreeNode BstFromPreorder(int[] preorder) {
        TreeNode root = dfs(0, preorder.length - 1, preorder);
        return root;
    }
    
    public TreeNode dfs(int start, int end, int[] preorder) {
        if (start > end) return null;
        
        TreeNode node = new TreeNode(preorder[start]);
        
        int left = start + 1;
        int next = left;
        
        while (next <= end && preorder[next] < preorder[start]) {
            next++;
        }
        
        TreeNode leftNode = dfs(left, next - 1, preorder);
        TreeNode rightNode = dfs(next, end, preorder);
        
        node.left = leftNode;
        node.right = rightNode;
        
        return node;
    }
    
}