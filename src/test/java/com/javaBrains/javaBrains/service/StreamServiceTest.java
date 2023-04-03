package com.javaBrains.javaBrains.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
class StreamServiceTest {

    @Test
    void flatMapTwoListOperation(){
        Integer[] list1 = {1,2,3};
        Integer[] list2 = {4,5,6};
        List<Integer> result = Arrays.stream(list1).flatMap(i -> Arrays.stream(list2).map(j -> i * j)).collect(Collectors.toList());
        System.out.println(result);
    }

}