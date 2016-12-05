/**
* <T extends Comparable<? super T>> means that the type parameter must support
* comparison with other instances of either (1) its own type or (2) ancestors
* of that type.
*/
public interface BSTInterface<T extends Comparable<? super T>> {
	
	void clear();
	boolean isEmpty();
	void insert(T data);
	void delete(T data);
	boolean contains(T data);
}