package ProgramacionIII.tp1;

import java.util.Iterator;

public class Node implements Iterable<Integer> {

	private Integer info;
	private Node next;

	public Node() {
		this.info = 0;
		this.next = null;
	}

	public Node(Integer i, Node n) {
		this.setInfo(i);
		this.setNext(n);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
