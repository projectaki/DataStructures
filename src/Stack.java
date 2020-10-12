public class Stack<T> {
    private final LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void add(T data) {
        list.addToHead(data);
    }

    public T pop() {
        return list.removeHead();
    }


}
