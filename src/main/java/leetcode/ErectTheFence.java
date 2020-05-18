package main.java.leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*题目描述
    587. 安装栅栏
    在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。
    只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
*/
/*示例1:
    输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
    输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
    图片地址：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/erect_the_fence_1.png
 */
/*示例2:
    输入: [[1,2],[2,2],[4,2]]
    输出: [[1,2],[2,2],[4,2]]
    图片地址：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/erect_the_fence_2.png
    即使树都在一条直线上，你也需要先用绳子包围它们。
 */
/*注意:
    所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
    输入的整数在 0 到 100 之间。
    花园至少有一棵树。
    所有树的坐标都是不同的。
    输入的点没有顺序。输出顺序也没有要求。
 */
//凸包问题
public class ErectTheFence {
    public List<Point> outerTrees(Point[] points) {
        List<Point> list = new ArrayList<>();
        List<Point> temp = new ArrayList<>();
        int len = points.length;
        if (len <= 3) {
            list = Arrays.asList(points);
            return list;
        }
        int up = 0;
        int down = 100;
        int left = 100;
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (points[i].x < left) {
                left = points[i].x;
            }
            if (points[i].x > right) {
                right = points[i].x;
            }
            if (points[i].y < down) {
                down = points[i].y;
            }
            if (points[i].y > up) {
                up = points[i].y;
            }
        }
        if (left == right || up == down) {
            list = Arrays.asList(points);
            return list;
        }
        for (int j = 0; j < len; j++) {
            if (points[j].x == left || points[j].x == right || points[j].y == up || points[j].y == down) {
                list.add(points[j]);
            } else {
                temp.add(points[j]);
            }
        }
        for (int k = 0; k < temp.size(); k++) {
            if (compare(temp.get(k), list)) {
                list.add(temp.get(k));
            }
        }
        return list;
    }

    private boolean compare(Point point, List<Point> list) {
        int len = list.size();
        //先找界限外边的

        //再找边界上边的

        return false;
    }

    //源码画图方式
    private boolean compare1(Point point, List<Point> list) {
        int len = list.size();
        Polygon p = new Polygon();
        for (int i = 0; i < len; i++) {
            p.addPoint(list.get(i).x, list.get(i).y);
        }
        return !p.contains(point.x, point.y);
    }

    public static void main(String[] args) {
        ErectTheFence e = new ErectTheFence();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(2, 4);
        Point p5 = new Point(3, 3);
        Point p6 = new Point(4, 2);
        Point[] p = new Point[] {p1, p2, p3, p4, p5, p6};
        List<Point> list = e.outerTrees(p);
        for (Point point : list) {
            System.out.println("(x, y) : " + "(" + point.x + ", " + point.y + ")");
        }
    }

    private static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
