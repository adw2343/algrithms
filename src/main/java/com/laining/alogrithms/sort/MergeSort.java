package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.less;


/**
 * 
 * @author admin
 * 归并排序的思想是:将左右两边局部有序的子数组归并就能得到一个有序的大数组
 */
public class MergeSort {
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(T[] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		@SuppressWarnings("rawtypes")
		Comparable[] aux= new Comparable[array.length];
		sort(array,0,array.length -1,aux);
		
	} 
	
	private static <T extends Comparable<? super T>> void sort(T[] array,int lo,int hi,T[] aux) {
		if(lo >= hi)
			return;
		int mid = lo + (hi-lo)/2;
		sort(array,lo,mid,aux);
		sort(array,mid + 1,hi,aux);
		merge(array, lo, hi, mid, aux);
	}
	
	private static <T extends Comparable<? super T>> void merge(T[] array,int lo,int hi,int mid,T[] aux) {
		int i = lo,j = mid+1;    // 逐个比较两个子数组中未排序的最小值
		for(int k = lo;k<= hi;k++)
			aux[k] = array[k];
		for(int k = lo;k<= hi;k++) {
			if(i > mid)
				array[k] = aux[j++];
			else if(j > hi)
				array[k] =aux[i++];
			else if(less(aux[j], aux[i]))
				array[k] = aux[j++];
			else
				array[k] = aux[i++];
		}
		
	}

}
