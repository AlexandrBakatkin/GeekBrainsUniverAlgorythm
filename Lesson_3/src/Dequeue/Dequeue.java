package Dequeue;

public interface Dequeue<E> {
    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();
}
