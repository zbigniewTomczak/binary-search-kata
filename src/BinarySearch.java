public class BinarySearch implements Search {
	private final int beginIndex;
	private final int endIndex;
	private final int[] A;
	public static final int NOT_FOUND_VALUE = -1;
	private int middleIndex;

	public BinarySearch(int[] A) {
		this(A, 0, A.length - 1);
	}

	private BinarySearch(int[] A, int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.middleIndex = calculateMiddle(endIndex);
		this.A = A;
	}

	private int calculateMiddle(int endIndex) {
		return 1; //TODO simplification
	}

	@Override
	public int find(int n) {
		System.out.println(beginIndex +", "+ endIndex +", "+ middleIndex);
		if (isSizeOne()) {
			return firstMatches(n) ? beginIndex : NOT_FOUND_VALUE;
		}
		if (inFirstHalf(n)) {
			return new BinarySearch(A, beginIndex, middleIndex - 1).find(n);
		}
		if (inSecondHalf(n)) {
			return new BinarySearch(A, middleIndex, endIndex).find(n);
		}
		return NOT_FOUND_VALUE;
	}

	private boolean inFirstHalf(int n) {
		return n < A[middleIndex];
	}

	private boolean inSecondHalf(int n) {
		return !inFirstHalf(n);
	}

	private boolean firstMatches(int n) {
		return A[beginIndex] == n;
	}

	private boolean isSizeOne() {
		return beginIndex == endIndex;
	}
}
