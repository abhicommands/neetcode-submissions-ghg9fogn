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
    //iterative stack:

    public TreeNode invertTree(TreeNode root) {
        if (root== null) return root;
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode currentRoot = stack.poll();
            TreeNode temp = currentRoot.left;
            currentRoot.left = currentRoot.right;
            currentRoot.right = temp;

            if (currentRoot.left != null)stack.offer(currentRoot.left);
            if (currentRoot.right != null) stack.offer(currentRoot.right);
        }

        return root;
    }
    //recursive:
    // public TreeNode invertTree(TreeNode root) {
    //     helper(root);
    //     return root;
    // }
    // public void helper(TreeNode root) {
    //     if (root!= null) {
    //         TreeNode temp = root.right;
    //         root.right = root.left;
    //         root.left = temp;
    //         helper(root.right);
    //         helper(root.left);
    //     } else return;
    // }
}
