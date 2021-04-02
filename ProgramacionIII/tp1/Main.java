package ProgramacionIII.tp1;

public class Main {

	public static void main(String[] args) {
		
		MySimpleLinkedList lista = new MySimpleLinkedList();
		
		lista.insertFront(4);
		lista.insertFront(3);
		lista.insertFront(2);
		lista.insertFront(1);
		
		for( int i = 0;i< lista.size(); i++ ) {
			Object info = lista.get(i);
			System.out.println(info);
		}
		
		System.out.println("tamano pre extraccion:" + lista.size());
		
//		Object nodoExtraido = lista.extractFront();
//		Object nodoExtraido2 = lista.extractFront();
//		Object nodoExtraido3 = lista.extractFront();
//		Object nodoExtraido4 = lista.extractFront();
		
//		System.out.println("extraje el nodo con el valor:" + nodoExtraido);
		System.out.println("tamano post estraccion:" + lista.size());

		System.out.println("Esta vacia la lista? "+ lista.isEmpty());
		
		System.out.println("Esta vacia la lista? "+ lista.isEmpty());
		
		Object infoAbuscar = 1;
		
		System.out.println("el numero " + infoAbuscar + " se excuentra en el index: "+ lista.indexOf(infoAbuscar));
		
		/////////////////////////////	
        Stack pila = new Stack();
        
        pila.push(44);
        pila.push(33);
        pila.push(22);
        pila.push(11);
        System.out.println("creo la pila");
        
        System.out.println("El tamaño de la pila es: "+ pila.size());
        
        pila.reverse();
        
        Object primeroEnPila = pila.top();
        
        System.out.println("el primer elemento de la pila es: "+ primeroEnPila);
        
//        System.out.println("El tamaño de la pila es: "+ pila.size());
//
//        System.out.println(pila.pop());
//        System.out.println(pila.pop());
//        System.out.println(pila.pop());
//        System.out.println(pila.pop());
		
	}

}
