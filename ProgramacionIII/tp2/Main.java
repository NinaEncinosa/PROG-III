package ProgramacionIII.tp2;

public class Main {

	public static void main(String[] args) {
		
		TreeWithNode tree = new TreeWithNode();
		
		tree.add(6);
		
		tree.add(2);
		
		tree.add(8);
		
		tree.add(1);
		
		tree.add(4);
		
		tree.add(3);
		
		System.out.print("Pre order: ");
		tree.printPreOrder();
		System.out.println();

		System.out.print("Pos order: ");
		tree.printPosOrder();
		System.out.println();

		System.out.print("In order: ");
		tree.printInOrder();
		System.out.println();

		System.out.println();
		System.out.println("El arbol esta vacio? -> " + tree.isEmpty());
		
		System.out.println();
		System.out.println("Mayor elemento del arbol -> " + tree.getMaxElem());
		
		System.out.println();
		int elem = 7;
		System.out.println("El arbol tiene el numero " + elem + " ?  -> " + tree.hasElem(elem));
		
		System.out.println();
		elem = 4;
		System.out.println("El arbol tiene el numero " + elem + " ?  -> " + tree.hasElem(elem));
		
		System.out.println();
		System.out.println("La altura del arbol es: " + tree.getHeight());
		
		
		//TESTS DE CASOS DE BORRADO:
		elem = 30;
		System.out.println();
		System.out.println("CASO 0: Borrar elemento que no existe -> " + elem + " pudo? -> " + tree.delete(elem));
		System.out.print("In order: ");
		tree.printInOrder();
		System.out.println();
		
		elem = 3;
		System.out.println();
		System.out.println("CASO 1: Borro nodo hoja -> " + elem + " pudo? -> " + tree.delete(elem));
		System.out.print("In order: ");
		tree.printInOrder();
		System.out.println();
		tree.add(elem);
		
		
		elem = 4;
		System.out.println();
		System.out.println("CASO 2: Borro nodo con 1 solo hijo -> "+ elem + " pudo? -> " + tree.delete(elem));
		System.out.print("In order: ");
		tree.printInOrder();
		System.out.println();
		tree.add(elem);
		
		elem = 2;
		System.out.println();
		System.out.println("CASO 3: Borro nodo con 2 hijos -> "+ elem + " pudo? -> " + tree.delete(elem));
		System.out.print("In order: ");
		tree.printInOrder();
		System.out.println();
		tree.add(elem);
		
		//
		
	}

}
