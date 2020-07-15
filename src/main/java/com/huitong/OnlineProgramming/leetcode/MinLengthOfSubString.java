package com.huitong.OnlineProgramming.leetcode;
//3. 无重复字符的最长子串
// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
// 输入: "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:
// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MinLengthOfSubString {
    public int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        int pos = 0;
        int maxLength = 0;
        Set set = new HashSet<>();
        int i = 0;
        while(i < array.length) {
            if(set.contains(array[i])){
                if(maxLength < set.size()) {
                    maxLength = set.size();
                }
                set.clear();
                pos ++;
                i = pos;
            } else {
                set.add(array[i]);
                if(maxLength < set.size()) {
                    maxLength = set.size();
                }
                i ++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MinLengthOfSubString minLengthOfSubString = new MinLengthOfSubString();
        String input = "abcabcbb";
        assertEquals(3, minLengthOfSubString.lengthOfLongestSubstring(input));
        input = "bbbbb";
        assertEquals(1, minLengthOfSubString.lengthOfLongestSubstring(input));
        input = "pwwkew";
        assertEquals(3, minLengthOfSubString.lengthOfLongestSubstring(input));
        input = " ";
        assertEquals(1, minLengthOfSubString.lengthOfLongestSubstring(input));

    }
}
