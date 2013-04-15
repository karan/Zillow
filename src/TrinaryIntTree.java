/**
 * Implements a tri-node tree similar to a binary tree
 * but with three nodes.
 * 
 * @author Karan Goel (karanmatic@gmail.com)
 *
 */
public class TrinaryIntTree {

	public static void main(String[] args) {
		
		TrinaryIntTree x = new TrinaryIntTree();
		Tree t = x.new Tree();
		t.insert(5);
		t.insert(10);
		t.insert(2);
		t.insert(5);
		t.insert(5);
		t.insert(3);
		t.insert(15);
		t.print();
		System.out.println();
		t.delete(10);
		t.print();
		System.out.println();
		t.delete(5);
		t.print();
	}
	
	/**
	 * Class that denotes the main tree.
	 * 
	 * @author Karan Goel (karanmatic@gmail.com)
	 */
	public class Tree {
		Node overallRoot; // points to the top of the tree
		
		public Tree() {
			overallRoot = null;
		}
		
		public Tree(Node overallRoot) {
			this.overallRoot = overallRoot;
		}
		
		/**
		 * Inserts the passed value in the tree at appropriate
		 * location
		 * @param value
		 */
		public void insert(int value) {
			if (overallRoot != null) {
				overallRoot = insert(value, overallRoot);
			} else {
				overallRoot = new Node(value);
			}
		}
		
		/**
		 * Inserts the passed value in the tree at appropriate
		 * location
		 * @param value
		 */
		private Node insert(int value, Node root) {
			if (value < root.val) {
				if (root.left != null) insert(value, root.left);
				else root.left = new Node(value);
			} else if (value > root.val) {
				if (root.right != null) insert(value, root.right);
				else root.right = new Node(value);
			} else {
				if (root.mid != null) insert(value, root.mid);
				else root.mid = new Node(value);
			}
			return root;
		}
		
		
		/**
		 * Deletes the passed value from the tree.
		 * @param value
		 */
		public void delete(int value) {
			overallRoot = delete(value, overallRoot);
		}
		
		/**
		 * Deletes the passed value from the tree.
		 * @param value
		 */
		private Node delete(int value, Node root) {
			if (root != null) {
				if (value < root.val) {
					root.left = delete(value, root.left);
				} else if (value > root.val) {
					root.right = delete(value, root.right);
				} else {
					if (root.mid != null) {
						root.mid = delete(value, root.mid);
					} else if (root.right != null){
						int min = treeMin(root.right).val;
						root.val = min;
						root.right = delete(min, root.right);
					} else {
						root = root.left;
					}
				}
			}
			return root;
		}

		/**
		 * Returns the node with the minimal value in the tree
		 * formed by the passed node.
		 * @param root
		 * @return node with minimum value
		 */
		private Node treeMin(Node root) {
			if (root != null) {
				while (root.left != null) {
					return treeMin(root.left);
				}
			}
			return root;
		}

		/**
		 * Prints the tree in pre-traversal order.
		 */
		public void print() {
			print(overallRoot);
		}

		/**
		 * Prints the tree in pre-traversal order.
		 */
		private void print(Node root) {
			if (root != null) {
		          System.out.println("Node value : " + root.val);
		          print(root.left);
		          print(root.mid);
		          print(root.right);
			}
		}
		
		
	}
	
	/**
	 * Node class represents an individual node in the overall
	 * tree. Each node holds a value, and points to at most 3
	 * more nodes.
	 * 
	 * @author Karan Goel (karanmatic@gmail.com)
	 *
	 */
	public class Node {
		int val;
		Node left;
		Node mid;
		Node right;
		
		public Node(int val, Node left, Node mid, Node right) {
			this.val = val;
			this.left = left;
			this.mid = mid;
			this.right = right;
		}

		public Node(int value) {
			this(value, null, null, null);
		}
	}

}
