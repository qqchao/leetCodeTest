package cn.qqchao.leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 */
public class P141HasCycle {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
