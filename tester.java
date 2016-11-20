public class tester {

	public static void main(String[] args) {

		System.out.println("Instantiating new linked list.");
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();

		System.out.println("Inserting 4 numbers.");
		ll.add(new Integer(1), 0);
		ll.add(new Integer(2), 0);
		ll.add(new Integer(3), 0);
		ll.add(new Integer(4), 0);
		ll.print();
		System.out.println("Size is: " + ll.size());
		ll.printReverse();

		System.out.println("Inserting another.");
		ll.add(new Integer(5), 2);
		ll.print();
		System.out.println("Size is: " + ll.size());
		ll.printReverse();

		System.out.println("Deleting at position 2.");
		ll.remove(2);
		ll.printReverse();
		ll.size();

	}
}