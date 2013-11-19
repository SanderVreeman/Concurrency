
public class SplitList {
	private int[] part1, part2;
	
	public SplitList() {

	}
	
	public void split(int[] intList) {
		part1 = new int[intList.length / 2];
		part2 = new int[intList.length / 2];
		
		System.arraycopy(intList, 0, part1, 0, part1.length);
		System.arraycopy(intList, part1.length, part2, 0, part2.length);
	}
	
	public int[] getPart1() {
		return part1;
	}
	
	public int[] getPart2() {
		return part2;
	}
}
