package LinkedList;

public interface LinkedList <E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    default boolean isFull(){
        return false;
    }

    String toString();

    E getFirstValue();

    class Entry<T> {

        public final T value;
        public Entry <T> next;

        public Entry(T value) {
            this.value = value;
        }
    }
}
