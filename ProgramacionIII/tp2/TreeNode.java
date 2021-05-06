package ProgramacionIII.tp2;

public class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;

	//O(1)
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	//O(1)
	public TreeNode getLeft() {
		return left;
	}
	
	//O(1)
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	//O(1)
	public TreeNode getRight() {
		return right;
	}

	//O(1)
	public void setRight(TreeNode right) {
		this.right = right;
	}

	//O(1)
	public int getValue() {
		return value;
	}
	
	//O(1)
	public void setValue(int value) {
		this.value = value;
	}
	
	//O(1)
	public boolean isLeaf() {
		return ((this.getLeft() == null) && (this.getRight() == null));
	}


	
}
