package com.atguigu.recursion;

/**
 * @author www
 * @date 2023/3/29
 * 递归问题
 * 方法自身调用自身，每次传入的变量都不同
 * 每执行一个方法，就会开辟一个新的空间栈
 * 每个空间的局部变量是独立的，不会相互影响
 */
public class RecursionTest {
    public static void main(String[] args) {
        int n = 4;
        test(n);

        int res = factorial(n);
        System.out.println("res=" + res);
    }

    /**
     * 打印问题
     */

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    /**
     * 阶乘问题
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}




