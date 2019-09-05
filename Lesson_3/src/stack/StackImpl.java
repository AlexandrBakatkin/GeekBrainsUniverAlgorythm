package stack;

public class StackImpl<E> implements Stack<E> {

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
    }

    @Override
    public void push(E value) {
        data[size++] = value;
    }

    @Override
    public E pop() {
        if (size >= 0){
        return data[--size];}
        else {return null;}
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            pop();
        }
    }

    public int length(){
       return data.length;
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer("Stack: [");
        for (int i = 0; i < size; i++) {
            if (i == 0){str.append(data[i]);} else {
                str.append(" " + data[i]);}
        }
        str.append("]");
        return str.toString();
    }
}
