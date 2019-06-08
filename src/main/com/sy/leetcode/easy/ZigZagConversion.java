package com.sy.leetcode.easy;

/*6. ZigZag Conversion
         The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string s, int numRows);
        Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I*/
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int sLen = s.length(), pos, retIdx = 0;
        int steps = numRows * 2 - 2, midSteps;
        if (numRows >= sLen) return s;
        char ret[] = new char[sLen];
        for (int i = 0; i < numRows; i++) {
            pos = i;
            midSteps = 0;
            if (i > 0 && i < numRows - 1) {
                midSteps = (numRows - i - 1) * 2;
            }
            while (pos < sLen) {
                ret[retIdx++] = s.charAt(pos);
                if (midSteps > 0 && pos + midSteps < sLen) {
                    ret[retIdx++] = s.charAt(midSteps + pos);
                }
                pos += steps;
            }
        }
        return new String(ret);
    }
}
