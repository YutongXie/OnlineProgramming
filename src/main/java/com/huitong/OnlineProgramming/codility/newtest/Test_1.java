package com.huitong.OnlineProgramming.codility.newtest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qiushui.Zhe
 * @date 2022/10/18 20:26
 */
public class Test_1 {

    public int solution(String S) {
        // write your code in Java SE 8
        int move = 0;
        int numA = 0;
        int numB = 0;
        int numN = 0;
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'A') {
                numA++;
            } else if (aChar == 'B') {
                numB++;
            } else if (aChar == 'N') {
                numN++;
            }
        }

        int a = numA / 3;
        int b = numB;
        int c = numN /2;

        move = a;
        if( b < move) {
            move = b;
        }
        if(c < move) {
            move = c;
        }
        return move;
//        Set<Integer> set = new HashSet<>();
//        set.add(a);
//        set.add(b);
//        set.add(c);
//        return (int) set.toArray()[0];
    }

    public static void main(String[] args) {
        Test_1 test_1 = new Test_1();
        test_1.solution("NAABXXAN");
    }
}
