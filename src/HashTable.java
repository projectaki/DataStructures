// Class for HashTable implementation with generic Key, Value using a separate chaining and resizing array

public class HashTable<Key, Value> {

    private ResizingHashTableArray<Node> resizingArray;

    private static class Node{
        private final Object key;
        private Object val;
        private final Node next;

        public Node(Object key, Object val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private static class ResizingHashTableArray<T> {
        private static final int init = 5;
        private static final double resizeFactor = 0.75;
        private static final int sizeMultiplier = 2;
        private final T[] arr;
        private int n;



        public ResizingHashTableArray()
        {
            arr = (T[]) new Object[init];
            n = 0;
        }

        public ResizingHashTableArray(int size)
        {
            arr = (T[]) new Object[size*sizeMultiplier];
            n = 0;
        }

        public int size()
        {
            return arr.length;
        }

        public boolean needsResizing()
        {
            return (double)n/arr.length >= resizeFactor;
        }

        public void add(T item, int index)
        {
            if (index >= arr.length || index < 0) throw new IndexOutOfBoundsException();
            arr[index] = item;
            n++;


        }


        public T get(int i)
        {
            return arr[i];
        }

    }

    public HashTable(){
        resizingArray = new ResizingHashTableArray<>();
    }

    private int hash(Key key, int size)
    {
        return (key.hashCode() & 0x7fffffff % size);
    }

    public Object get(Key key){
        int i = hash(key, resizingArray.size());
        for (Node x = resizingArray.get(i); x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val){

        if(resizingArray.needsResizing())
        {
            ResizingHashTableArray<Node> newArr = new ResizingHashTableArray<>(resizingArray.size());
            //newArr.resize(2* resizingArray.size());
            reHash(newArr);
            resizingArray = newArr;
        }

        int i = hash(key, resizingArray.size());
        for (Node x = resizingArray.get(i); x != null; x = x.next) {
            if (key.equals(x.key))
            {
                x.val = val;
                return;
            }

        }
        resizingArray.add(new Node(key,val, resizingArray.get(i)),i);
    }

    private void reHash(ResizingHashTableArray<Node> newArr)
    {
        for (int i = 0; i < resizingArray.size(); i++) {
            for (Node x = resizingArray.get(i); x != null; x = x.next) {
                int newHash = hash((Key) x.key, newArr.size());
                newArr.add(new Node(x.key,x.val,newArr.get(newHash)),newHash);
            }
        }
    }

}
