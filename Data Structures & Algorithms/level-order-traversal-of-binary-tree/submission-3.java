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
    // //iterative bfs
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) return res;
    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> level = new ArrayList<>();
    //         for(int i =0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             level.add(node.val);
    //             if(node.left!=null) queue.offer(node.left);
    //             if(node.right!=null) queue.offer(node.right);
    //         }
    //         res.add(level);
    //     }
    //     return res;
    // }

    //recursive dfs: 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> list, int depth) {
        if(root == null) return;

        if(list.size() == depth) list.add(new ArrayList<Integer>());

        list.get(depth).add(root.val);
        helper(root.left, list, depth+1);
        helper(root.right, list, depth+1);
    }

    
}
