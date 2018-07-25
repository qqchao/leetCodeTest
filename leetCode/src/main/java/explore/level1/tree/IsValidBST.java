package explore.level1.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode H = new TreeNode(8, null, null);
        TreeNode G = new TreeNode(7, H, null);
        TreeNode F = new TreeNode(6, null, null);
        TreeNode E = new TreeNode(5, null, null);
        TreeNode D = new TreeNode(4, null, G);
        TreeNode C = new TreeNode(3, E, F);
        TreeNode B = new TreeNode(2, D, null);
        TreeNode A = new TreeNode(1, B, C);

        System.out.println(isValidBST(A));
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

    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        List<Integer> treeList = treeToList(root, new ArrayList<Integer>());

        for(int i = 1; i < treeList.size(); i++){
            if(treeList.get(i-1) >= treeList.get(i)) return false;
        }

        return true;
    }

    public static List<Integer> treeToList(TreeNode root, List<Integer> list){
        if(root.left != null){
            treeToList(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            treeToList(root.right, list);
        }
        return list;
    }
}
