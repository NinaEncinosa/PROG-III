package ProgramacionIII.tp2;

import java.util.ArrayList;

public class TreeWithNode {
	
	private TreeNode root;
	
	//O(1)
	public TreeWithNode() {
		root = null;
	}
	
	//El metodo add tiene complejidad O(h) por lo que este metodo sera tambien O(h)
	//En el peor de los casos el arreglo pasado como parametro esta ordenado y el arbol resultante termina siendo un arbol enredadera
	//O(h) siendo h la altura del arbol
	public TreeWithNode(int[] valoresIniciales) {
		for (int i = 0; i < valoresIniciales.length; i++) {
			this.add(valoresIniciales[i]);
		}
	}

	//O(1)
	public int getRoot() {
		if (root != null)
			return root.getValue();
		else 
			return -100000000;  //valor discernible
	}
	
	//En el peor de los casos el elemnto a buscar no existe y es mayor al nodo hoja de la rama mas larga 
	//O(h) donde h es la altura del arbol
	public boolean hasElem(int elem) {
		if (!isEmpty())
			return hasElem(root,elem);
		else 
			return false;
	}

	//O(h) donde h es la altura del arbol
	private boolean hasElem(TreeNode node, int elem) {
		//O(1)
		if (node == null)
			return false;
		//O(h) siendo h la altura del arbol, en el peor de los casos hago recursion hasta el nodo mas abajo de la rama mas larga
		else {
			if (node.getValue() == elem)
				return true;
			else if (node.getValue() < elem) 
				return hasElem(node.getRight(),elem);
			
			else 
				return hasElem(node.getLeft(),elem);		
		}
	}
	
	//O(1)
	public boolean isEmpty() {
		return root == null;
	}

	//O(h) donde h es la altura del arbol, en el peor de los casos agrego un nodo en la rama mas larga
	public void insert (int elem) {
		add(elem);
	}
	
	//O(h) donde h es la altura del arbol, en el peor de los casos agrego un nodo en la rama mas larga
	public void add(int value) {
		//O(1)
		if (this.root == null) {
			this.root = new TreeNode(value);
		}
		//O(h) donde h es la altura del arbol, en el peor de los casos agrego un nodo en la rama mas larga
		else
			this.add(this.root,value);
	}
	
	//O(h) siendo h la altura del arbol
	private void add(TreeNode actual, int value) {
		//llamo recursivamente por la rama izquierda
		if (actual.getValue() > value) {
			//O(1)
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} 
			//O(h) siendo h la altura del arbol, supongo peor de los casos voy a la rama izquierda mas larga
			else
				add(actual.getLeft(),value);
			
		}
		//llamo recursivamente por la rama derecha
		else if (actual.getValue() < value) { //con el if controlo que no agregue valores repetidos en el arbol
			//O(1)
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			}
			//O(h) siendo h la altura del arbol, supongo peor de los casos voy a la rama derecha mas larga
			else 
				add(actual.getRight(),value);
		}
	}
	
	//O(n) siendo n la cantidad de nodos
	public int getHeight() {
		//Si esta vacio no tiene altura, return 0
		//O(1)
		if (isEmpty()) {
			return 0;
		}
		//O(n) siendo n la cantidad de nodos
		return getHeight(this.root); 
	}

	//Hago llamado recursivo calculando la altura de ambas ramas, izquierda y derecha, luego comparo ambas alturas y devuelvo la mayor
	//Al no ser "else if.." implica que recorro si o si ambas ramas mientras tengan hijos
	//O(n) siendo n la cantidad de nodos
	private int getHeight(TreeNode node) {
		int hIzq = 0;
		int hDer = 0;

		//rama mas larga izquierda
		//Llamado recursivo por la rama izquierda
		if (node.getLeft() != null) {
			hIzq += getHeight(node.getLeft()) + 1;
		}

		//rama mas larga derecha
		//Llamado recursivo por la rama derecha
		if (node.getRight() != null) {
			hDer += getHeight(node.getRight()) + 1;
		}
		
		//O(1)
		if (hIzq < hDer)
			return hDer;
		//O(1)
		else
			return hIzq;
		
	}
	
	//O(n) siendo n la cantidad de nodos del arbol
	public void printPosOrder() {
		printPosOrder(this.root);
	}

	//Recorro todos los nodos de manera recursiva
	//O(n) siendo n la cantidad de nodos del arbol
	private void printPosOrder(TreeNode node) {
		if (node == null) 
			return;
		printPosOrder(node.getLeft());
		printPosOrder(node.getRight());
		System.out.print(node.getValue() + ", ");
	}
	
	//O(n) siendo n la cantidad de nodos del arbol
	public void printPreOrder() {
		printPreOrder(this.root);
	}
	
	//Recorro todos los nodos de manera recursiva
	//O(n) siendo n la cantidad de nodos del arbol
	private void printPreOrder(TreeNode node) {
		if (node == null) {
			System.out.print(" - ");
			return;	
		}
		System.out.print(node.getValue() + " ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	//O(n) siendo n la cantidad de nodos del arbol
	public void printInOrder() {
		printInOrder(this.root);
	}
	
	//Recorro todos los nodos de manera recursiva
	//O(n) siendo n la cantidad de nodos del arbol
	private void printInOrder(TreeNode node) {
		if (node == null)
			return;
		printInOrder(node.getLeft());
		System.out.print(node.getValue() + ", ");
		printInOrder(node.getRight());
	}
	
	//O(n) siendo n la cantidad de nodos del arbol
	public ArrayList<Integer> getLongestBranch() {
		//O(1)
		if (isEmpty())
			return new ArrayList <Integer> ();
		//O(n) siendo n la cantidad de nodos
		else {
			return getLongestBranch(root);
		}
	}

	//Debo recorrer recursivamente ambas ramas del arbol, izquierda y derecha, agregando nodos en las listas resultantes (hIzq, hDer) 
	//y quedandome con la lista de mayor tamanio
	//O(n) siendo n la cantidad de nodos
	private ArrayList<Integer> getLongestBranch(TreeNode node) {
		
		ArrayList<Integer> hIzq = new ArrayList <Integer> ();
		ArrayList<Integer> hDer = new ArrayList <Integer> ();
		
		hIzq.add(node.getValue());
		hDer.add(node.getValue());
			
		//rama mas larga izquierda
		if (node.getLeft() != null) {
			hIzq.addAll(getLongestBranch(node.getLeft()));
		}
		//rama mas larga derecha
		if (node.getRight() != null) {
			hDer.addAll(getLongestBranch(node.getRight()));
		}

		if (hIzq.size() < hDer.size())
			return hDer;
		else
			return hIzq;

	}
	
	//O(n) siendo n la cantidad de nodos del arbol
	public  ArrayList<Integer> getFrontera(){
		//O(1)
		if (isEmpty())
			return new ArrayList <Integer> ();
		//O(n) siendo n la cantidad de nodos del arbol
		else
			return getFrontera(root);
	}
	
	//Debo recorrer recursivamente ambas ramas, izq y derecha, para encontrar todos los nodos "hoja"
	//O(n) siendo n la cantidad de nodos del arbol
	private  ArrayList<Integer> getFrontera(TreeNode node){
		ArrayList<Integer> list = new ArrayList<Integer> ();
		
		if (node != null) {
			//Cuando encuentro un nodo hoja lo agrego a la lista resultante
			if(node.isLeaf())
				list.add(node.getValue());	
			//El nodo en el que estoy parada tiene hijo izq o derecho, llamo recursivamente por ambas ramas hasta dar con un nodo hoja
			else {
				list.addAll(getFrontera(node.getLeft()));
				list.addAll(getFrontera(node.getRight()));
			}
		}	
		return list;
	}
	
	//En el peor de los casos el elemento mas grande del arbol es tambien el nodo hoja de la rama mas larga
	//O(h) siendo h la altura del arbol
	public int getMaxElem() {
		//O(1)
		if (isEmpty())
			return 0;
		//O(h) siendo h la altura del arbol
		else 
			return getMaxElem(root);
	}
	
	//O(h) siendo h la altura del arbol 
	private int getMaxElem(TreeNode node) {	
		//Condicion de corte, no hay valores mas grandes en el arbol
		if (node.getRight() == null)
			return node.getValue();
		//Llamado recursivo por la rama derecha hasta topar con el nodo mas derecho/grande
		else
			return getMaxElem(node.getRight());
	}
	
	//Recorro tanto la rama derecha como la izq de manera recursiva
	//En el peor de los casos me piden los elementos del ultimo nivel del arbol para lo cual debo haber previamente recorrido todo el arbol
	//O(n) siendo n la cantidad de nodos
	public ArrayList<Integer> getElemAtLevel(int level){
		//O(1)
		if(isEmpty())
			return new ArrayList <Integer> ();
		//O(n) siendo n la cantidad de nodos del arbol
		else {
			int currentLevel = 0;
			return getElemAtLevel(root,currentLevel,level);
		}
	}
	
	//Recorro tanto la rama derecha como la izq de manera recursiva
	//O(n) siendo n la cantidad de nodos
	private ArrayList<Integer> getElemAtLevel(TreeNode node,int currentLevel, int level){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//Condicion de corte, estoy en un nodo en el mismo nivel que el pedido por parametro, lo agrego a la lista salida
		//O(1)
		if((currentLevel == level) && (node != null)){
			list.add(node.getValue());
			return list;
		}
		//Estoy en un nodo de menor nivel que el pedido por parametro, llamo recursivamente a las ramas hijas izq y derecha hasta dar con la altura 
		else if ((currentLevel < level) && (node != null)) {
			currentLevel++;
			list.addAll(getElemAtLevel(node.getLeft(),currentLevel,level));
			list.addAll(getElemAtLevel(node.getRight(),currentLevel,level));
		}
		
		return list;
	}
	
	//En el peor de los casos el nodo a borrar es el root de un arbol con 2 hijos en el que su NMI de la rama derecha es el nodo hoja de la rama mas larga
	//O(h) siendo h la altura del arbol
	public boolean delete (int elem) {
		//O(1)
   		if (isEmpty())
			return false;
   		//O(h) siendo h la altura del arbol
		else
			return delete(root,root,elem);
	}

	//En el peor de los casos el nodo a borrar es el root de un arbol con 2 hijos en el que su NMI es la rama mas larga
	//O(h) siendo h la rama mas larga
	private boolean delete (TreeNode parentNode, TreeNode node, int elem) {
		boolean estaba = false;
		
		//Checkeo que el nodo en el que estoy parada no sea null
		if(node != null) {
			//Momento en el que encuentro el nodo a borrar
			if (node.getValue() == elem) {
				//Analizo los 3 posibles casos..
				
				//CASO 1: El nodo a borrar es hoja
				//Al nodo padre le borro segun corresponda, la rama izquierda o la derecha
				//O(1)
				if(node.isLeaf()) 
					deleteLeaf(parentNode,elem);
				
				//CASO 2: El nodo a borrar tiene SOLO 1 rama hija
				//O(1)
				else if((node.getLeft() == null) || (node.getRight() == null)) {
					//Pregunto si esa unica rama hija es derecha o izquierda
					//Reemplazo el nodo a borrar por su nodo hijo der/izq segun corresponda
					if(node.getValue() > parentNode.getValue()) 
							parentNode.setRight(getNodeFromOnlyBranchDown(node));
						else 
							parentNode.setLeft(getNodeFromOnlyBranchDown(node));
					}
				
				//CASO 3: El nodo a borrar tiene 2 ramas hijas
				//Busco el nodo mas izquierdo de la rama derecha al nodo a borrar, lo guardo en una variable
				//Borro ese NMI en su ubicacion actual, llamado recursivo
				//Inserto el valor guardado en la variable (NMI) en la ubicacion del nodo a borrar 
				else {
					int nmi = NMI(node.getRight());
					delete(nmi);
					node.setValue(nmi);		
				}
				
				//Si o si en alguno de los 3 casos anteriores contemple al nodo encontrado para borrar, por lo que el metodo ahora retornara true
				estaba = true;
			}
			
			//No encontre aun el nodo a borrar
			//Llamo recursivamente por la rama izq o por la rama derecha segun corresponda 
			//En el peor de los casos el nodo a borrar es el mas grande que el nodo de la rama mas larga (recorreria la altura maxima y no lo encontraria)
			//O(h) siendo h la altura del arbol
			else {
				if(node.getValue() > elem)
					estaba = delete(node,node.getLeft(),elem);
				else 
					estaba = delete(node,node.getRight(),elem);
			}
		}
		
		return estaba;
	}
	
	//Llega como parametro el nodo padre del nodo hoja a borrar, checkeo si el nodo hoja es hijo izq o derecho de su padre y borro su valor
	//O(1)
	private void deleteLeaf (TreeNode parentNode, int elem) {
		//El nodo a borrar era hijo izquierdo, lo borro
		if ((parentNode.getLeft() != null) && (parentNode.getLeft().getValue() == elem)){
			parentNode.setLeft(null);
		}
		//El nodo a borrar era hijo derecho, lo borro
		else
			parentNode.setRight(null);	
	}
	
	//LLamo a este metodo UNICAMENTE desde el metodo delete en el CASO 2, donde ya se que solo uno de los 2 nodos hijos si o si es null
	//Devuelve el nodo hijo que no es null (este nodo es el que va a reemplazar el nodo a borrar)
	//O(1)
	private TreeNode getNodeFromOnlyBranchDown (TreeNode node) {
		if(node.getLeft() != null) 
			return node.getLeft();
		return node.getRight();
	}

	//En el peor de los casos el NMI es el nodo hoja de la rama mas larga del arbol
	//O(h) siendo h la rama mas larga 
	private int NMI(TreeNode node) {	
		//Llamado recursivo por la rama izquierda
        if(node.getLeft() != null) {	
            return NMI(node.getLeft());
        }
        //Condicion de corte, no hay mas nodos izquierdos hijos
        return node.getValue();
    }
    
	
}
