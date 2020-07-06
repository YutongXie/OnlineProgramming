package com.huitong.OnlineProgramming.ali.item;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//概述：
//        有一个阵营，里面有n个小队(1<=n<=100)，每个小队都有他们的能力值ai(0<=i<n)。
//        现在有一个紧急情况，需要从这些小队中选出连续的几个小队，组成一个最强的团队。
//        最强的团队的定义为这个团队的所有小队的平均能力值最高。如果有多个最强团队，则选包含小队最多的一个。
//        现在请你写个程序，输出这个最强的团队包含的小队的个数。
//        输入小队的数量n，和n个数，分别代表各小队的能力值ai
//        输出一个数表示这个最强团队包含的小队的个数
//        示例1
//        输入：
//        6
//        [1,2,3,3,2,1]
//        输出：
//        2
@Slf4j
public class StrongestGroup {

    public static void main(String[] args) {
        int num = 6;
        int[] powers = {1,2,3,3,2,1};

        StrongestGroup strongestGroup = new StrongestGroup();
        int size = strongestGroup.getStrongestGroupSize(num, powers);
        log.info("Strongest group including {} teams", size);

        int num1 = 7;
        int[] powers1 = {1,0,0,0,0,0,0};
        int size1 = strongestGroup.getStrongestGroupSize(num1, powers1);
        log.info("Strongest group including {} teams", size1);
    }

    private int getStrongestGroupSize(int num, int[] powers) {
        Group group = findGroup(initialTeam(num, powers));
        return group.getTeamList().size();
    }

    private List<Team> initialTeam(int num, int[] powers) {
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Team team = new Team();
            team.setNum(i + 1);
            team.setPower(powers[i]);
            teamList.add(team);
        }
        return teamList;
    }

    public Group findGroup(List<Team> teamList) {
        Group finalGroup = new Group();
        for (int i = 0; i < teamList.size(); i++) {
            Group group = new Group();
            group.addTeam(teamList.get(i));

            Group tempGroup = new Group();
            tempGroup.addTeam(teamList.get(i));
            for (int j = i + 1; j < teamList.size(); j++) {
                tempGroup.addTeam(teamList.get(j));
                if(group.getGroupPower() <= tempGroup.getGroupPower()) {
                    group.addTeam(teamList.get(j));
                }
            }

            if(finalGroup.getGroupPower() < group.getGroupPower()) {
                finalGroup = group;
            } else if(finalGroup.getGroupPower() == group.getGroupPower() && finalGroup.getTeamList().size() < group.getTeamList().size()) {
                finalGroup = group;
            }
        }
        return finalGroup;
    }

    @Setter
    @Getter
    class Team {
        private int num;
        private int power;
    }
    @Getter
    @Setter
    class Group {
        private List<Team> teamList = new ArrayList<>();
        private int getGroupPower() {
            if(teamList.size() == 0)
                return 0;
            return teamList.stream().mapToInt(Team::getPower).sum() / teamList.size();
        }

        private void addTeam(Team team) {
            teamList.add(team);
        }
    }
}
