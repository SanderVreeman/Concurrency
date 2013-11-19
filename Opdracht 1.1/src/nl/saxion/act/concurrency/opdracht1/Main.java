package nl.saxion.act.concurrency.opdracht1;

/**
 *
 * @author Sander
 */
public class Main {
    private static final int[] ARRAY_SIZES = {800000, 400000, 200000, 100000, 50000, 25000};
//    private static final int[] ARRAY_SIZES = {15};
    private static final int NUMBER_OF_RUNS = 6;
    
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();

        for (int i = 0; i < ARRAY_SIZES.length; i++) {
            System.out.println("----------------------------------");
            System.out.println("");
            System.out.println("Sorting array with size of " + ARRAY_SIZES[i]);
            System.out.println("");
            System.out.println("----------------------------------");
            
            for (int j = 0; j < NUMBER_OF_RUNS; j++) {
            System.out.println("Run: " + j);
            
            int[] intArray = sort.generateArray(ARRAY_SIZES[i]);
            
            double start = (double) System.currentTimeMillis();

            sort.sort(intArray);

            double stop = (double) System.currentTimeMillis();
            System.out.println("Array sorted in " + ((stop - start) / 1000)
                    + " sec");

            sort.checkArray(intArray);
            
            System.out.println("");
            }
        }
    }
}
