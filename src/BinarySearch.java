public class BinarySearch implements Search {
	private final int beginIndex;
	private final int endIndex;
	private final int[] A;
	public static final int NOT_FOUND_VALUE = -1;
	private int middle;

	public BinarySearch(int[] A) {
		this(A, 0, A.length - 1);
	}

	private BinarySearch(int[] A, int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.middle = calculateMiddle(endIndex);
		this.A = A;
	}

	private int calculateMiddle(int endIndex) {
		return 1; //TODO simplification
	}

	@Override
	public int find(int n) {
		System.out.println(beginIndex +", "+ endIndex +", "+ middle);
		if (isSizeOne()) {
			return firstMatches(n) ? beginIndex : NOT_FOUND_VALUE;
		}

		if (inSecondHalf(n)) {
			return new BinarySearch(A, middle, endIndex).find(n);
		}
		return NOT_FOUND_VALUE;
	}

	private boolean inSecondHalf(int n) {
		return true; //TODO simplification
	}

	private boolean firstMatches(int n) {
		return A[beginIndex] == n;
	}

	private boolean isSizeOne() {
		return beginIndex == endIndex;
	}
}
