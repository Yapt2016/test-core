package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: Quicksort.java, v 0.1 2020/6/2 14:13 YaphetS Exp $$
 */
@Slf4j
public class QuickSort {

    /**
     * 快速排序,选取最左边的一个数即arr[0]作为基数，分别从右往左寻找比基数小的值，从左往右寻找比基数大的值，然后互相交换
     * 当寻找过程中相遇时，将基数与相遇下标的数交换位置，这样就让基数归位，保证了基数左边的值都比基数小，右边的值都比基数大
     * 然后再将基数两边的数据记为两个新的数组，再次重复上述操作，直到所有基数归位，即完成排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right){

        int i, j, t, temp;

        //每次都是从右边往坐标找，所以必须保证right大于left
        if(left>right){
            return;
        }

        //i记录左边循环开始时的初始位置
        i = left;

        //j记录右边循环开始时的初始位置
        j = right;

        //temp记录基数的值
        temp = arr[left];

        //循环开始，只要i和j没有相遇就一直循环
        while (i != j){

            //每次都是先从右边开始循环,寻找小于基数的值,找到之后就退出当前循环
            while (arr[j] >=temp && i<j){
                j--;
            }

            //接着从右边开始循环,寻找大于基数的值,找到之后也退出当前循环
            while (arr[i] <= temp && i<j){
                i++;
            }

            //左右两边都退出当前循环,交换两边的值，继续下一轮循环
            if(i<j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //左右两边相遇,循环结束,交换相遇位置与基数的值，基数归位
        arr[left] = arr[i];
        arr[i] = temp;

        //继续处理左边的，这里是一个递归的过程
        quickSort(arr,left, i-1);

        //继续处理右边的 ，这里是一个递归的过程
        quickSort(arr,i+1, right);
    }

    public static void main(String[] args) {
        int[] array = {3,2,0,7,1,4,9,5,8,6};
        Long start = System.currentTimeMillis();
        quickSort(array,0,array.length-1);
        Long end = System.currentTimeMillis();
        log.info("快速排序,总耗时:{},result:{}",end-start,array);
    }

}