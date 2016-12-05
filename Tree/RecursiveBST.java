public class RecursiveBST<T extends Comparable<? super T>> implements BSTInterface<T> {
	private Node<T> root;

	/**
	* Clear the binary search tree.
	*/
	public void clear() {
		root = null;
	}

	/**
	* Check if the tree is empty.
	*
	* @return true if empty, false otherwise.
	*/
	public boolean isEmpty() {
		return root == null;
	}

	/**
	* Insert an item into the tree.
	*
	* @param data The item to insert.
	*/
	public void insert(T data) {
		root = insert(root, data);
	}

	/** 
	* Helper function for insert.
	*
	* @param curr The node to check.
	* @param data The data to insert.
	*
	* @return The node that was inserted, or the node already holding the data.
	*/ 
	private Node<T> insert(Node<T> curr, T data) {

		// Check if tree is empty
		if (curr == null) {

			// Insert at root
			return new Node<T>(data);
		}

		// Data to insert is already in tree
		if (data.compareTo(curr.data) == 0) {
			return curr;
		}

		// Data to insert is less than current node
		if (data.compareTo(curr.data) < 0) {

			// Go left
			curr.left = insert(curr.left, data);
		}

		// Data to insert is greater than current node
		else {

			// Go right
			curr.right = insert(curr.right, data);
		}

		// Compiler needs a return statement outside of if statements
		return curr;
	}

	/**
	* Delete a node in the tree.
	*
	* @param data Delete the node holding the specified data.
	*/
	public void delete(T data) {
		root = delete(root, data);

	}

	/**
	* Helper function for delete. 
	* "Deleting" a node in the BST involves (1) finding a successor,
	* (2) replace the node-to-delete with the successor, and (3) delete the
	* successor. For nodes with one child, the successor will be that child.
	* For nodes with two children, we will replace the deleted node with
	* the largest node in the left subtree. Alternatively, we could have used
	* the smallest node in the right subtree.
	*
	* @param curr The node we are currently at in the tree.
	* @param data The data we are searching for
	*
	* @param the successor node.
	*/
	private Node<T> delete(Node<T> curr, T data) {

		// Check if there is anything to delete
		if (curr == null) {
			return null;
		}

		// Check if data to delete is less than curr node
		if (data.compareTo(curr.data) < 0) {
			curr.left = delete(curr.left, data);
		}

		// Check if data to delete is greater than curr node
		else if (data.compareTo(curr.data) > 0) {
			curr.right = delete(curr.right, data);
		}

		// Found node to delete
		else {

			// Node has at most one child, to the right
			if (curr.left == null) {

				// Return null or right, depending on whether there is a right
				return curr.right;
			}

			// Node has two children
			else {

				// Find the biggest node in the left subtree
				T successor = findMax(curr.left);

				// Replace current data with successor data
				curr.data = successor;

				// Delete the successor, guaranteed to be a leaf node
				curr.left = delete(curr.left, successor);

			}
		}

		return curr;
	}

	/** 
	* Get the biggest node in the given node's subtree. Used in the remove
	* method, since we are getting the largest node in the node-to-delete's
	* left subtree.
	*
	* @param curr The node to start searching from.
	* 
	* @return the data held by the biggest node in the given node's right 
	* subtree.
	*/
	private T findMax(Node<T> curr) {
		Node<T> max = curr;

		// Get the rightmost leaf node 
		while (max.right != null) {
			max = max.right;
		}

		// Return the data of that leaf node
		return max.data;
	}

	/** 
	* Check if the tree contains a node holding the specified data.
	*
	* @param data The data to check for.
	*
	* @return true if a node in that tree contains the data, false otherwise.
	*/
	public boolean contains(T data) {
		return contains(root, data);
	}

	/** 
	* Helper function for contains.
	*
	* @param curr The node we are currently on.
	* @param data The data we are looking for
	* 
	* @return true if we have reached a node that holds the data.
	*/
	private boolean contains(Node<T> curr, T data) {

		// Check if we have reached end of tree
		if (curr == null) {
			return false;
		}

		// Check if current node holds requested data
		if (curr.data.compareTo(data) == 0) {
			return true;
		}

		// Check if current node is less than requested data
		else if (curr.data.compareTo(data) < 0) {
			return contains(curr.right, data);
		}

		// Check if current node is greater than requested data 
		else {
			return contains(curr.left, data);
		}
	}

	/**
	* Preorder traversal of the tree. In preorder, we visit (1) the current
	* node, (2) then the left, (3) then the right.
	*/
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	/**
	* Helper function for preorder traversal.
	*
	* @param curr The current node.
	*/
	private void preOrderTraversal(Node<T> curr) {
		if (curr == null) {
			return;
		}

		// Print the current node's data
		System.out.println(curr.data);

		// Visit left subtree
		inOrderTraversal(curr.left);

		// Visit the right subtree
		inOrderTraversal(curr.right);

	}

	/* Inorder traversal of the tree. In inorder, we visit the (1) left,
	* then (2) current, then (3) the right.
	*/
	private void inOrderTraversal() {
		inOrderTraversal(root);
	}

	/**
	* Helper function for inorder traversal.
	*
	* @param curr The current node.
	*/
	private void inOrderTraversal(Node<T> curr) {
		if (curr == null) {
			return;
		}

		// Visit left subtree
		inOrderTraversal(curr.left);

		// Print the current node's data
		System.out.println(curr.data);

		// Visit the right subtree
		inOrderTraversal(curr.right);
	}

	/**
	* Postorder traversal of the tree. In postorder, we visit the (1) left,
	* (2) right, and then (3) the current node.
	*/
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	/**
	* Helper function for postorder traversal.
	*
	* @param curr The current node.
	*/
	private void postOrderTraversal(Node<T> curr) {
		if (curr == null) {
			return;
		}

		// Visit left subtree
		inOrderTraversal(curr.left);

		// Visit the right subtree
		inOrderTraversal(curr.right);

		// Print the current node's data
		System.out.println(curr.data);

	}


	public static void main(String[] args) {
		System.out.println("Instantiating a BST.");
		RecursiveBST<Integer> bst = new RecursiveBST<Integer>();
		bst.insert(new Integer(4));
		bst.insert(new Integer(2));
		bst.insert(new Integer(6));
		bst.insert(new Integer(1));
		bst.insert(new Integer(3));
		bst.insert(new Integer(5));
		bst.insert(new Integer(7));
		System.out.println("Inorder Traversal:");
		bst.inOrderTraversal();
	}

	/**
	* The binary search tree node. Holds the left and right node, but not the
	* parent.
	*/
	class Node<T> {
		public T data;
		public Node<T> left;
		public Node<T> right;
		public Node(T data) {
			this.data = data;
		}
	}
}
