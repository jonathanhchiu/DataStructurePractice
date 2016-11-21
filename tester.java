public class tester {

	public static void main(String[] args) {

		System.out.println("Instantiating new list-based stack.");
		ListBasedStack<Integer> stack = new ListBasedStack<Integer>();

		System.out.println("Adding 3 elements into the stack.");
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.print();

		System.out.println("Popping 1 element from the stack.");
		System.out.println(stack.pop().toString());
		System.out.println(stack.pop().toString());
		System.out.println(stack.pop().toString());
		System.out.println(stack.pop().toString());
		
		System.out.println("Printing.");
		stack.print();
		System.out.println("Check if list is empty.");
		System.out.println(stack.isEmpty());
	}
}