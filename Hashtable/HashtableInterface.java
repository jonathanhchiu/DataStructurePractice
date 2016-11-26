/**
* A Hash Table is a data structure that can map keys to value. It's strength
* is in fetching/adding/removing elements in constant time (on average). 
*
* The data inserted into the hash table is always in a key, value pair. The 
* key must be unique, and if not, the old value corresponding to that key will
* be replaced with the new value. The hash function maps the set of keys to
* a valid index in the hash table. This function has two parts:
*
* 1. hash code: in Java, every object has its own hash code
* 2. compressor: take the modulo of the hash code by the size of the table
*
* A collision is when the hash function maps two different keys to the same
* bucket. There are several collision resolution techniques including:
* 
* 1. Separate Chaining: linked lists for each bucket of the table
* 2. Double Hashing: use second hashing function to determine next spot
* 3. Linear Probing: look at subsequent buckets until first free spot
*
* but we will be implementing the Separate Chaining (1) Technique. The worst
* case is if every element gets mapped to the same bucket (obtaining a linked
* list with every element in it). Then, our searching would be O(n) instead of
* O(1). To remedy this, we will double our hash table size if our load factor
* (buckets filled / total buckets) passes a certain threshold.
*/
public interface HashtableInterface<K, V> {

	V get(K key);
	int getSize();
	void add(K key, V value);
	V remove(K key);
	boolean isEmpty();
}