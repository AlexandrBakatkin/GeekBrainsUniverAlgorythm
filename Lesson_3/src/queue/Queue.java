package queue;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peek();

}
