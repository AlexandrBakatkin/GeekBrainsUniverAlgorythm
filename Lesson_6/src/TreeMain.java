import java.util.Random;
public class TreeMain {
    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();

        Random random = new Random();

        for (int i = 0; i < 11; i++) {
            tree.add(20 - random.nextInt(40));
        }

        tree.traverse(TraverseMode.IN_ORDER);

        tree.display();

    }
}