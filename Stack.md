## Implement a Stack by using LinkedList. 
We can use these mothods in Linked List

1. use linked list 
2. isEmpty()
3. push(): add()
4. pop(): removeLast()
5. peek(): return last
  
  
```java
import java.util.*;
class Stack <T> implements Iterable<T> {
	// use linked list 
	// isEmpty()
	// push(): add()
	// pop(): removeLast()
	// peek(): return last
	private LinkedList<T> list = new LinkedList<>();
	public Stack(){
	}
	public Stack(T firstElem) {
		push(firstElem);
	}

	public int size(Node LL) {
		return list.size();
	}
	public boolean isEmpty() {
		return list.size() = 0;
	}
	//1. push
	public void push(T data) { 
		list.add(data);
	}
	//2. peek 
	public T peek(Node head) { 
		if(isEmpty()) {
			return null;
		}
		return list.peekLast();
	}
	public T pop() { 
		if(head.isEmpty()) {
			return null;
		}
		return list.removeLast();	
	}
	@Override public Iterator<T> iterator(){
		return list.iterator();
	}


}
```
