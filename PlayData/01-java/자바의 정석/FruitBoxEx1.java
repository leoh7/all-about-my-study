import java.util.ArrayList;

class Fruit					{ public String toString() { return "Fruit";} }
class Apple extends Fruit	{ public String toString() {return "Apple";} }
class Grape extends Fruit	{ public String toString() {return "Grape";} }
class Toy					{ public String toString() {return "Toy";} }

class FruitBoxEx1 {
	public static void main (String[]args){
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
//		Box<Grape> grapeBox = new Box<Apple>();		//FruitBoxEx1.java:13: error: incompatible types: Box<Apple> cannot be converted to Box<Grape> / 에러. 타입 불일치.

		fruitBox.add(new Fruit() );
		fruitBox.add(new Apple() );	// OK. void add(Fruit item) / 타입이 부모형이기 때문에 자연스럽게 자식이 들어갈 수 있는 것.

		appleBox.add(new Apple() );
		appleBox.add(new Apple() );
//		appleBox.add((new Toy() );	// 에러. Box<Apple>에는 Apple만 담을 수 있다

		toyBox.add(new Toy() );
//		toyBox.add(new Apple() );	// 역시 에러. Box<Toy>에는 Toy만 담을 수 있다.

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}	// class FruitBoxEx1 끝

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item)	{ list.add(item); }
	T get (int i)		{ return list.get(i); }
	int size()			{ return list.size(); }
	public String toString() { return list.toString(); }
}