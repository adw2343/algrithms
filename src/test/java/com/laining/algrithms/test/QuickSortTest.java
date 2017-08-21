package com.laining.algrithms.test;

import static com.laining.alogrithms.sort.SortUtils.getRandomIntegerArray;
import static com.laining.alogrithms.sort.SortUtils.isSorted;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.laining.alogrithms.sort.QuickSort;

public class QuickSortTest {
	
	@Test
	public void test() {
		Integer [] array = getRandomIntegerArray(1000);
		long start = System.currentTimeMillis();
		QuickSort.sort(array);
		long end = System.currentTimeMillis();
		System.out.println("used:" +(end - start));
		assertTrue(isSorted(array));
	}
	

}
