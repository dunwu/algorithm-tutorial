package io.github.dunwu.ds.array;

//    【移动零】

//
//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    示例:
//
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//    说明:
//
//    必须在原数组上操作，不能拷贝额外的数组。
//    尽量减少操作次数。

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class MoveZeros {

	private static void move(int[] nums, int pos) {
		int temp = nums[pos];
		for (int i = pos; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[nums.length - 1] = temp;
	}

	public static void moveZeroes(int[] nums) {
		int i = 0;
		int right = nums.length - 1;
		while (i <= right) {
			if (nums[i] == 0) {
				move(nums, i);
				right--;
			}
			else {
				i++;
			}
		}
	}

}
