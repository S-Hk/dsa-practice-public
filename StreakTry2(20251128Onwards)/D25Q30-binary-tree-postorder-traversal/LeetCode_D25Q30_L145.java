/*
145. Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/

EASY
 */


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
        if(root==null) return new ArrayList<Integer>();

        List<Integer> ans = new ArrayList<>();

        if(root.left!=null){
            ans.addAll(postorderTraversal(root.left));
        }
        if(root.right!=null){
            ans.addAll(postorderTraversal(root.right));
        }
        ans.add(root.val);

        return ans;
    }
}