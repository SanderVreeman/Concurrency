
public class Merge {
	
	public Merge() {
		
	}
	
	public int[] merge(int[] p1, int p2[]) {
		int[] part1, part2, merged;
		part1 = new int[p1.length];
		part2 = new int[p2.length];
		merged = new int[part1.length + part2.length];		
		int i = 0, j = 0, k = 0;
		
		while (i < part1.length && j < part2.length) {
			if (part1[i] < part2[j]) {
				merged[k] = part1[i];
				i++;
			} else {
				merged[k] = part2[j];
				j++;
			}
			k++;
		}

		while (i < part1.length) {
			merged[k] = part1[i];
			i++;
			k++;
		}

		while (j < part2.length) {
			merged[k] = part2[j];
			j++;
			k++;
		}
		return merged;
	}

}
