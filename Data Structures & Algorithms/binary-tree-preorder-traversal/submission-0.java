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
    // //iterative
    // public List<Integer> preorderTraversal(TreeNode root) {

        
    // }
    //recursive: 
    public List<Integer> preorderTraversal(TreeNode root ) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr!=null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return res;
    }
}