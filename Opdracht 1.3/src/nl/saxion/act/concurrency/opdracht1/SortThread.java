public class SortThread extends Thread {
	private static int limit;
	private int[] intList;
	private SortThread t1, t2;

	public SortThread(int[] intListIn, int limit) {
		intList = new int[intListIn.length];
		intList = intListIn;
		this.limit = limit;
	}

	public void run() {
		if (intList.length > limit) {
			
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
		} else {
			InsertionSort iSort = new InsertionSort();
			intList = iSort.sort(intList);
		}
		
	}
	
	public int[] getSortedList() {
		return intList;
	}

}
