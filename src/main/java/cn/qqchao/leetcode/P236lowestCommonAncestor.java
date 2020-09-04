package cn.qqchao.leetcode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 *
 * 说明:
 *
 *     所有节点的值都是唯一的。
 *     p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P236lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;

        System.out.println(lowestCommonAncestor(treeNode2, treeNode2, treeNode4).val);
    }

    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        String firstPath = findNodePath(root, p, "");
        String secondPath = findNodePath(root, q, "");

        System.out.println(firstPath);
        System.out.println(secondPath);

        String commonPath = comparePath(firstPath, secondPath);
        if(commonPath!=null){
            char[] pathChars = commonPath.toCharArray();
            for (int i = 0; i < pathChars.length; i++) {
                if (pathChars[i] == '1') {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return root;
    }

    static String comparePath(String path1, String path2){
        if (path1 == null || path2 == null)
            return null;

        char[] chars1 = path1.toCharArray();
        char[] chars2 = path2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(chars1.length, chars2.length); i++) {
            if (chars1[i] == chars2[i]) {
                sb.append(chars1[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    static String findNodePath(TreeNode root, TreeNode p, String prePath){
        if (root.val == p.val) {
            return prePath;
        } else if (root.left != null && root.right != null){
            String pathResult = findNodePath(root.left, p, prePath + 1);
            if (pathResult ==null) {
                return findNodePath(root.right, p, prePath+2);
            } else {
                return pathResult;
            }
        } else if (root.left != null) {
            return findNodePath(root.left, p, prePath+1);
        } else if (root.right != null) {
            return findNodePath(root.right, p, prePath+2);
        } else {
            return null;
        }
    }

}
