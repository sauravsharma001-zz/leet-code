import java.util.Collections;

import java.util.Queue;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (45.48%)
 * Total Accepted:    207.3K
 * Total Submissions: 455.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> levelNode = new LinkedList<>();
        Deque<TreeNode> toVisit = new LinkedList<TreeNode>();
        Deque<TreeNode> inStack = new LinkedList<TreeNode>();

        toVisit.add(root);
        List<Integer> t = new LinkedList<>();
        t.add(root.val);
        levelNode.add(t);

        while(!toVisit.isEmpty()) {
            TreeNode node = toVisit.remove();

            if(node.left != null) inStack.add(node.left);
            if(node.right != null) inStack.add(node.right);

            if(toVisit.isEmpty() && !inStack.isEmpty()) {
                toVisit = new LinkedList(inStack);
                List<Integer> l = new LinkedList<>();
                for(TreeNode tempNode : inStack) {
                    l.add(tempNode.val);
                }    
                levelNode.add(l);
                inStack.clear();
            }
        }
        Collections.reverse(levelNode);
        return levelNode;
    }
}
