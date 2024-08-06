package com.nhnacademy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        exam1(args);
    }

    static void exam1(String[] args) {
        float x[];
        x = new float[10];
        args = new String[10];
        boolean[] isPrime = new boolean[5];
        int fib1[] = {0, 1, 1, 2, 3, 5, 8, 13};
        int fib2[] = new int[] {0, 1, 1, 2, 3, 5, 8, 13};
        double a[][] = { { 1.1, 2.2 }, { 3.3, 4.4 }, null, { 5.5, 6.6 }, null };
        short[][] b = new short[4][10];
        Object[] objects = { x, args, isPrime, fib1, fib2, b, a };
        Integer[] ints = {};

        System.out.println("x = " + Arrays.toString(x));
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("isPrime = " + Arrays.toString(isPrime));
        System.out.println("fib1 = " + Arrays.toString(fib1));
        System.out.println("fib2 = " + Arrays.toString(fib2));
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
        System.out.println("objects = " + Arrays.toString(objects));
    }
    
    static void Array() {
        int[] first;
        first = new int[5];
        first[0] = 1;

        int[] second = new int[]{1, 2, 3};
        int[] third = {1, 2, 3, 4, 5};
        // int[] not = new int[3]{1, 2, 3};
    
        System.out.println("Arrays = " + Arrays.toString(first));
    }

    static void doubleArray() {
        int[][] g = { {0, 1}, {2, 3}, {4, 5} };
        int[][] h = { {0, 1}, null, {2, 3, 4, 5} };

        System.out.println("g.length = " + g.length);
        System.out.println("g = " + Arrays.toString(g));
        
        System.out.println();

        // 첫번째 배열의 길이
        System.out.println("h.length = " + h.length);
        System.out.println("h = " + Arrays.toString(h));
    }
}