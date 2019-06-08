package com.sy.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {
    /*string convert(string s, int numRows);
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
    @Test
    void convertCase1() {
        ZigZagConversion zig = new ZigZagConversion();
        String ret = zig.convert("PAYPALISHIRING",3);
        assertEquals("PAHNAPLSIIGYIR",ret,"Wrong Conversion!");
    }
    @Test
    void convertCase2() {
        ZigZagConversion zig = new ZigZagConversion();
        String ret = zig.convert("PAYPALISHIRING",4);
        assertEquals("PINALSIGYAHRPI",ret,"Wrong Conversion!");
    }
    @Test
    void convert1Char() {
        ZigZagConversion zig = new ZigZagConversion();
        String ret = zig.convert("A",1);
        assertEquals("A",ret,"Wrong Conversion!");
    }

    @Test
    void convertABCD3() {
        ZigZagConversion zig = new ZigZagConversion();
        String ret = zig.convert("ABCD",3);
        assertEquals("ABDC",ret,"Wrong Conversion!");
    }
}