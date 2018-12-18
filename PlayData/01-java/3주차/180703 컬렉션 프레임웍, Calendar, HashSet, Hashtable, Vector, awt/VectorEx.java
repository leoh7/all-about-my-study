import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Enumeration;

class VectorEx {
	public static void main (String[]args){
		//����
		Vector <String> v = new Vector <String> (5, 3);
		
		// �߰�
			// add(E e)
				System.out.println("�߰� : "+v.add("ȫ�浿") );
				System.out.println("�߰� : "+v.add("�̼���") );
				System.out.println("�߰� : "+v.add("������") );
			// void addElement
				v.addElement("ȫ�浿");
			// void add(int index, E element)
				v.add(2, "������");
			// insertElementAt(E element, int index)
				v.insertElementAt("������", 3);

		
		System.out.println("�뷮 : "+v.capacity() );	//�뷮 Ȯ��
		System.out.println("ũ�� : "+v.size() );		//������ Ȯ��

		// ���� 	boolean	removeAll(Collection<?> c)
		HashSet <String> hs = new HashSet <String> ();	// �÷��� �ڸ��� ���� �� / �� �̷������� ��Ƽ� ������ / ������ �� �ѹ��� ����� �����ž� / �����ϸ� ���� ������ �ٽ� ����, �̷� ���� ���ݾ�. / ���� ���� ���� ���� , �̰� ��� �ϸ� �۾��� ������ݾ�. / �׷��� HashSet �����ſ� �ѹ��� �־(������ �ֵ���) �ѹ��� ������ ������ ����°ž�
		hs.add("ȫ�浿");
		hs.add("������");
		hs.add("�����ҹ�");	// ��� �����µ��� true ��� ������ ���ɴϴ�. �ϳ��� �������� true �ߴ� ��
				// ���ϰ��� �����ϱ� ����� �� �ְ���?
		System.out.println("���� : "+v.removeAll(hs));
		
		// ���
			// get, elementAt �Ȱ���. ���� �ΰ�����, �츰 get ����	/for�� ���� �� size�� �����;� �Ѵ�. index�� 0���� �����ϴ°� ��������
			for(int i=0; i<v.size();i++){
				//System.out.println("��� : "+v.elementAt(i) );
				System.out.println("��� get : "+v.get(i) );
			}

		// �迭�� �ٲٴ°�	/ void	copyInto(Object[] anArray) �� ������Ʈ �迭�� �޷�, �׷��� ���Ϳ� �ִ°� ä���ְڴ� / Object[]	toArray() �̰� �׳� ���ְڴ� / Object[]	toArray(T[] a) �ƹ� �ڷ��� �迭�� �ָ� �迭�� �̾��ְڴ�
		String str[] = new String[v.size()];	// �迭 ������ ������
		v.copyInto(str);
		for( String s : str){
			System.out.println("�迭 : " + s);
		}

		// �÷��Ǹ� ������ �ݺ��� �� ������ ���°�
			// Iterator ������ ������, �޸� ���� ���� / �ݺ��� ������ ���ؼ� ���纻�� �ϳ� ���� ����
				//Iterator<E>	iterator()	/ E�� ���׸�����?
			Iterator<String> it = v.iterator();
			while(it.hasNext()){
				System.out.println("Iterator : "+it.next());
			}
			// Enumeration  �������� ��ġ���� �������ش�. / �޸� ���� ���� / �ּ��ϰԵ� Enumeration �� �� �� �ۿ� ������ �� ���� / ���߿� ������ Iterator �� ��� �ϴ� ��Ȳ�� �־�
				//Enumeration<E>	elements()

			Enumeration<String> en = v.elements();
			System.out.println(en);
			System.out.println();
			while( en.hasMoreElements()){
				System.out.println("Enumeration : "+ en.nextElement() );
			}

		// trim
		System.out.println("�뷮 : "+v.capacity() );	//�뷮 Ȯ�� 8
		System.out.println("ũ�� : "+v.size() );		//������ Ȯ�� 3
		v.trimToSize();
		System.out.println("�뷮 : "+v.capacity() );	//�뷮 Ȯ�� 3
		System.out.println("ũ�� : "+v.size() );		//������ Ȯ�� 3
			
		
		

		// 

	
	}
}

/*	API

	//������
	Vector()	// ����Ʈ�� ������ ���� 10���� �����µ�, �� ���� 20���� �þ. �� ���� 40����, �� ���� 80���� / �ι辿 �þ�η� ���� / HashSet �� �ι辿 �þ����, ��� �׷��� ���� ���� �ȵ�. set�̷���?
		Constructs an empty vector so that its internal data array has size 10 and its standard capacity increment is zero.
	Vector(Collection<? extends E> c)
		Constructs a vector containing the elements of the specified collection, in the order they are returned by the collection's iterator.
	Vector(int initialCapacity)
		Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero.
	Vector(int initialCapacity, int capacityIncrement)	// ����Ʈ�� ������ ���� 10���� �����µ�, �� ���� 20���� �þ.-> �׷��� �ʱⰪ,�������߰� �̷��� ������
		Constructs an empty vector with the specified initial capacity and capacity increment.


��Ӱ��� -> abstract. new �ؼ� �� ���ٴ� �Ҹ�
�ʵ��� protected ��� �ްų� ���� ���� �ƴϸ� �� ���ٴ� �Ҹ�


boolean	add(E e)	//��� boolean �� ����
				Appends the specified element to the end of this Vector.
void	add(int index, E element)		//�߰��� ���� ����
				Inserts the specified element at the specified position in this Vector.

void	addElement(E obj)	// �굵 ���� �Ȱ�����, ���ϰ� ���°�
				Adds the specified component to the end of this vector, increasing its size by one.

void	insertElementAt(E obj, int index)	//�굵 �߰��� ���� �����ε�, �ε����� E �� ������ �ٲ������ ��
				Inserts the specified object as a component in this vector at the specified index.


�ٸ� �÷������� �۾��ϴ��� �ο��� ���̴°�
boolean	addAll(Collection<? extends E> c)
Appends all of the elements in the specified Collection to the end of this Vector, in the order that they are returned by the specified Collection's Iterator.

��� �Ȱ����� �߰��� index ��ƴ� �����ִ°�
boolean	addAll(int index, Collection<? extends E> c)
Inserts all of the elements in the specified Collection into this Vector at the specified position.

int	capacity()	// �뷮Ȯ��
Returns the current capacity of this vector.


int	size()		// ������
Returns the number of components in this vector.


// �Ȱ���
E	get(int index)
Returns the element at the specified position in this Vector.
E	elementAt(int index)
Returns the component at the specified index.

// �����ϰ� �ִ���
boolean	contains(Object o)
Returns true if this vector contains the specified element.

// sort ������ ���ϴϱ� �迭�� �̾Ƴ��°�. �̾Ƽ� �����ؼ� �ٽ� �ְ� �׷� ��
void	copyInto(Object[] anArray)
Copies the components of this vector into the specified array.

Enumeration<E>	elements()
Returns an enumeration of the components of this vector.

// �̰� ��ü�� �ݺ��� �����°�. �ٵ� �� ��Ģ��(Consumer) ���ؼ� �����. ��ü�� sort ��. Ŭ������ ���� ��ü�� ����� ��� sort�� �Ѵ�.
void	forEach(Consumer<? super E> action)
Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.

// ��� / ���� ���� �ٸ��� / �������̽��� �� �� / �������̽��ϱ� ���� �����ص� �ǰ���? / �����ٳ� �޼��尡 �ΰ����ۿ� �����ϱ� / �ٵ� �޼��尡 ���̵��� ������ ���Ƽ� ������ ���� / ����� ����Ŭ������ �� ��� �ؼ� ������ �ؼ� �� �� �� �ְ����� / ������ ���� �������̽����� ������ ������� �� ��� ����� / �׷��� ��� �����ϰ� �ִ� '�޼���'�� �ʿ��� / �װ� �����Ѵٴ� �Ҹ�
// Vector �� HashTable �� �̰� ��� ������ִ� �ְ� �ִµ�, �ٸ� �ֵ��� ���� / ���߿� Enumeration�� ����� �ִ� �ֵ��� �־� / 
Iterator<E>	iterator()
Returns an iterator over the elements in this list in proper sequence.

ListIterator<E>	listIterator()
Returns a list iterator over the elements in this list (in proper sequence).

boolean	removeAll(Collection<?> c)
Removes from this Vector all of its elements that are contained in the specified Collection.


// Ŭ����� �Ȱ���?
void	removeAllElements()
Removes all components from this vector and sets its size to zero.


// ������� �Ȱ���?
boolean	removeElement(Object obj)
Removes the first (lowest-indexed) occurrence of the argument from this vector.
void	removeElementAt(int index)
Deletes the component at the specified index.

// ���ǹ��� Ŭ������ ���� �ָ�, ���ǿ� ������ ����� �ƴϸ� ����. �����Ѱ� �Ƚ� �Ƚ�/ ���� �ٸ��� ���� ��
boolean	removeIf(Predicate<? super E> filter)
Removes all of the elements of this collection that satisfy the given predicate.

// protected �� ������� �� util ��Ű���� �ִ���, ���͸� ��� �޴��� �ؾ� �� �� �ִٴ� �ǵ� �̰� �� ���������� �𸣰ڴٴ�. �� ���� ���� ���� protected �� �Ǿ��ִ� �ֵ��� ���� �� �׷���
protected void	removeRange(int fromIndex, int toIndex)
Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.

// �ε����� E �ָ� �ٲ���
E	set(int index, E element)
Replaces the element at the specified position in this Vector with the specified element.
void	setElementAt(E obj, int index)
Sets the component at the specified index of this vector to be the specified object.

//�߶� ��������
Spliterator<E>	spliterator()
Creates a late-binding and fail-fast Spliterator over the elements in this list.

// �迭�� ����� �ִ°�
Object[]	toArray()
Returns an array containing all of the elements in this Vector in the correct order.
<T> T[]	toArray(T[] a)
Returns an array containing all of the elements in this Vector in the correct order; the runtime type of the returned array is that of the specified array.

// trim
void	trimToSize()
Trims the capacity of this vector to be the vector's current size.

*/


/*
	Ŭ������ ���� ���
	- ��ü ����
	- extends ���
	- ����� ���� static �� ��� Ŭ���� import �ؼ� Ŭ����.�ʵ�, �޼��� ��
	- ��� ��ü�� ������ �ִ� static �޼���(�����ֵ�)�� ��ü�� ����	ex)Callender Ŭ���� ��ü���� �ȵ� / abstract ��Ӿȵ� ¥���ؼ� / ��� static�̰� �����ΰ� �Ƴ� / ��Ư�ϰԵ� �ȿ� �޼��� �߿� getInstance��°� �־� / �̰ɷ� ��ü�� ���鷡, �� �޼��带 ȣ���Ҷ�� �޼��尡 �ʿ��ѵ� / �̷� �� ��� �޼��带 ������ִ� �޼���� static�̾� / Callender.getInstance() / ��� ȣ���ϸ� ��� ��ü�� ������� ���
	- Class.forName( "Ŭ���� Ǯ���" ) / Ŭ������ �����ϴ� class �� �ִµ� ���� �޼��� �߿� forName() �� ����� ��. / �� ���� ���� / ��ü ������ �ٲ� �� / ��ü ������ ���� �� �� �ְ� ���ִ� ��. / ���α׷��� ���� ���� �ƴ϶� / ���߿� ������ �� �̰� ���Ƴ��� ������ ���� �� / �ַ� DB �ʿ��� ���� ������ ����Ŭ DB ���� ���� ��, mySQL DB ���� ���� ��, ������ �𸣰ڴµ� ���߿� �ٲٰ� ���� ��, �̷� �� �ٲ� �� �ְ� ���ִ� ��.

	�������̽� ���� ���
	- implements �� �� ��� ������
	- Adapter(��� ������ Ŭ���� cf.�̺�Ʈ ó�������� �ƴ��Ͷ�� �ҷ���...) Ŭ������ ���extends�ϰų� implements, (��� ������ Ŭ����)��ü�� �����ؼ� ��� 
	- �͸� ����Ŭ������ �̿ϼ� �κ��� �����Ͽ� ��ü ���� �� ���.	// 
	- ��ü�� ��� �������ִ� �޼��带 ���� �޾Ƽ�(��ü�� �޾Ƽ�) ��� // �� �̻��� �̰ɷ� ���ϴ�. 

*/