package io.github.dunwu.ds.sort.strategy;

import io.github.dunwu.ds.sort.Sort;
import io.github.dunwu.ds.util.ArrayUtil;

/**
 * 插入排序算法
 *
 * @author Zhang Peng
 */
public class InsertSort implements Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// 打印第一个元素
		ArrayUtil.debugLogArray(list, 0, 0, String.format("i = %d:\t", 0));

		// 第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
		for (int i = 1; i < list.length; i++) {
			int j = 0;
			// 取出第i个数，和前i-1个数比较后，插入合适位置
			T temp = list[i];

			// 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
			for (j = i - 1; j >= 0 && temp.compareTo(list[j]) < 0; j--) {
				list[j + 1] = list[j];
			}
			list[j + 1] = temp;

			ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("i = %d:\t", i));
		}
	}

}
