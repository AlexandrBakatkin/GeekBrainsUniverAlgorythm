package queue;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;
    private final E[] data;
    private int size;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()){
            return false;
        }

        if (tail == lastIndex()){
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {

        if(isEmpty()){
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return data[head];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!isEmpty()){
            sb.append(remove());
        }
        sb.append(']');
        return sb.toString();
    }
}
