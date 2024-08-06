package com.nhnacademy;

import java.util.Arrays;

public class Exam7 {
    public static void main(String[] args) {
        Box[] boxes = new Box[10];

        for (int i=0; i<boxes.length; i++) {
            boxes[i] = new Box(i+1);
        }
        
        System.out.println(Arrays.toString(boxes));

        // 값 참조 (레퍼런스 카피)
        Box[] boxes_copy = Arrays.copyOfRange(boxes, 2, 5);
        System.out.println(Arrays.toString(boxes_copy));

        for (Box box : boxes_copy) {
            box.up();
        }

        System.out.println("After up");
        System.out.println(Arrays.toString(boxes));
        System.out.println(Arrays.toString(boxes_copy));
    }
}
