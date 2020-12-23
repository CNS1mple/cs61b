import java.util.Objects;

public class ArrayDeque<T> {

    private int size = 0, capacity = 8;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkSize() {
        if(size == capacity) {
            capacity *= 2;
            T[] newItems = (T[])new Object[capacity];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
    }

    public void addLast(T x) {
        checkSize();
        items[size++] = x;
    }

    public void addFirst(T x) {
        checkSize();
        if (size >= 0) System.arraycopy(items, 0, items, 1, size++);
        items[0] = x;
    }

    //The next item we want to add, will go in to position size, and size increase by 1
    public T getLast() {
        if(size == 0) return null;
        return items[size - 1];
    }


    public T get(int i) {
        if(i < 0 || i >= size()) return null;
        return items[i];
    }

    public int size() {
        return size;
    }

    public void contractCheck() {
        double rate = (double) this.size / (double) this.capacity;
        if(rate < 0.25 && size > 16) capacity /= 2;
        T[] newItems = (T[])new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
    public T removeLast() {
        if(size == 0) return null;
        contractCheck();
        return items[size--];
    }

    public T removeFirst() {
        if(size == 0) return null;
        contractCheck();
        T res = items[0];
        if (size >= 0) System.arraycopy(items, 1, items, 0, size--);
        return res;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(get(i) +" ");
        }
    }
}
