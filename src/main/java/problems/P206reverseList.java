package problems;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class P206reverseList {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        ListNode res = reverseList(l);
        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p,q,pre;
        p = head;
        q = null;

        while (p != null){
            pre = p.next;
            p.next = q;
            q = p;
            p = pre;
        }

        return q;
    }

    /**
     * 新路子，递归方法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode head1, ListNode head2) {
        if(head2 == null) return null;
        if(head2.next == null){
            head2.next = head1;
            return head2;
        }

        ListNode node = head2.next;
        head2.next = head1;
        return reverseList(head2, node);
    }
}
