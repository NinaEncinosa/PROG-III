package ProgramacionIII.tp2;

public class Main {

	public static void main(String[] args) {

		int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
		TreeWithNode miArbol = new TreeWithNode(valoresIniciales);

		miArbol.printPreOrder();
		System.out.println( );
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2));
		System.out.println( miArbol.getFrontera() );

		miArbol.add(23);
		miArbol.add(3);
		miArbol.delete(6);
		miArbol.delete(30);

		miArbol.printPreOrder();
		System.out.println( );
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

		miArbol.add(65);
		miArbol.delete(5);
		miArbol.delete(15);
		miArbol.add(55);

		miArbol.printPreOrder();
		System.out.println( );
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElemAtLevel(2) );
		System.out.println( miArbol.getFrontera() );
		
		
		
		//ERRORES MARCADOS EN LA DEVOLUCION:
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("ERRORES MARCADOS EN LA DEVOLUCION: ");
		System.out.println("");
		
		//1) Si el arbol tiene un elemento y lo quiero borrar no lo hace
		
		System.out.println("Arbol con solo una hoja y la borro:");
		System.out.println("");
		
		int[] valoresInicialesE1 = new int[] {10};
		TreeWithNode miArbolErrorUno = new TreeWithNode(valoresInicialesE1);
		
		miArbolErrorUno.printPreOrder();
		System.out.println();
		
		miArbolErrorUno.delete(10);
		
		miArbolErrorUno.printPreOrder();
		System.out.println();
		
		//2)Si el arbol tiene dos elementos (10, 2) y quiero borrar la raiz no lo hace, lo mismo para (10,11), fijarse para este ultimo caso que repite el 11 cuando quiero borrar el 10.


		System.out.println("Arbol con solo una hoja y una rama hija, borro root:");
		System.out.println(" ");
		System.out.println(" # ejemplo 1 (10,2) #");
		
		int[] valoresInicialesE2 = new int[] {10,2};
		TreeWithNode miArbolErrorDos = new TreeWithNode(valoresInicialesE2);
		
		miArbolErrorDos.printPreOrder();
		System.out.println();
		
		miArbolErrorDos.delete(10);
		
		miArbolErrorDos.printPreOrder();
		System.out.println();
		
		System.out.println(" ");
		System.out.println(" # ejemplo 2 (10,11) #");
		
		valoresInicialesE2 = new int[] {10,11};
		miArbolErrorDos = new TreeWithNode(valoresInicialesE2);
		
		miArbolErrorDos.printPreOrder();
		System.out.println();
		
		miArbolErrorDos.delete(10);
		
		miArbolErrorDos.printPreOrder();
		System.out.println();
		
		
		//3)Si el arbol tiene 3 elementos (10,2,5) o (10, 9, 8) y quiero borrar la raiz no lo hace lo mismo para (10, 11, 12),
		//fijarse para este ultimo caso si quiero eliminar el 10 me repite los numeros.
		
		System.out.println("Arbol solo con 3 elementos y borro la raiz:");
		System.out.println(" ");
		System.out.println(" # ejemplo 1 (10,2,5) #");
		
		int[] valoresInicialesE3 = new int[] {10,2,5};
		TreeWithNode miArbolErrorTres = new TreeWithNode(valoresInicialesE3);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		miArbolErrorTres.delete(10);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		System.out.println(" ");
		System.out.println(" # ejemplo 2 (10,9,8) #");
		
		valoresInicialesE3 = new int[] {10,9,8};
		miArbolErrorTres = new TreeWithNode(valoresInicialesE3);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		miArbolErrorTres.delete(10);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		System.out.println(" ");
		System.out.println(" # ejemplo 3 (10,11,12) #");
		
		valoresInicialesE3 = new int[] {10,11,12};
		miArbolErrorTres = new TreeWithNode(valoresInicialesE3);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		miArbolErrorTres.delete(10);
		
		miArbolErrorTres.printPreOrder();
		System.out.println();
		
		
	}

}
