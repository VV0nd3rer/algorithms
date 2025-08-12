package com.home.algorithms;

import com.home.algorithms.sort.SortStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest(classes = { com.home.aop.advice.ExecutionTimeAdvice.class,
		com.home.algorithms.sort.impl.BubbleSort.class})
@Slf4j
class AlgorithmsApplicationTests {

	@Autowired
	SortStrategy bubbleSort;

	@Test
	void contextLoads() {
		log.info("Hello :)");
	}

	@Test
	void testBubbleSort() {
		Integer[] array = new Integer[] {5, 9, 3};
		Integer[] expectedArray = new Integer[] {3, 5, 9};
		bubbleSort.sort(array);
		assertArrayEquals(expectedArray, array);
	}

	@Test
	void testAopExecutionTime() {
		Integer[] array = new Integer[] {5, 9, 3};

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream originalSystemOut = System.out;
		System.setOut(new PrintStream(baos));

		bubbleSort.sort(array);

		System.setOut(originalSystemOut);
		String logOutput = baos.toString();
		log.info("Log output: {} ", logOutput);
		assertThat(logOutput, containsString("Tracking execution time"));
	}
}
