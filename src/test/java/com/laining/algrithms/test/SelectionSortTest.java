package com.laining.algrithms.test;


import static org.junit.Assert.*;

import static com.laining.alogrithms.sort.SortUtils.*;

import org.junit.Test;

import com.laining.alogrithms.sort.SelectionSort;


public class SelectionSortTest {

	@Test
	public void test() {
		Integer [] array = getRandomIntegerArray(1000);
		long start = System.currentTimeMillis();
		SelectionSort.sort(array);
		long end = System.currentTimeMillis();
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}
	
	

}
