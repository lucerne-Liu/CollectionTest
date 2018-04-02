package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        //将集合A中得元素映射成集合B中的元素
        return array.stream().map(n -> n * 3).collect(Collectors.toList());
//        throw new NotImplementedException();
    }

    public List<String> mapLetter() {
        //数字映射为字母
        List<String> list = new ArrayList<>();
        for (Integer num : array) {
            list.add(letterList.get(num - 1));
        }
        return list;
//        throw new NotImplementedException();
    }

    public List<String> mapLetters() {
        //字母表映射
        List<String> list = new ArrayList<>();
        String letters;
        for (Integer num : array) {
            letters =  num / 26 > 0 ? letterList.get((num - 1) / 26 - 1) + letterList.get(num - 26 * ((num - 1) / 26) - 1) : letterList.get(num - 1);
            list.add(letters);
        }
        return list;
//        throw new NotImplementedException();
    }

    public List<Integer> sortFromBig() {
        //从大到小排序
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        //从小到大排序
        return array.stream().sorted().collect(Collectors.toList());
        //        throw new NotImplementedException();
    }
}
