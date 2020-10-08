public class HashTable {

    private Node[] arr;


    private static class Node{
        private final Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public HashTable(){
        arr = new Node[97];
    }

    private int hash(Object key)
    {
        return (key.hashCode() & 0x7fffffff % arr.length);
    }

    public Object get(Object key){
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Object key, Object val){
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) x.val = val;
            else
            {
                arr[i] = new Node(key,val,arr[i]);
            }
        }

    }







}
