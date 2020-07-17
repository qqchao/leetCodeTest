package explore.level1.tree;

import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode H = new TreeNode(8, null, null);
        TreeNode G = new TreeNode(7, H, null);
        TreeNode F = new TreeNode(6, null, null);
        TreeNode E = new TreeNode(5, null, null);
        TreeNode D = new TreeNode(4, null, G);
        TreeNode C = new TreeNode(3, E, F);
        TreeNode B = new TreeNode(2, D, null);
        TreeNode A = new TreeNode(1, B, C);

        System.out.println(maxDepth(A));
        System.out.println(maxDepth2(A));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxDepth = 1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> nodeDepth = new Stack<Integer>();
        nodeDepth.push(maxDepth);
        nodeStack.push(root);

        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = nodeDepth.pop();

            if(depth > maxDepth) maxDepth = depth;

            if(node.left != null){
                nodeDepth.push(depth+1);
                nodeStack.push(node.left);
            }
            if(node.right != null){
                nodeDepth.push(depth+1);
                nodeStack.push(node.right);
            }
        }
        return maxDepth;
    }


    /**
     * 递归超快，膜拜一下
     */
    public static int maxDepth2(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth2(root.left), maxDepth2(root.right)));
    }
}
