public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        public Node() {}
        T val;
        Node prev, next;
    }

    private int size = 0;
    private Node sentinel = new Node();
    private Node ptr = sentinel.next;
    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 && index > size - 1) {
            return null;
        }
        Node p = sentinel.next;
        while (index-- > 0) {
            p = p.next;
        }
        return p.val;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.val + " ");
             p = p.next;
        }
    }

    @Override
    public void addLast(T item) {
        Node node = new Node();
        node.val = item;
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        sentinel.prev = node;
        node.next = sentinel;
        size++;
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node();
        node.val = item;
        Node second = sentinel.next;
        sentinel.next = node;
        node.prev = sentinel;
        node.next = second;
        second.prev = node;
        size++;
    }

    @Override
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        last.prev = null;
        last.next = null;
        size--;
        return last.val;
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        first.prev = null;
        first.next = null;
        size--;
        return first.val;
    }

    public T getRecursive(int index) {
        Node ptr = sentinel.next;
        return getRecursiveHelper(index, ptr);
    }

    private T getRecursiveHelper(int index, Node ptr) {
        if (ptr == null) return null;
        if (index == 0) {
            return ptr.val;
        }
        return getRecursiveHelper(index - 1, ptr.next);
    }
}
