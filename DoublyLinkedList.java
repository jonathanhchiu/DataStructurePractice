/**
* Implementation of a generic singly linked list. Includes common insertion
* and deletion methods, as well as print, reverse, and size methods.
*
* @author Jonathan Chiu 
* @version 1.0
*/ 

class DoublyLinkedList<T> implements LinkedListInterface<T> {

	/**
	* The first node of the linked list.
	*/
	private Node<T> head = null;

	/**
	* Obtain the size of the linked list
	*
	* @return size of the linked list
	*/
	public int size() {

		// check if list is empty
		if (head == null) {
			return 0;
		}

		// Instantiate counter and iterator node
		int counter = 0;
		Node<T> nextNode = head; 

		// Find the last node
		while (nextNode != null) {
			nextNode = nextNode.getNext();
			counter++;
		}

		// Return the number of nodes travelled to to reach end
		return counter;
	}

	/**
	* Check if a list is empty.
	*/
	public boolean isEmpty() {
		return head == null;
	}

	/**
	* Insert a generic item to a certain position of the linked list.
	* 
	* @param item Generic item to insert to the list.
	*/
	public void add(T item, int position) {

		// Initialize a new Node
		Node<T> newNode = new Node<T>(item);

		// Check if list is empty 
		if (head == null) {
			head = newNode;
			return;
		}

		// Check if we want to insert at the front
		if (position == 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;

		}

		// insert at somewhere else in the list 
		else {

			// Runner Node to traverse List
			Node<T> runnerNode = head;

			// Find node at (position - 1)
			for (int index = 1; index < position; index++) {
				runnerNode = runnerNode.getNext();
			}

			// Insert after (position - 1)
			Node<T> tempNode = runnerNode.getNext();

			// Redirect connections
			runnerNode.setNext(newNode);
			tempNode.setPrev(newNode);

			// Insert new node
			newNode.setNext(tempNode);
			newNode.setPrev(runnerNode);
		}
	}

	/**
	* Get an item at a certain position in the linked list.
	*
	* @param position Position at the linked list to return the node.
	* @return data that the node at specified position is holding
	*/
	public T get(int position) {
		
		// Check if the list is empty 
		if (head == null) {
			System.out.println("List is empty.");
			return null;
		}

		// Check that the position is less than size
		if (this.size() - 1 == position) {
			System.out.println("Position exceeds size.");
			return null;
		}

		// Forward current node to position
		Node<T> currNode = head;
		for (int index = 0; index < position; index++)  {
			currNode = currNode.getNext();
		}

		// Return data that the node contains
		return currNode.getData();
	}

	/**
	* Deletes the node at a specified position.
	*
	* @param position 0 indexed position corresponding to the node to delete
	*/
	public void remove(int position) {

		// Check if the list is empty
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		// Check if the node we want to delete is the first one
		if (position == 0) {

			// delete the head node 
			head = head.getNext();
			return;
		}

		// Find node at position and one before it
		Node<T> runnerNode = head;
		Node<T> trailingNode = null;

		for (int index = 0; index < position; index++) {
			trailingNode = runnerNode;
			runnerNode = runnerNode.getNext();
		}

		// Reconnect linked list to delete node
		trailingNode.setNext(runnerNode.getNext());
		runnerNode.getNext().setPrev(trailingNode);
	}

	/**
	* Deletes all nodes in the linked list.
	*/
	public void clear() {
		head = null;
	}

	/**
	* Print the contents of the linked list.
	*/
	public void print() {

		// Check for empty list
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		// Grab the first node in the list
		Node<T> nextNode = head;

		// Print out nodes one at a time
		while (nextNode != null) {
			System.out.println(nextNode.getData().toString());
			nextNode = nextNode.getNext();
		}
	}

	/**
	* Print the contents of the linked list in reverse order.
	*/
	public void printReverse() {

		// Check for empty list
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		// Grab the first node in the list
		Node<T> nextNode = head;

		// Print out nodes one at a time
		while (nextNode.getNext() != null) {
			nextNode = nextNode.getNext();
		}

		// nextNode is now the last node of the list 
		while (nextNode != null) {
			System.out.println(nextNode.getData().toString());
			nextNode = nextNode.getPrev();
		}
	}
	
	/**
	* Hidden class within SinglyLinkedList implementing a genric Node to be
	* used for the linked list.
	*/
	class Node<T> {
		private T item;
		private Node<T> next;
		private Node<T> prev;

		/**
		* Constructor function for a Node. Node must be initialized with an
		* item that it holds, because we do now allow for Node data to be 
		* edited.
		*
		* @param item The data that the node holds.
		*/
		public Node(T item) {
			this.item = item;
			prev = null;
			next = null;
		}

		/**
		* Accessor method for the item that the node holds.
		*
		* {@link Node#item}
		*/
		public T getData() {
			return item;
		}

		/**
		* Accessor method for the next Node.
		*
		* {@link Node#prev}
		*/
		public Node<T> getPrev() {
			return prev;
		}

		/**
		* Mutator method for the item that the node holds.
		*
		* {@link Node#prev}
		*/
		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		/**
		* Accessor method for the next Node.
		*
		* {@link Node#next}
		*/
		public Node<T> getNext() {
			return next;
		}

		/**
		* Mutator method for the item that the node holds.
		*
		* {@link Node#item}
		*/
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}