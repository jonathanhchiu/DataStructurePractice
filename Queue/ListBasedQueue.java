/** 
* A trivial implementation of the queue interface, built as a wrapper  around
* the SinglyLinkedList class.
* 
* @author Jonathan Chiu
*/
public class ListBasedQueue<T> implements QueueInterface<T> {

	/**
	* The queue is a singly linked list.
	*/
	private SinglyLinkedList<T> queue;

	/** 
	* Constructor function to create a Queue from a Singly linked list.
	*/
	public ListBasedQueue() {
		queue = new SinglyLinkedList<T>();
	}

	/**
	* Check if the queue is empty. Required to have runtime of O(1).
	*
	* @return true if queue is empty, false otherwise.
	*/
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	* Get the front item in the queue. Does not change the queue. Required to
	* have a runtime of O(1).
	*
	* @return the data held by the front item in the queue.
	*/
	public T peek() {
		return queue.getFirst();
	}

	/**
	* Remove and return the frontmost item in the queue. Required to have a
	* have a runtime of O(1).
	*
	* @return the data held by the front item in the queue.
	*/
	public T dequeue() {
		return queue.removeFirst();
	}

	/** 
	* Add an item to the back of the queue. Required to have a runtime of O(1).
	*
	* @param item The item to add to the queue.
	*/
	public void enqueue(T item) {
		queue.addLast(item);
	}

	/**
	* Delete all items in the queue.
	*/
	public void clear() {
		queue.clear();
	}

	/**
	* Get the number of elements in the queue.
	*
	* @return The number of elements in the queue.
	*/
	public int size() {
		return queue.size();
	}

	/**
	* Prints the contents of the queue.
	*/
	public void print() {
		queue.print();
	}
}