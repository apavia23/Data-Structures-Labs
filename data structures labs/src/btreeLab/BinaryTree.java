package btreeLab;

import lecture.BinaryTree.TNode;

public class BinaryTree {
	TNode root;
	
	public void add(int data) {
		TNode newNode = new TNode(data);
		
		if(root == null) {
			root = newNode;
		}else {
			TNode focusNode = root;
			TNode parent;
			
			while(true) {
				parent = focusNode;
				if(data < focusNode.data) {
					focusNode = focusNode.left;
					if(focusNode == null) {
						parent.left = newNode;
						return;
					}
				}else {
					focusNode = focusNode.right;
					if(focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}	
	}
	
	void preOrder(TNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	void inOrder(TNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	void postOrder(TNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	int maxDepth(TNode node){ 
		if (node == null) {
        	return 0;
        }else {
        	int lDepth = maxDepth(node.left);
        	int rDepth = maxDepth(node.right);

        	if (lDepth > rDepth) {
        		return (lDepth + 1); 
        	}else {
        		return (rDepth + 1);
        	}
        }
	}

	int search(TNode root, int x) throws NullPointerException {
		if(root == null) {
			throw new NullPointerException("Data Tree Doesn't Exist");
		}
		if(root.data != x) {
			if(x <= root.data) {
				search(root.left, x);
			}else {
				search(root.right, x);
			}
		}else {
			return x;
		}
	}
	
	class TNode {
		int data;
		TNode left, right;
		
		TNode(int input){
			this.data = input;
		}
	}
}
