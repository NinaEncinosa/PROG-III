package ProgramacionIII.tp2;

import java.util.List;

public class TreeWithNode {
	
	private TreeNode root;
	private int cantNodos;
	
	public TreeWithNode() {
		this.root = null;
		this.cantNodos = 0;
	}
	
//	private Object getRoot() {
//		return this.root;
//	}
	
	public boolean hasElem(int elem) {
		if (!isEmpty())
			return hasElem(root,elem);
		else 
			return false;
	}
	
	private boolean hasElem(TreeNode node, int elem) {
		if (node == null)
			return false;
		
		else {
			if (node.getValue() == elem)
				return true;
			else if (node.getValue() < elem) 
				return hasElem(node.getRight(),elem);
			
			else return hasElem(node.getLeft(),elem);
			
		}
	}
	
	public boolean isEmpty() {
		return cantNodos == 0;
	}
	
	public void insert (int elem) {
		add(elem);
	}
	
	public void add(int value) {
		if (this.root == null) {
			this.root = new TreeNode(value);
			this.cantNodos++;
		}else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, int value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
				this.cantNodos++;
			} else {
				add(actual.getLeft(),value);
			}
		} else {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
				this.cantNodos++;
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	
	public boolean delete (int elem) {
		//TODO
		return false;
	}
	
	public int getHeight() {
		//TODO
		return -1;
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
	
	public List<Integer> getLongestBranch() {
		//TODO
		return null;
	}
	
	public  List<Integer> getFrontera(){
		//TODO
		return null;
	}
	
	public int getMaxElem() {
		if (!isEmpty())
			return getMaxElem(root);
		else 
			return 0;
	}
	
	private int getMaxElem(TreeNode node) {	
		if (node.getRight() == null)
			return node.getValue();
		else
			return getMaxElem(node.getRight());
	}
	
	
	public List<Integer> getElemAtLevel(int level){
		//TODO
		return null;
	}
	
}
