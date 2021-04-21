package ProgramacionIII.tp2;

public class Main {

	public static void main(String[] args) {
		
		TreeWithNode tree = new TreeWithNode();
		
		tree.add(5);
		
		tree.add(2);
		
		tree.add(7);
		
		tree.add(3);
		
		tree.add(9);
		
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
		
		
		
		
	}

}
