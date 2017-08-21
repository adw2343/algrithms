package com.laining.algrithms.test;


import static org.junit.Assert.*;

import static com.laining.alogrithms.sort.SortUtils.*;

import org.junit.Test;

import com.laining.alogrithms.sort.BubbleSort;


public class BubbleSortTest {

	@Test
	public void test() {
		Integer [] array = getRandomIntegerArray(1000);
		long start = System.currentTimeMillis();
		BubbleSort.sort(array);
		long end = System.currentTimeMillis();
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}
	
	@Test
	public void testOptimizedSort() {
		Integer [] array = getRandomIntegerArray(1000);
		long start = System.currentTimeMillis();
		BubbleSort.optimizedSort(array);
		long end = System.currentTimeMillis();
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}

}
