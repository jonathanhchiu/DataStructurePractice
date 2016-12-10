public class QuickFind implements UnionFindInterface {

	private int[] id;

	public QuickFind() {
		int size = 10;

		this(size);
	}

	/**
	* Constructor function. Initializes array so that the ith element has value
	* i, a unique ID.
	* 
	* Time: O(n), we access the entire array
	*/
	public QuickFind(int size) {
		id = new int[size];

		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	/**
	* Merge components containing p and q. For every entry containing id[p],
	* change to id[q]. 
	*
	* Time: O(n). Need to iterate through entire array and possibly change
	* values.
	*/
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];

		// Change all entries with id[p] to id[q]
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}

	/** 
	* Check if p and q are in the same connected component. P and q are
	* connected if and only if they have the same ID.
	*
	* Time: O(1)
	*/
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
}