package com.week1.demo;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 暴力枚举解法
     * 时间复杂度：O(N^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 哈希表解法
     * 时间复杂度:O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v) && i != map.get(v)) {
                result[0] = i;
                result[1] = map.get(v);
                return result;
            }
        }
        return result;
    }
}
