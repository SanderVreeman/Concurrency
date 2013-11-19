
public class InsertionSort {
	
	public InsertionSort() {
		
	}
	
	public int[] sort(int[] intListIn) {
		int[] intList = new int[intListIn.length];
		int i, j, key;
		
		intList = intListIn;
		
		for (j = 0; j < intList.length; j++) {
			key = intList[j];
			for (i = j - 1; (i >= 0) && (intList[i] > key); i--) {
				intList[i + 1] = intList[i];
			}
			intList[i + 1] = key;
		}
		
		return intList;
	}
	
}
