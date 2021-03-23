// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;


      class myIterator implements Iterator {
        private int ptr;
        public myIterator() {
            ptr = first;
        }
        public boolean hasNext() {
            return ptr != last;
        }
        public T next() {
            T res = rb[ptr++];
            ptr %= capacity;
            return res;
        }

    }
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        this.capacity = capacity;
        fillCount = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }


    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.fillCount;
    }

    @Override
    public boolean isEmpty() {
        return fillCount == 0;
    }

    @Override
    public boolean isFull() {
        return fillCount == capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last++] = x;
        last %= capacity;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T res = rb[first];
        first = (first + 1) % capacity;
        fillCount --;
        return res;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
//        if(this.isEmpty()) {
//            throw new RuntimeException("Ring buffer empty");
//        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
