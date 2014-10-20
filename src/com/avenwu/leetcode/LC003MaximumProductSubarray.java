package com.avenwu.leetcode;

/**
 * Created by Administrator on 2014/10/20.
 */
public class LC003MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1, 1, -1, -1, -1, 1, 1, 1, -1, 1111, -1}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1, 1, 0, 2, 0, -31, -1}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1, 0, 2, 0, -3, -1}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{0}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{0, 2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{0, -2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1, 0, 2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{-1, 0, 2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{-1, 0}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1, 0}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{1}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{-1}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{-4, -3, -2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{-4, 0, -2}));
        System.out.println("maximum subarray result=" + solution.maxProduct(new int[]{3, -1, 4}));
    }

    public static class Solution {
        public int maxProduct(int[] A) {
            return subSum(0, A.length - 1, A);
//            return product(A, 0, A.length);
        }

        public int subSum(int s, int e, int[] A) {
            int negativeCount = 0;
            int negativeIndex = 0;
            int zeroIndex = -1;
            for (int i = s; i <= e; i++) {
                if (A[i] < 0) {
                    negativeCount++;
                    negativeIndex = i;
                } else if (A[i] == 0) {
                    zeroIndex = i;
                }
            }
            if (zeroIndex > 0) {
                if (s == e) {
                    return A[s];
                } else {
                    int s1 = subSum(s, max(s, zeroIndex - 1), A);
                    int s2 = subSum(min(zeroIndex + 1, e), e, A);
                    return max(max(s1, s2), 0);
                }
            }
            if (negativeCount % 2 == 0) {
                return sum(s, e, A);
            } /*else if (negativeIndex == 1) {
                return max(sum(s, max(s, negativeIndex - 1), A), sum(min(negativeIndex + 1, e), e, A));
            } */ else {
                int leftSum = 1, rightSum = 1;
                boolean leftStop = false, rightStop = false;
                int left = s, right = e;
                while (left < right) {
                    if (!leftStop) {
                        leftSum *= A[left];
                        if (A[left] > 0) {
                            left++;
                        } else {
                            leftStop = true;
                        }
                    }
                    if (!rightStop) {
                        rightSum *= A[right];
                        if (A[right] > 0) {
                            right--;
                        } else {
                            rightStop = true;
                        }
                    }
                    if (leftStop && rightStop) break;
                }
                int start = s;
                int end = max(s, right - 1);
                if (leftSum >= rightSum) {
                    start = min(left + 1, e);
                    end = e;
                }
                return sum(start, end, A);
            }
        }

        public int sum(int start, int end, int[] A) {
            if (start == end) {
                return A[start];
            }
            int sum = A[start];
            for (int i = start + 1; i <= end; i++) {
                sum *= A[i];
            }
            return sum;
        }

        public int min(int a, int b) {
            return a > b ? b : a;
        }

        public int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
