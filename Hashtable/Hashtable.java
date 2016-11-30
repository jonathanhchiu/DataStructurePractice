import java.util.ArrayList;

public class Hashtable<K, V> implements HashtableInterface<K, V> {
    private ArrayList<Node<K, V>> buckets;
    private int size;
    private int capacity;

    /**
    * Constructor method for a Hashtable. 
    * 
    * @param capacity The capacity of the hash table.
    */
    @SuppressWarnings("unchecked")
    public Hashtable(int capacity) {
        
        // Java does not allow for generic array creation, so we cast it
        buckets = new ArrayList<>();
        
        // Initialize Hashtable properties
        size = 0;
        this.capacity = capacity;
        
        // Create empty chains
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }
 	
 	/**
 	* Get the size of the hash table.
 	*
 	* @return the size of the hash table.
 	*/
    public int getSize() {
    	return size;
    }

    /**
    * Check if the hash table is empty.
    *
    * @return true if empty, false otherwise.
    */
    public boolean isEmpty() {
    	return size == 0;
    }
 	
 	/**
 	* Map the key to an index in the hash table. Data stored in the hash table
 	* must have a key and a value. The hash function maps the set of keys to
 	* the set of nonzero integers that correspond to valid indices in the 
 	* hash table. Every hash function has two parts: a hash code and
 	* compressor. The hash code is an integer, and in Java, every Object
 	* has its own hash code. The compressor is the modulo operator, which
 	* ensures that the codomain of the hash function is the set of valid
 	* indices.
 	* 
 	* @param key The key of the data stored in the hash table.
 	* @return the index to store the data.
 	*/
    private int hash(K key) {

    	// Use Java's built in hash code function
        int hashCode = key.hashCode();

        // Compress the hash code using modulo operator
        return hashCode % capacity;
    }
 
    /**
    * Remove a key, value pair, as identified by the key. Does this in O(1) 
    * time on average. Worst case is when all entries are in a single  linked
    * list and we must traverse through it all.
    *
    * @param key The key to identify the pair
    * @return the value held by the deleted node.
    */
    public V remove(K key) {
    	int index = 0;
    	Node<K, V> curr = null;
    	Node<K, V> prev = null;
    	Node<K, V> found = null;

        // Apply hash function to determine index for given key and grab head
        index = hash(key);
        curr = buckets.get(index);
 		
 		// Entry is empty
 		if (curr == null) {
 			return null;
 		}

        // Search for desired node in linked list
        else {
	        while (curr != null) {

	        	// Found node holding data with desired key
	        	if (curr.getKey().equals(key)) {

	        		// Save the node to be unlinked
	        		found = curr;
                    size--;
	        		break;
	        	}

	        	// Move on in the chain
	        	else {
		            prev = curr;
		            curr = curr.getNext();
	        	}           
	        }

	        // Node to delete is the first one
	        if (prev == null) {
                buckets.set(index, curr.getNext());
	        }

	        // Node to delete is somewhere else in the list
	        else {
	        	prev.setNext(curr.getNext());
	        }
 		}
 		
 		// Return data held by node
        return found.getValue();
    }
 
    /**
    * Return the value associated with the specified key. Computes the index
    * of the hash table with the given key using the hash function. Then, 
    * traverse the linked list, if exists to find the value associated with the
    * key. Does this in O(1) time on average. Worst case, O(n), when all items
    * are in the same linked list.
    *
    * @param key The key that pairs to the desired value.
    * @return the value associated with the key.
    */
    public V get(K key) {
        int index;
        Node<K, V> curr;

        // Find the head node
        index = hash(key);
        curr = buckets.get(index);
 
        // Traverse the linked list to find the node with the key
        while (curr != null) {

            // Found node holding key
            if (curr.getKey().equals(key)) {

                // Return value associated with key
                return curr.getValue();
            }

            // Check the next node
            curr = curr.getNext();
        }
 
        // Node containing key does not exist in hashtable
        return null;
    }
 
    /**
    * Adds a key, value pair to the hash table. Does this in O(1) time on 
    * average. Adds to the front of the linked list.
    *
    * @param key
    * @param value
    */
    public void add(K key, V value) {
        int index;
        Node<K, V> curr;

        // Find the head in the specified index
        index = hash(key);
        curr = buckets.get(index);
 
        // Check if we already have an entry in the linked list
        while (curr != null) {

            // Found a node with the same key
            if (curr.getKey().equals(key)) {

                // Replace old value with new value
                curr.setValue(value);
                return;
            }

            // Go to the next node
            curr = curr.getNext();
        }
    
        // Grab the first node in the linked list
        curr = buckets.get(index);

        // Create a new node and insert to the front of the linked list
        Node<K, V> newNode = new Node<K, V>(key, value);
        newNode.setNext(curr);
        buckets.set(index, newNode);
        size++;
 
        // If load factor goes beyond threshold, then
        // double hash table size
        // if ((1.0*size)/numBuckets >= 0.7)
        // {
        //     ArrayList<HashNode<K, V>> temp = bucketArray;
        //     bucketArray = new ArrayList<>();
        //     numBuckets = 2 * numBuckets;
        //     size = 0;
        //     for (int i = 0; i < numBuckets; i++)
        //         bucketArray.add(null);
 
        //     for (HashNode<K, V> headNode : temp)
        //     {
        //         while (headNode != null)
        //         {
        //             add(headNode.key, headNode.value);
        //             headNode = headNode.next;
        //         }
        //     }
        // }
    }

    public void print() {
        Node<K, V> curr;

        for (int i = 0; i < capacity; i++) {
            curr = buckets.get(i);

            System.out.print("Bucket " + i + ": ");
            while (curr != null) {
                System.out.print(curr.getValue());
                curr = curr.getNext();
            }

            // Newline 
            System.out.println("");
        }
    }
    /**
    *  Node class for the singly linked list in each bucket. Each node holds
    * a key and a value.
    */
    class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> next;
     
        /**
        * Constructor function for a node. A key and value must be specified
        * for a node.
        *
        * @param key 
        * @parma value
        */
        public Node(K key, V value) {

            // Initialize key, value, and next fields
            this.key = key;
            this.value = value;
            next = null;
        }

        /**
        * Get the key that the node holds.
        *
        * @return the key
        */
        public K getKey() {
            return key;
        }

        /**
        * Get the value that the node holds.
        *
        * @return the value
        */
        public V getValue() {
            return value;
        }

        /**
        * Change the value that the node holds.
        *
        * @param value What you want the value to be.
        */
        public void setValue(V value) {
            this.value = value;
        }

        /**
        * Get the next node in the linked list.
        *
        * @return the next node.
        */
        public Node<K, V> getNext() {
            return next;
        }

        /**
        * Set the next node in the linked list.
        *
        * @param next The next node.
        */
        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    /**
    * Performing basic hashtable operations such as insert, lookup, and delete.
    */
    public static void main(String[] args) {
        int capacity = 11;

        System.out.println("Instantiating a new hashtable.");
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>(capacity);
        System.out.println("Size: " + ht.getSize());

        System.out.println("Inserting 2 elements.");
        ht.add(new Integer(1), "Hello");
        ht.add(new Integer(2), "World");
        System.out.println("Size: " + ht.getSize());
        ht.print();

        System.out.println("Deleting element with key 2 :).");
        ht.remove(new Integer(2));
        System.out.println("Size: " + ht.getSize());
    }
}