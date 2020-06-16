package com.yapt.demo.test.core.common.collection;

import com.google.common.collect.Lists;

import java.util.*;

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
        System.out.println("去重并排序,return:"+ treeSet);
        list = new ArrayList<>(treeSet);
    }

    public static void main(String[] args) {
        //distinctAndSortByHashSet(list);

        distinctAndSortByTreeSet(list);
    }
}