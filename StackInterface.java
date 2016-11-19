/*
* A word on interfaces:
* Interfaces are a promise that whoever implements this interface must
* implement listed methods with the same argument signatures and return types.
* Many classes can implement an interface, and a class can implement many 
* interfaces.
*
* Regarding what we can (and cannot) declare:
* + public, abstract methods
* + static and final variables.
* - static methods
* - main method
* - constructors
*/

/**
* A stack is a collection that is based on the LIFO policy. To add an element,
* we "push". To remove, we "pop". We can also see if the stack "isEmpty" and
* determine the "size" of the stack. It is most commonly implemented using
* arrays or linked lists.
* 
* @author Jonathan chiu
*/
public interface StackInterface<T> {

	boolean isEmpty();
	void push(T item);
	T pop();
	T peek();
	int size();

}