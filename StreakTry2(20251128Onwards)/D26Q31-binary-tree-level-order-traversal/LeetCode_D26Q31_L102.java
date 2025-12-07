/*
102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/

Medium
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        computeLevelOrder(root, ans, 0);
        return ans;
    }

    private void computeLevelOrder(TreeNode root, List<List<Integer>> ans, int level) {
        if(root==null) return;

        List<Integer> nthList;
        if(level+1>ans.size()){
            nthList = new ArrayList<>();
            nthList.add(root.val);
            ans.add(nthList);
        }else{
            nthList = ans.get(level);
            nthList.add(root.val);
            ans.set(level, nthList);
        }

        if(root.left!=null){
            computeLevelOrder(root.left, ans, level+1);
        }

        if(root.right!=null){
            computeLevelOrder(root.right, ans, level+1);
        }
    }
}