class Parent {
	int x = 100;
	void method(){
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	void method(){
		System.out.println("Child Method");
	}
}

class BindingTest {
	public static void main(String[] args) 	{
		Parent	p =	new Child();
		Child	c =	new Child();

		System.out.println("p.x(Parent�� int x��=100) = " + p.x );
		p.method();

		System.out.println("c.x(Child�� int x��=200) = "+ c.x );
		c.method();
	}
}
