package com.sy.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {

    @Test
    void reverse() {
        ReverseNumber rn = new ReverseNumber();
        assertEquals(123, rn.reverse(321));
        assertEquals(-123, rn.reverse(-321));
        assertEquals(-21, rn.reverse(-120));
        assertEquals(0,(rn.reverse(Integer.MIN_VALUE)));
        assertEquals(0,(rn.reverse(Integer.MAX_VALUE)));
    }
    @Test
    void reverseOld() {
        ReverseNumber rn = new ReverseNumber();
        assertEquals(123, rn.reverseOld(321));
        assertEquals(-123, rn.reverseOld(-321));
        assertEquals(-21, rn.reverseOld(-120));
        assertEquals(0,(rn.reverseOld(Integer.MIN_VALUE)));
        assertEquals(0,(rn.reverseOld(Integer.MAX_VALUE)));
    }
}