import java.util.EmptyStackException;

/**
* List based implementation of a stack, includes isEmpty, pop, push, peek,
* and size methods. This class utilizes a doubly linked list as the main stack.
*
* @author Jonathan Chiu
*/
public class ListBasedStack<T> implements StackInterface<T> {
	private DoublyLinkedList<T> stack;

	/**
	* Constructor for the stack. Does not take a capacity, as there are no
	* capacity to linked lists.
	*/
	public ListBasedStack() {
		stack = new DoublyLinkedList<T>();
	}

	/**
	* Check if the stack is empty.
	* 
	* @return true if stack is empty, false otherwise.
	*/
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	* Add an item to the top of the stack.
	*
	* @param item The item to be pushed.
	*/
	public void push(T item) {

		// Get the size of the Linked list
		int size = stack.size();

		// Push to the last position on the list
		stack.add(item, size);
	}

	/** 
	* Remove and return the topmost item on the stack.
	*
	* @return the data held by the topmost item in the stack.
	*/
	public T pop() {

		// Get the size of the Linked list
		int size = stack.size();

		// Make sure stack is full
		if (size == 0) {
			throw new EmptyStackException();
		}

		// Return the data held by the last node in the list
		return stack.remove(size - 1);
	}

	/**
	* Returns, but does not remove, the topmost item on the stack. The stack
	* itself is not changed.
	*
	* @return the data held by the topmost item in the stack.
	*/
	public T peek() {

		// Get the size of the Linked list
		int size = stack.size();

		// Return the data held by the last node in the list
		return stack.get(size - 1);
	}

	/**
	* Get the size of the stack.
	*/
	public int size() {
		return stack.size();
	}

	/** 
	* Prints the contents of the stack from first added to last.
	*/
	public void print() {
		stack.print();
	}
}