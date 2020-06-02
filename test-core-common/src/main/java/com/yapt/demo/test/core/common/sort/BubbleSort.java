package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: BubbleSort.java, v 0.1 2020/6/1 14:26 YaphetS Exp $$
 */
@Slf4j
public class BubbleSort {

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static void bubbleSort(int[] array){
        //记录执行的次数
        int num = 0;
        int temp = 0;
        for(int i = 0; i<array.length-1; i++){

            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            ++num;
        }
        log.info("冒泡排序,总共交换了{}轮",num);
    }

    public static void main(String[] args) {
        int[] array = {3,2,0,7,1,4,9,5,8,6};
        Long start = System.currentTimeMillis();
        bubbleSort(array);
        Long end = System.currentTimeMillis();
        log.info("冒泡排序,总耗时:{},result:{}",end-start,array);
    }
}