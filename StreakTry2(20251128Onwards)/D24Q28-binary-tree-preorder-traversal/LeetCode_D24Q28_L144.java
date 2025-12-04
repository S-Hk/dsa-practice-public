/*
144. Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(root.val);
        if(root.left!=null){
            a.addAll(preorderTraversal(root.left));
        }
        if(root.right!=null){
            a.addAll(preorderTraversal(root.right));
        }
        return a;
    }
}