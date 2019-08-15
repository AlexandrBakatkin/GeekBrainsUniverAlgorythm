import java.util.ArrayList;
import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E>{

    protected static final int INITIAL_SIZE = 16;

    private E[] data;
    private int size;


    public ArrayImpl() {
        this(INITIAL_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int size) {
        this.data = (E[]) new Object[size];
    }

    @Override
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Not null value is required");
        }
        checkSize();
        data[size++] = value;
    }

    @Override
    public boolean delete(E value) {
        int count = 0;
        for (int i = 0; i < size; i++) {

            if (data[i].equals(value)){
                delete(i);
                i--;
                count++;
            }
        }

        if (count > 0){
            return true;
        } else {return false;}
    }

    @Override
    public boolean delete (int index) {
        if (index <= 0 || index > size) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return true;
    }

    @Override
    public ArrayList <Integer> find(E value) {
        if (value == null) {
            return null;
        }
        ArrayList <Integer> list = new ArrayList();

        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)){
                list.add(i);
            }
        }

        if (list.isEmpty()){return null;}
        return list;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    public String toString(){
        StringBuffer str = new StringBuffer("Array: [");
        for (int i = 0; i < size; i++) {
            if (i == 0){str.append(data[i]);} else {
            str.append(" " + data[i]);}
        }
        str.append("]");
        return str.toString();
    }

    public int length(){
        return data.length;
    }

    private void checkSize() {
        if (size == data.length){
            data = Arrays.copyOf(data, size * 2);
        }
    }

    @Override
    public void clear() {
        for (int i = size; i > 0; i--) {
            delete(i);
        }
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    E temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            E temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    public int getSize() {
        return size;
    }
}