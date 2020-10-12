import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node head;
    private Node tail;


    private class Node {
        private T data;
        private Node next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addToTail(T data) {
        Node x = new Node(data);
        if (head == null) {
            head = tail = x;
            return;
        }
        tail.next = x;
        tail = x;
    }

    public void addToHead(T data) {
        Node x = new Node(data);
        if (head == null) {
            head = tail = x;
            return;
        }
        x.next = head;
        head = x;
    }

    public T removeHead() {
        if(head == null) throw new NoSuchElementException();
        Node x = head;
        head = x.next;
        x.next = null;
        return x.data;
    }


}
