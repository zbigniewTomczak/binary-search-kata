public class BinarySearch implements Search {
	private final int beginIndex;
	private final int endIndex;
	private final int[] A;
	public static final int NOT_FOUND_VALUE = -1;
	private int firstIndexOfSecondHalf;

	public BinarySearch(int[] A) {
		this(A, 0, arrayLastIndex(A));
	}

	private BinarySearch(int[] A, int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.firstIndexOfSecondHalf = calculateBeginningOfSecondHalf(endIndex);
		this.A = A;
	}

	private int calculateBeginningOfSecondHalf(int endIndex) {
		return 1; //TODO simplification
	}

	@Override
	public int find(int n) {
		System.out.println(beginIndex +", "+ endIndex +", "+ firstIndexOfSecondHalf);
		if (isSizeOne()) {
			return firstMatches(n) ? beginIndex : NOT_FOUND_VALUE;
		}
		if (inFirstHalf(n)) {
			int lastIndexOfFirstHalf = firstIndexOfSecondHalf - 1;
			return new BinarySearch(A, beginIndex, lastIndexOfFirstHalf).find(n);
		}
		if (inSecondHalf(n)) {
			return new BinarySearch(A, firstIndexOfSecondHalf, endIndex).find(n);
		}
		return NOT_FOUND_VALUE;
	}

	private boolean inFirstHalf(int n) {
		return n < A[firstIndexOfSecondHalf];
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

	private static int arrayLastIndex(int[] A) {
		return A.length - 1;
	}
}
