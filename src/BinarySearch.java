public class BinarySearch implements Search {
	private final int beginIndex;
	private final int endIndex;
	private final int[] A;
	public static final int NOT_FOUND_VALUE = -1;
	private int firstIndexOfSecondHalf;

	public BinarySearch(int[] A) {
		this(A, 0, arrayLastIndex(A));
	}

	BinarySearch(int[] A, int beginIndex, int endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.firstIndexOfSecondHalf = calculateBeginningOfSecondHalf();
		this.A = A;
	}

	@Override
	public int find(int n) {
		if (isSizeOne()) {
			return firstMatches(n) ? beginIndex : NOT_FOUND_VALUE;
		}
		if (inFirstHalf(n)) {
			//TODO protect against stack overflow
			return new BinarySearch(A, beginIndex, calculateEndOfFirstHalf()).find(n);
		}
		if (inSecondHalf(n)) {
			//TODO protect against stack overflow
			return new BinarySearch(A, firstIndexOfSecondHalf, endIndex).find(n);
		}
		return NOT_FOUND_VALUE;
	}

	int calculateBeginningOfSecondHalf() {
		int a = endIndex - beginIndex;
		if (isEven(a)) {
			return a/2 + beginIndex;
		}
		return 1 + beginIndex + a/2;
//		return 1 + (beginIndex + endIndex)/2; // would produce overflow for two big integers
	}

	private boolean isEven(int endIndex) {
		return (endIndex % 2) == 0;
	}

	private int calculateEndOfFirstHalf() {
		return firstIndexOfSecondHalf - 1;
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
