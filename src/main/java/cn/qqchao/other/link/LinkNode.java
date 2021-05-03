package cn.qqchao.other.link;

/**
 * Class:
 *
 * 2018/7/23
 */
public class LinkNode {

    class Node { // 保存每一个节点，此处为了方便直接定义成内部类
        private String data; // 节点的内容
        private Node next; // 保存下一个节点

        public Node(String data) { // 通过构造方法设置节点内容
            this.data = data;
        }

        public void add(Node node) { // 增加节点
            if (this.next == null) { // 如果下一个节点为空，则把新节点加入到next的位置上
                this.next = node;
            } else { // 如果下一个节点不为空，则继续找next
                this.next.add(node);
            }
        }

        public void print() { // 打印节点
            if (this.next != null) {
                System.out.print(this.data + "-->");
                this.next.print();
            } else {
                System.out.print(this.data + "\n");
            }
        }

        public boolean search(String data) { // 内部搜索节点的方法
            if (this.data.equals(data)) {
                return true;
            }
            if (this.next != null) {
                return this.next.search(data);
            } else {
                return false;
            }
        }

        public void delete(Node previous, String data) { // 内部删除节点的方法
            if (this.data.equals(data)) {
                previous.next = this.next;
            } else {
                if (this.next != null) {
                    this.next.delete(this, data);
                }
            }
        }
    }

    private Node root; // 定义头节点

    public void addNode(String data) { // 根据内容添加节点
        Node newNode = new Node(data); // 要插入的节点
        if (this.root == null) { // 没有头节点，则要插入的节点为头节点
            this.root = newNode;
        } else { // 如果有头节点，则调用节点类的方法自动增加
            this.root.add(newNode);
        }
    }

    public void print() { // 展示列表的方法
        if (root != null) { // 当链表存在节点的时候进行展示
            this.root.print();
        }
    }

    public boolean searchNode(String data) { // 在链表中寻找指定内容的节点
        return root.search(data); // 调用内部搜索节点的方法
    }

    public void deleteNode(String data) { // 在链表中删除指定内容的节点
        if (root.data.equals(data)) { // 如果是头节点
            if (root.next != null) {
                root = root.next;
            } else {
                root = null;
            }
        } else {
            root.next.delete(this.root, data);
        }
    }

    public static void main(String[] args) {
        /*LinkNode l = new LinkNode();
        l.addNode("A");

        l.addNode("B");
        l.addNode("C");
        l.addNode("A");
        l.addNode("D");
        System.out.println("原链表：");
        l.print();
        String searchNode = "B";
        System.out.println("查找节点:" + searchNode);
        String result = l.searchNode(searchNode)?"找到!":"没找到!";
        System.out.println("查找结果：" + result);
        System.out.println("查找节点:" + "E");
        System.out.println("查找结果：" + (l.searchNode("E")?"找到!":"没找到!"));
        System.out.println("删除节点：" + searchNode);
        l.deleteNode(searchNode);
        System.out.println("删除节点后的链表：");
        l.print();*/


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(FindKthToTail(node1, 6).val);

    }



    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
    }


        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param pHead ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public static ListNode FindKthToTail (ListNode pHead, int k) {
            // write code here
            ListNode fast = pHead;
            ListNode slow = pHead;

            for(int i = 0; i < k; i++){
                if (fast == null) {
                    return null;
                }
                fast = fast.next;
            }
            while (fast!=null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;

        }
}
