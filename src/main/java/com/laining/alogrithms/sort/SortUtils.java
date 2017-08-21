package com.laining.alogrithms.sort;

import java.util.Random;

/**
 * ���ڸ�������Ĺ�����
 * @author admin
 *
 */
public class SortUtils {
	
	/**
	 * �ж� {@code val1} �Ƿ�� {@code val2}С
	 * @param val1
	 * @param val2
	 * @return
	 */
	public static  <T extends Comparable<? super T>> boolean less(T val1,T val2){
		assert val1 != null;
		assert val2 != null;
		return val1.compareTo(val2) < 0;
	}
	
	/**
	 * ������{@code array}�еĵ�{@code i}��Ԫ�����{@code j}��Ԫ�ؽ���
	 * @param array
	 * @param i
	 * @param j
	 */
	public static <T extends Object> void exch(T[] array,int i,int j) {
		assert array != null;
		assert array.length > i;
		assert array.length > j;
		assert i >= 0;
		assert j >= 0;
		if(i == j)
			return;
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * �����ӡ����{@code array}�е�Ԫ��
	 * @param array
	 */
	public static <T extends Object> void print(T[] array) {
		assert array != null;
		for(T item : array) {
			System.out.print(item);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	/**
	 * �ж�����{@code array}�е�Ԫ���Ƿ���������
	 * @param array
	 * @return
	 */
	public static <T extends Comparable<? super T>> boolean isSorted(T[] array){
		assert array != null;
		int len = array.length;
		if(len <= 1)
			return true;
		for(int i = 0; i < len-1;i++) {
			if(less(array[i+1], array[i]))
				return false;
		}
		return true;
	}
	
	public  static Integer[] getRandomIntegerArray(int size) {
		Integer [] array = new Integer[size];
		Random random = new Random();
		for(int i = 0; i < size;i++) {
			array[i] = random.nextInt(size);
		}
		return array;
	}

}
