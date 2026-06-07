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
    //recursvie: 
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    //iterative: 
    // public int maxDepth(TreeNode root) {
        
    // }
}
