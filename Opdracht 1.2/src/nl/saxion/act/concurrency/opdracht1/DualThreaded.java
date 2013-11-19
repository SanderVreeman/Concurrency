import java.util.Random;

public class DualThreaded {
	private static int[] intList;
	private static int aantalInts;
	private static SortThread t1, t2;

	public static void main(String[] args) {
		int[] limits = new int[] { 1000000, 100000, 10000 };

		for (int i = 0; i < limits.length; i++) {
			System.out.println("Sorting array with size of " + limits[i]);
			aantalInts = limits[i];
			fillList();

			double start = (double) System.currentTimeMillis();

			sort();

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

	public static void sort() {
		int[] part1 = new int[aantalInts / 2];
		int[] part2 = new int[aantalInts / 2];
		Merge merge = new Merge();

		System.arraycopy(intList, 0, part1, 0, part1.length);
		System.arraycopy(intList, part1.length, part2, 0, part2.length);

		t1 = new SortThread(part1);
		t2 = new SortThread(part2);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		part1 = t1.getSortedList();
		part2 = t2.getSortedList();

		intList = merge.merge(part1, part2);

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
