import java.util.Arrays;

public class StringBuilder {

    private char[] arr;
    private int n;
    private static final int init = 8;

    public StringBuilder() {
        arr = new char[init];
        n = 0;
    }

    public StringBuilder(int init) {
        arr = new char[init];
        n = 0;
    }

    public void append(String item)
    {

        for (int i = 0; i < item.length(); i++) {
            if (n == arr.length) resize(2*arr.length);
            arr[n++] = item.charAt(i);
        }

    }

    public String toString() {
        return String.valueOf(arr);
    }

    private void resize(int newSize)
    {
        char[] newArr = new char[newSize];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {

        // Hashtable----------------------
        String[] arr = {"a","b","c","fght"};
        StringBuilder sb = new StringBuilder(1);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
        //--------------------------------------------------------------------------

    }










}
