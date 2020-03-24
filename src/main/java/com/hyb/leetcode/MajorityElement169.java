package com.hyb.leetcode;

import java.util.Arrays;

/**
 * @Author : hongyb
 * @Description
 * @Date Created  in 12:39 2020/3/13
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 在这个假设前提下，对数组进行排序，中间数一定是多数元素
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
