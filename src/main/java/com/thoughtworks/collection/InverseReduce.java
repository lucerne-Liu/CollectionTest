package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        //根据给定数字无限分割至等于0(提示：9-2=7,7-2=5 ...)
        List<Integer> resultList = new ArrayList<>();
        int divideNum = random.nextInt(3);
        if (number < divideNum){
            return resultList;
        }
        for (int i = number - divideNum; i >= 0; i -= divideNum) {
            resultList.add(i);
        }
        return resultList;
//        throw new NotImplementedException();
    }
}
