/**
* Modified quick union to avoid tall trees, by keeping track of size of each
* component. We balance by linking small tree below big one.
* We provide additional optimizations with path compression by making every
* other node in path point to its grandparent.
*/
public class OptimizedQuickUnion implements UnionFindInterface {

  /**
  * Integer array id[] of size N, where id[i] is the parent of i. The root of
  * i is id[id[id[...id[i]...]]] (we keep going until it doesn't change).
  */
  private int[] id;
  private int[] sz;

  public OptimizedQuickUnion(int size) {
      id = new int[size];
      sz = new int[size];

      // Initialize all elements to its own unique id
      for (int i = 0; i < size; i++) {
        id[i] = i;
        sz[i] = 1;
      }
  }

  public OptimizedQuickUnion() {
    this(10);
  }

  /**
  * Find the root of i. Keep going until it doesn't change.
  * Optimization: Path compression. Make every other node in path point to its
  * grandparent.
  *
  * Time proportional to depth of i.
  */
  private int root(int i) {
    while (i != id[i]) {

      // Path compression
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  /**
	* Add connection between elements p and q. This is done by setting the id
  * of p's root to the id of q's root. One problem is that
  * the trees can get long. Also, we need the find operation to do the union
  * operation.
  * Optimization: Modify quick union to merge smaller tree into larger tree.
  *
  * Time is proportional to depth of p and q.
  * O(logN), including the cost of find.
	*/
	public void union(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);

    // Root of Q has bigger tree
    if (sz[rootP] < sz[rootQ]) {
      id[rootP] = rootQ;
      sz[rootQ] += sz[rootP];
    }

    // Root of P has bigger tree
    else {
      id[rootQ] = rootP;
      sz[rootP] += sz[rootQ];
    }

  }

  /**
	* Check if p and q are in the same connected component. This is done by
  * checking if p and q have the same root.
  *
  * Time proportional to depth of p and q. Find could be N steps so it is
  * too expensive.
  * O(logN), worst case, if the trees are too tall.
	*/
	public boolean find(int p, int q) {
    return root(p) == root(q);
  }


}
