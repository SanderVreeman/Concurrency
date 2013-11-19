public class SortThread extends Thread {
	private int[] intList;

	public SortThread(int[] intListIn) {
		intList = new int[intListIn.length];
		intList = intListIn;
	}

	public void run() {
		InsertionSort iSort = new InsertionSort();
		iSort.sort(intList);
	}
	
	public int[] getSortedList() {
		return intList;
	}

}
