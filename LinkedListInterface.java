public interface LinkedListInterface<T> {
	
	public int size();
	public boolean isEmpty();
	public void add(T item, int position);
	public T get(int position);
	public T remove(int position);
	public void clear();
}