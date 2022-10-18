package com.huitong.OnlineProgramming.codility.newtest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qiushui.Zhe
 * @date 2022/10/18 20:04
 */

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class Prepare {

    public int solution(int[] A) {
        // write your code in Java SE 8
        long size = A.length;
        int small = 1;
        Set<Integer> good = new HashSet();

        for (int i = 0; i < size; i++) {
            good.add(A[i]);
        }
        Object[] newA = good.stream().sorted().toArray();

        for (int i = 0; i < newA.length; i++) {
            int temp = (int) newA[i];
            if(i== 0 && temp > small) {
                return small;
            }
            if(temp == small) {
                small ++;
            }
            if(temp - small == 1 && i == newA.length -1) {
                return small;
            }

            if(temp - small == 1) {
                small = temp;
            }
            if(temp - small > 1) {
                return small + 1;
            }
        }
        return small;

    }

}
