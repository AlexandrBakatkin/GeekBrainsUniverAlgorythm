package LinkedList;

public class LinkedQueue<E> implements queue.Queue<E> {

    private TwoSideLinkedList<E> data;

    public LinkedQueue() {
        this.data = new TwoSideLinkedListImpl<E>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    public int size(){
        return data.size();
    }

    public boolean isFull(){
        return false;
    }
}
