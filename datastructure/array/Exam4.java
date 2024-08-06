package com.nhnacademy;

public class Exam4 {
    public static void main(String[] args) {
        int a[] = {22, 44, 66, 88};
        int b[] = a.clone(); // deep copy 새 객체 생성

        a[0] = 11;
        System.out.println(a[0]);
        System.out.println(b[0]);

        String[] c = { "AB", "CD", "EF"};
        String[] d = c; // assign 같은곳 가리킴

        c[0] = "XYZ";
        System.out.println(c[0]);
        System.out.println(d[0]);
    }
}
