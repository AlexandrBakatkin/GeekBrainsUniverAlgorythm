public class Main {
    public static void main(String[] args) {
        countDown(10);
    }

    private static void countDown(int n) {
        if (n > 0){
            System.out.println(n);
            countDown(--n);
        }
    }
}