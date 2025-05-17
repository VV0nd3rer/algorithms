package com.home.algorithms.sort.impl;

import com.home.algorithms.sort.SortStrategy;
import com.home.aop.advice.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class BubbleSort implements SortStrategy {
    @TrackExecutionTime
    @Override
    public void sort(Integer[] elements) {
//        bubbleSortArray(elements);
        bubbleSortArrayOptimized(elements);
    }

    @Override
    public void sort(List<Integer> elements) {
        bubbleSortList(elements);
    }

    private void bubbleSortList(List<Integer> elements) {
        int n = elements.size();
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if(elements.get(j-1) > elements.get(j)) {
                        log.info("Swapping j: " + elements.get(j) + " with j-1: " + elements.get(j-1));
                        Collections.swap(elements, j, j-1);
                    }
                });
        log.info("list: " + elements);
    }

    private void bubbleSortArray(Integer[] elements) {
        int n = elements.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if(elements[j-1] > elements[j]) {
                        log.info("Swapping j: " + elements[j] + " with j-1: " + elements [j-1]);
                        int temp = elements[j];
                        elements[j] = elements[j-1];
                        elements[j-1] = temp;
                    }
                });
        log.info("arr: " + Arrays.toString(elements));
    }

    private void bubbleSortArrayOptimized(Integer[] elements) {
        int n = elements.length;
        int temp;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for(int j = 1; j < n - i; j++) {
                if (elements[j-1] > elements[j]) {
                    log.info("Swapping j: " + elements[j] + " with j-1: " + elements [j-1]);
                    temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        log.info("arr: " + Arrays.toString(elements));

    }
}
