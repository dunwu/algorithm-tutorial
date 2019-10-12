package io.github.dunwu.ds.sort.strategy;

import io.github.dunwu.ds.sort.Sort;
import io.github.dunwu.ds.util.ArrayUtil;

public class MergeSort implements Sort {

	private <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
		// i是第一段序列的下标
		int i = low;
		// j是第二段序列的下标
		int j = mid + 1;
		// k是临时存放合并序列的下标
		int k = 0;
		// array2是临时合并序列
		T[] array2 = (T[]) new Comparable[high - low + 1];

		// 扫描第一段和第二段序列，直到有一个扫描结束
		while (i <= mid && j <= high) {
			// 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
			if (array[i].compareTo(array[j]) <= 0) {
				array2[k] = array[i];
				i++;
				k++;
			}
			else {
				array2[k] = array[j];
				j++;
				k++;
			}
		}

		// 若第一段序列还没扫描完，将其全部复制到合并序列
		while (i <= mid) {
			array2[k] = array[i];
			i++;
			k++;
		}

		// 若第二段序列还没扫描完，将其全部复制到合并序列
		while (j <= high) {
			array2[k] = array[j];
			j++;
			k++;
		}

		// 将合并序列复制到原始序列中
		for (k = 0, i = low; i <= high; i++, k++) {
			array[i] = array2[k];
		}
	}

	private <T extends Comparable<T>> void mergeSort(T[] array, int gap, int length) {
		int i = 0;

		// 归并gap长度的两个相邻子表
		for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
			merge(array, i, i + gap - 1, i + 2 * gap - 1);
		}

		// 余下两个子表，后者长度小于gap
		if (i + gap - 1 < length) {
			merge(array, i, i + gap - 1, length - 1);
		}
	}

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		for (int gap = 1; gap < list.length; gap = 2 * gap) {
			mergeSort(list, gap, list.length);
			ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("gap = %d", gap));
		}
	}

}
