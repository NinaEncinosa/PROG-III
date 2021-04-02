package ProgramacionIII.tp1;

public class Stack {
	
    private MySimpleLinkedList pila;
	 
	
    public Stack() {
        this.pila = new MySimpleLinkedList();
    }

    public Object top(){
        if(pila.isEmpty())
        	return null;   
        return pila.get(0);       
    }

    public void push(Object o){
        this.pila.insertFront(o);
    }

    public Object pop(){
        return this.pila.extractFront();
    }
	
    public void reverse(){
        MySimpleLinkedList aux = new MySimpleLinkedList();
        while(!this.pila.isEmpty()){
            Object info = this.pila.extractFront();
            aux.insertFront(info);
        }
        this.pila = aux;
    }
    
    public int size() {
    	return this.pila.size();
    }

}
