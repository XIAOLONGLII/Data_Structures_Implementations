

```java
class MyString {
	private char[] array = null;

	public MyString(char[] array) {
		this.array = array;
	}
	public int LEN() {
		return this.array.length;
	}
	public MyString subString(int begin) {
		char[] temp = new char[this.array.length - begin];

		for(int i = begin; i < this.array.length; i++) {
			temp[i - begin] = this.array[begin];
		}

		return new MyString(temp);
	}
  public static void main(String[] args) {
		String s = "hello";
		char[] ch = s.toCharArray(); 
		MyString string = new MyString(ch);

		System.out.println("the length of string is " + string.LEN()); // LEN working here
	}

}
```
