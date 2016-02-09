import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void find_firstMatches_returnsIndexZero() {
		// given
		int[] A = new int[]{1};
		Search sort = new BinarySearch(A);
		// when
		int index = sort.find(1);
		//then
		assertEquals(0, index);
	}

	@Test
	public void find_noMatches_returnsNotFoundValue() {
		// given
		int notFoundValue = -1;
		int[] A = new int[]{1};
		Search sort = new BinarySearch(A);
		// when
		int index = sort.find(2);
		//then
		assertEquals(notFoundValue, index);
	}

	@Test
	public void find_twoValuesAndSecondMatches_returnsSecondIndex() {
		// given
		int secondIndex = 1;
		int[] A = new int[]{1,2};
		Search sort = new BinarySearch(A);
		// when
		int index = sort.find(2);
		//then
		assertEquals(secondIndex, index);
	}


}
