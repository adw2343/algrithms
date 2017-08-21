package com.laining.alogrithms.sort;
import static com.laining.alogrithms.sort.SortUtils.*;


public class QuickSort {
	
	public static <T extends Comparable<? super T>>  void sort(T [] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		sort(array,0,len-1);
				
	}
	
	public static <T extends Comparable<? super T>>  void sort(T [] array,int lo,int hi) {
		if(lo >= hi)
			return;
		int partition = partition(array, lo, hi);
		sort(array,lo,partition - 1);
		sort(array,partition + 1,hi);		
	}
	
	
	public static <T extends Comparable<? super T>>  int partition(T [] array,int lo,int hi) {
		int i = lo,j = hi + 1;
		while(true) {
			while(less(array[++i], array[lo])) {
				if(i>=hi)
					break;
			}
				
			while(less(array[lo], array[--j])) {
				if(j <= lo) {
					break;
				}
			}
			if(i >= j)
				break;
			exch(array, i, j);
		}
		exch(array, lo, j);
		return j;
				
	}
	
	 
}
