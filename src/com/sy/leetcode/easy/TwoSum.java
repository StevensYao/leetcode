package com.sy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (container.containsKey(complement) && i != container.get(complement)) {
                return new int[]{container.get(complement), i};
            }
            container.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] results = new TwoSum().twoSum(nums, 9);
        for (int num : results) {
            System.out.print(num + " ");
        }
    }
}
