/**
* Optimized for the find operation, at the expense of the union operation. The
* Quick-find algorithm may take M*N steps to process M union commands on N
* objects.
*/
public class QuickFind implements UnionFindInterface {

	private int[] id;

	/**
	* Constructor function. Initializes array so that the ith element has value
	* i, a unique ID.
	*
	* Time: O(n), we access the entire array
	*/
	public QuickFind(int size) {
		id = new int[size];

		// Set each element to its own unique id, so none are connected
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	/**
	* Default constructor function, with size 10.
	*/
	public QuickFind() {
		this(10);
	}

	/**
	* Merge p with q. For every entry containing id[p], change to id[q].
	* The trees are flat, but it is very expensive to keep them flat.
	*
	* Time: O(n). Need to iterate through entire array and possibly change
	* values.
	*/
	public void union(int p, int q) {
		int pid = id[p];

		// Change all entries with id[p] to id[q]
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = id[q];
			}
		}
	}

	/**
	* Check if p and q are in the same connected component. P and q are
	* connected if and only if they have the same ID.
	*
	* Time: O(1)
	*/
	public boolean find(int p, int q) {
		return id[p] == id[q];
	}
}
