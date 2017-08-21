package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.less;
import static com.laining.alogrithms.sort.SortUtils.exch;


/**
 * 冒泡排序
 * 对于未排序的数据，从第一个开始逐个与相邻元素比较，如果较大的元素在前就交换，保证每次冒泡后最大的元素都处于该次排序子数组的最后
 * 比较次数:n-1 + n-2 +....+1 = n(n-1)/2
 * 最坏情况下的交换次数:n-1 + n-2 +....+1 = n(n-1)/2
 * @author admin
 *
 */
public class BubbleSort{

	public static <T extends Comparable<? super T>> void sort(T[] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		for(int i = 0; i < len - 1;i++) { //冒泡次数
			for(int j = 0; j < len - 1 - i; j ++) { //每次冒泡需要比较的次数
				if(less(array[j + 1], array[j])) //每次将较大的元素交换到后面
					exch(array, j+1, j);
			}
		}
		
	}
	
	/**
	 * 如果数组本身有序，冒泡排序仍然需要进行 n-1次冒泡和n(n-1)/2次比较
	 * 但是实际上每次冒泡可以知道当前排序的子数组是否已经有序。所以可以在每次冒泡结束后判断当前数组是否已经有序来决定是否终止冒泡
	 * @param array
	 */
	public static <T extends Comparable<? super T>> void optimizedSort(T[] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		boolean unSorted = true;
		for(int i = 0; i < len - 1 && unSorted;i++) { //冒泡次数
			unSorted = false;  //如果该次冒泡内，未发生过交换，就表示数组已经有序，可以终止冒泡i
			for(int j = 0; j < len - 1 - i; j ++) { //每次冒泡需要比较的次数
				if(less(array[j + 1], array[j])) {//每次将较大的元素交换到后面
					exch(array, j+1, j);
					unSorted = true;
				}
			}
		}
		
	}
	
}
