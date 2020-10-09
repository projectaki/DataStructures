public class HashTable<Key, Value> {

    private HTArray<Node> arr;

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

    private static class HTArray<T> {
        private static final int init = 5;
        private static final double resizeFactor = 0.75;
        private T[] arr;
        private int n;


        public HTArray()
        {
            arr = (T[]) new Object[init];
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


        public void resize(int newSize)
        {
            T[] newArr = (T[]) new Object[newSize];
            arr = newArr;
        }


        public T get(int i)
        {
            return arr[i];
        }


    }

    public HashTable(){
        arr = new HTArray<>();
    }

    private int hash(Key key, int size)
    {
        return (key.hashCode() & 0x7fffffff % size);
    }

    public Object get(Key key){
        int i = hash(key,arr.size());
        for (Node x = arr.get(i); x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val){

        if(arr.needsResizing())
        {
            HTArray<Node> newArr = new HTArray<>();
            newArr.resize(2*arr.size());
            reHash(newArr);
            arr = newArr;
        }

        int i = hash(key, arr.size());
        for (Node x = arr.get(i); x != null; x = x.next) {
            if (key.equals(x.key))
            {
                x.val = val;
                return;
            }

        }
        arr.add(new Node(key,val,arr.get(i)),i);
    }


    private void reHash(HTArray<Node> newArr)
    {
        for (int i = 0; i < arr.size(); i++) {
            for (Node x = arr.get(i); x != null; x = x.next) {
                int newHash = hash((Key) x.key, newArr.size());
                newArr.add(new Node(x.key,x.val,newArr.get(newHash)),newHash);
            }
        }
    }

    public static void main(String[] args)
    {
        HashTable<String,Integer> HT = new HashTable<>();
        HT.put("akosa",22);
        HT.put("helo",12);
        HT.put("maria",15);
        HT.put("loveu",7);
        HT.put("girl",9);
        HT.put("testcode",45);
        HT.put("hash",553);
        HT.put("hashy",3);
        HT.put("hasythen",665);
        HT.put("akossoa",3222);
        HT.put("mariiia",2234);
        HT.put("salsa",223);
        HT.put("akosa1",221);
        HT.put("helo1",121);
        HT.put("maria1",151);
        HT.put("loveu1",71);
        HT.put("girl1",91);
        HT.put("testcode1",451);
        HT.put("hash1",5531);
        HT.put("hashy1",31);
        HT.put("hasythen1",6651);
        HT.put("akossoa1",32221);
        HT.put("mariiia1",22341);
        HT.put("salsa1",2231);
        HT.put("akosa2",222);
        HT.put("helo2",122);
        HT.put("maria2",152);
        HT.put("loveu2",72);
        HT.put("girl2",92);
        HT.put("testcode2",452);
        HT.put("hash2",5532);
        HT.put("hashy2",32);
        HT.put("hasythen2",6652);
        HT.put("akossoa2",32222);
        HT.put("mariiia2",22342);
        HT.put("salsa2",2232);



        System.out.println(HT.get("mariiia1"));
    }





}
