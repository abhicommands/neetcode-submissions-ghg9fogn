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
    public List<Integer> postorderTraversal(TreeNode root) {
        class Visited {
            TreeNode node;
            boolean visited;
            Visited() {}
            Visited(TreeNode node1, boolean val) {
                node = node1;
                visited = val;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Deque<Visited> stack = new ArrayDeque<>();
        stack.push(new Visited(root, false));
        while (!stack.isEmpty()) {
            Visited tNode = stack.peek();
            if (tNode.visited) {
                res.add(stack.pop().node.val);
            } else {
                tNode.visited = true;
                if(tNode.node.right!=null) stack.push(new Visited(tNode.node.right, false));
                if(tNode.node.left!=null) stack.push(new Visited(tNode.node.left, false));
            }
        }
        return res;
    }
}