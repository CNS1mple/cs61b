public interface Deque <T>{
    public int size();
    public boolean isEmpty();
    public void addLast(T x);
    public void addFirst(T x);
    public T get(int x);
    public T removeLast();
    public T removeFirst();
    public void printDeque();
}
