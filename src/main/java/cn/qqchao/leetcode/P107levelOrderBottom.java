package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P107levelOrderBottom {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        LinkedList<TreeNode> nodeList = new LinkedList();
        nodeList.add(root);
        nodeList.add(null);
        List<Integer> rowData = new ArrayList();
        rowData = new ArrayList();
        while(!nodeList.isEmpty()){
            TreeNode currentNode = nodeList.poll();
            if (currentNode == null) {
                result.add(rowData);
                rowData = new ArrayList<>();
                if (!nodeList.isEmpty()){
                    nodeList.add(null);
                }
            } else {
                rowData.add(currentNode.val);
                if (currentNode.left!=null) {
                    nodeList.add(currentNode.left);
                }
                if (currentNode.right!=null) {
                    nodeList.add(currentNode.right);
                }
            }
        }

        int start = 0;
        int end = result.size()-1;
        while (start<end){
            List<Integer> temp = result.get(start);
            result.set(start, result.get(end));
            result.set(end, temp);
            start++;
            end--;
        }

        return result;
    }
}
