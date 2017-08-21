package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.less;
import static com.laining.alogrithms.sort.SortUtils.exch;


/**
 * ð������
 * ����δ��������ݣ��ӵ�һ����ʼ���������Ԫ�رȽϣ�����ϴ��Ԫ����ǰ�ͽ�������֤ÿ��ð�ݺ�����Ԫ�ض����ڸô���������������
 * �Ƚϴ���:n-1 + n-2 +....+1 = n(n-1)/2
 * �����µĽ�������:n-1 + n-2 +....+1 = n(n-1)/2
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
		for(int i = 0; i < len - 1;i++) { //ð�ݴ���
			for(int j = 0; j < len - 1 - i; j ++) { //ÿ��ð����Ҫ�ȽϵĴ���
				if(less(array[j + 1], array[j])) //ÿ�ν��ϴ��Ԫ�ؽ���������
					exch(array, j+1, j);
			}
		}
		
	}
	
	/**
	 * ������鱾������ð��������Ȼ��Ҫ���� n-1��ð�ݺ�n(n-1)/2�αȽ�
	 * ����ʵ����ÿ��ð�ݿ���֪����ǰ������������Ƿ��Ѿ��������Կ�����ÿ��ð�ݽ������жϵ�ǰ�����Ƿ��Ѿ������������Ƿ���ֹð��
	 * @param array
	 */
	public static <T extends Comparable<? super T>> void optimizedSort(T[] array) {
		if(array == null)
			return;
		int len = array.length;
		if(len <= 1)
			return;
		boolean unSorted = true;
		for(int i = 0; i < len - 1 && unSorted;i++) { //ð�ݴ���
			unSorted = false;  //����ô�ð���ڣ�δ�������������ͱ�ʾ�����Ѿ����򣬿�����ֹð��i
			for(int j = 0; j < len - 1 - i; j ++) { //ÿ��ð����Ҫ�ȽϵĴ���
				if(less(array[j + 1], array[j])) {//ÿ�ν��ϴ��Ԫ�ؽ���������
					exch(array, j+1, j);
					unSorted = true;
				}
			}
		}
		
	}
	
}
