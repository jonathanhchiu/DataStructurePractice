/**
* A queue is a linear collection of objects that are inserted or removed 
* according to the first-in-first-out principle. To add an item to the back of
* the queue, we "enqueue," and to remove an item from the front of the queue, 
* we dequeue. All core functionality of queues are required to have a runtime
* of O(1).
* 
* @author Jonathan chiu
*/
interface QueueInterface<T> {

	/**
	* Check if the queue is empty. Required to have runtime of O(1).
	*
	* @return true if queue is empty, false otherwise.
	*/
	boolean isEmpty();

	/**
	* Get the front item in the queue. Does not change the queue. Required to
	* have a runtime of O(1).
	*
	* @return the data held by the front item in the queue.
	*/
	T peek();

	/**
	* Remove and return the frontmost item in the queue. Required to have a
	* have a runtime of O(1).
	*
	* @return the data held by the front item in the queue.
	*/
	T dequeue();

	/** 
	* Add an item to the back of the queue. Required to have a runtime of O(1).
	*
	* @param item The item to add to the queue.
	*/
	void enqueue(T item);

	/**
	* Delete all items in the queue.
	*/
	void clear();
}