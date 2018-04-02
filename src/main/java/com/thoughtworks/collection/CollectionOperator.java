package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        //选出给定区间中所有的数字
        return Stream.iterate(left, n -> {
            return left < right ? n + 1 : n - 1;
        }).limit(Math.abs(right - left) + 1).collect(Collectors.toList());
        //throw new NotImplementedException();
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        //选出给定区间中所有的偶数
        return Stream.iterate(left, n -> {
            return left < right ? n + 1 : n - 1;
        }).limit(Math.abs(right - left) + 1).filter(n -> n % 2 == 0).collect(Collectors.toList());
        //        throw new NotImplementedException();
    }

    public List<Integer> popEvenElments(int[] array) {
        //选出给定区间中所有的偶数
        //方法一
//        List<Integer> resultList = new ArrayList<>();
//        for (int i : array) {
//            if (i % 2 == 0) {
//                resultList.add(i);
//            }
//        }
//        return resultList;
        //使用Stream的方法二
        return Arrays.stream(array).boxed().filter(n -> n % 2 == 0).collect(Collectors.toList());
        //throw new NotImplementedException();
    }

    public int popLastElment(int[] array) {
        //弹出集合最后一个元素
        return array[array.length - 1];
//        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        //弹出两个集合的交集
        //转换成list使用retainAll
        List<Integer> firstList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        firstList.retainAll(secondList);
        return firstList;
        //        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        // 将集合二中与集合一不同的元素加入集合一
        List<Integer> firstList = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).collect(Collectors.toList());
        secondList.removeAll(firstList);
        firstList.addAll(secondList);
        return firstList;
        //        throw new NotImplementedException();
    }
}
