package com.laining.alogrithms.query;

/**
 * 有序符号表API
 * 不允许null键和null值
 * @author admin
 * @param <Key>
 * @param <Value>
 */
public interface ST<Key extends Comparable<Key>,Value> {
	
	/**
	 * 将键{@code key},值{@code value}放入符号表
	 * 如果值{@code value}为null则删除键{@code key}
	 * 如果键{@code key}为null,则抛出运行时异常
	 * @param key
	 * @param value
	 */
	void put(Key key,Value value);
	
	/**
	 * 获取键{@code key}对应的值
	 * 如果键{@code key}不存在则返回null
	 * @param key
	 * @return
	 */
	Value get(Key key);
	
	/**
	 * 从表中删除键{@code key}
	 * @param key
	 */
	void delete(Key key);
	
	/**
	 * 判断键{@code key}是否存在于表中
	 * @param key
	 * @return
	 */
	boolean contains(Key key);
	
	
	/**
	 * 判断符号表是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 获取符号表的键值对数量
	 * @return
	 */
	int size();
	
	/**
	 * 返回最小的键
	 * @return
	 */
	Key min();
	
	/**
	 * 返回最大的键
	 * @return
	 */
	Key max();
	
	/**
	 * 小于等于键{@code key}的最大键
	 * @param key
	 * @return
	 */
	Key floor(Key key);

	/**
	 * 大于等于键{@code key}的最小键
	 * @param key
	 * @return
	 */
	Key ceiling(Key key);
	
	/**
	 * 键{@code key}在符号表中的排名,返回的索引是第一个大于等于{@code key}的键所在的索引
	 * @param key
	 * @return
	 */
	int rank(Key key);
	
	/**
	 * 获取排名为{@code k}的键
	 * @param k
	 * @return
	 */
	Key select(int k);
	
	/**
	 * 删除符号表中最小的键及其值
	 */
	void deleteMin();
	
	/**
	 * 删除表中最大的键及其值
	 */
	void deleteMax();
	
	/**
	 * 获取符号表中[lo...hi]之间的键值对数量
	 * @param lo
	 * @param hi
	 * @return
	 */
	int size(Key lo,Key hi);
	
	/**
	 * 获取符号表中[lo...hi]之间的所有键
	 * @param lo
	 * @param hi
	 * @return
	 */
	Iterable<Key> keys(Key lo,Key hi);
	
	/**
	 * 获取符号表中的所有键
	 * @return
	 */
	Iterable<Key> keys();
	
}
