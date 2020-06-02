package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: Quicksort.java, v 0.1 2020/6/2 14:13 YaphetS Exp $$
 */
@Slf4j
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right){

        int i, j, t, temp;

        if(left>right){
            return;
        }

        i = left;
        j = right;
        temp = arr[left];

        while (i != j){

            while (arr[j] >=temp && i<j){
                j--;
            }

            while (arr[i] <= temp && i<j){
                i++;
            }

            if(i<j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
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