import java.util.ArrayList;

public class RecursionMain {
    public static void main(String[] args) {

        System.out.println(degree(4, -2));
        System.out.println();

        Obj book = new Obj("Книга", 10, 30);
        Obj bottle = new Obj("Бутылка", 15, 58);
        Obj glasses = new Obj("Очки", 15, 20);
        Obj stone = new Obj("Камень", 10, 45);
        Obj notebook = new Obj("Ноутбук", 25, 70);

        ArrayList<Obj> objList= new ArrayList<>();
        objList.add(book);
        objList.add(bottle);
        objList.add(glasses);
        objList.add(stone);
        objList.add(notebook);


        BackPack backPack = new BackPack(objList, 50);
        backPack.calcBestSet(objList);
        objList = backPack.getBestSet();
        for (int i = 0; i < objList.size(); i++) {
            System.out.println(objList.get(i).getName() + " " + objList.get(i).getCost());
        }
        System.out.println("Total best price is " + backPack.getBestPrice());
        System.out.println("Count: " + backPack.getCount());
    }


    private static float degree(float basis, int exponent) {

        if (exponent == 0 && basis == 0) {
            return 0;
        }

        if (exponent > 0){
            return basis*(degree(basis, exponent - 1));

        }

        if (exponent == 0){
            return 1;

        }

        if (exponent < 0){
            return 1/basis*(degree(basis, exponent + 1));

        } return 0;
    }
}