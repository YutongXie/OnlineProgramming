package com.huitong.OnlineProgramming.ali.item;

import com.sun.javafx.geom.Edge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

//概述：
//        现在有n个点(1<=n<=1000)，每个点都有一个值称为点权ai(ai为偶数，1<=ai<=1000)，现在可以将任意两个点相连，
//        连起来以后这条边也有一个值称为边权，这个边的边权为这两个点的点权之和的一半。现在需要你添加n-1条边，
//        问将这n个点连通以后(连通是指任意两个点都能互相到达)的最大的边权和是多少。
//        输入点的数量n；和n个数，表示点权的值
//        输出最大的边权和
//        示例1
//        输入：
//        5
//        [2,4,6,8,10]
//        输出：
//        30
@Slf4j
public class MaxSummaryEdgeValues {

    public static void main(String[] args) {
        int pointNum = 6;
        int[] values = {2, 4, 6, 8,10,15};
        MaxSummaryEdgeValues maxValue = new MaxSummaryEdgeValues();
        Result result = maxValue.calculate(pointNum, values);
        log.info("total value:{}", result.getTotalValue());
        result.getEdgeList().forEach(edge ->{
            List<Point> list = new ArrayList(edge.getPointSet());
            log.info("Edge:{} -> {}, value:{}", list.get(0).getNum(), list.get(1).getNum(), edge.getEdgeValue());
        });

        pointNum = 20;
        int[] values2 = {388,416,902,992,216,316,142,356,864,706,328,136,320,564,82,950,700,238,106,58};
        System.out.println(maxValue.calculate(pointNum, values2));
        result = maxValue.calculate(pointNum, values2);
        log.info("total value:{}", result.getTotalValue());
        result.getEdgeList().forEach(edge ->{
            List<Point> list = new ArrayList(edge.getPointSet());
            log.info("Edge:{} -> {}, value:{}", list.get(0).getNum(), list.get(1).getNum(), edge.getEdgeValue());
        });
    }

    private List<Point> initialPoint(int pointNum, int[] values){
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < pointNum; i++) {
            Point point = new Point(i + 1, values[i]);
            pointList.add(point);
        }
        return pointList;
    }

    public Result calculate(int pointNum, int[] values) {
        List<Point> pointList = initialPoint(pointNum, values);
        int sum = 0;
        Result result = new Result();
        for (Point point : pointList) {
            List<Edge> edgeList = new ArrayList<>();
            for (Point otherPoint : pointList) {
                if(point.getNum() != otherPoint.getNum()) {
                    Edge edge = new Edge(point, otherPoint);
                    edgeList.add(edge);
                }
            }
            int tempSum = totalEdgeValue(edgeList);
            if( sum < tempSum) {
                sum = tempSum;
                result.setEdgeList(edgeList);
            }
        }
        result.setTotalValue(sum);
        return result;
    }

    private int totalEdgeValue(List<Edge> edgeList) {
        return edgeList.stream().mapToInt(Edge:: getEdgeValue).sum();
    }


    @Setter
    @Getter
    @AllArgsConstructor
    class Point {
        private int num;
        private int value;

    }
    @Setter
    @Getter
    class Edge {
        Edge(Point pointA, Point pointB){
            pointSet.add(pointA);
            pointSet.add(pointB);
        }
        private Set<Point> pointSet = new HashSet<>();
        private int value;

        public int getEdgeValue() {
            return pointSet.stream().mapToInt(Point::getValue).sum() / 2;
        }
    }

    @Getter
    @Setter
    class Result {
        private int totalValue;
        private List<Edge> edgeList = new ArrayList<>();
    }
}
