package com.atguigu.recursion;

public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    static int count = 0;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0, 4, 7, 5, 2, 6, 1, 3};
    int[] array = new int[max];
    static int judgeCount = 0;

    public static void main(String[] args) {

        //测试一把,8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共有%d次judge", judgeCount);
    }

    /**
     * 放置第n个皇后
     */
    private void check(int n) {
        if (n == max) {
            count++;
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前的皇后n，放入该行的第1列
            array[n] = i;
            if (judge(n)) {
                //不冲突,接着放第 n+1 个皇后
                check(n + 1);
            }
            //如果冲突，就会去执行 array[n] = i; 但此时的i是放置在上一个位置之后的
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]  表示判断第n个皇后   是否和前面的n-1个皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i])    表示判断第n个皇后 是否在同一斜线
            //同一斜线：意味着 两个皇后之间的 行距离 = 列距离
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //先写一个方法，可以将皇后摆放的位置打印出来
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
