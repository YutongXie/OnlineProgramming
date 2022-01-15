package com.huitong.OnlineProgramming.codility;

import java.util.HashSet;

/**
 * @author Qiushui.Zhe
 * @date 2022/01/15 11:19
 */

/**
 * Missing Integer
 * Write a function:
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int result = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
                if (A[i] == result) {
                    result = result + 1;
                } else {
                    while (set.contains(result)) {
                        result = result + 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MissingInteger minPositiveNumber = new MissingInteger();
        int[] array = {1, 3, 6, 4, 1, 2};
        int result = minPositiveNumber.solution(array);
        System.out.println(result);

        int[] array1 = {1, 2, 3};
        result = minPositiveNumber.solution(array1);
        System.out.println(result);

        int[] array2 = {-1, -3};
        result = minPositiveNumber.solution(array2);
        System.out.println(result);

        int[] array3 = {1, 9, 2, 5, 8, 9, 120, 112, 200, -102};
        result = minPositiveNumber.solution(array3);
        System.out.println(result);
    }
}
