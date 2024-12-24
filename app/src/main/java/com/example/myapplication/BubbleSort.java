package com.example.myapplication;

import java.util.Random;

public class BubbleSort {
     static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Giá trị ngẫu nhiên từ 0 đến 999
        }
        return array;
    }

    // Hàm Bubble Sort
    static double bubbleSort(int countLoop, int arraySize) {
         int m = countLoop;
         double sum = 0;
         for (int y = 0; y < m; y++){
             double startTime = System.nanoTime();

             int[] array = generateRandomArray(arraySize);
             int n = arraySize;
             for (int i = 0; i < n - 1; i++) {
                 for (int j = 0; j < n - i - 1; j++) {
                     if (array[j] > array[j + 1]) {
                         // Hoán đổi hai phần tử
                         int temp = array[j];
                         array[j] = array[j + 1];
                         array[j + 1] = temp;
                     }
                 }
             }
             double endTime = System.nanoTime();
             double duration = endTime - startTime;
             sum += 1/duration;
         }
        return m/sum;
    }
}
