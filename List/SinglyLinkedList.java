/**
* Implementation of a generic singly linked list. Includes common insertion
* and deletion methods, as well as print, reverse, and size methods.
*
* @author Jonathan Chiu 
* @version 1.0
*/ 
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

	/**
	* The first node of the linked list. Allows for insertion in the front to
	* have O(1) runtime.
	*/
	private Node<T> head = null;

	/**
	* The last node of the linked list. Allows for insertion in the back to
	* have O(1) runtime.
	*/
	private Node<T> tail = null;

	/**
	* The number of elements in the linked list. Allows for checking whether
	* we are inserting to the back to have O(1) runtime.
	*/
	private int size = 0;

	/**
	* Obtain the size of the linked list.
	*
	* @return size of the linked list
	*/
	public int size() {
		return size;
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

		// List is empty: insert first node into the list
		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		// List is nonempty 
		else {

			// Check if we want to insert at the front: O(1) runtime.
			if (position == 0) {
				newNode.setNext(head);
				head = newNode;
			}

			// Insert to the back of the list
			else if (position == size) {
				tail.setNext(newNode);
				tail = newNode;
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

		// Increment the size of the list
		size++;
	}

	/** 
	* Add node to the front of the list with O(1) runtime.
	* 
	* @param item The item to add to the list
	*/
	public void addFirst(T item) {
		add(item, 0);
	}

	/**
	* Add node to the back of the list with O(1) runtime.
	*
	* @param item The item to add to the list.
	*/
	public void addLast(T item) {
		add(item, size);
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

		// List is not empty
		else {

			// Check if we want the first node
			if (position == 0) {
				return head.getData();
			}

			// Check if we want the last node
			else if (position == size - 1) {
				return tail.getData();
			}

			// Data we want is held by node in middle of list
			else {

				// Forward current node to position
				Node<T> currNode = head;
				for (int index = 0; index < position; index++)  {
					currNode = currNode.getNext();
				}

				// Return data that the node contains
				return currNode.getData();
			}
		}
	}

	/** 
	* Get the data held by the first node in the list in O(1) runtime.
	*
	* @return data held by the first node
	*/
	public T getFirst() {
		return get(0);
	}

	/**
	* Get the data held by the last node in the list in O(1) runtime.
	*
	* @return data held by the last node
	*/
	public T getLast() {
		return get(size - 1);
	}

	/**
	* Deletes the node at a specified position.
	*
	* @param position 0 indexed position corresponding to the node to delete
	* @return data held by the deleted node
	*/
	public T remove(int position) {
		T deletedData = null;

		// Check if the list is empty
		if (head == null) {
			System.out.println("List is empty.");
		}

		// List is nonempty
		else {

			// The node we want to delete is the first one
			if (position == 0) {

				// Save data and delete 
				deletedData = head.getData();
				head = head.getNext();
			}

			// Node we want to delete is not the first one
			else {

				// Using the runner technique with two runners
				Node<T> runnerNode = head;
				Node<T> trailingNode = null;

				// Find node at position and one before it
				for (int index = 0; index < position; index++) {
					trailingNode = runnerNode;
					runnerNode = runnerNode.getNext();
				}

				// Save data in node
				deletedData = runnerNode.getData();

				// Check if the node we deleted is the last one 
				if (position == size() - 1) {
					tail = trailingNode;
				}

				// Delete node at position 
				trailingNode.setNext(runnerNode.getNext());
			}
		}

		// Decrement the size and return data held by deleted node
		size--;
		return deletedData;
	}

	/**
	* Deletes the first node in the list with O(1) runtime.
	*
	* @return data held by the deleted node
	*/
	public T removeFirst() {
		return remove(0);
	}

	/**
	* Deletes all nodes in the linked list.
	*/
	public void clear() {
		head = null;
		tail = null;
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