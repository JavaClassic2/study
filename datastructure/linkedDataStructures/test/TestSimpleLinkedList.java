package test;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import list.SimpleLinkedList;
import list.SimpleListIterator;

public class TestSimpleLinkedList {
    static Random random = new Random();

    // @Test
    // void testAddFirst() {
    //     SimpleList list = new SimpleLinkedList();
    //     int[] datas = new int[5];
    //     int[] reverseDatas = new int[5];

    //     for (int i = 0; i < datas.length; i++) {
    //         datas[i] = random.nextInt(100);
    //         reverseDatas[reverseDatas.length - i - 1] = datas[i];
    //     }

    //     for (int data : datas) {
    //         list.addFirst(data);
    //     }

    //     assertEquals(Arrays.toString(reverseDatas), list.toString());
    // }

    @Test
    void testAddLast() {
        SimpleLinkedList list = new SimpleLinkedList();
        int[] datas = new int[5];

        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(100);
        }

        for (int data : datas) {
            list.add(data);
        }

        assertEquals(Arrays.toString(datas), list);
    }

    @Test
    void testRemoveFirst() {
        SimpleLinkedList list = new SimpleLinkedList();
        int[] datas = new int[5];

        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(100);
        }

        for (int data : datas) {
            list.add(data);
        }

        list.remove();

        assertEquals(Arrays.toString(Arrays.copyOfRange(datas, 1, datas.length)), list);
    }

    @Test
    void testRemoveLast() {
        SimpleLinkedList list = new SimpleLinkedList();
        int[] datas = new int[5];

        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(100);
        }

        for (int data : datas) {
            list.add(data);
        }

        list.remove();

        assertEquals(Arrays.toString(Arrays.copyOfRange(datas, 0, datas.length - 1)), list);
    }

    @Test
    void testIterator() {
        SimpleLinkedList list = new SimpleLinkedList();
        int[] datas = new int[5];
        int[] reverseDatas = new int[5];

        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(100);
            reverseDatas[reverseDatas.length - i - 1] = datas[i];
        }

        for (int data : datas) {
            list.add(data);
        }

        SimpleListIterator iterator = list.iterator();
        for (int data : datas) {
            assertEquals(data, iterator.next());
        }

        for (int data : reverseDatas) {
            assertEquals(data, iterator.previous());
        }

        iterator.remove();
        iterator.remove();
        for (int data : Arrays.copyOfRange(datas, 2, datas.length)) {
            assertEquals(data, iterator.next());
        }
    }
}