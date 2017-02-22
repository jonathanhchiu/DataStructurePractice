/**
* Implementation of a Stack using two Queues. Push will be made fast, with O(1)
* time and space, and Pop will be O(n).
*/
public class QueueBasedStack<T> implements StackInterface<T> {
	
	private Queue<T> queue1;
	private Queue<T> queue2;
	private T top;

	public QueueBasedStack() {
		queue1 = new LinkedList<T>();
		queue2 = new LinkedList<T>();
		top = null;
	}

	/**
	* Check if the stack is empty. The stack is empty iff both queues are
	* empty.
	*
	* Time: O(1)
	* Space: O(1)
	*
	* @return true if empty, false otherwise.
	*/
	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

	/**
	* Push an item to the stack. 
	*
	* Time: O(1)
	* Space: O(1)
	*
	* @param item
	*/
	public void push(T item) {
		queue1.add(item);
		top = item;
	}

	/**
	* Pop an item from the stack. We need to move all items from queue1 onto
	* queue2 and store the last item moved for return. We then swap queue1
	* and queue2.
	*
	* Time: O(n), we dequeue n elements from queue1 and enqueue n-1 elements
	* onto queue2. 
	* Space: O(1)
	*
	* @return the popped item
	*/
	public T pop() {
		T item;

		// Move all but one item to the second queue
		while (queue1.size() > 1) {
			top = queue1.remove();
			queue2.add(top);
		}

		// Remove item to be returned
		item = queue1.remove();

		// Swap names
		Queue<T> temp = queue1;
		queue1 = queue2;
		queue2 = temp;

		// Return popped items
		return item;
	}

	/**
	* Get the head of the queue without altering it.
	*
	* Time: O(1): top is a member of the class
	* Space: O(1)
	*
	* @return the head item
	*/
	public T peek() {
		return top;
	}
}