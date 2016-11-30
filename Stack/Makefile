arraystack: interface
	javac ArrayBasedStack.java

liststack: interface
	javac -cp LinkedList.jar:. ListBasedStack.java

interface:
	javac StackInterface.java

run: arraystack
	java ArrayBasedStack
	
clean:
	rm *.class
