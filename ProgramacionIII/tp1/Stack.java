package ProgramacionIII.tp1;

public class Stack {
	
    private MySimpleLinkedList pila;
	 
	
    public Stack() {
        this.pila = new MySimpleLinkedList();
    }

    //EJ 3. Agregar elementos a la pila
    //O(1)
    public void push(Integer elem){
        this.pila.insertFront(elem);
    }
    
    //EJ 3. Retorna el último elemento agregado a la pila y lo elimina de la misma
    //O(1)
    public Integer pop(){
        return this.pila.extractFront();
    }
    
    //EJ 3. Consultar el tope de la pila (sin eliminarlo)
    //O(1) por mas que el metodo get sea O(n), en este caso no importa el tamanio de la pila
    public Integer top(){ 
        return pila.get(0);       
    }

    //EJ 3. Invertir el orden de la pila
    //O(n) siendo n el tamanio de la pila
    public void reverse(){
        MySimpleLinkedList aux = new MySimpleLinkedList();
        Integer info;
        
        //O(n) siendo n el tamanio de la lista
        while(!this.pila.isEmpty()){
        	info = this.pila.extractFront();	//O(1)
            aux.insertFront(info);	//O(1)
        }
        
        this.pila = aux;
    }
    
    
}
