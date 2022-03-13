package com.company;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] array, int first, int last, int key) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (array[mid] == key) {
                return mid;
            } else {
                return array[mid] > key ? binarySearch(array, first, mid - 1, key) : binarySearch(array, mid + 1, last, key);
            }
        } else {
            return -1;
        }
    }

}
