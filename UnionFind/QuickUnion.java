public class QuickUnion implements UnionFindInterface {

  /**
  * Integer array id[] of size N, where id[i] is the parent of i. The root of
  * i is id[id[id[...id[i]...]]] (we keep going until it doesn't change).
  */
  private int[] id;

  public QuickUnion(int size) {
      id = new int[size];

      // Initialize all elements to its own unique id
      for (int i = 0; i < size; i++) {
        id[i] = i;
      }
  }

  public QuickUnion() {
    this(10);
  }

  /**
  * Find the root of i. Keep going until it doesn't change.
  *
  * Time proportional to depth of i.
  */
  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }


  /**
	* Add connection between elements p and q. This is done by setting the id
  * of p's root to the id of q's root. One problem is that
  * the trees can get long. Also, we need the find operation to do the union
  * operation.
  *
  * Time is proportional to depth of p and q.
  * O(n), including the cost of find.
	*/
	public void union(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);

    // Set the id of p's root to the id of q's root
    id[rootP] = rootQ;

  }

  /**
	* Check if p and q are in the same connected component. This is done by
  * checking if p and q have the same root.
  *
  * Time proportional to depth of p and q. Find could be N steps so it is
  * too expensive.
  * O(n), worst case, if the trees are too tall.
	*/
	public boolean find(int p, int q) {
    return root(p) == root(q);
  }
}
