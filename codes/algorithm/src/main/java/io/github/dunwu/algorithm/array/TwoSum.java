package io.github.dunwu.ds.array;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two nums such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] {2, 7, 11, 15}
		int target = 18;
		int[] result = twoSum(nums, target);
		System.out.println(result);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}

}
