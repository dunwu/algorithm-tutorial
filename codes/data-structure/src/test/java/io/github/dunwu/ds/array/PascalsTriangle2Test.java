package io.github.dunwu.ds.array;

import io.github.dunwu.ds.util.ArrayUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class PascalsTriangle2Test {

	@Test
	public void test() {
		List<Integer> list = PascalsTriangle2.getRow(3);
		System.out.println(ArrayUtil.getArrayString(list.toArray(), 0, list.size() - 1));
	}

}
