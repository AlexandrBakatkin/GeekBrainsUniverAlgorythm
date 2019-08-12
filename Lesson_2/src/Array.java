import java.util.ArrayList;

public interface Array <E>{

    void add(E value);

    boolean delete(E value);

    boolean delete (int index);

    ArrayList<Integer> find(E value);

    E get(int index);

    String toString();

    void clear();
}