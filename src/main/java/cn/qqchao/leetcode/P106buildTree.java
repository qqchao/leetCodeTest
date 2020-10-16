package cn.qqchao.leetcode;

import cn.qqchao.other.treenode.TreeNode;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P106buildTree {
    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if (length >0) {
            TreeNode currentNode = new TreeNode();
            int rootValue = postorder[length -1];
            currentNode.val = rootValue;
            int rootIndex = 0;
            for (int i = 0; i < length; i++) {
                if (inorder[i] == rootValue) {
                    rootIndex = i;
                    break;
                }
            }
            if (rootIndex > 0) {
                currentNode.left = buildTree(Arrays.copyOf(inorder, rootIndex), Arrays.copyOf(postorder, rootIndex));
            }
            if (rootIndex < length-1) {
                currentNode.right = buildTree(Arrays.copyOfRange(inorder, rootIndex+1, length), Arrays.copyOfRange(postorder, rootIndex, length-1));
            }

            return currentNode;
        } else return null;
    }
}
