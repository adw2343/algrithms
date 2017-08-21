package com.laining.alogrithms.query;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayST<Key extends Comparable<Key>,Value> implements ST<Key, Value>{

	private Key[] keys;
	private Value[] values;
	private int size;
	private final int DEFAULT_CAPACITY = 32;	
	
	@SuppressWarnings("unchecked")
	ArrayST(){		
		keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
		values = (Value []) new Comparable[DEFAULT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	ArrayST(int capacity){
		assert capacity >= 0;
		keys = (Key[]) new Comparable[capacity];
		values = (Value []) new Comparable[capacity];
	}
	
	 @SuppressWarnings("unchecked")
	private void resize(int capacity) {
	        assert capacity >= size;
	        Key[]   tempk = (Key[])   new Comparable[capacity];
	        Value[] tempv = (Value[]) new Object[capacity];
	        for (int i = 0; i < size; i++) {
	            tempk[i] = keys[i];
	            tempv[i] = values[i];
	        }
	        values = tempv;
	        keys = tempk;
	    }
	
		
	public void put(Key key, Value value) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");		
		if (value == null) {
            delete(key);
            return;
        }
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) == 0) {
			values[i] = value;
		}else{
	        if (size == keys.length) resize(2*keys.length);

			for(int j = size;j > i;j--) {
				keys[j] = keys[j-1];
				values[j] = values[j-1];
			}
			keys[i] = key;
			values[i] = value;
			size++;
		}
        assert check();
	}

	public Value get(Key key) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");	
		if(isEmpty())
			return null;
		int index = rank(key);
		if(index < size && keys[index].compareTo(key) == 0)
			return values[index];
		else
			return null;
	}

	public void delete(Key key) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");	
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) == 0) {
			for(int j = i; j < size - 1;j++) {
				keys[j] = keys[j+1];
				values[j] = values[j+1];
			}
			keys[size-1] = null;
			values[size-1] = null;
			size--;
			
		}
        assert check();
	}

	public boolean contains(Key key) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");	
		return get(key) != null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Key min() {
        if (isEmpty()) 
        	throw new NoSuchElementException("called min() with empty symbol table");
		return keys[0];
	}

	public Key max() {
        if (isEmpty()) 
        	throw new NoSuchElementException("called min() with empty symbol table");
		return keys[size-1];
	}

	public Key floor(Key key) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");	
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) <= 0) {
			return keys[i];
		}else if(i < size  && i > 0 && keys[i].compareTo(key) > 0) {
			return keys[i-1];
		}else{
			return null;
		}
	}

	public Key ceiling(Key key) {
		if(key == null)
			throw new IllegalArgumentException("键不能为空");	
		int i = rank(key);
		if(i < size  && keys[i].compareTo(key) >= 0) {
			return keys[i];
		}else if(i < size - 1 && keys[i].compareTo(key) < 0) {
			return keys[i + 1];
		}else {
			return null;
		}	
	}

	
	public int rank(Key key) {
		int lo = 0,hi = size - 1;
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)
				hi = mid - 1;
			else if(cmp > 0)
				lo = mid + 1;
			else 
				return mid;
		}
		return lo;
	}

	
	public Key select(int k) {
		if(k < 0 || k >= size())
			return null;
		return keys[k];
	}

	public void deleteMin() {
		if (isEmpty()) 
        	throw new NoSuchElementException("called deleteMin with empty symbol table");
		for(int i = 0; i < size - 1;i++) {
			keys[i] = keys[i+1];
			values[i] = values[i+1];
		}
		keys[size-1] = null;
		values[size-1]=null;
		size--;
		
	}

	public void deleteMax() {
		if (isEmpty()) 
        	throw new NoSuchElementException("called min() with empty symbol table");
		keys[size-1] = null;
		values[size-1]=null;
		size--;
	}

	public int size(Key lo, Key hi) {
		return size;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		int loIndex = rank(lo);
		int hiIndex = rank(hi);
		List<Key> list = new ArrayList<Key>();
		for(int i = loIndex; i < hiIndex;i++) {
			list.add(keys[i]);
		}
		if(contains(hi))
			list.add(hi);
		return list;
	}

	public Iterable<Key> keys() {
		List<Key> list = new ArrayList<Key>();
		for(int i = 0; i < size;i++) {
			list.add(keys[i]);
		}
		return list;
	} 
	
	 /***************************************************************************
	    *  Check internal invariants.
	    ***************************************************************************/

	    private  boolean check() {
	        return isSorted() && rankCheck();
	    }

	    // are the items in the array in ascending order?
	    private  boolean isSorted() {
	        for (int i = 1; i < size(); i++)
	            if (keys[i].compareTo(keys[i-1]) < 0) return false;
	        return true;
	    }

	    // check that rank(select(i)) = i
	    private boolean rankCheck() {
	        for (int i = 0; i < size(); i++)
	            if (i != rank(select(i))) return false;
	        for (int i = 0; i < size(); i++)
	            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
	        return true;
	    }


	    /**
	     * Unit tests the {@code BinarySearchST} data type.
	     *
	     * @param args the command-line arguments
	     */
	    public static void main(String[] args) { 
	    	ArrayST<String, Integer> st = new ArrayST<String, Integer>();
	    	Random random = new Random();
	    	String stings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    	for(int i = 0;i < stings.length();i++) {
	    		int value = i;
	    		st.put(String.valueOf(stings.charAt(value)), value);
	    	}
	    	print(st);
    		String kString = "G";
    		System.out.println("rank of " + kString + " is " + st.rank(kString));
	    	for(int i = 0;i < 26;i++) {
	    		int value = random.nextInt(26);
	    		st.delete("a"+value);
	    	}
	    	
	    }
	    
	    private static void print(ArrayST<String, Integer> st) {
	    	Iterable<String> keys = st.keys();
	    	if(keys != null) {
		    	Iterator<String> iterator = keys.iterator();
		    	while(iterator.hasNext()) {
		    		String key = iterator.next();
		    		Integer value = st.get(key);
		    		System.out.println(key + "-" + value);
		    	}

	    	}
	    }
	    
	    
	

}
