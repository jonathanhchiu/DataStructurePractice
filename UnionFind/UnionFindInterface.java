public interface UnionFindInterface {

	/** 
	* Add connection between elements p and q.
	*/
	void union(int p, int q);

	/**
	* Check if p and q are in the same connected component.
	*/
	boolean connected(int p, int q);


}