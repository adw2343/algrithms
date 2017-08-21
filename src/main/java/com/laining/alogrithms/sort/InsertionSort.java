package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.*;

public class InsertionSort {
	
	public static <T extends Comparable<? super T>>  void sort(T [] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		for(int i = 1; i < len; i++) {
			for(int j = i; j > 0;j--) {
				if(less(array[j], array[j-1]))
					exch(array, j-1, j);
			}
		}
		
	}
	
	

}
