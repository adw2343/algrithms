package com.laining.alogrithms.query;

/**
 * ������ű�API
 * ������null����nullֵ
 * @author admin
 * @param <Key>
 * @param <Value>
 */
public interface ST<Key extends Comparable<Key>,Value> {
	
	/**
	 * ����{@code key},ֵ{@code value}������ű�
	 * ���ֵ{@code value}Ϊnull��ɾ����{@code key}
	 * �����{@code key}Ϊnull,���׳�����ʱ�쳣
	 * @param key
	 * @param value
	 */
	void put(Key key,Value value);
	
	/**
	 * ��ȡ��{@code key}��Ӧ��ֵ
	 * �����{@code key}�������򷵻�null
	 * @param key
	 * @return
	 */
	Value get(Key key);
	
	/**
	 * �ӱ���ɾ����{@code key}
	 * @param key
	 */
	void delete(Key key);
	
	/**
	 * �жϼ�{@code key}�Ƿ�����ڱ���
	 * @param key
	 * @return
	 */
	boolean contains(Key key);
	
	
	/**
	 * �жϷ��ű��Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * ��ȡ���ű�ļ�ֵ������
	 * @return
	 */
	int size();
	
	/**
	 * ������С�ļ�
	 * @return
	 */
	Key min();
	
	/**
	 * �������ļ�
	 * @return
	 */
	Key max();
	
	/**
	 * С�ڵ��ڼ�{@code key}������
	 * @param key
	 * @return
	 */
	Key floor(Key key);

	/**
	 * ���ڵ��ڼ�{@code key}����С��
	 * @param key
	 * @return
	 */
	Key ceiling(Key key);
	
	/**
	 * ��{@code key}�ڷ��ű��е�����,���ص������ǵ�һ�����ڵ���{@code key}�ļ����ڵ�����
	 * @param key
	 * @return
	 */
	int rank(Key key);
	
	/**
	 * ��ȡ����Ϊ{@code k}�ļ�
	 * @param k
	 * @return
	 */
	Key select(int k);
	
	/**
	 * ɾ�����ű�����С�ļ�����ֵ
	 */
	void deleteMin();
	
	/**
	 * ɾ���������ļ�����ֵ
	 */
	void deleteMax();
	
	/**
	 * ��ȡ���ű���[lo...hi]֮��ļ�ֵ������
	 * @param lo
	 * @param hi
	 * @return
	 */
	int size(Key lo,Key hi);
	
	/**
	 * ��ȡ���ű���[lo...hi]֮������м�
	 * @param lo
	 * @param hi
	 * @return
	 */
	Iterable<Key> keys(Key lo,Key hi);
	
	/**
	 * ��ȡ���ű��е����м�
	 * @return
	 */
	Iterable<Key> keys();
	
}
