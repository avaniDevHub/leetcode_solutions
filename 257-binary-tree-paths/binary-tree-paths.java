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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        // Append current node's value to the path
        path += node.val;

        // Base case: If it's a leaf node, save the full path
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // If left child exists, explore left subtree
        if (node.left != null) {
            dfs(node.left, path + "->", result);
        }

        // If right child exists, explore right subtree
        if (node.right != null) {
            dfs(node.right, path + "->", result);
        }
    }
}