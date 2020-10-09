// Class that implements a resizing array of generic type

import java.util.NoSuchElementException;

public class ResizingArray<T> {
    private static final int init = 8;
    private T[] arr;
    private int n;

    public ResizingArray()
    {
        arr = (T[]) new Object[init];
        n = 0;
    }

    public void add(T item)
    {
        if (n == arr.length) resize(2*arr.length);
        arr[n++] = item;
    }

    public void add(T item, int index)
    {
        if (index > n || index < 0) throw new IndexOutOfBoundsException();

        if (n == arr.length) resize(2*arr.length);
        arr[index] = item;
        if (index == n) n++;


    }

    public void remove()
    {
        if(isEmpty()) throw new NoSuchElementException();
        arr[n--] = null;
        if (n == arr.length/4 && arr.length > init) resize(arr.length/2);
    }

    public void remove(int index)
    {
        if (index > n || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = null;
        if (index == n) n--;
        if (n == arr.length/4 && arr.length > init) resize(arr.length/2);
    }

    private void resize(int newSize)
    {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public T get(int i)
    {
        return arr[i];
    }

}
