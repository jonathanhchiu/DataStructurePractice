public class tester {

	public static void main(String[] args) {

		System.out.println("Instantiating new list-based stack.");
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();

		ll.addFirst(new Integer(1));
		System.out.println("First.");
		ll.add(new Integer(2), 1);
		System.out.println("Second.");
		ll.addLast(new Integer(3));
		System.out.println("Third.");
		ll.print();
		System.out.println("Size is: " + ll.size());
		System.out.println("Deleted: " + ll.remove(0).toString());
		System.out.println("Size is: " + ll.size());
		ll.print();
	}
}