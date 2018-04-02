package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        //求数组中的偶数
        return array.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        throw new NotImplementedException();
    }

    public List<Integer> filterMultipleOfThree() {
        //求数组中3的倍数
        return array.stream().filter(n -> n % 3 == 0).collect(Collectors.toList());
//        throw new NotImplementedException();
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        //求两数组的公共元素
        List<Integer> list = firstList.stream().collect(Collectors.toList());
        list.retainAll(secondList);
        return list;
        //                throw new NotImplementedException();
    }

    public List<Integer> getDifferentElements() {
        //去除数组中的重复元素
        return array.stream().distinct().collect(Collectors.toList());
//        throw new NotImplementedException();
    }
}