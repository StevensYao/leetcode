package com.sy.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*3. Longest Substring Without Repeating Characters
        Given a string, find the length of the longest substring without repeating characters.

        Example 1:

        Input: "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int len,longest=0;
        char c;
        Map<Character, Integer> set = new HashMap<>();
        int start = 0, pos = 0, temp;
        for (; pos < s.length(); pos++) {
            c = s.charAt(pos);
            if(set.containsKey(c)){
                len = pos-start;
                longest = len>longest?len:longest;
                temp=set.get(c)+1;
                start=start>temp?start:temp;
            }
            set.put(c,pos);
        }
        len = pos-start;
        longest = len>longest?len:longest;
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubString().lengthOfLongestSubstring("abba"));
    }
}
