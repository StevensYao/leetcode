package com.sy.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSwapTest {

    @Test
    void maximumSwap() {
        MaximumSwap ms = new MaximumSwap();
        assertEquals(7236, ms.maximumSwap(2736));
        assertEquals(9973, ms.maximumSwap(9973));
        assertEquals(98863, ms.maximumSwap(98368));
    }
    @Test
    void maximumSwap98368() {
        MaximumSwap ms = new MaximumSwap();
        assertEquals(98863, ms.maximumSwap(98368));
    }
    @Test
    void maximumSwap1993() {
        MaximumSwap ms = new MaximumSwap();
        assertEquals(9913, ms.maximumSwap(1993));
    }
}