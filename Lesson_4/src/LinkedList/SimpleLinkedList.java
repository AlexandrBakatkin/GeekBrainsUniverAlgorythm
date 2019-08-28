package LinkedList;

import iterator.Iterator;

public class SimpleLinkedList <E> implements LinkedList<E>, Iterable<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<E>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()){return null;}

        E value = firstElement.value;
        firstElement = firstElement.next;

        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;
        while (current != null){
            if (current.value.equals(value)){break;};

            previous = current;
            current = current.next;
        }

        if (current == null){
            return false;
        }

        if (current == firstElement){
            firstElement = current.next;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linked List: [ ");
        Entry<E> current = firstElement;
        while (current != null){
            sb.append(current.value);
            sb.append(' ');
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    public Entry<E> getFirst(){
        return firstElement;
    }

    public Iterator<E> iterator() {

        return new Iterator<E>(this) {

            Entry<E> currentLink = firstElement;
            Entry<E> tempLink;
            boolean firstIter = true;

            public boolean hasNext() {
                return currentLink.next != null;
            }

            public E next() {
                if (firstIter){
                    firstIter = false;
                    return firstElement.value;
                }

                tempLink = currentLink;
                if (currentLink.next != null){
                    currentLink = currentLink.next;
                    return currentLink.value;
                } else {
                    return null;
                }
            }
        };
    }
}
