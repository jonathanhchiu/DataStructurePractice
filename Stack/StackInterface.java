/**
* A stack is a collection that is based on the LIFO policy. To add an element,
* we "push". To remove, we "pop", or if we just need to know what the top item
* is, we "peek." It is most commonly implemented using arrays or linked lists. 
* All stack operations must have O(1) runtime.
* 
* @author Jonathan chiu
*/
public interface StackInterface<T> {

	/**
	* Check if a stack is empty. Required to have O(1) runtime.
	*
	* @return true if stack is empty, false otherwise.
	*/
	boolean isEmpty();

	/** 
	* Push an item to the top of the stack. Required to have O(1) runtime.
	*
	* @param item The item to push.
	*/
	void push(T item);

	/**
	* Pops the top item from the stack. Required to have O(1) runtime.
	*
	* @return the data that the deleted item holds.
	*/
	T pop();

	/**
	* Returns the top item from the stack. Stack itself is not changed.
	* Required to have O(1) runtime.
	* 
	* @return the data that the top item holds.
	*/
	T peek();
}