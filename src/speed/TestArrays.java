package speed;

public class TestArrays {

    static int arrayLenght = 100000;
    static int attemts = 100;

    public TestArrays() {
    }

    public static void testIntArray() {

        long timeStart = System.currentTimeMillis();

        for (int j = 0; j < attemts; j++) {
            int[] initArray = new int[arrayLenght];
            for (int i = 0; i < arrayLenght; i++) {
                initArray[i] = i;
            }
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd-timeStart);
    }

}
