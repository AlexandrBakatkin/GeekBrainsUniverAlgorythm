package stack;

public interface Stack<E> {

    void push (E value);

    E pop();

    E peek();

    boolean isEmpty();

    String toString();

    int size();

    boolean isFull();

    void clear();
}