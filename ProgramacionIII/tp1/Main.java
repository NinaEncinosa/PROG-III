package ProgramacionIII.tp1;

public class Main {

	public static void main(String[] args)  {
		
//		EJEMPLO 1:
//		Lista de entrada = [] Valor umbral: 10
//		Lista de salida = [] // No devuelve nada (una lista vacía)
		
		MySimpleLinkedList lista1 = new MySimpleLinkedList();

		int umbral1 = 10;
			
		MySimpleLinkedList listaConSecs1 = contarSecuenciasHastaUmbral(lista1,umbral1);
		
		System.out.println("Ej1 lista entrada:");
		imprimirLista(lista1);
		
		System.out.println("Umbral entrada: " + umbral1);
		System.out.println("----------------------------------------");
		
		System.out.println("Lista resultante:");
		imprimirLista(listaConSecs1);
		
		System.out.println("========================================");
		System.out.println("");
		
		
//		EJEMPLO 2:	
//		Lista de entrada = [1, 2, 3] Valor umbral: 10
//		Lista de salida = [6] // Todos los valores de la lista

		MySimpleLinkedList lista2 = new MySimpleLinkedList();

		int umbral2 = 10;
		
		
		lista2.insertFront(3);
		lista2.insertFront(2);
		lista2.insertFront(1);
		
		MySimpleLinkedList listaConSecs2 = contarSecuenciasHastaUmbral(lista2,umbral2);
		
		System.out.println("Ej2 lista entrada:");
		imprimirLista(lista2);
		
		System.out.println("Umbral entrada: " + umbral2);
		System.out.println("----------------------------------------");
		
		System.out.println("Lista resultante:");
		imprimirLista(listaConSecs2);
		
		System.out.println("========================================");
		System.out.println("");
		
//		EJEMPLO 3:
//		Lista de entrada = [1, 2, 3] Valor umbral: 2
//		Lista de salida = [1, 2] // Dos elementos, el 3 como sub-secuencia supera el valor umbral.

		MySimpleLinkedList lista3 = new MySimpleLinkedList();

		int umbral3 = 2;
		
		
		lista3.insertFront(3);
		lista3.insertFront(2);
		lista3.insertFront(1);
		
		MySimpleLinkedList listaConSecs3 = contarSecuenciasHastaUmbral(lista3,umbral3);
		
		System.out.println("Ej3 lista entrada:");
		imprimirLista(lista3);
		
		System.out.println("Umbral entrada: " + umbral3);
		System.out.println("----------------------------------------");
		
		System.out.println("Lista resultante:");
		imprimirLista(listaConSecs3);
		
		System.out.println("========================================");
		System.out.println("");
		
//		EJEMPLO 4:
//		Lista de entrada = [3, 5, 2, 7, 19, 14, 28] Valor umbral: 10
//		Lista de salida = [10, 7] // Los valores surgen de las sub-secuencias [3,5,2]; [7]; 
		
		MySimpleLinkedList lista4 = new MySimpleLinkedList();

		int umbral4 = 10;
		
		
		lista4.insertFront(28);
		lista4.insertFront(14);
		lista4.insertFront(19);
		lista4.insertFront(7);
		lista4.insertFront(2);
		lista4.insertFront(5);
		lista4.insertFront(3);
		
		MySimpleLinkedList listaConSecs4 = contarSecuenciasHastaUmbral(lista4,umbral4);
		
		System.out.println("Ej4 lista entrada:");
		imprimirLista(lista4);
		
		System.out.println("Umbral entrada: " + umbral4);
		System.out.println("----------------------------------------");
		
		System.out.println("Lista resultante:");
		imprimirLista(listaConSecs4);
		
		System.out.println("========================================");
		System.out.println("");
		
//		EJEMPLO 5:	
//		Lista de entrada = [3, 5, 4, 2, 7, 15, 14, 28] Valor umbral: 15
//		Lista de salida = [14,7,15,14] // Los valores surgen de las sub-secuencias [3,5,4,2]; [7]; [15];[14]
		
		MySimpleLinkedList lista5 = new MySimpleLinkedList();

		int umbral5 = 15;
		
		
		lista5.insertFront(28);
		lista5.insertFront(14);
		lista5.insertFront(15);
		lista5.insertFront(7);
		lista5.insertFront(2);
		lista5.insertFront(4);
		lista5.insertFront(5);
		lista5.insertFront(3);
		
		MySimpleLinkedList listaConSecs5 = contarSecuenciasHastaUmbral(lista5,umbral5);
		
		System.out.println("Ej5 lista entrada:");
		imprimirLista(lista5);
		
		System.out.println("Umbral entrada: " + umbral5);
		System.out.println("----------------------------------------");
		
		System.out.println("Lista resultante:");
		imprimirLista(listaConSecs5);
		
		System.out.println("========================================");
		
	
	}	
	
	public static void imprimirLista (MySimpleLinkedList lista) {
		MyIterator it = lista.iterator();
		
		while (it.hasNext())
			System.out.print(it.next() + " | ");
		
		System.out.println("");
		System.out.println("----------------------------------------");
	}
	
	//ENTREGABLE: Dada una lista crear otra con sumatoria de subsecuencias hasta un valor umbral dado.
	//O(n)  siendo n el tamanio de la lista
	public static MySimpleLinkedList contarSecuenciasHastaUmbral (MySimpleLinkedList list, int umbral) {
		
		MySimpleLinkedList listaSalida = new MySimpleLinkedList();
		MyIterator it = list.iterator();
		int suma = 0;
		boolean ingresoAlgo = false; 
		
		//O(n) * ( O(1) + O(1) ) -> O(n) siendo n el tamanio de la lista pasada por parametro
		while (it.hasNext()){
			//Sumatoria hasta valor umbral
			//Mismo O(n) del while exterior, no suma complejidad
			while((it.hasNext()) && (((suma + it.get()) <= umbral)) ){
				suma += it.next(); //O(1), complejidad constante
				ingresoAlgo = true;
			}
			
			//O(1)
			if(ingresoAlgo) { // considero caso de valores negativos en la lista origen
				listaSalida.insertLast(suma); //O(1), metodo independiente al largo de la lista
				suma = 0;
				ingresoAlgo = false;
			}
			
			//O(1) 
			if((it.hasNext() && ((suma + it.get()) > umbral))) { 
				it.moveNext(); //O(1), una sola consulta
			}
		} 
			
		return listaSalida;
	}
	
}


