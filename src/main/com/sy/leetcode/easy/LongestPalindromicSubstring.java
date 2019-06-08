package com.sy.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
5. Longest Palindromic Substring
   Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
   Example 1:

   Input: "babad"
   Output: "bab"
   Note: "aba" is also a valid answer.
   Example 2:

   Input: "cbbd"
   Output: "bb"
        */
public class LongestPalindromicSubstring {
    private int longest = 0, low = 0, high = 0, medianLow = 0, medianHigh = 0, workLow = 0, workHigh = 0;
    private boolean palindromicStart = false;
    private Queue<MedianData> medianQueue = new LinkedList<>();

    private class MedianData {
        int medianLow, medianHigh;

        MedianData(int medianLow, int medianHigh) {
            this.medianLow = medianLow;
            this.medianHigh = medianHigh;
        }
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String ret;
        char c;
        int pos;
        for (pos = 1; pos < s.length(); pos++) {
            c = s.charAt(pos);
            if (palindromicStart) {
                if ((pos == medianHigh + 1) && c == s.charAt(medianHigh)) {
                    medianHigh++;
                    workHigh = pos;
                    workLow = medianLow - (pos - medianHigh);
                    queueMedian(s, c, pos);
                } else if ((medianLow - (pos - medianHigh) >= 0 && c == s.charAt(medianLow - (pos - medianHigh)))) {
                    workHigh = pos;
                    workLow = medianLow - (pos - medianHigh);
                    queueMedian(s, c, pos);
                } else {
                    palindromicStart = false;
                    workHigh = pos - 1;
                    workLow = medianLow - (workHigh - medianHigh);
                    calculateLongest();
                    workHigh = workLow = 0;
                    checkPalindromicStart(s, c, pos);
                }
            } else checkPalindromicStart(s, c, pos);
        }
        calculateLongest();
        MedianData currentMedian;
        while ((currentMedian = medianQueue.poll()) != null) {
            medianLow = currentMedian.medianLow;
            medianHigh = currentMedian.medianHigh;
            pos = medianHigh + 1;
            palindromicStart = true;
            for (; pos < s.length(); pos++) {
                c = s.charAt(pos);
                if ((pos == medianHigh + 1) && c == s.charAt(medianHigh)) {
                    medianHigh++;
                    workHigh = pos;
                    workLow = medianLow - (pos - medianHigh);
                } else if ((medianLow - (pos - medianHigh) >= 0 && c == s.charAt(medianLow - (pos - medianHigh)))) {
                    workHigh = pos;
                    workLow = medianLow - (pos - medianHigh);
                } else {
                    palindromicStart = false;
                    workHigh = pos - 1;
                    workLow = medianLow - (workHigh - medianHigh);
                    break;
                }
            }
            calculateLongest();
        }
        if (longest > 0) ret = s.substring(low, high); //exclusive the end index
        else ret = s.substring(0, 1);
        return ret;
    }

    private void queueMedian(String s, char c, int pos) {
        if (c == s.charAt(pos - 1)) {
            medianQueue.offer(new MedianData(pos - 1, pos));
        } else if (pos > 1 && c == s.charAt(pos - 2)) {
            medianQueue.offer(new MedianData(pos - 1, pos - 1));
        }
    }

    private void calculateLongest() {
        if ((workHigh - workLow) > longest) {
            longest = workHigh - workLow;
            low = workLow;
            high = workHigh + 1; //exclusive the end index
        }
    }

    private void checkPalindromicStart(String s, char c, int pos) {
        if (c == s.charAt(pos - 1)) {
            medianLow = pos - 1;
            medianHigh = pos;
            palindromicStart = true;
            workHigh = pos;
            workLow = pos - 1;
        } else if (pos > 1 && c == s.charAt(pos - 2)) {
            medianLow = medianHigh = pos - 1;
            palindromicStart = true;
            workHigh = pos;
            workLow = pos - 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa"));
    }
}
