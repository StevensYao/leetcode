package com.sy.leetcode.easy;

/*Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:

        Input: 123
        Output: 321
        Example 2:

        Input: -123
        Output: -321
        Example 3:

        Input: 120
        Output: 21
        Note:
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2,147,483,648,  2,147,483,647].
        For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.*/
public class ReverseNumber {
    public int reverse(int x) {
        int ret = 0;
        int digital;
        while (x != 0) {
            digital = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && digital > 7)) return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && digital < -8)) return 0;
            ret = ret * 10 + digital;
        }
        return ret;
    }

    public int reverseOld(int x) {
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        int start = 0;
        boolean tailZero = true;
        if (s.charAt(start) == '-') sb.append(s.charAt(start++));
        for (int i = s.length() - 1; i >= start; i--) {
            if (s.charAt(i) == '0' && tailZero) continue;
            tailZero = false;
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        if ((s.length() == 10 && s.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) || (s.length() == 11 && s.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0))
            s = "0";
        return Integer.valueOf(s);
    }
}
