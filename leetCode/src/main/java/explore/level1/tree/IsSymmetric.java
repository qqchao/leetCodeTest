package explore.level1.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode H = new TreeNode(8, null, null);
        TreeNode G = new TreeNode(7, H, null);
        TreeNode F = new TreeNode(6, null, null);
        TreeNode E = new TreeNode(5, null, null);
        TreeNode D = new TreeNode(4, null, G);
        TreeNode C = new TreeNode(3, E, F);
        TreeNode B = new TreeNode(2, D, null);
        TreeNode A = new TreeNode(1, B, C);

        System.out.println(isSymmetric(A));
        System.out.println(isSymmetric(A));
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

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
