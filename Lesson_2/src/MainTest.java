import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void checkArray(){
        ArrayImpl arrayTest = new ArrayImpl(1000);
        ArrayImpl arrayTestDefaultSize = new ArrayImpl();
        Assertions.assertEquals(1000, arrayTest.length());
        Assertions.assertEquals(16, arrayTestDefaultSize.length());
    }

    @Test
    void checkAdd(){
        ArrayImpl arrayTest = new ArrayImpl<>();
        arrayTest.add(1);
        arrayTest.add(2);
        arrayTest.add(1);
        Assertions.assertEquals(1, arrayTest.get(0));
        Assertions.assertNotEquals(arrayTest.get(0), arrayTest.get(1));
    }

    @Test
    void checkDelete(){
        ArrayImpl arrayTestDelete = new ArrayImpl<>(5);

        ArrayImpl arrayExpected = new ArrayImpl();
        arrayExpected.add("1");
        arrayExpected.add("2");
        arrayExpected.add("3");

        ArrayImpl arrayActual = new ArrayImpl();
        arrayActual.add("1");
        arrayActual.add("10");
        arrayActual.add("2");
        arrayActual.add("10");
        arrayActual.add("10");
        arrayActual.add("10");
        arrayActual.add("3");

        arrayActual.delete("10");

        for (int i = 0; i < arrayTestDelete.length(); i++) {
            arrayTestDelete.add(i);
        }

        Assertions.assertEquals(5, arrayTestDelete.getSize());

        arrayTestDelete.delete(2);

        Assertions.assertEquals(4, arrayTestDelete.get(3));
        Assertions.assertEquals(4, arrayTestDelete.getSize());
        Assertions.assertEquals(arrayExpected.toString(), arrayActual.toString());
    }

    @Test
    void findCheck(){
        ArrayImpl arrayTestFind = new ArrayImpl<>();

        for (int i = 0; i < 5; i++) {
            arrayTestFind.add(i);
        }

        Assertions.assertEquals(4, arrayTestFind.get(4));
        Assertions.assertEquals(null, arrayTestFind.find("1"));
    }
}