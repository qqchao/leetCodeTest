package cn.qqchao.leetcode;

import cn.qqchao.other.treenode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P144preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodeList = new LinkedList<>();
        if (root!=null){
            nodeList.add(root);
        }
        while (!nodeList.isEmpty()){
            TreeNode treeNode = nodeList.poll();
            res.add(treeNode.val);
            if (treeNode.right!=null) {
                nodeList.addFirst(treeNode.right);
            }
            if (treeNode.left!=null) {
                nodeList.addFirst(treeNode.left);
            }
        }
        return res;
    }
}
