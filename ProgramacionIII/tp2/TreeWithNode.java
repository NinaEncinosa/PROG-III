package ProgramacionIII.tp2;

import java.util.ArrayList;

public class TreeWithNode {
	
	private TreeNode root;
	private int cantNodos;
	
	public TreeWithNode() {
		this.root = null;
		this.cantNodos = 0;
	}

	//O(1)
	public int getRoot() {
		return this.root.getValue();
	}
	
	//O(h) donde h es la altura del arbol
	public boolean hasElem(int elem) {
		if (!isEmpty())
			return hasElem(root,elem);
		else 
			return false;
	}

	//complejidad depende de la altura del arbol (no importa si es un ABB o un AB)
	//O(h) donde h es la altura del arbol
	//si fuese ABB seria O(log n) donde n es la cantidad de nodos, equivalente a decir tambien O(h)
	private boolean hasElem(TreeNode node, int elem) {
		if (node == null)
			return false;
		
		else {
			if (node.getValue() == elem)
				return true;
			else if (node.getValue() < elem) 
				return hasElem(node.getRight(),elem);
			
			else return hasElem(node.getLeft(),elem);
			
			//caso que NO es un ABB, el segundo else se vuelve esto nomas:
			//complejidad O(n) siendo n la cantidad de nodos, recorro todo el arbol, seria mas tipo una lista
			//return (hasElem(node.getRight(),elem) || hasElem(node.getLeft(),elem));
			
		}
	}
	
	//O(1)
	public boolean isEmpty() {
		return cantNodos == 0;
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
			this.cantNodos++;
		}
		else
			//O(h) donde h es la altura del arbol, en el peor de los casos agrego un nodo en la rama mas larga
			this.add(this.root,value);
	}
	
	//O(h) siendo h la altura del arbol
	private void add(TreeNode actual, int value) {
		if (actual.getValue() > value) {
			//O(1)
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
				this.cantNodos++;
			} 
			else
				//O(h) siendo h la altura del arbol, supongo peor de los casos voy a la rama izquierda mas larga
				add(actual.getLeft(),value);
			
		} else {
			//O(1)
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
				this.cantNodos++;
			} else 
				//O(h) siendo h la altura del arbol, supongo peor de los casos voy a la rama derecha mas larga
				add(actual.getRight(),value);
		}
	}
	
	//O(h) siendo h la altura del arbol
	public int getHeight() {
		// si es vacia no tiene altura
		//O(1)
		if (isEmpty()) {
			return 0;
		}
		//O(h) siendo h la altura del arbol
		return getHeight(this.root); 
	}

	//O(h) siendo h la altura del arbol
	private int getHeight(TreeNode node) {
		int hIzq, hDer;
		
		//condicion de corte
		if (node.isLeaf()) {
			return 1;
		} 
		
		else {
			//ya se que al menos hay 1 elemento
			hIzq = 1;
			hDer = 1;
			//rama mas larga izquierda
			if (node.getLeft() != null) {
				hIzq += getHeight(node.getLeft());
			}

			//rama mas larga derecha
			if (node.getRight() != null) {
				hDer += getHeight(node.getRight());
			}
			
			if (hIzq < hDer)
				return hDer;
			
			return hIzq;
		}
	}
	
	
	public void printPosOrder() {
		printPosOrder(this.root);
	}

	private void printPosOrder(TreeNode node) {
		if (node == null) 
			return;
		printPosOrder(node.getLeft());
		printPosOrder(node.getRight());
		System.out.print(node.getValue() + ", ");
	}
	
	public void printPreOrder() {
		printPreOrder(this.root);
	}
	
	private void printPreOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + ", ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	public void printInOrder() {
		printInOrder(this.root);
	}
	
	private void printInOrder(TreeNode node) {
		if (node == null)
			return;
		printInOrder(node.getLeft());
		System.out.print(node.getValue() + ", ");
		printInOrder(node.getRight());
	}
	
	public ArrayList<Integer> getLongestBranch() {
		//TODO
		return null;
	}
	
	public  ArrayList<Integer> getFrontera(){
		//TODO
		return null;
	}
	
	//O(log n) siendo n la cantidad de nodos
	public int getMaxElem() {
		if (isEmpty())
			return 0;
		else 
			return getMaxElem(root);
	}
	
	//O(h) siendo h la altura del arbol. 
	//En el peor de los casos, el nodo que delimita la altura es el NMD (el nodo mas derecho, el nodo con mayor valor del arbol)
	private int getMaxElem(TreeNode node) {	
		if (node.getRight() == null)
			return node.getValue();
		else
			return getMaxElem(node.getRight());
	}
	
	
	public ArrayList<Integer> getElemAtLevel(int level){
		//TODO
		return null;
	}
	
	//O(h) siendo h la rama mas larga
	public boolean delete (int elem) {
   		if (isEmpty())
			return false;
		else
			return delete(root,root,false,elem);
	}

	//O(h) siendo h la rama mas larga
	//En el peor de los casos el nodo a borrar es el root de un arbol con 2 hijos en el que su NMI es la rama mas larga
	private boolean delete (TreeNode parentNode, TreeNode node, boolean isRightBranch, int elem) {
		boolean estaba = false;
		
		//O(h) siendo h la rama mas larga
		if(node != null) {
			//O(h) siendo h la rama mas larga
			if (node.getValue() == elem) {
				
				//CASO 1: El nodo a borrar es hoja
				//O(1)
				if(node.isLeaf()) 
					deleteLeaf(parentNode,elem);
				
				//CASO 2: El nodo a borrar tiene solo 1 rama hija
				//O(1)
				else if((node.getLeft() == null) || (node.getRight() == null)) {
						if (isRightBranch)
							parentNode.setRight(getNodeOnlyBranchDown(node));
						else 
							parentNode.setLeft(getNodeOnlyBranchDown(node));
					}
				
				//CASO 3: El nodo a borrar tiene 2 ramas hijas
				//O(h)
				else {
					//O(h) siendo h la rama mas larga
					//En el peor de los casos, quiero borrar el nodo root del arbol, el cual posee 2 hijos y su NMI es la rama mas larga
					int nmi = NMI(node.getRight());
					delete(nmi);
					
					//O(1)
					if(isRightBranch) 
						parentNode.getRight().setValue(nmi);
					
					//O(1)
					else
						parentNode.getLeft().setValue(nmi);	
						
				}	
				
				estaba = true;
			}
			//Llamado recursivo ya sea por la rama izq o por la rama derecha
			//O(h) siendo h la altura del arbol
			//En el peor de los casos el nodo a borrar es el nodo de la rama mas larga (si es que es ese, sino es mas grande/chico y no borra nada)
			else {
				if(node.getValue() > elem)
					estaba = delete(node,node.getLeft(),false,elem);
				else 
					estaba = delete(node,node.getRight(),true,elem);
			}
		}
		
		return estaba;
	}
	
	//O(1)
	private void deleteLeaf (TreeNode node, int elem) {
		if ((node.getLeft() != null) && (node.getLeft().getValue() == elem)){
			node.setLeft(null);
		}
		else
			node.setRight(null);	
	}
	
	//O(1)
	private TreeNode getNodeOnlyBranchDown (TreeNode node) {
		if(node.getLeft() != null) 
			return node.getLeft();
		return node.getRight();
	}

	//O(h) siendo h la rama mas larga 
	//En el peor de los casos el NMI es la rama mas larga del arbol
	private int NMI(TreeNode node) {	
        if(node.getLeft() != null) {	
            return NMI(node.getLeft());
        }
        return node.getValue();
    }
    
	
}
