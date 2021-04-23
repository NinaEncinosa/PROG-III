package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{
	
	private Node cursor;

	//O(1) 
	@Override
	public boolean hasNext() {
		return cursor != null;
	}

	//O(1) 
	@Override
	public Integer next() {
		Integer aux = cursor.getInfo();
		cursor = cursor.getNext();
		return aux;
	}
	
	//O(1)
	public void moveNext() {
		cursor = cursor.getNext();
	}

	public MyIterator(Node first) {
		cursor = first ;
	}
	
	//O(1) 
	public Integer get() {
		return cursor.getInfo();
	}
	
	
}


