package com.home.algorithms.sort.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class BubbleSortTest {
    private static final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void sortArray() {
        Integer[] array = new Integer[] {5, 9, 3};
        Integer[] expectedArray = new Integer[] {3, 5, 9};
        bubbleSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }
    @Test
    void sortList() {
        List<Integer> list = Arrays.asList(5, 9, 3);
        List<Integer> expectedList = Arrays.asList(3, 5, 9);
        bubbleSort.sort(list);
        assertEquals(expectedList, list);
    }

    @Test
    void sortArrayAlreadySorted() {
        Integer[] array = new Integer[] {3, 5, 9};
        Integer[] expectedArray = new Integer[] {3, 5, 9};
        bubbleSort.sort(array);
        assertArrayEquals(expectedArray, array);
    }
}