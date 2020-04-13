### implement a queue using Linked List. 

```java
import java.util.*;
class Queue<T> implements Iterable<T> {

	public LinkedList<T> list = new LinkedList<>();

	public Queue(T firstItem){
		offer(firstItem);
	}
	// public Queue(){

	// }
	public int size() {
		return list.size();
	}
	public boolean isEmpty(){
		return size = 0;
	}

	public T poll() {
		if(list.isEmpty()) {
			throw new RuntimeException("queue isEmpty");
		}
		return list.removeFirst();
	}
	public T add(T data) {
		return list.add(data);
	}
	public T offer(T data) {
		return list.add(data);
	}
	// public T peek() {
	// 	return list.
	// }
	@Override public Iterator<T> iterator() {
		return list.iterator();
	}

}
```
