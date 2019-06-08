package com.sy.leetcode.easy;

public class MaximumSwap {
    /*Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

    Example 1:
    Input: 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.
    Example 2:
    Input: 9973
    Output: 9973
    Explanation: No swap.
    Note:
    The given number is in the range [0, 10e8]*/
    public int maximumSwap(int num) {
        if (num < 10) return num;
        char s[] = String.valueOf(num).toCharArray();
        char max = s[0], posChar;
        int idx = 0, pos = 0;
        boolean swap = false;
        while (!swap && pos < s.length) {
            posChar = max = s[pos];
            idx = 0;
            for (int i = pos + 1; i < s.length; i++) {
                if (s[i] >= max) {
                    max = s[i];
                    idx = i;
                }
            }
            if (idx > 0 && max > posChar) {
                swap = true;
                break;
            }
            pos++;
        }
        if (swap) {
            s[idx] = s[pos];
            s[pos] = max;
            return Integer.valueOf(String.valueOf(s));
        } else {
            return num;
        }
    }
}
