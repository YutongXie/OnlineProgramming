package com.huitong.OnlineProgramming.codility.newtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Qiushui.Zhe
 * @date 2022/10/18 20:51
 */
public class Test_2 {

    public static void main(String[] args) {
        Test_2 test_2 = new Test_2();
//        int x = test_2.getInd(1001223443);
//        System.out.print(x);
//        x = test_2.getInd(18);
//        System.out.print(x);
//        int[] A = {120, 191, 200, 10};
        int[] A = {30, 909, 3190, 99, 3990, 9009};
        test_2.solution(A);
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : A) {
            int key = getInd(num);
            if(map.containsKey(key)) {
                map.get(key).add(num);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(key, list);
            }
        }
        final int[] max = {-1};

        map.forEach((k,v) -> {
            if(v.size() >=2) {
                int temp = getMax(v);
                if(temp > max[0]) {
                    max[0] = temp;
                }
            }
        });
        return max[0];
    }

    public int getInd(int value) {
        char[] chars = String.valueOf(value).toCharArray();
        if(chars.length == 2)
            return value;

        String x = chars[0] + String.valueOf(chars[chars.length -1]);
        return Integer.parseInt(x);
    }

    public int getMax(List<Integer> list) {
        if(list.size() == 2)
            return list.get(0) + list.get(1);

        Object[] array = list.stream().sorted().toArray();
        return (int) array[array.length - 2] + (int) array[array.length -1];
    }
}
