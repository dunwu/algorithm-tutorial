package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class DiagonalTraverseTest {

	@Test
	public void test() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] expected = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };
		Assert.assertArrayEquals(expected, DiagonalTraverse.findDiagonalOrder(matrix));
	}

}
