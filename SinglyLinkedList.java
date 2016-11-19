/* A Note on Encapsulation:
* 
* Encapsulation deals with the implementation side of a program; it is the act
* of hiding properties and behaviors of an object that the user is not meant
* to have access to, or modify. Our goal is to hide implementation details from
* the user.
*
*
*
* Achieving Encapsulation in Java:
*
* We can declare fields protected/private to limit access to users.
* If a field is declared private, outside classes cannot access it, unless we
* implement accessor/mutator methods that allow these fields to be accessed/
* modified. In using these public methods, the user does not know HOW the 
* data in a class is changed, but simply the fact that it IS changed.
*
*
*
* Benefits of Encapsulation:
*
* + The fields of a class can be made read/write only
* + Class can have control over what is stored in its fields
* + User does not need to know how class stores its data
*/

/**
* Implementation of a generic singly linked list. Includes common insertion
* and deletion methods, as well as print, reverse, and size methods.
*
* @author Jonathan Chiu 
* @version 1.0
*/ 
public class SinglyLinkedList<T> {

	/**
	* The first node of the linked list.
	*/
	private Node<T> head = null;

	/**
	* Insert a generic item to the front of the linked list.
	* 
	* @param item Generic item to insert to the list.
	*/
	public void insertFront(T item) {

		// Create a new node 
		Node<T> newNode = new Node<T>(item);

		// Insert to the front (head)
		newNode.setNext(head);
		head = newNode;
	}

	/**
	* Insert a generic item to the back of the linked list.
	* 
	* @param item Generic item to insert to the list.
	*/
	public void insertBack(T item) {

		// Create a new node
		Node<T> newNode = new Node<T>(item);

		// Base case: List is empty
		if (head == null) {
			head = newNode;
		}

		// List is nonempty, find the last Node
		else {
			Node<T> nextNode = head;
			while (nextNode.getNext() != null) {
				nextNode = nextNode.getNext();
			}

			// nextNode is now the last Node; insert after nextNode
			nextNode.setNext(newNode);
		}
	}

	/**
	* Insert a generic item to a certain position of the linked list.
	* 
	* @param item Generic item to insert to the list.
	*/
	public void insertAt(T item, int position) {
		
		// Initialize a new Node
		Node<T> newNode = new Node<T>(item);

		// Check if we want to insert at the front
		if (position == 0) {
			newNode.setNext(head);
			head = newNode;

		}

		// Insert somewhere else in the list
		else {

			// Runner Node to traverse List
			Node<T> runnerNode = head;

			// Find node at (position - 1)
			for (int index = 1; index < position; index++) {
				runnerNode = runnerNode.getNext();
			}

			// Insert after (position - 1)
			Node<T> tempNode = runnerNode.getNext();
			runnerNode.setNext(newNode);
			newNode.setNext(tempNode);

		}
	}

	/**
	* Delete a generic item from the front of the linked list.
	*/
	public void deleteFront() {

		// Head becomes the second element
		head = head.getNext();
	}

	/**
	* Delete a generic item from the back of the linked list.
	*/
	public void deleteBack() {

		// Check for empty list
		if (head == null) {
			return;
		}

		// Traverse through the list, one after another
		Node<T> runnerNode = head;
		Node<T> trailingNode = null;

		// Hit the last node
		while (runnerNode.getNext() != null) {
			trailingNode = runnerNode;
			runnerNode = runnerNode.getNext();
		}

		// Delete the last node
		trailingNode.setNext(runnerNode.getNext());
	}

	/**
	* Deletes the node at a specified position.
	*
	* @param position 0 indexed position corresponding to the node to delete
	*/
	public void deleteAt(int position) {

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

		// Delete node at position 
		trailingNode.setNext(runnerNode.getNext());
		return;
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
	* Reverse the linked list.
	*/
	public void reverse() {

		// Check if the list is empty
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node<T> currNode = head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;

		// Reverse the list 
		while (currNode != null) {

			// Grab the next node
			nextNode = currNode.getNext();

			// Reverse 
			currNode.setNext(prevNode);

			// Move everything over
			prevNode = currNode;
			currNode = nextNode;
		}

		// Reset head node
		head = prevNode;

	}

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
	* Hidden class within SinglyLinkedList implementing a genric Node to be
	* used for the linked list.
	*/
	class Node<T> {
		private T item;
		private Node<T> next;

		/**
		* Constructor function for a Node. Node must be initialized with an
		* item that it holds, because we do now allow for Node data to be 
		* edited.
		*
		* @param item The data that the node holds.
		*/
		public Node(T item) {
			this.item = item;
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