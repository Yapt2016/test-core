package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: SelectSort.java, v 0.1 2020/6/1 14:28 YaphetS Exp $$
 */
@Slf4j
public class SelectSort {

    /**
     * 选择排序(选出每一轮最大的那个数，再与最后一位对换位置)
     * @param array
     * @return
     */
    public static void selectSort(int[] array){
        int maxIndex;
        int temp;
        for(int i = 0; i< array.length-1 ; i++){
            maxIndex = 0;
            for(int j = 1; j<array.length-i;j++){
                if(array[j]>array[maxIndex]){
                    maxIndex = j;
                }
            }
            temp = array[maxIndex];
            array[maxIndex] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,0,7,1,4,9,5,8,6};
        Long start = System.currentTimeMillis();
        selectSort(array);
        Long end = System.currentTimeMillis();
        log.info("选择排序,总耗时:{},result:{}",end-start,array);
    }
}