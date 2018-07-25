package problems;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class P234IsPalindrome {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        int sum = 0;
        int i = 1;
        while (p != null){
            sum += i * p.val;
            i *= 2;
            p = p.next;
        }
        while (q != null){
            i /= 2;
            sum -= i * q.val;
            q = q.next;
        }
        return (sum == 0);
    }
}
