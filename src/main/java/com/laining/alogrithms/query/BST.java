package com.laining.alogrithms.query;

public class BST<Key extends Comparable<Key>,Value> implements ST<Key, Value> {
	
	private Node root;
	
	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int size;
		
		public Node(Key key,Value value,int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}
	}

	public void put(Key key, Value value) {
		// TODO Auto-generated method stub
		
	}

	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Key key) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}

	public void deleteMax() {
		// TODO Auto-generated method stub
		
	}

	public int size(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
