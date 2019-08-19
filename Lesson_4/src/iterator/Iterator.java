package iterator;

import LinkedList.LinkedList;
import LinkedList.SimpleLinkedList;

public class Iterator<E> implements java.util.Iterator<E> {

    public LinkedList.Entry<E> current;
    private LinkedList.Entry<E> previous;
    private SimpleLinkedList<E> linkedList;

    public Iterator(SimpleLinkedList<E> linkedList) {
        this.linkedList = linkedList;
        this.reset();
    }

    public void reset(){
        current = linkedList.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public boolean hasNext(){
        return current.next == null;
    }

    @Override
    public E next(){
        previous = current;
        current = current.next;
        return previous.next.value;
    }

    @Override
    public void remove() {

    }

    public E getCurrent(){
        return current.value;
    }

}
