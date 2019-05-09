package btreeLab;

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
	
	void printPreOrder()   { preOrder(root);   }
    void printInOrder()    { inOrder(root);    }
    void printPostOrder()  { postOrder(root);  } 
    void printLevelOrder() { levelOrder(root); }
    void remove(int key)   { removeNumRec(root, key); }
    boolean search(int key) { return search(root, key); }
	
	private void preOrder(TNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private void inOrder(TNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	private void postOrder(TNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(root.data + " ");
	}
	
	private void levelOrder(TNode root) {
		int height = maxDepth(root);
		for(int i = 0; i <= height; i++) {
			printCurrentLevel(root, i);
		}
	}
	
	private void printCurrentLevel(TNode root, int level) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root.data + " ");
		} else if(level > 1) {
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
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

	private boolean search(TNode node, int key) {  
	    if (node == null) {
	    	return false;
	    }
	    
	    if (node.data == key) {
	    	return true;	
	    }
	    boolean res1 = search(node.left, key);    
	    boolean res2 = search(node.right, key);
	    
	    return res1 || res2;
	}
	
	int minValue(TNode root){
		int min = root.data;
		while (root.left != null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	} 
	
	private TNode removeNumRec(TNode root, int key) {
		if (root == null) {
	    	return root;
	    }
		
		if (key < root.data) {
            root.left = removeNumRec(root.left, key);
		}
        else if (key > root.data) {
            root.right = removeNumRec(root.right, key);
        }else {
        	if(root.left == null) {
        		return root.right;
        	}else if(root.right == null) {
        		return root.left;
        	}
        	root.data = minValue(root.right);
        	removeNumRec(root.right, root.data);
        }
		return root;
	}
	
	class TNode {
		int data;
		TNode left, right;
		
		TNode(int input){
			this.data = input;
		}
	}
}
