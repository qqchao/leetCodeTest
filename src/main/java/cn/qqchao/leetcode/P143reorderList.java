package cn.qqchao.leetcode;

import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P143reorderList {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> tempList = new LinkedList();
        ListNode head1 = head;
        while (head1 != null) {
            tempList.add(head1);
            head1 = head1.next;
        }
        int nextIndex = 1;
        while (tempList.size()>0) {
            if (nextIndex > 0) {
                head.next = tempList.pollFirst();
            } else {
                head.next = tempList.pollLast();
            }
            head = head.next;
            nextIndex *= -1;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
