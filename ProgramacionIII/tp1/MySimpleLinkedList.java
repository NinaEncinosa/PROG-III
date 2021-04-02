package ProgramacionIII.tp1;

public class MySimpleLinkedList {
	
	protected Node first;
	protected int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		Node tmp = new Node(o , null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size ++;
	}
	
	public Object extractFront() {
		if (this.first == null)
		return null;
		
		Object info = this.first.getInfo();
		this.first = this.first.getNext();
		
		this.size --;
		return info;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}
	
	public Object get(int index) {
		if (index < size) {
			Node tmp = this.first;
			for (int i=0; i<index; i++ ) {
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		return null;
	}
	
	public int indexOf(Object o) {
		Node aux = new Node();
		aux = this.first;
		int index = 0;
		
		while ((aux != null) && (aux.getInfo() != o)) {
			index++;
			aux = aux.getNext();	
		}
		
		if(aux == null) {
			index = -1;
		}
		
		return index;
	}

}
