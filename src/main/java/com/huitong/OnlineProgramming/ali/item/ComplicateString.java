package com.huitong.OnlineProgramming.ali.item;

import lombok.extern.slf4j.Slf4j;

//概述：
//现在有两个字符串s1和s2（长度不超过200000），
// Tom是一个有强迫症的人，他想要把这两个字符串变的相同。
//
//但是每次只能删除其中一个字符串的最左端的字符，
// 问最少需要经过多少次操作才能使这两个字符串变的相同？
//输入内容为两个，第一个为字符串s1，第二个为字符串s2
//输出一个数字，表示最小的操作次数
//
//示例1
//输入：
//"dadc"
//"dddc"
//输出：
//  4
@Slf4j
public class ComplicateString {
    private int count = 0;
    public int solution(String s1,String s2) {
        //use StringBuilder is consider the memory usage.
        //if use String, will frequently create new objects which will occupy much memory
        //if the input string is quite long
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        return calculate(sb1, sb2);
    }

    int calculate(StringBuilder sb1, StringBuilder sb2) {
        if(sb1.toString().equalsIgnoreCase(sb2.toString()))
            return count;
        else {
            if(sb1.length() == sb2.length()) {
                //remove both
                sb1.delete(0, 1);
                sb2.delete(0, 1);
                count = count + 2;
                log.info("new s1:{}", sb1.toString());
                log.info("new s2:{}", sb2.toString());
            } else if( sb1.length() > sb2.length()) {
                //s1 remove
                int cutNum = sb1.length() - sb2.length();
                sb1.delete(0, cutNum);
                count = count + cutNum;
                log.info("new s1:{}", sb1.toString());
            } else {
                //s2 remove
                int cutNum = sb2.length() - sb1.length();
                sb2.delete(0, cutNum);
                count = count + cutNum;
                log.info("new s2:{}", sb2);
            }
        }
        return calculate(sb1, sb2);

    }

    public static void main(String[] args) {
        String s1 = "dadc";
        String s2 = "dddc";
        ComplicateString complicateString = new ComplicateString();
        log.info("action count:{}", complicateString.solution(s1, s2));
        log.info("-----------------");
        ComplicateString complicateString2 = new ComplicateString();
        s1 = "test";
        s2 = "yes";
        log.info("action count:{}", complicateString2.solution(s1, s2));
    }
}
