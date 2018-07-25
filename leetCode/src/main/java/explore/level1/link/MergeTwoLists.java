package explore.level1.link;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public class ListNode {
       int val;
       ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode n, p, n1, n2;

        n = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            n = l1;
            n1 = l1.next;
            n2 = l2;
        }else {
            n = l2;
            n1 = l1;
            n2 = l2.next;
        }

        p = n;

        while(n1 != null && n2 != null){
            if(n1 == null){
                p.next = n2;
                n2 = null;
            }
            if(n2 == null){
                p.next = n1;
                n1 = null;
            }
            if(n1.val < n2.val){
                p.next = n1;
                p = n1;
                n1 = n1.next;
            }else {
                p.next = n2;
                p = n2;
                n2 = n2.next;
            }
        }

        return n;
    }
}
