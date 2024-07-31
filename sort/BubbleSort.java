package sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort<C extends Comparable<C>> {

    public void sort(C[] list) {
        for (int i=list.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (list[j].compareTo(list[j+1]) > 0) {
                    C temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }

}

class Test {
    public static void main(String[] args) {
        BubbleSort<Integer> bubble = new BubbleSort<>();
        Integer[] intList = {1, 2, 5, 7, 8, 3, 2, 6};
        bubble.sort(intList);
        for (int i : intList) {
            System.out.println(i);
        }
    }
    
}
