package com.laining.algrithms.test;


import static org.junit.Assert.*;

import static com.laining.alogrithms.sort.SortUtils.*;

import org.junit.Test;

import com.laining.alogrithms.sort.MergeSort;


public class MergeSortTest {

	@Test
	public void test() {
		Integer [] array = getRandomIntegerArray(1000);
		print(array);
		long start = System.currentTimeMillis();
		MergeSort.sort(array);
		long end = System.currentTimeMillis();
		print(array);
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}
	
	

}
