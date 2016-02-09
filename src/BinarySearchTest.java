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
}
