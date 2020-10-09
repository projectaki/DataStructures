public class HTArray<T> {
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
