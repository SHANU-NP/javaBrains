package com.javaBrains.javaBrains.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class ArithmeticAndLogicalOperationServiceTest {

    @Test
    void arraySorting(){
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Arrays.sort(numbers);
    }

    @Test
    void ArrayTraversal(){
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        System.out.println("TRAVERSAL ASC : ");
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println("TRAVERSAL REVERSE : ");
        System.out.println("array length : "+numbers.length);
        for (int i = numbers.length - 1; i >=0; i=i-1){
            System.out.println(numbers[i]);
        }
    }

    @Test
    void selectionSortTest(){

        int[] number = new int[5];
        number[0] = 32;
        number[1] = 23;
        number[2] = 10;
        number[3] = 2;
        number[4] = 30;
        for (int i = 0; i < number.length - 1; i++){

            int min = number[i];
            int pos = i;

        for (int j = i +1; j < number.length; j ++ ){
            if (number[j] < min){
                min = number[j];
                pos = j;
            }
        }
        if (pos != i){
            number[pos] = number[i];
            number[i] = min;
        }
    }
        System.out.println("OUT PUT ");
        for (int n : number){
            System.out.println(n);
        }

    }

    @Test
    void bubbleSortTest(){
        int[] numbers = new int[5];
        numbers[0] = 32;
        numbers[1] = 23;
        numbers[2] = 10;
        numbers[3] = 2;
        numbers[4] = 30;


        for (int i = 0; i < numbers.length - 1; i++){

            for (int j = 0; j < numbers.length -i -1; j++){

                if (numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        System.out.println("OUT PUT ");
        for (int n : numbers){
            System.out.println(n);
        }
    }

    @Test
    void linearSearchTest(){
        int[] numbers = new int[5];
        numbers[0] = 32;
        numbers[1] = 23;
        numbers[2] = 10;
        numbers[3] = 11;
        numbers[4] = 30;

        int element = 10;
        int position = -1;
        for (int i = 0; i < numbers.length; i ++){
            if (numbers[i] == element){
                position = i;
            }
        }
        if (position != -1){
            System.out.println(" element fount at position : "+position);
        }else {
            System.out.println("Element not found");
        }

    }

    @Test
    void binarySearchTest(){
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        int firstPos = 0;
        int lastPos = numbers.length - 1;
        int element = 3;
        int elementPos = -1;

        while (firstPos <= lastPos){

            int middlePos = (firstPos + lastPos)/2;

            if (numbers[middlePos] == element){
                elementPos = middlePos;
                break;
            }
            if (element < numbers[middlePos]){
                lastPos = middlePos -1;
            }else {
                firstPos = middlePos + 1;
            }
        }
        if (elementPos != -1){
            System.out.println("element found at position : "+elementPos);
        }else {
            System.out.println("element not found");
        }
    }

}