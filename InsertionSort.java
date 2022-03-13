package com.company;

public class InsertionSort {
    static int[] sort(int[] array) {
        int n = array.length;

        for(int i = 1; i < n; ++i) {
            int j = i - 1;

            int temp;
            for(temp = array[i]; j >= 0 && temp < array[j]; --j) {
                array[j + 1] = array[j];
            }

            array[j + 1] = temp;
        }

        return array;
    }

}
