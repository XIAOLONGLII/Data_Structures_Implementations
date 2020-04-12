### HashTable functions: map.get(key) map.remove(key) 
They are using using a constant time -> O(1)

HashTable is thread safe.  HashMap is not thread safe. (1)

```java
import java.util.ArrayList;

class HashNode<K, V> {
	  K key;
	  V value;
	  HashNode<K, V> next;

	  // 1. parameterized constructor
	  public HashNode(K key, V value) { 
	    this.key = key;
	    this.value = value;
	  } 
}
class Map<K, V> {
	  // 1.1. bucketArray will store array of chains 
	  private ArrayList<HashNode<K, V>> bucketArray;
	  // 1.2 capacity of array list
	  private int numBuckets;
	  // 1.3 current size of array list
	  private int size;
	  
	  public Map() {
	    bucketArray = new ArrayList<>();
	    numBuckets = 10;
	    size = 0;
	    
	    //2. create empty chains bucketArray = {null, null,null,null,null,null,null,null,null,null}
	    for(int i = 0; i < numBuckets;i++) {
	      bucketArray.add(null);
	    }
	  }

	  public int size() {
	  	return size;
	  }

	  public boolean isEmpty() {
	  	return size() == 0;
	  }

	  //3. find index for a key
	  private int getBucketIndex(K key) {
	  	int hashCode = key.hashCode();
	  	int index = hashCode % numBuckets;
	  	return index;
	  }
	  //4. method remove a given key
	  public V remove(K key) {
	  	int bucketIndex = getBucketIndex(key);
	  	HashNode<K, V> head = bucketArray.get(bucketIndex);
	  	HashNode<K, V> prev = null;
	  	while(head != null) {
	  		if(head.key.equals(key)) {
	  			break;
	  		}
	  		prev = head;
	  		head = head.next;
	  	}
	  	if(head == null) {
	  		return null; 
	  	}
	  	size--;

	  	if(prev != null) {
	  		prev.next = head.next;
	  	}
	  	else
	  		bucketArray.set(bucketIndex, head.next);

	  	return head.value;
	  }
	  //5. return value for a key
	  public V get(K key) {
	  	int bucketIndex = getBucketIndex(key);
	  	HashNode<K, V> head = bucketArray.get(bucketIndex);

	  	while(head != null) {
	  		if(head.key.equals(key)) {
	  			return head.value;
	  		}
	  		head = head.next;
	  	}
	  	return null;
	  }
	  //6. add a <key,value> pair to hash 
	  public void add(K key, V value) {
	  	int bucketIndex = getBucketIndex(key);
	  	HashNode<K, V> head = bucketArray.get(bucketIndex);
	  	while(head != null) {
	  		if(head.key.equals(key)) {
	  			head.value = value;
	  			return;
	  		}
	  		head = head.next;
	  	}
	  	// 6. 1 insert key in chain
	  	size++;
	  	head = bucketArray.get(bucketIndex);
	  	HashNode<K, V> newNode = new HashNode<K, V>(key, value);
	  	newNode.next = head;
	  	bucketArray.set(bucketIndex, newNode);

	  	// 6.2 load facotr goes beyond threhold, then double hash table size
	  	if((1.0 * size) / numBuckets >= 0.7) {
	  		ArrayList<HashNode<K, V>> temp = bucketArray;
	  		bucketArray = new ArrayList<>();
	  		numBuckets = 2 * numBuckets;
	  		size = 0;
	  		for(int i = 0; i < numBuckets; i++) {
	  			bucketArray.add(null);
	  		}
	  		for(HashNode<K, V> headNode : temp) {
	  			while(headNode != null) {
	  				add(headNode.key, headNode.value);
	  				headNode = headNode.next;
	  			}
	  		}
	  	}
	  }

	  public static void main(String[] args) {
	  	Map<String, Integer> map = new Map<>();
	  	map.add("this", 1);
	  	map.add("coder", 2);
	  	map.add("this", 3);
	  	map.add("hi", 4);

	  	System.out.println(map.size());
	  	System.out.println(map.remove("this"));
	  	System.out.println(map.remove("this"));
	  	System.out.println(map.size());
	  	System.out.println(map.isEmpty());

	  }
	}
	
	
/*result: 
3
4
null
2
false
*/
```












*Reference:
(1)
1. HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
2. HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
3. HashMap is generally preferred over HashTable if thread synchronization is not needed
