package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class P102LevelOrder {
    public static void main(String[] args) {
        TreeNode H = new TreeNode(8, null, null);
        TreeNode G = new TreeNode(7, H, null);
        TreeNode F = new TreeNode(6, null, null);
        TreeNode E = new TreeNode(5, null, null);
        TreeNode D = new TreeNode(4, null, G);
        TreeNode C = new TreeNode(3, E, F);
        TreeNode B = new TreeNode(2, D, null);
        TreeNode A = new TreeNode(1, B, C);

        System.out.println(levelOrder(A));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        List<Integer> levelVals = new ArrayList<Integer>();
        levelVals.add(root.val);
        result.add(levelVals);

        treeNodes.add(root);
        return getLevelOrder(result, treeNodes);
    }

    public static List<List<Integer>> getLevelOrder(List<List<Integer>> result, List<TreeNode> preNodes){
        List<TreeNode> curNodes = new ArrayList<TreeNode>();
        List<Integer> levelVals = new ArrayList<Integer>();
        for(TreeNode node : preNodes){
            if(node.left != null){
                curNodes.add(node.left);
                levelVals.add(node.left.val);
            }
            if(node.right != null){
                curNodes.add(node.right);
                levelVals.add(node.right.val);
            }
        }
        if(levelVals.isEmpty()) return result;
        else{
            result.add(levelVals);
            return getLevelOrder(result, curNodes);
        }
    }
}
