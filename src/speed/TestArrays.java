package speed;

import java.util.Arrays;
import java.util.Random;

public class TestArrays {

    static int arrayLenght = 1000000;
    static int attemts = 1000;

    public TestArrays() {
    }

    public static int[] testIntArray()  {

        final Random random = new Random();
        long timeStart = System.currentTimeMillis();
        int[] initArray = new int[arrayLenght];

        for (int att = 0; att < attemts; att++) {
            long timeAttemtStart = System.currentTimeMillis();
            initArray = new int[arrayLenght];
            for (int i = 0; i < arrayLenght; i++) {
//                initArray[i] = random.nextInt(arrayLenght);
                initArray[i] = i;
            }

            // обращаем массив
            for (int i = 0,k=arrayLenght-1;  i < k-1; i++,k--) {
                int temp = initArray[i];
                initArray[i] = initArray[k];
                initArray[k] = temp;
            }

            int[] secondArray = new int[arrayLenght];
            System.arraycopy(initArray, 0, secondArray, 0 , arrayLenght-1);

            // обращаем массив
            for (int i = 0,k=arrayLenght-1;  i < k-1; i++,k--) {
                int temp = secondArray[i];
                secondArray[i] = secondArray[k];
                secondArray[k] = temp;
            }
            long timeAttemtend = System.currentTimeMillis();
            System.out.println(timeAttemtend - timeAttemtStart);
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("End");
        System.out.println(timeEnd-timeStart);
        return initArray;
    }

}
