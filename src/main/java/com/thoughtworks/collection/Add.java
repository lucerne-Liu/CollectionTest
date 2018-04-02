package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


import java.util.List;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
//      求leftBorder 和rightBorder之间的偶数和
        int sum = 0, startInx = leftBorder < rightBorder ? leftBorder : rightBorder,
            endInx = leftBorder > rightBorder ? leftBorder : rightBorder;
        for (int i = startInx; i <= endInx; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
//        throw new NotImplementedException();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        //求leftBorder 和rightBorder之间的奇数和
        int sum = 0, startInx = leftBorder < rightBorder ? leftBorder : rightBorder,
            endInx = leftBorder > rightBorder ? leftBorder : rightBorder;
        for (int i = startInx; i <= endInx; i++) {
            if ((i-1) % 2 == 0) {
                sum += i;
            }
        }
        return sum;
//        throw new NotImplementedException();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
//        求数组中每个元素的3倍加2的和
//        Java8 Stream API实现
        return arrayList.stream().mapToInt(n -> 3 * n + 2).sum();
//        throw new NotImplementedException();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加2，偶数元素不变的数组
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : arrayList) {
            if ((num - 1) % 2 == 0) {
                num = 3 * num + 2;
            }
            resultList.add(num);
        }
        return resultList;
//        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加5的和
//        Java8 Stream API实现
        return arrayList.stream().filter(n -> (n - 1) % 2 == 0).mapToInt(n -> 3 * n + 5).sum();
//        throw new NotImplementedException();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        //求数组中所有偶数组成的数组的中位数
//        Java8 Stream API实现
        List<Integer> resultList = arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        int len = resultList.size();
        return len % 2 == 0 ? resultList.get(len / 2 - 1) + 1 : resultList.get(len / 2);
// throw new NotImplementedException();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        //求数组中所有偶数的平均数
        int count = 0,sum = 0;
        for (Integer num : arrayList) {
            if (num % 2 == 0) {
                count++;
                sum += num;
            }
        }
        return sum / count;
//        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        // 求数组中所有偶数组成的数组是否包含某特定的数specialElment
        return arrayList.stream().filter(n -> n % 2 == 0).anyMatch(n -> n == specialElment);
        //        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        //去除数组中所有偶数组成的数组的重复数
        return arrayList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
        //        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
      //排序数组 结果使数组偶数在递增在前，奇数递减在后
        List<Integer> evenList = arrayList.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(n -> (n - 1) % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
//     throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        // 数组中前一个元素和后一个元素的和的3倍的数组
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1 ; i++) {
            resultList.add((arrayList.get(i) + arrayList.get(i+1)) * 3);
        }
        return resultList;
//        throw new NotImplementedException();
    }

}
