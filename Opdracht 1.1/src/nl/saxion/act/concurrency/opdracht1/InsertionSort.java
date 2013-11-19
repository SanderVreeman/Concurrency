package nl.saxion.act.concurrency.opdracht1;

import java.util.Random;

public class InsertionSort {

    public InsertionSort() {

    }

    public int[] sort(int[] intArrayIn) {
        int[] intArray = intArrayIn;
        int i, j, key;

        for (j = 0; j < intArray.length; j++) {
            key = intArray[j];
            for (i = j - 1; (i >= 0) && (intArray[i] > key); i--) {
                intArray[i + 1] = intArray[i];
            }
            intArray[i + 1] = key;
        }

        return intArray;
    }

    public int[] generateArray(int arraySize) {
        int[] intArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            intArray[i] = i;
        }

        Random random = new Random();
        for (int i = intArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            int a = intArray[index];
            intArray[index] = intArray[i];
            intArray[i] = a;
        }

        return intArray;
    }

    public void checkArray(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] > intArray[i + 1]) {
                System.out.println("Fout met sorteren");
                return;
            }
        }
        System.out.println("Lijst goed gesorteerd");
    }

}
