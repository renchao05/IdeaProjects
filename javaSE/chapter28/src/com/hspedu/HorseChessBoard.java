package com.hspedu;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    private static final int X = 8;
    private static final int Y = 8;
    private static final int[][] checkerboard = new int[Y][X];
    private static final boolean[] state = new boolean[X * Y];
    private static boolean successful = false;
    private static int step = 0;

    public static void main(String[] args) {
//        ArrayList<Point> ps = findNextLocation(new Point(0, 5));
        long l = System.currentTimeMillis();
        action2(1, 1);
        long l1 = System.currentTimeMillis();
        System.out.println("耗时：" + (l1 - l));
        for (int[] cs : checkerboard) {
            for (int i : cs) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void action2(int x, int y) {

        step++;
        checkerboard[x][y] = step;
        state[y * X + x] = true;
        ArrayList<Point> ps = findNextLocation(new Point(x, y), true);
        for (Point p : ps) {
            if (checkerboard[p.x][p.y] == 0) {
                action2(p.x, p.y);
            }
        }
        if (step >= X * Y)
            return;
        step--;
        checkerboard[x][y] = 0;
        state[y * X + x] = false;

    }

    public static void action(int x, int y) {

        step++;
        checkerboard[x][y] = step;
        state[y * X + x] = true;
        ArrayList<Point> ps = findNextLocation(new Point(x, y), false);
        for (Point p : ps) {
            if (!state[p.y * X + p.x]) {
                action(p.x, p.y);
            }
        }
        if (step >= X * Y)
            return;
        step--;
        checkerboard[x][y] = 0;
        state[y * X + x] = false;

    }

    @Test
    public void test(){
        ArrayList<Point> ps = findNextLocation(new Point(3, 3), false);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            ArrayList<Point> ps2 = new ArrayList<>(ps);
            sort2(ps2);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("耗时：" + (l1 - l));
    }

    public static ArrayList<Point> findNextLocation3(Point location, boolean b) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p = new Point();
        //位置1
        if ((p.x = location.x - 1) >= 0 && (p.y = location.y - 2) >= 0)
            ps.add(new Point(p));
        //位置2
        if ((p.x = location.x + 1) < X && (p.y = location.y - 2) >= 0)
            ps.add(new Point(p));
        //位置3
        if ((p.x = location.x + 2) < X && (p.y = location.y - 1) >= 0)
            ps.add(new Point(p));
        //位置4
        if ((p.x = location.x + 2) < X && (p.y = location.y + 1) < Y)
            ps.add(new Point(p));
        //位置5
        if ((p.x = location.x + 1) < X && (p.y = location.y + 2) < Y)
            ps.add(new Point(p));
        //位置6
        if ((p.x = location.x - 1) >= 0 && (p.y = location.y + 2) < Y)
            ps.add(new Point(p));
        //位置7
        if ((p.x = location.x - 2) >= 0 && (p.y = location.y + 1) < Y)
            ps.add(new Point(p));
        //位置8
        if ((p.x = location.x - 2) >= 0 && (p.y = location.y - 1) >= 0)
            ps.add(new Point(p));
        if (b) {
            sort(ps);
        }
        return ps;
    }

    public static void sort2(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return findNextLocation(o1,false).size() - findNextLocation(o2,false).size();
            }
        });
    }

    public static void sort(ArrayList<Point> ps) {
        int[] size = new int[ps.size()];
        Point p;
        int ii = 0;
        int s;
        for (Point point : ps) {
            size[ii++] = findNextLocation(point, false).size();
        }
        for (int i = 0; i < size.length - 1; i++) {
            for (int j = 0; j < size.length - i - 1; j++) {
                if (size[j] > size[j + 1]) {
                    s = size[j];
                    size[j] = size[j + 1];
                    size[j + 1] = s;
                    p = ps.get(j);
                    ps.set(j, ps.get(j + 1));
                    ps.set(j + 1, p);
                }
            }
        }
    }

    public static ArrayList<Point> findNextLocation(Point location, boolean b) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p = new Point();
        //位置1
        if ((p.x = location.x - 1) >= 0 && (p.y = location.y - 2) >= 0 && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置2
        if ((p.x = location.x + 1) < X && (p.y = location.y - 2) >= 0 && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置3
        if ((p.x = location.x + 2) < X && (p.y = location.y - 1) >= 0 && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置4
        if ((p.x = location.x + 2) < X && (p.y = location.y + 1) < Y && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置5
        if ((p.x = location.x + 1) < X && (p.y = location.y + 2) < Y && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置6
        if ((p.x = location.x - 1) >= 0 && (p.y = location.y + 2) < Y && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置7
        if ((p.x = location.x - 2) >= 0 && (p.y = location.y + 1) < Y && !state[p.y * X + p.x])
            ps.add(new Point(p));
        //位置8
        if ((p.x = location.x - 2) >= 0 && (p.y = location.y - 1) >= 0 && !state[p.y * X + p.x])
            ps.add(new Point(p));
        if (b) {
            sort(ps);
        }
        return ps;
    }
}

