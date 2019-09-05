import java.util.Random;
public class TreeMain {
    public static void main(String[] args) {
        int count = 0;
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 11; j++) {
                tree.add(20 - random.nextInt(40));
            }
            if (tree.isBalancedTree()){
                count++;
            }
            System.out.println(i + ": " + tree.isBalancedTree());
        }

        double proc = (double) count/20*100;
        System.out.println(count);
        System.out.println("Процент сбалансированных деревьев: " + proc + "%");

        //tree.traverse(TraverseMode.IN_ORDER);

        //tree.display();

    }
}