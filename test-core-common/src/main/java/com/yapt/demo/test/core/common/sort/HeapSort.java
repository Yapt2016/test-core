package com.yapt.demo.test.core.common.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hurui
 * @version Id: HeapSort.java, v 0.1 2020/6/1 14:29 YaphetS Exp $$
 */
@Slf4j
public class HeapSort {

    /**
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        log.info("创建初始堆，arr:{}",arr);
        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            log.info("i:{}",i);
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 创建大顶堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {

        //将temp作为父节点
        int temp = arr[parent];

        //左节点
        int lChild = 2 * parent + 1;

        //若左节点存在，就一直循环
        while (lChild < length) {

            //右节点
            int rChild = lChild + 1;

            //默认左节点的值最大，如果右节点的值大于左节点,则记录最大值的下标
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            //如果父节点已经大于所以子节点就直接退出
            if(temp > arr[lChild]){
                break;
            }

            //父子节点位置交换
            arr[parent] = arr[lChild];
            arr[lChild] = temp;

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        log.info("array:{},parent:{},temp:{}",arr,parent,temp);
    }

    public static void main(String[] args) {
        int[] array = {3,2,2,1,4,9,5,8,6};
        heapSort(array);
        log.info("堆排序,result:{}",array);
    }
}