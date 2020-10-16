package cn.qqchao.other.treenode;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int x, TreeNode p, TreeNode q) {
        val = x;
        left = p;
        right = q;
    }

    public TreeNode(int[] array){
        List<TreeNode> nodeList=new LinkedList<TreeNode>();

        this.val = array[0];
        nodeList.add(this);
        for(int nodeIndex=1;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //防止是非完全二叉树
            if((parentIndex*2+2)<array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
    }
}
