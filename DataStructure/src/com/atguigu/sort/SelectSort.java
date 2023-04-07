package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 * 1.选择排序一共有数组大小-1轮排序
 * 2.每轮排序，又是一个循环，循环的规则
 * 2.1先假定当前这个数是最小数
 * 2.2然后和后面的数进行比较，如果发现有比当前数更小的数，就重新确定当前数，并得到下标
 * 2.3当遍历到当前数组的最后时，就得到本轮最小数和下标
 * 2.4交换数
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i=0;i<80000;i++) {
            arr[i] = (int)(Math.random() * 80000);
        }

//        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是："+ date1Str);

        selectSort(arr);

//        System.out.println("排序后：");
//        System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是："+ date2Str);
    }


    public static void selectSort(int[] arr) {
        //使用逐步推导的方式，选择排序
        //第一轮
        //原始数组： 101,34,119，1
        //第一轮排序：1,101,34,119
//        O(n^2)

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
//            只需要判断minIndex是否改变，优化
//            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
//                    flag = true;
                    //重置min
                    min = arr[j];
                    //重置minIndex
                    minIndex = j;
                }
            }
                if (minIndex != i) {
//                不需要第三方的 temp，利用min和minIndex
//                int temp = arr[0];
//                arr[0] = min;
//                arr[minIndex] = temp;
                    arr[minIndex] = arr[i];
                    arr[i] = min;
                }
//            System.out.println("第"+(i+1)+"轮后~");
//            System.out.println(Arrays.toString(arr));
        }
    }


}
