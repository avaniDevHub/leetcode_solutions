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
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        // 1. Visit Left Subtree
        postorder(root.left, result);
        
        // 2. Visit Right Subtree
        postorder(root.right, result);
        
        // 3. Visit Root (Added last in Post-order)
        result.add(root.val);
    }
}