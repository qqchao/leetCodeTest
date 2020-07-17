package problems;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        a.next = new ListNode(8);

        ListNode res = addTwoNumbers(a, b);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = add(l1, l2);

        return reverseList(result);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode add(ListNode l1, ListNode l2){
        ListNode result = null;

        int a;
        int b;

        int c;
        int d = 0;

        while(l1 != null || l2 != null){
            if(l1 !=  null){
                a = l1.val;
                l1 = l1.next;
            }else{
                a = 0;
            }

            if(l2 !=  null){
                b = l2.val;
                l2 = l2.next;
            }else{
                b = 0;
            }

            c = (a+b+d)%10;
            d = (a+b+d)/10;

            ListNode current = new ListNode(c);
            current.next = result;
            result = current;
        }

        if(d == 1){
            ListNode current = new ListNode(1);
            current.next = result;
            result = current;
        }

        return result;
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
}
