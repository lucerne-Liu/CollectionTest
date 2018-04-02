package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        //把二维数组变成一维数组
        List<Integer> list = new ArrayList<>();
        for (Integer[] arr : array) {
            for (Integer num : arr) {
                list.add(num);
            }
        }
        return list;
//        throw new NotImplementedException();
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        // 把二维数组变成一维数组,消除重复,按照第一次出现的顺序排列最后的输出结果
        List<Integer> list = new ArrayList<>();
        for (Integer[] arr : array) {
            for (Integer num : arr) {
                list.add(num);
            }
        }
        //去重方法一
        return list.stream().distinct().collect(Collectors.toList());
        //去重方法二
//        LinkedHashSet<Integer> set = new LinkedHashSet<>(list.size());
//        set.addAll(list);
//        list.clear();
//        list.addAll(set);
//        return list;
        //        throw new NotImplementedException();

    }
}
