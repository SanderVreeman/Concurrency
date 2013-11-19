import java.util.Random;

public class MultiThreaded {
	private static int[] intList, limitsThread;
	private static int aantalInts = 1000000;
	private static SortThread t1, t2;

	public static void main(String[] args) {
		int[] limits = new int[] { 1000000, 100000, 10000 };
		limitsThread = new int[] { 100000, 10000 };

//		for (int i = 0; i < limits.length; i++) {
			for (int j = 0; j < limitsThread.length; j++) {
//				aantalInts = limits[i];
				System.out.println("Sorting array with size of " + aantalInts);
				System.out.println("Limit of " + limitsThread[j] + " ints per array");
				fillList();

				double start = (double) System.currentTimeMillis();

				sort(limitsThread[j]);

				double stop = (double) System.currentTimeMillis();

				System.out.println("Array sorted in " + ((stop - start) / 1000)
						+ " sec");
				
				checkList();
				
				System.out.println("----------------------------------");
			}
//		}
	}

	public static void fillList() {
		Random random = new Random();
		intList = new int[aantalInts];

		for (int i = 0; i < aantalInts; i++) {
			intList[i] = random.nextInt();
		}
	}

	public static void sort(int limit) {
		SplitList split = new SplitList();
		Merge merge = new Merge();

		split.split(intList);

		t1 = new SortThread(split.getPart1(), limit);
		t2 = new SortThread(split.getPart1(), limit);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		intList = merge.merge(t1.getSortedList(), t2.getSortedList());

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
