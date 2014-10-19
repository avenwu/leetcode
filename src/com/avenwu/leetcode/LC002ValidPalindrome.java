package com.avenwu.leetcode;

/**
 * Created by aven on 14-10-19.
 * <p/>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p/>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p/>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class LC002ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("a=" + (int) 'a' + ", z=" + (int) 'z' + ", A=" + (int) 'A' + ", Z=" + (int) 'Z');
        System.out.println("result=" + solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("result=" + solution.isPalindrome("A MAN, a plan, a canal: Panama"));
        System.out.println("result=" + solution.isPalindrome("race a car"));
        System.out.println("result=" + solution.isPalindrome(" "));
        System.out.println("result=" + solution.isPalindrome(".,."));

    }

    public static final class Solution {

        public boolean isPalindrome(String s) {
            // take of invalid input
            if (s == null || s.equals("") || s.length() == 1) return true;
            int max = s.length() - 1;
            for (int i = 0, j = max; i <= j; i++, j--) {
                char left = s.charAt(i);
                char right = s.charAt(j);
                //skip characters
                while (!isAlphanumeric(left) && i <= j) {
                    i++;
                    if (inRange(i, max)) {
                        left = s.charAt(i);
                    }
                }

                while (!isAlphanumeric(right) && i <= j) {
                    j--;
                    if (inRange(j, max)) {
                        right = s.charAt(j);
                    }
                }
                // check equals
                if (toLowercase(left) != toLowercase(right) && i <= j) {
                    return false;
                }
            }
            return true;
        }

        public boolean inRange(int i, int max) {
            return i >= 0 && i <= max;
        }

        public boolean isAlphanumeric(char c) {
            return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }

        public char toLowercase(char c) {
            return c >= 'a' && c <= 'z' ? (char) (c - 32) : c;
        }
    }
}
