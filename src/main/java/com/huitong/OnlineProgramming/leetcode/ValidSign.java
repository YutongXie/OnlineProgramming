package com.huitong.OnlineProgramming.leetcode;

import org.springframework.util.Assert;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//  有效字符串需满足：
//
//  左括号必须用相同类型的右括号闭合。
//  左括号必须以正确的顺序闭合。
//  注意空字符串可被认为是有效字符串。
//
//  示例 1:
//
//  输入: "()"
//  输出: true
//  示例 2:
//
//  输入: "()[]{}"
//  输出: true
//  示例 3:
//
//  输入: "(]"
//  输出: false
//  示例 4:
//
//  输入: "([)]"
//  输出: false
//  示例 5:
//
//  输入: "{[]}"
//  输出: true
//
public class ValidSign {
    public static void main(String[] args) {
        ValidSign validSign = new ValidSign();
        String input = "()";
        Assert.isTrue(validSign.isValid(input));
        input = "()[]{}";
        Assert.isTrue(validSign.isValid(input));
        input = "(]";
        Assert.isTrue(!validSign.isValid(input));
        input = "([)]";
        Assert.isTrue(!validSign.isValid(input));
        input = "{[]}";
        Assert.isTrue(validSign.isValid(input));
        input = "[])";
        Assert.isTrue(!validSign.isValid(input));
        input = "(([]){})";
        Assert.isTrue(validSign.isValid(input));
        input = "{}{}()[]";
        Assert.isTrue(validSign.isValid(input));
    }
    public boolean isValid(String s) {
        if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")){
            return false;
        }
        return validation(s);
    }

    private boolean validation(String s) {
        if(!s.contains("(") && !s.contains("[") && !s.contains("{") && !s.contains(")") && !s.contains("]") && !s.contains("}")) {
            return true;
        }
        if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")){
            return false;
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                continue;
            } else {
                if(chars[i] == ')' && chars[i - 1] != '(') {
                    return false;
                }
                if(chars[i] == ']' && chars[i -1] != '[') {
                    return false;
                }
                if(chars[i] == '}' && chars[i -1] != '{') {
                    return false;
                }
                chars[i] ='*';
                chars[i-1] ='*';
                return validation(new String(chars).replace("*", ""));
            }
        }

        return false;
    }




}
