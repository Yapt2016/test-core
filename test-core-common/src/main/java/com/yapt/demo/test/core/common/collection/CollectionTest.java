package com.yapt.demo.test.core.common.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hurui
 * @version Id: CollectionTest.java, v 0.1 2020/6/15 12:16 YaphetS Exp $$
 */
public class CollectionTest {

    private static List<Integer> list  = Lists.newArrayList(31,22,53,3,2,1,4,7,6,7);


    /**
     * 去重并排序
     */
    public static void distinctAndSortByHashSet(List<Integer> list){
        HashSet<Integer> hashSet = new HashSet<>(list);
        System.out.println("去重,return:{}"+ hashSet);
        list = new ArrayList<>(hashSet);
        Collections.sort(list);
        System.out.println("排序,return:"+ list);
    }

    /**
     * 去重并排序
     */
    public static void distinctAndSortByTreeSet(List<Integer> list){
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        list = new ArrayList<>(treeSet);
        System.out.println("去重并排序,return:"+ list);
    }

    /**
     * 集合不能在迭代的时候做删除,如类型1操作
     * 如果需要可以使用类型2操作
     *
     * @param list
     * @param type
     */
    public static void removeList(List<Integer> list,String type){
        if("1".equals(type)){
            for(Integer integer : list){
                if(integer.equals(4)){
                    list.remove(integer);
                }
            }
        }else if("2".equals(type)){
            list.removeIf(item->item.equals(4));
        }
        System.out.println("迭代并删除"+list);
    }

    /**
     * 将list里面的数据顺序随机打乱
     * @param list
     */
    public static void rankRandom(List<Integer> list){
        Collections.shuffle(list);
        System.out.println("打乱list里元素的顺序"+list);
    }

    /**
     * list截取，
     * 类型1截取会有一定的风险,
     * @param list
     * @param type
     */
    public static List<Integer> subList(List<Integer> list ,String type){

        List<Integer> result = new ArrayList<>();
        if("1".equals(type)){
            result = list.subList(1,10);
            result.remove(0);
            System.out.println("原始数据"+list);
            System.out.println("截取数据"+result);
        }else if("2".equals(type)){
            result = list.stream().skip(1).limit(10).collect(Collectors.toList());
            result.remove(0);
            System.out.println("原始数据"+list);
            System.out.println("截取数据"+result);
        }
        return result;
    }

    public static void main(String[] args) {
        //distinctAndSortByHashSet(list);

        //distinctAndSortByTreeSet(list);

        //removeList(list,"1");

        //rankRandom(list);

        //
        subList(list,"1");
        subList(list,"2");
    }
}