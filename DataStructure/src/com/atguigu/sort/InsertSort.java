package com.atguigu.sort;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i=0;i<80000;i++) {
            arr[i] = (int)(Math.random() * 80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1Str =  simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        insertSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是："+ date2Str);
    }

    //排入排序
    public static void insertSort(int[] arr) {

        //使用for循环简化代码
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex +1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第" + i + "轮输出");
//            System.out.println(Arrays.toString(arr));
        }
/*
        //使用逐步分解的方法，便于理解
        //第一轮{101,34,119,1} --> {34,101,119,1}

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1;

        //找到要插入的位置
        //1.insertIndex >= 0 保证数组下标不越界
        //2.insertVal<arr[insertIndex] 待插入的数，还没有找到要插入的位置
        //3.就需要将arr[insertIndex]后移
        //4.继续和前面的数比较，下标减一
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
//            {101,34,119,1} -> {101,101,119,1}
            insertIndex--;
        }
        //当退出循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;
        System.out.println("第一轮插入后：" + Arrays.toString(arr));

        //第二轮插入
        insertVal=arr[2];
        insertIndex= 2-1;
        while(insertIndex >= 0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第二轮插入后：" +Arrays.toString(arr) );

        //第三轮插入
        insertVal=arr[3];
        insertIndex= 3-1;
        while(insertIndex >= 0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第三轮插入后：" +Arrays.toString(arr) );

 */
    }
}
