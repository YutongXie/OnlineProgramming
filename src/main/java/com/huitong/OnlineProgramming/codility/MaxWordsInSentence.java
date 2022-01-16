package com.huitong.OnlineProgramming.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiushui.Zhe
 * @date 2022/01/15 21:20
 */

/**
 * 题目：给定一段文字，每段文字由多个句子组成。句子以 ”？“，”！“，”.“结尾断句。
 * 1. 文字中只包含 ”？“，”！“，”.“，[a-z A-Z]
 *
 * 现要求找出给定文字中所包含的句子中最多包含多少个单词。
 * 例如：
 *      给定的文字是 "We test coders. Give us a try?"
 *      此段文字包含两个句子，"We test coders." 和 "Give us a try?"
 *      那么最多包含4个单词，是"Give" "us" "a" "try"
 *
 *      给定的文字是 "Forget  Cvs..Save time . x x"
 *      那么最后包含2个单词
 */
public class MaxWordsInSentence {

    public int solution(String S) {
        String[] sentenceList = S.replaceAll("\\.", "|")
                .replaceAll("\\!", "|")
                .replaceAll("\\?", "|")
                .split("\\|");
        int max = 0;
        for (String sentence : sentenceList) {
            String[] wordList = sentence.split(" ");
            int count = 0;
            for (String word : wordList) {
                if (word.length() > 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "We test coders. Give us a try?"; // 4
        MaxWordsInSentence test = new MaxWordsInSentence();
        int result = test.solution(s);
        System.out.println(result);

        String s1 = "Forget  Cvs..Save time . x x"; // 2
        result = test.solution(s1);
        System.out.println(result);

        String s2 = "who is good person en!!We test coders. Give us a try?"; // 5
        result = test.solution(s2);
        System.out.println(result);
    }
}
