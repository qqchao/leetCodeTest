package other.link;

/**
 * Class:
 *
 * @author 秦超
 * 2018/7/23
 */
public class DoubleLinkNode<T> {
    class Node<T> {
        T data;
        Node<T> pre;
        Node<T> next;

        public Node (){
            this.data = null;
            this.next = null;
            this.pre = null;
        }

        public Node(T data, Node<T> pre, Node<T> next){
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private int size;
    private Node<T> Header;
    private Node<T> Tail;

    public DoubleLinkNode(){
        size = 0;
        Header = new Node<T>(null, null, null);
        Tail = new Node<T>(null, Header, null);
        Tail.pre = Header;
    }

    public void add(T data){
        Node<T> node = new Node<T>(data, null, null);

        Tail.pre.next = node;
        node.next = Tail;

        node.pre = Tail.pre;
        Tail.pre = node;

        size++;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int size(){
        return this.size;
    }
}
