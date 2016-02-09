import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void find_firstMatches_returnsIndexZero() {
		// given
		int[] A = new int[]{1};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(1);
		//then
		assertEquals(0, index);
	}

	@Test
	public void find_noMatches_returnsNotFoundValue() {
		// given
		int notFoundValue = -1;
		int[] A = new int[]{1};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(2);
		//then
		assertEquals(notFoundValue, index);
	}

	@Test
	public void find_twoValuesAndSecondMatches_returnsSecondIndex() {
		// given
		int secondIndex = 1;
		int[] A = new int[]{1,2};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(2);
		//then
		assertEquals(secondIndex, index);
	}

	@Test
	public void find_twoValuesAndFirstMatches_returnsFirstIndex() {
		// given
		int firstIndex = 0;
		int[] A = new int[]{1,2};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(1);
		//then
		assertEquals(firstIndex, index);
	}

	@Test
	public void calculateBeginningOfSecondHalf_threeElementArrayAndBeginningInMiddle_returnsMiddleBeginning() {
		// given
		int middleBeginning = 2;
		int[] A = new int[]{1,2,3};
		BinarySearch search = new BinarySearch(A, 1, 2);
		// when
		int index = search.calculateBeginningOfSecondHalf();
		//then
		assertEquals(middleBeginning, index);
	}
	
	@Test
	public void find_threeValuesAndMiddleMatches_returnsMiddleIndex() {
		// given
		int middleIndex = 1;
		int[] A = new int[]{1,2,3};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(2);
		//then
		assertEquals(middleIndex, index);
	}

	@Test
	public void calculateBeginningOfSecondHalf_fiveElementArrayAndBeginningAtEnd_returnsEndBeginning() {
		// given
		int endBeginning = 5;
		int[] A = new int[]{1,2,3,4,5};
		BinarySearch search = new BinarySearch(A, 4, 5);
		// when
		int index = search.calculateBeginningOfSecondHalf();
		//then
		assertEquals(endBeginning, index);
	}

	@Test
	public void find_fiveValuesAndLastMatches_returnsLastIndex() {
		// given
		int lastIndex = 4;
		int[] A = new int[]{1,2,3,4,5};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(5);
		//then
		assertEquals(lastIndex, index);
	}

	@Test
	public void find_fiveValuesAndLastButOneMatches_returnsLastButOneIndex() {
		// given
		int lastButOneIndex = 2;
		int[] A = new int[]{1,2,3,4,5};
		Search search = new BinarySearch(A);
		// when
		int index = search.find(3);
		//then
		assertEquals(lastButOneIndex, index);
	}

	@Test
	public void calculateBeginningOfSecondHalf_fiveElementArrayAndEvenLength_returnsCorrectBeginning() {
		// given
		int beginning = 4;
		int[] A = new int[]{1,2,3,4,5};
		BinarySearch search = new BinarySearch(A, 3, 5);
		// when
		int index = search.calculateBeginningOfSecondHalf();
		//then
		assertEquals(beginning, index);
	}

	@Test
	public void find_bigDataset_returnsCorrectIndexes() {
		// given
		int[] A = new int[]{1,2,3,4,5,7,13,14,17,54,67,890,999,5554,123444};
		Search search = new BinarySearch(A);

		for (int i = 0; i < A.length; i++) {
			// when
			int index = search.find(A[i]);
			//then
			assertEquals(i, index);
		}
	}
}
