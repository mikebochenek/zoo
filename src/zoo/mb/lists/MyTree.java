package zoo.mb.lists;

public class MyTree {

	Node root;
	
	String[] testString = {"moscow", "warsaw", "shangai", "chicago", "singapore", "tokyo"};
	
	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.root = tree.new Node("root");
		tree.root.add(tree.new Node("zurich"));
		
		for (int i = 0; i < tree.testString.length; i++) {
			tree.root.add(tree.new Node(tree.testString[i]));
		}
		
		System.out.println("inorder: " + tree.root.inorder(tree.root));
		System.out.println("preorder: " + tree.root.preorder(tree.root));
		System.out.println("postorder: " + tree.root.postorder(tree.root));

		// hmm... I guess this seems sorta correct
//		inorder:  chicago   moscow   root  shangai  singapore  tokyo     warsaw   zurich  
//		preorder:  root  moscow  chicago    zurich  warsaw  shangai  singapore  tokyo      
//		postorder:  chicago   moscow   tokyo   singapore   shangai   warsaw   zurich   root 

	}

	class Node {
		Node(Object o) {
			value = o;
		}
		
		Object value;
		Node left;
		Node right;
		
		void add(Node n) {
			if (n.value.toString().compareTo(value.toString()) < 0) {
				if (left == null) {
					left = n;
				} else {
					left.add(n);
				}
			} else {
				if (right == null) {
					right = n;
				} else {
					right.add(n);
				}
			}
		}	
		
		/**
		 * To traverse a non-empty binary tree in preorder, 
		 * perform the following operations recursively at each node, 
		 * starting with the root node:
		 * 
		 * Visit the root.
		 * Traverse the left subtree.
		 * Traverse the right subtree.
		 */
		public String preorder(Node n) {
			if (n == null) return " null - yikes! ";
			
			String ret = "";
			ret += " " + n.value.toString() + " ";
			if (n.left != null) ret += preorder(n.left) + " ";
			if (n.right != null) ret += preorder(n.right) + " ";
			return ret;
		}
		
	
		/**
		 * To traverse a non-empty binary tree in inorder (symmetric), 
		 * perform the following operations recursively at each node
		 * 	
		 * Traverse the left subtree.
		 * Visit the root.
		 * Traverse the right subtree.
		 */
		public String inorder(Node n) {
			if (n == null) return " null - yikes! ";
			
			String ret = "";
			if (n.left != null) ret += inorder(n.left) + " ";
			ret += " " + n.value.toString() + " ";
			if (n.right != null) ret += inorder(n.right) + " ";
			return ret;
		}

		/**
		 * To traverse a non-empty binary tree in postorder, perform the 
		 * following operations recursively at each node:
		 * 
		 * Traverse the left subtree.
		 * Traverse the right subtree.
		 * Visit the root.
		 */
		public String postorder(Node n) {
			if (n == null) return " null - yikes! ";
			
			String ret = "";
			if (n.left != null) ret += postorder(n.left) + " ";
			if (n.right != null) ret += postorder(n.right) + " ";
			ret += " " + n.value.toString() + " ";
			return ret;
		}
		
	}
	

}
