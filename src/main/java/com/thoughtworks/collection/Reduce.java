package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        // 获取数组中的最大值
//        throw new NotImplementedException();
        return Collections.max(arrayList);
    }

    public double getMinimum() {
        //获取数组中的最小值
        return Collections.min(arrayList);
//        throw new NotImplementedException();
    }

    public double getAverage() {
        // 获取数组的平均值
        return arrayList.stream().mapToInt(n -> n).sum() / (double)arrayList.size();
//        throw new NotImplementedException();
    }

    public double getOrderedMedian() {
        // 获取数组中位数
        int len = arrayList.size();
        return len % 2 == 0 ? (arrayList.get(len / 2 - 1 ) + arrayList.get(len / 2)) / (double)2 : arrayList.get((len - 1) / 2);
//        throw new NotImplementedException();
    }

    public int getFirstEven() {
        //获取数组中第一个偶数
        //方法一
//        return arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()).get(0);
        //方法二
        int even = -1;
        for (Integer num : arrayList) {
            if (num % 2 == 0) {
                even =  num;
                break;
            }
        }
        return even;
//        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        //获取数组中第一个偶数的下标
        int index = -1;
        for (Integer num : arrayList) {
            index++;
            if (num % 2 == 0) {
                break;
            }
        }
        return index;
//        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        //判断两个数组是否相等
        return this.arrayList.toString().equals(arrayList.toString());
//        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        //获取单链表中的中位数
        for (Integer sum : arrayList) {
            singleLink.addTailPointer(sum);
        }
        singleLink = new Link<Integer>(arrayList);
        int len = singleLink.size();
//        return (singleLink.getNode(6) + singleLink.getNode(7)) / (double)2;
        return len % 2 == 0 ? (singleLink.getNode(len / 2) + singleLink.getNode(len / 2 + 1)) / (double)2 : singleLink.getNode((len - 1) / 2 + 1) / (double)1;
//        throw new NotImplementedException();
    }

    public int getLastOdd() {
        //获取数组中最后一个奇数
        int odd = -1;
        for (Integer num : arrayList) {
            if ((num - 1) % 2 == 0) {
                odd = num;
            }
        }
        return odd;
//        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        //获取数组中最后一个奇数的下标
        int odd = -1;
        for (Integer num : arrayList) {
            if ((num - 1) % 2 == 0) {
                odd = num;
            }
        }
        return arrayList.indexOf(odd);
//        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 4, 6, 2, 3, 10, 9, 8, 11, 2, 19, 30};
        List<Integer> arrayList = Arrays.asList(array);

        Link<Integer> singleLink = new Link<Integer>(arrayList);
        Reduce reduce = new Reduce(arrayList);

        reduce.getMedianInLinkList(singleLink);
    }
}
