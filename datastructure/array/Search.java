package com.nhnacademy;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] a = {22, 33, 44, 55, 66, 77, 88, 99};
        String[] b = {"A", "B", "C"};

        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));

        System.out.println("Search(a, 44) : " + sequential(a, 44));
        System.out.println("Search(b, B) : " + sequential(b, "B"));

        System.out.println("Search(a, 44) : " + binary(a, 44));
    }

    private static int sequential(int[] a, int find) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == find) {
                return i;
            }
        }
        return -1;
    }
    // 오버로딩
    private static int sequential(String[] a, String find) {
        for (int i=0; i<a.length; i++) {
            if (a[i].equals(find)) {
                return i;
            }
        }
        return -1;
    }

    private static int binary(int[] array, int find) {
        int min = 0;
        int max = array.length-1;
        
        while (min <= max) {
            int mid = (min + max) / 2;

            if (array[mid] < find) {
                min = mid+1;
            } else if (array[mid] > find) {
                max = mid-1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
