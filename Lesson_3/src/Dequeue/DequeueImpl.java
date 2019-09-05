package Dequeue;

public class DequeueImpl<E> implements Dequeue<E>{

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;
    private final E[] data;
    private int size;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public DequeueImpl (int capacity){
        this.data = (E[]) new Object[capacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()){
            return false;
        }

        if (head <= 0){
            head = data.length - 1;
        }

        data[head--] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLeft(E value) {
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
    public E removeLeft() {
        if(isEmpty()){
            return null;
        }

        if (head == data.length - 1) {
            head = DEFAULT_HEAD - 1;
        }
        E value = data[++head];
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        if(isEmpty()){
            return null;
        }

        if (tail < 0) {
            tail = data.length - 1;
        }
        E value = data[tail--];
        size--;
        return value;
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

    public int length(){
        return data.length;
    }

    public void print(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!isEmpty()){
            sb.append(removeLeft());
        }
        sb.append(']');
        return sb.toString();
    }
}