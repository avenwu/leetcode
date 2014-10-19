package com.avenwu.leetcode;

/**
 * Created by aven on 14-10-19.
 * <p/>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. You may assume no duplicate exists in the array.
 */
public class LC001FindMimmumElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result=" + solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("result=" + solution.findMin(new int[]{4, 5, 6, 7, 11, 1, 2}));
    }

    public static final class Solution {
        public int findMin(int[] num) {
            int result = num[0];
            for (int element : num) {
                if (element < result) result = element;
            }
            return result;
        }
    }
}
