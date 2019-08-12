import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        ArrayImpl arrayBubble = new ArrayImpl();
        for (int i = 0; i < 10000; i++) {
            arrayBubble.add(random.nextInt(100000));
        }
        ArrayImpl arraySelect = new ArrayImpl();
        for (int i = 0; i < 10000; i++) {
            arraySelect.add(random.nextInt(100000));
        }
        ArrayImpl arrayInsert = new ArrayImpl();
        for (int i = 0; i < 10000; i++) {
            arrayInsert.add(random.nextInt(100000));
        }

        long n1 = System.nanoTime();
        arrayBubble.sortBubble();
        long n2 = System.nanoTime();
        System.out.println(n2 - n1);

        n1 = System.nanoTime();
        arraySelect.sortSelect();
        n2 = System.nanoTime();
        System.out.println(n2 - n1);

        n1 = System.nanoTime();
        arrayInsert.sortInsert();
        n2 = System.nanoTime();
        System.out.println(n2 - n1);
    }
}