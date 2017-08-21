package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.*;


/**
 * 选择排序
 * 选择次数：n - 1
 * 每次选择的逻辑：从待排序数组中选择最小的元素与待排序数组中的第一个元素进行交换
 * 比较次数：n-1+n-2+...+1=n(n-1)/2
 * 交换次数最坏情况：n-1
 * @author admin
 *
 */
public class SelectionSort {
	
	public static <T extends Comparable<? super T>> void sort(T[] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		for(int i = 0 ; i < len - 1;i++) {
			int min = i;
			for(int j = i+1; j < len; j++) {
				if(less(array[j],array[min]))
					min = j;
			}
			exch(array, i, min);
		}
		
	}
	
	

}
