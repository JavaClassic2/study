package com.nhnacademy;

import java.util.Arrays;

public class Exam3 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};

        printEvenValue(a);
    }

    static void printAll(int[] a){
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }

    static void printEvenValue(int[] a){
        for (int i=0; i<a.length; i++) {
            if (a[i] % 2 == 0){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
        for (int i : a) {
            if (i%2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        Arrays.stream(a).filter(i -> i%2 == 0).forEach(i -> System.out.print(i + " "));
    }

    static void printEvenIndex(int[] a){
        for (int i=0; i<a.length; i++) {
            if ((i+1) % 2 == 0){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();

        int index = 1;
        for (int i : a) {
            if (index%2 == 0) {
                System.out.print(i + " ");
            }
            index++;
        }
    }
}
