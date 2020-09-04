package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P257binaryTreePaths {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode5;

        System.out.println(binaryTreePaths(treeNode1));
    }

//    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<String> routes;

    public static List<String> binaryTreePaths(TreeNode root) {
        routes = new ArrayList<>();
        if (root != null) {
            setRoute(new StringBuilder(String.valueOf(root.val)), root);
        }
        return routes;
    }

    private static void setRoute(StringBuilder preRoute, TreeNode treeNode){
        if (treeNode.left == null && treeNode.right == null) {
            routes.add(preRoute.toString());
        }
        if (treeNode.left != null) {
            StringBuilder preRoute1 = new StringBuilder(preRoute);
            preRoute1.append("->").append(treeNode.left.val);
            setRoute(preRoute1, treeNode.left);
        }
        if (treeNode.right != null) {
            StringBuilder preRoute1 = new StringBuilder(preRoute);
            preRoute1.append("->").append(treeNode.right.val);
            setRoute(preRoute1, treeNode.right);
        }
    }
}
