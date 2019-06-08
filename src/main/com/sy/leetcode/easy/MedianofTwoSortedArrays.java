package com.sy.leetcode.easy;

/*
  4. Median of Two Sorted Arrays
  There are two sorted arrays nums1 and nums2 of size m and n respectively.

  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

  You may assume nums1 and nums2 cannot be both empty.

  Example 1:

  nums1 = [1, 3]
  nums2 = [2]

  The median is 2.0
  Example 2:

  nums1 = [1, 2]
  nums2 = [3, 4]

  The median is (2 + 3)/2 = 2.5
  */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ret;
        int len = nums1.length + nums2.length;
        int medianUp = len / 2;
        int median = medianUp;
        if ((len % 2) == 0) median = medianUp - 1;
        int len1 = 0, len2 = 0, resultLen = 0, m1 = 0, m2 = 0, m;
        while ((len1 < nums1.length || len2 < nums2.length) && resultLen <= medianUp) {
            if (len1 < nums1.length && len2 < nums2.length) {
                if (nums1[len1] < nums2[len2]) {
                    m = nums1[len1++];
                } else {
                    m = nums2[len2++];
                }
            } else if (len1 < nums1.length) {
                m = nums1[len1++];
            } else {
                m = nums2[len2++];
            }
            if (resultLen == median) m1 = m;
            if (resultLen == medianUp) m2 = m;
            resultLen++;
        }
        ret = (m1 + m2) / 2.0;
        return ret;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2}, n2 = {3, 4};

        double result = new MedianofTwoSortedArrays().findMedianSortedArrays(n1, n2);
        System.out.println(result);
    }
}
