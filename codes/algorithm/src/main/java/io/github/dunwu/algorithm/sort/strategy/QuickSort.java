package io.github.dunwu.ds.sort.strategy;

import io.github.dunwu.ds.sort.Sort;
import io.github.dunwu.ds.util.ArrayUtil;

/**
 * 快速排序算法
 *
 * @author Zhang Peng
 */
public class QuickSort implements Sort {

	private <T extends Comparable<T>> int division(T[] list, int left, int right) {
		// 以最左边的数(left)为基准
		T base = list[left];
		while (left < right) {
			// 从序列右端开始，向左遍历，直到找到小于base的数
			while (left < right && list[right].compareTo(base) >= 0) {
				right--;
			}
			// 找到了比base小的元素，将这个元素放到最左边的位置
			list[left] = list[right];

			// 从序列左端开始，向右遍历，直到找到大于base的数
			while (left < right && list[left].compareTo(base) <= 0) {
				left++;
			}
			// 找到了比base大的元素，将这个元素放到最右边的位置
			list[right] = list[left];
		}

		// 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
		// 而left位置的右侧数值应该都比left大。
		list[left] = base;
		return left;
	}

	private <T extends Comparable<T>> void quickSort(T[] list, int left, int right) {

		// 左下标一定小于右下标，否则就越界了
		if (left < right) {
			// 对数组进行分割，取出下次分割的基准标号
			int base = division(list, left, right);

			ArrayUtil.debugLogArray(list, left, right, String.format("base = %d: ", list[base]));

			// 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
			quickSort(list, left, base - 1);

			// 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
			quickSort(list, base + 1, right);
		}
	}

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}

}
