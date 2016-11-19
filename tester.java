public class tester {

	public static void main(String[] args) {

		System.out.println("Instantiating new linked list.");
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();

		System.out.println("Inserting 4 numbers.");
		ll.insertBack(new Integer(1));
		ll.insertBack(new Integer(2));
		ll.insertBack(new Integer(3));
		ll.insertBack(new Integer(4));
		ll.print();
		System.out.println("Size is: " + ll.size());

		System.out.println("Reversing list.");
		ll.reverse();
		ll.print();
		
		System.out.println("Deleting the node at position 2.");
		ll.deleteAt(2);
		ll.print();
		System.out.println("Size is: " + ll.size());

		System.out.println("Deleting the back.");
		ll.deleteBack();
		ll.print();
		System.out.println("Size is: " + ll.size());
	}
}