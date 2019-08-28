public interface Tree <E> {

    /*boolean add (E value);

    boolean find (E value);

    boolean remove(E value);

    boolean isEmpty();

    boolean isBalancedTree();

    void display();

    int getSize();

    void traverse (TraverseMode mode);

    boolean isBalancedNode(E value);

    int height(E value);
*/

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    void display();

    boolean isBalanced(Node node);

    boolean isBalancedTree();

    void traverse(TraverseMode mode);

    class Entry<T> {

        public final T value;
        public Entry <T> next;

        public Entry(T value) {
            this.value = value;
        }
    }

}