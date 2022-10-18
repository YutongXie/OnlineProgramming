package com.huitong.OnlineProgramming.codility.newtest;

/**
 * @author Qiushui.Zhe
 * @date 2022/10/18 21:27
 */
public class Test_3 {

    public static void main(String[] args) {
        Test_3 test_3 = new Test_3();
//        int[] A ={2, 2};
//        int[] A = {-1, 0,0,0, -1};
//        int[] B = {-1, 0, 0, 0, -1};
        int[] A = {0,-1, -1, 0};
        int[] B = {0,-1, -1, 0};

//        int[] A ={2, -2, -3, 3};
//        int[] B = {2, -2, -3, 3};
//        int[] B = {2, 2};
        System.out.println("result:" +test_3.solution(A, B));
    }
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        long sumA = getSum(A);
        long sumB = getSum(B);

        int indexNum = 0;

        int length = A.length;
        long a1 = 0;
        long a2 = 0;
        long b1 = 0;
        long b2 = 0;
        for (int i = 0; i < length-1; i++) {
            a1 = a1 + A[i];
            a2 = sumA -a1;
            b1 = b1 + B[i];
            b2 = sumB - b1;
            if(a1 == a2 && a2 == b1 && b1== b2) {
                System.out.println(i +1);
                indexNum ++;
            }
        }

        return indexNum;
    }

    public long getSum(int[] array) {
        long sum =0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
