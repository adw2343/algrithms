package com.laining.algrithms.test;

import static com.laining.alogrithms.sort.SortUtils.getRandomIntegerArray;
import static com.laining.alogrithms.sort.SortUtils.isSorted;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import com.laining.alogrithms.sort.InsertionSort;

public class InsertionSortTest {
	
	@Test
	public void test() {
		Integer [] array = getRandomIntegerArray(1000);
		long start = System.currentTimeMillis();
		InsertionSort.sort(array);
		long end = System.currentTimeMillis();
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}
}
