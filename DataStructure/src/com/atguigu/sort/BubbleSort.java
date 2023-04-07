package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * 一共要进行（n-1）次排序，并且每次排序需要进行（n-1-i）次排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[8000];
        for(int i =0 ;i<arr.length;i++){
            arr[i] = (int) (Math.random() * arr.length);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间：" + date1Str);
        System.out.println();


//        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

//        System.out.println("排序后：");
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间：" + date2Str);

    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        //临时变量用于交换
        int temp = 0;
        boolean flag = false;
        //一共要进行（n-1）次排序，并且每次排序需要进行（n-1-i）次排序
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

//            System.out.println("第" + (i + 1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag) {
                //在一趟排序中，一次交换都没有发生过
                break;
            } else {
                //重置flag，进行下次判断
                flag = false;
            }

        }
    }

}