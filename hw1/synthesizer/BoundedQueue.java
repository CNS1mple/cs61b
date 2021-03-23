package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    default boolean isEmpty() {return true;}
    default boolean isFull() {return false;}
}
