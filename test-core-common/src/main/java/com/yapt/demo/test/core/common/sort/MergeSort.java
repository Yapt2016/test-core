package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: MergeSort.java, v 0.1 2020/6/2 15:31 YaphetS Exp $$
 */
@Slf4j
public class MergeSort {


    /**
     * 归并排序
     * 通过每次取数组中间的位置进行循环拆分，再合并
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr ,int left, int right){

        int i = 1;
        log.info("i:{}",i);
        //left等于right时，说明只有一个元素了，不需要拆分
         if(left == right){
             return;
         }

         //取中间下标的位置进行拆分
        int middle = (left+right)/2;

         //左边继续循环拆分
        mergeSort(arr,left,middle);

        //右边继续循环拆分
        mergeSort(arr,middle+1,right);

        //合并
        merge(arr,left,middle,right);
        ++i;
    }


    /**
     * 合并
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    public static  void merge(int[] arr,int left,int middle,int right){
        log.info("arr:{},left:{},middle:{},right:{}",arr,left,middle,right);
        //辅助数组
        int []tmp=new int[arr.length];
        //p1、p2是检测指针，k是存放指针
        int p1=left,p2=middle+1,k=left;

        log.info("tmp0:{}",tmp);
        while(p1<=middle && p2<=right){
            if(arr[p1]<=arr[p2]){
                tmp[k++]=arr[p1++];
            } else{
                tmp[k++]=arr[p2++];
            }

        }
        log.info("tmp1:{}",tmp);

        while(p1<=middle) {
            //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            tmp[k++]=arr[p1++];
        }
        log.info("tmp2:{}",tmp);
        while(p2<=right) {
            //同上
            tmp[k++]=arr[p2++];
        }
        log.info("tmp3:{}",tmp);
        //复制回原素组
        for (int i = left; i <=right; i++) {
            arr[i] = tmp[i];
        }
        log.info("arr:{}",arr);
    }

    public static void main(String[] args) {
        int[] array = {3,2,5,7,1,4,9,0,8,6};
        Long start = System.currentTimeMillis();
        mergeSort(array,0,array.length-1);
        Long end = System.currentTimeMillis();
        log.info("归并排序,总耗时:{},result:{}",end-start,array);
    }
}