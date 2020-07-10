package com.huitong.OnlineProgramming.ali.item;

import lombok.extern.slf4j.Slf4j;

//概述：
//   现在有3只怪兽，他们的都有自己的血量a,b,c(1<=a,b,c<=100)，
//   当Tom打死第一怪兽的时候花费的代价为0，其余的怪兽的代价为当前的怪兽的血量减去上一个怪兽的血量的绝对值。
//   问Tom打死这些怪兽所需要的最小代价
//   分别输入三只怪兽的血量
//   输出打死三只怪兽的最小代价
//
//
//   示例1
//   输入：
//   2
//   5
//   8
//   输出：
//   6
@Slf4j
public class BeatMonster {
    public int solution(int a,int b,int c) {
        int cost = -1;
        int[] monster = {a, b, c};
        for (int i = 0; i < monster.length; i++) {
            for (int j = 0; j < monster.length; j++) {
                if(i != j) {
                    for (int k = 0; k < monster.length; k++) {
                        if(j != k &&  i !=k) {
                            int tempCost = Math.abs(monster[j] - monster[i]) + Math.abs(monster[k] - monster[j]);
                            if(cost <0) {
                                cost = tempCost;
                            } else if(cost > tempCost) {
                                cost = tempCost;
                            }
                        }
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        BeatMonster beatMonster = new BeatMonster();
        int a = 2;
        int b = 5;
        int c = 8;
        log.info(beatMonster.solution(a, b, c) + "");

        a = 5;
        b = 5;
        c = 5;
        log.info(beatMonster.solution(a, b, c) + "");


    }
}
