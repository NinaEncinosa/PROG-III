package ProgramacionIII.tp1;


public class MySimpleLinkedList implements Iterable<Integer> {

	protected Node first;
	protected Node last;
	protected int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	//EJ 1. Funciones basicas de una lista
	//O(1) complejidad constante, no depende del tamanio de la lista
	public void insertFront(Integer o) {
		Node tmp = new Node(o , null);
		tmp.setNext(this.first);
		
		if(this.isEmpty())
			this.last = tmp;
		
		this.first = tmp;
		this.size ++;

	}
	
	//EJ 1. Funciones basicas de una lista
	//O(1) complejidad constante, no depende del tamanio de la lista
	public void insertLast(Integer o) {
		if(this.last == null) {
			this.insertFront(o); //dentro del insertFront hago el size++
		} else {
			Node tmp = this.last;
			this.last = new Node (o,null);
			tmp.setNext(this.last);
			this.size ++;
		}	
	}
	
	//EJ 1. Funciones basicas de una lista
	//O(1) complejidad constante, no depende del tamanio de la lista
	public Integer extractFront() {
		if (this.first == null)
		return -1;
		 
		Integer info = this.first.getInfo();
		this.first = this.first.getNext();
		this.size --;
		
		//si el first era el unico elemento y lo saque, last= null
		if(this.isEmpty()) 
			this.last=null;

		return info;
	}

	//EJ 1. Funciones basicas de una lista
	//O(1) complejidad constante, una sola consulta, no depende del tamanio de la lista
	public boolean isEmpty() {
		return this.size == 0;
	}

	//EJ 1. Funciones basicas de una lista
	//O(1) complejidad constante, no depende del tamanio de la lista
	public int size() {
		return this.size;
	}
	
	//EJ 1. Funciones basicas de una lista
	//O(n) en el peor de los casos el "for" va hasta n, siendo n el tamanio de la lista
	public Integer get(int index) {
		if (index < size) {
			Node tmp = this.first;
			//O(n) siendo n el tamanio de la lista 
			for (int i=0; i<index; i++ ) {
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		return -1;
	}
	
	//O(n) donde n el tamanio de la lista
    public MySimpleLinkedList reverseList() {
    	MyIterator it = this.iterator();
    	MySimpleLinkedList aux = new MySimpleLinkedList();
    	
    	//O(n) * O(1) -> O(n) donde n es el tamanio de la lista
    	while (it.hasNext()) {
    		aux.insertFront(it.next()); //O(1)
    	}
    	
    	return aux;
    }
	
	
	@Override
	public MyIterator iterator() {
		return new MyIterator(first);
	}

}





