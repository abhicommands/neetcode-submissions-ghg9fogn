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
    // iterative
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null && q != null) || (p != null && q == null))
            return false;
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1.val != node2.val)
                return false;
            if ((node1.right != null && node2.right == null)
                || (node1.right == null && node2.right != null))
                return false;
            if ((node1.left != null && node2.left == null)
                || (node1.left == null && node2.left != null))
                return false;
            if (node1.right != null)
                stack1.push(node1.right);
            if (node1.left != null)
                stack1.push(node1.left);
            if (node2.right != null)
                stack2.push(node2.right);
            if (node2.left != null)
                stack2.push(node2.left);
        }
        return true;
    }
    // //recursive:
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p == null && q == null) return true;
    //     else if ((p==null && q!=null) || (p!=null && q==null)) return false;
    //     else if(p.val != q.val) return false;
    //     else return (isSameTree(q.left, p.left) && (isSameTree(q.right, p.right)));
    // }
}
