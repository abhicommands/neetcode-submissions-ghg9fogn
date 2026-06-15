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
    // recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == q.val || curr.val == p.val) {
                return curr;
            }
            else if ((curr.val > p.val && curr.val < q.val ) || (curr.val < p.val && curr.val > q.val ))
                return curr;
            else if (curr.val > p.val && curr.val > q.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return null;
    }
}
