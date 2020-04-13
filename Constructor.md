### Default & Parameterized 
```java
// class DefaultConstructor {
// 	 int age;
// 	 String dateofBirth;
// 	 String name;
// 	 String address;

// 	public DefaultConstructor() {
// 		System.out.println("Defualt constructor here, no value assigned to anyone!");
// 	}
// }

class DefaultConstructor {
	 int age;
	 String dateofBirth;
	 String name;
	 String address;

	public DefaultConstructor() {
		System.out.println("Defualt constructor here, no value assigned to anyone!");
	}

	public DefaultConstructor(int age, String dateofBirth, option String name, String address) {
		this.age = age;
		this.dateofBirth = dateofBirth;
		this.name = name;
		this.address = address;

		System.out.println("Parameterized constructor here, these values are assigned to anyone!");
	}

}

//Overloading 超载： DefaultConstructor() and DefaultConstructor(int age, String dateofBirth, String name, String address)
class TestDefaultConstructor {
	public static void main(String[] args) {

		DefaultConstructor XIAOLONGLI = new DefaultConstructor();
		System.out.println(XIAOLONGLI.age);
		System.out.println(XIAOLONGLI.dateofBirth);
		System.out.println(XIAOLONGLI.name);
		System.out.println(XIAOLONGLI.address);

		DefaultConstructor XIAOLONG = new DefaultConstructor(32, "10/28/1986", "Xiaolong Li", "7724 Elkhorn Mountain TrailAustin, TX 78729");
		System.out.println(XIAOLONG.age);
		System.out.println(XIAOLONG.dateofBirth);
		System.out.println(XIAOLONG.name);
		System.out.println(XIAOLONG.address);
	}
}
```
