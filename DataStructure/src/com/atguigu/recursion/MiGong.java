package com.atguigu.recursion;

/**
 * @author www
 * 回溯的参数是引用型变量，就是共享性的数据
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1 表示墙

        //上下全部置为 1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为 1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //输出地图
        // 设置挡板
        System.out.println("地图的初始情况：");
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
//        setWay(map,1,1);
        setWay2(map,1,1);

        //输出新的地图，小球走过，并标识过的地图
        System.out.println("小球走过，并标识过的地图情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     *
     * @param map 表示地图
     * @param i   i 和 j 一起确定坐标
     * @param j   从哪个位置开始找
     * @return 如果小球能到达map[6][5]，就代表可以找到通路，返回true，否则返回false
     * 约定：当map[i][j]为 0 表示该点没有走过， 当为 1 表示墙， 为 2 表示通路可以走, 为 3 表示该点已经走过，但走不通
     * 在找迷宫时，需要定一个策略：下->右->上->左，如果该点走不通，再回溯
     */

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //证明是死路，走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j] != 0 就是 1，2，3
                return false;
            }
        }
    }

    /**
     * 修改找路的策略，改成上 -> 右 -> 下 -> 左
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    return true;
                } else {
                    //证明是死路，走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j] != 0 就是 1，2，3
                return false;
            }
        }
    }

}