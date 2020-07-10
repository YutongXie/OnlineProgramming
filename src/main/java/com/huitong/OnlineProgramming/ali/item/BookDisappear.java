package com.huitong.OnlineProgramming.ali.item;

import lombok.extern.slf4j.Slf4j;

//概述：
//   在书架上摆着一些书，这些书只有两种颜色，要么是黄色，
//   要么是蓝色，突然某一天这些书被施了魔法，如果一本黄色和一本蓝色的书挨着，
//   这两本书就会消失不见，然后右边的书会往左边移动，直到和左边的书挨着，如果这两本颜色不同，
//   这两本书又会神秘消失。现在给你一个只包含A和B的字符串s(1<=|s|<=100000)，
//   其中A表示黄色的书，B表示蓝色的书，问这n本书中最多会消失多少本书。
//   输入一个字符串s，s中A表示黄色的书，B表示蓝色的书
//   输出最多会消失多少本书
//
//   示例1
//   输入：
//   "AABB"
//   输出：
//   4
@Slf4j
public class BookDisappear {
    public int solution(String str) {
        int aCount = 0;
        int bCount = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
                if(chars[i] == 'A') {
                    aCount ++;
                } else if(chars[i] == 'B') {
                    bCount ++;
                }
        }
        return aCount <= bCount ? aCount *2 : bCount * 2;
    }

    public static void main(String[] args) {
        BookDisappear disappear = new BookDisappear();
        String input = "AABB";
        log.info("final disappear:{} books", disappear.solution(input));

        input = "AABAABABBBABAA";
        log.info("final disappear:{} books", disappear.solution(input));
    }

}
