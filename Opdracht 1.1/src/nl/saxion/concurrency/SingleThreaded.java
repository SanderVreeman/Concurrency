package nl.saxion.concurrency;

import java.util.Random;

public class SingleThreaded {
	private static int[] intList;
	private static int aantalInts;

	public static void main(String[] args) {
		InsertionSort iSort = new InsertionSort();
		int[] limits = new int[] { 1000000, 100000, 10000 };

		for (int i = 0; i < limits.length; i++) {
			System.out.println("Sorting array with size of " + limits[i]);
			aantalInts = limits[i];
			fillList();
			double start = (double) System.currentTimeMillis();

			iSort.sort(intList);

			double stop = (double) System.currentTimeMillis();
			System.out.println("Array sorted in " + ((stop - start) / 1000)
					+ " sec");

			checkList();
			
			System.out.println("----------------------------------");
		}
	}

	public static void fillList() {
		Random random = new Random();
		intList = new int[aantalInts];

		for (int i = 0; i < aantalInts; i++) {
			intList[i] = random.nextInt();
		}
	}
	
	public static void checkList() {
		boolean goed = true;
		for (int i = 0; i < intList.length - 1; i++) {
			if (intList[i] > intList[i + 1]) {
				goed = false;
			} else {
				goed = true;
			}
		}
		
		if (goed) {
			System.out.println("Lijst goed gesorteerd");
		} else {
			System.out.println("Fout met sorteren");
		}
	}
}
