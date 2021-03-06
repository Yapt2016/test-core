package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: OptimizeBubbleSort.java, v 0.1 2020/6/1 14:27 YaphetS Exp $$
 */
@Slf4j
public class OptimizeBubbleSort {

    /**
     * 优化版冒泡排序,增加一个标识记录是否存在不必要的循环，减少循环次数
     * @param array
     * @return
     */
    public static void optimizeBubbleSort(int[] array){

        //记录执行的次数
        int num = 0;

        //记录是否有做交换
        boolean isChange;

        int temp = 0;

        for(int i = 0; i<array.length-1; i++){
            isChange = true;
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isChange = false;
                }
            }
            if(isChange){
                break;
            }
            ++num;
        }
        log.info("优化版冒泡排序,总共交换了{}轮",num);
    }

    public static void main(String[] args) {
        int[] array = {3,2,0,7,1,4,9,5,8,6};
        Long start = System.currentTimeMillis();
       // optimizeBubbleSort(array);
        sort(array);
        Long end = System.currentTimeMillis();
        log.info("优化版冒泡排序,总耗时:{},result:{}",end-start,array);
        swap();

    }

    public static void sort(int[] array){

        for(int i = 0; i<array.length-1; i++){
            for(int j =0;j<array.length-1-i;j++){
                if(array[j]> array[j+1]){
                    array[j] = array[j] + array[j+1];
                    array[j+1] = array[j]-array[j+1];
                    array[j] = array[j]-array[j+1];
                }
            }
        }
    }


    public static void swap(){
        int a = 5;
        int b = 2;
        a = a+b;
        b = a-b;
        a = a-b;
        log.info("a:{}",a);
        log.info("b:{}",b);
    }
}