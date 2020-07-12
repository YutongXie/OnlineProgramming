package com.huitong.OnlineProgramming.ali.item;

import java.util.*;
//概述：
//  现在有n个魔法师(2<=n<=100000)，这n个魔法师都有自己的魔法值ai(1<=ai<=1000000000)，
//  他们为了证明自己是最强的魔法师便开始了争夺战，任意一个魔法师都可以对其他的魔法师发起攻击，
//  每次攻击，被攻击的魔法师损失掉的魔法值是攻击者当前的魔法值，当魔法值小于等于0的时候淘汰出局，
//  问最后只剩下一名魔法师时，他的魔法值最少是多少。
//  输入魔法师数n，和n个数，表示每个魔法师的初始魔法值
//  输出一个数，在任意的对决中，最后只剩下来一名魔法师的最小的魔法值
//
//
//  示例1
//  输入：
//  4
//  [2,8,6,20]
//  输出：
//  2
public class Winner {
    private int max = 0;

    public static void main(String[] args) {
        Winner winner = new Winner();
        int n = 4;
        int[] nums = {2, 8, 6, 20};
        int result = winner.solution(n, nums);
        System.out.println("result is: " + result);
        Winner winner2 = new Winner();
        int n1 = 4;
        int[] nums1 = {5, 13, 8, 1000000000};
        int result1 = winner2.solution(n1, nums1);
        System.out.println("result is: " + result1);
    }
    public int solution(int n, int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        max = list.get(list.size() -1);
        return find(list);
    }

    private int find(List<Integer> list) {
        Set<Integer> setList = new HashSet<>(list.size());
        if(list.size() == 1) {
            return list.get(0);
        }
        int size = list.size();

        int tempMax = 0;
        for (int i = 0; i < size; i++) {
            int item = list.get(i);
            if(item != max) {
                if(tempMax < item) {
                    tempMax = item;
                }
                int yushu = max % item;
                setList.add(item);
                if(yushu != 0) {
                    setList.add(yushu);
                }
                if(yushu > tempMax) {
                    tempMax = yushu;
                }
            }
        }

        max = tempMax;
        List<Integer> newList = new ArrayList<>(setList.size());
        newList.addAll(setList);
        System.out.println("newlist size: " + newList.size());
        System.out.println("newlist:" + newList);
        return find(newList);
    }
}
