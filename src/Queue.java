public class Queue<T> {

    private final LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void queue(T data) {
        list.addToTail(data);
    }

    public T dequeue() {
        return list.removeHead();
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.queue("a");
        stringQueue.queue("b");
        stringQueue.queue("c");
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
    }
}
