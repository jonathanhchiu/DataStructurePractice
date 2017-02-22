/**
* Based on Union Find in https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf.
*/
public interface UnionFindInterface {

	/**
	* Add connection between elements p and q.
	*/
	void union(int p, int q);

	/**
	* Check if p and q are in the same connected component.
	*/
	boolean find(int p, int q);
}
