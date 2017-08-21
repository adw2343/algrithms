package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.*;


/**
 * ѡ������
 * ѡ�������n - 1
 * ÿ��ѡ����߼����Ӵ�����������ѡ����С��Ԫ��������������еĵ�һ��Ԫ�ؽ��н���
 * �Ƚϴ�����n-1+n-2+...+1=n(n-1)/2
 * ��������������n-1
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
