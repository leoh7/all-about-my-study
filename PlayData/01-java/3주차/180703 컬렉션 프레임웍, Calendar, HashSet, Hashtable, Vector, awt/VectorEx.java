import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Enumeration;

class VectorEx {
	public static void main (String[]args){
		//생성
		Vector <String> v = new Vector <String> (5, 3);
		
		// 추가
			// add(E e)
				System.out.println("추가 : "+v.add("홍길동") );
				System.out.println("추가 : "+v.add("이순신") );
				System.out.println("추가 : "+v.add("김유신") );
			// void addElement
				v.addElement("홍길동");
			// void add(int index, E element)
				v.add(2, "강감찬");
			// insertElementAt(E element, int index)
				v.insertElementAt("대조영", 3);

		
		System.out.println("용량 : "+v.capacity() );	//용량 확인
		System.out.println("크기 : "+v.size() );		//사이즈 확인

		// 삭제 	boolean	removeAll(Collection<?> c)
		HashSet <String> hs = new HashSet <String> ();	// 컬렉션 자리에 던질 것 / 왜 이런식으로 담아서 던지냐 / 선택한 걸 한번에 지우고 싶은거야 / 선택하면 지워 선택을 다시 안해, 이럴 수도 있잖아. / 선택 해재 선택 해재 , 이걸 계속 하면 작업이 길어지잖아. / 그래서 HashSet 같은거에 한번에 넣어서(삭제할 애들을) 한번에 삭제만 눌러서 지우는거야
		hs.add("홍길동");
		hs.add("대조영");
		hs.add("연개소문");	// 얘는 없었는데도 true 라고 지웠다 나옵니다. 하나라도 지웠으면 true 뜨는 것
				// 리턴값이 있으니까 출력할 수 있겠쪄?
		System.out.println("삭제 : "+v.removeAll(hs));
		
		// 출력
			// get, elementAt 똑같다. 괜히 두개있음, 우린 get 쓸거	/for문 돌릴 때 size를 가져와야 한다. index는 0부터 시작하는거 잊지말고
			for(int i=0; i<v.size();i++){
				//System.out.println("출력 : "+v.elementAt(i) );
				System.out.println("출력 get : "+v.get(i) );
			}

		// 배열로 바꾸는거	/ void	copyInto(Object[] anArray) 빈 오브젝트 배열을 달래, 그러면 백터에 있는걸 채워주겠대 / Object[]	toArray() 이건 그냥 빼주겠대 / Object[]	toArray(T[] a) 아무 자료형 배열을 주면 배열로 뽑아주겠대
		String str[] = new String[v.size()];	// 배열 갯수가 문제야
		v.copyInto(str);
		for( String s : str){
			System.out.println("배열 : " + s);
		}

		// 컬렉션만 가지고 반복문 못 돌려서 쓰는게
			// Iterator 옛날에 쓰던거, 메모리 낭비가 생김 / 반복을 돌리기 위해서 복사본을 하나 만들어서 돌림
				//Iterator<E>	iterator()	/ E는 제네릭이져?
			Iterator<String> it = v.iterator();
			while(it.hasNext()){
				System.out.println("Iterator : "+it.next());
			}
			// Enumeration  원본에다 위치값만 지정해준다. / 메모리 낭비가 없음 / 애석하게도 Enumeration 은 몇 개 밖에 지원을 안 해줘 / 나중엔 억지로 Iterator 를 써야 하는 상황이 있어
				//Enumeration<E>	elements()

			Enumeration<String> en = v.elements();
			System.out.println(en);
			System.out.println();
			while( en.hasMoreElements()){
				System.out.println("Enumeration : "+ en.nextElement() );
			}

		// trim
		System.out.println("용량 : "+v.capacity() );	//용량 확인 8
		System.out.println("크기 : "+v.size() );		//사이즈 확인 3
		v.trimToSize();
		System.out.println("용량 : "+v.capacity() );	//용량 확인 3
		System.out.println("크기 : "+v.size() );		//사이즈 확인 3
			
		
		

		// 

	
	}
}

/*	API

	//생성자
	Vector()	// 디폴트로 잡으면 방이 10개가 잡히는데, 다 차면 20개로 늘어나. 다 차면 40개로, 다 차면 80개로 / 두배씩 늘어나부러 오메 / HashSet 도 두배씩 늘어나지만, 얘는 그렇게 많이 쓰면 안되. set이랬지?
		Constructs an empty vector so that its internal data array has size 10 and its standard capacity increment is zero.
	Vector(Collection<? extends E> c)
		Constructs a vector containing the elements of the specified collection, in the order they are returned by the collection's iterator.
	Vector(int initialCapacity)
		Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero.
	Vector(int initialCapacity, int capacityIncrement)	// 디폴트로 잡으면 방이 10개가 잡히는데, 다 차면 20개로 늘어나.-> 그래서 초기값,다차면몇개추가 이렇게 쓴거임
		Constructs an empty vector with the specified initial capacity and capacity increment.


상속관계 -> abstract. new 해서 못 쓴다는 소리
필드의 protected 상속 받거나 같은 폴더 아니면 못 쓴다는 소리


boolean	add(E e)	//얘는 boolean 값 리턴
				Appends the specified element to the end of this Vector.
void	add(int index, E element)		//중간에 삽입 가능
				Inserts the specified element at the specified position in this Vector.

void	addElement(E obj)	// 얘도 위랑 똑같은데, 리턴값 없는거
				Adds the specified component to the end of this vector, increasing its size by one.

void	insertElementAt(E obj, int index)	//얘도 중간에 삽입 가능인데, 인덱스랑 E 랑 순서가 바뀌어있지 ㅋ
				Inserts the specified object as a component in this vector at the specified index.


다른 컬렉션으로 작업하던걸 두에다 붙이는거
boolean	addAll(Collection<? extends E> c)
Appends all of the elements in the specified Collection to the end of this Vector, in the order that they are returned by the specified Collection's Iterator.

얘는 똑같은데 중간에 index 잡아다 끼워넣는거
boolean	addAll(int index, Collection<? extends E> c)
Inserts all of the elements in the specified Collection into this Vector at the specified position.

int	capacity()	// 용량확인
Returns the current capacity of this vector.


int	size()		// 사이즈
Returns the number of components in this vector.


// 똑같당
E	get(int index)
Returns the element at the specified position in this Vector.
E	elementAt(int index)
Returns the component at the specified index.

// 포함하고 있느냐
boolean	contains(Object o)
Returns true if this vector contains the specified element.

// sort 같은거 못하니까 배열로 뽑아내는거. 뽑아서 정리해서 다시 넣고 그런 식
void	copyInto(Object[] anArray)
Copies the components of this vector into the specified array.

Enumeration<E>	elements()
Returns an enumeration of the components of this vector.

// 이거 자체로 반복문 돌리는거. 근데 그 규칙을(Consumer) 정해서 줘야함. 자체로 sort 됨. 클래스로 만들어서 객체로 만들어 줘야 sort를 한다.
void	forEach(Consumer<? super E> action)
Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.

// 비슷 / 리턴 값이 다르다 / 인터페이스야 둘 다 / 인터페이스니까 직접 구현해도 되겠지? / 더군다나 메서드가 두개씩밖에 없으니깐 / 근데 메서드가 난이도가 굉장히 높아서 접근을 못해 / 배우기는 내부클래스나 뭐 등등 해서 구현을 해서 쓸 수 도 있겠지만 / 실제로 배우는 인터페이스들은 개같이 어려워서 손 대기 힘들어 / 그래서 대신 구현하고 있는 '메서드'가 필요해 / 그게 지원한다는 소리
// Vector 랑 HashTable 은 이걸 대신 만들어주는 애가 있는데, 다른 애들은 없어 / 나중엔 Enumeration만 만들어 주는 애들이 있어 / 
Iterator<E>	iterator()
Returns an iterator over the elements in this list in proper sequence.

ListIterator<E>	listIterator()
Returns a list iterator over the elements in this list (in proper sequence).

boolean	removeAll(Collection<?> c)
Removes from this Vector all of its elements that are contained in the specified Collection.


// 클리어랑 똑같지?
void	removeAllElements()
Removes all components from this vector and sets its size to zero.


// 리무브랑 똑같지?
boolean	removeElement(Object obj)
Removes the first (lowest-indexed) occurrence of the argument from this vector.
void	removeElementAt(int index)
Deletes the component at the specified index.

// 조건문을 클래스로 만들어서 주면, 조건에 맞으면 지우고 아니면 말고. 복잡한건 안써 안써/ 차라리 다른거 섞어 써
boolean	removeIf(Predicate<? super E> filter)
Removes all of the elements of this collection that satisfy the given predicate.

// protected 로 만들었단 건 util 패키지에 넣던지, 백터를 상속 받던지 해야 쓸 수 있다는 건데 이거 왜 만들어놨는지 모르겠다능. 쓸 일이 없어 거의 protected 로 되어있는 애들은 보통 다 그렇다
protected void	removeRange(int fromIndex, int toIndex)
Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.

// 인덱스랑 E 주면 바꿔줘
E	set(int index, E element)
Replaces the element at the specified position in this Vector with the specified element.
void	setElementAt(E obj, int index)
Sets the component at the specified index of this vector to be the specified object.

//잘라서 가져오기
Spliterator<E>	spliterator()
Creates a late-binding and fail-fast Spliterator over the elements in this list.

// 배열로 만들어 주는거
Object[]	toArray()
Returns an array containing all of the elements in this Vector in the correct order.
<T> T[]	toArray(T[] a)
Returns an array containing all of the elements in this Vector in the correct order; the runtime type of the returned array is that of the specified array.

// trim
void	trimToSize()
Trims the capacity of this vector to be the vector's current size.

*/


/*
	클래스를 쓰는 방법
	- 객체 생성
	- extends 상속
	- 멤버가 전부 static 인 경우 클래스 import 해서 클래스.필드, 메서드 명
	- 대신 객체를 생성해 주는 static 메서드(갖고있따)가 객체를 리턴	ex)Callender 클래스 객체생성 안되 / abstract 상속안되 짜잘해서 / 몇개만 static이고 전부인건 아냐 / 독특하게도 안에 메서드 중에 getInstance라는게 있어 / 이걸로 객체를 만들래, 이 메서드를 호출할라면 메서드가 필요한데 / 이럴 때 대신 메서드를 만들어주는 메서드는 static이야 / Callender.getInstance() / 라고 호출하면 대신 객체를 만들어줘 우왕
	- Class.forName( "클래스 풀경로" ) / 클래스를 관리하는 class 가 있는데 얘의 메서드 중에 forName() 을 사용한 것. / 왜 일케 쓰냐 / 객체 생성이 바뀔 때 / 객체 생성을 갈아 낄 수 있게 해주는 것. / 프로그램을 만들 때가 아니라 / 나중에 실행할 때 이걸 갈아끼고 싶으면 쓰는 것 / 주로 DB 쪽에서 많이 쓴ㄴ데 오라클 DB 쓰고 싶을 때, mySQL DB 쓰고 싶을 때, 지금은 모르겠는데 나중에 바꾸고 싶을 때, 이럴 때 바꿀 수 있게 해주는 것.

	인터페이스 쓰는 방법
	- implements 한 후 모두 재정의
	- Adapter(대신 구현한 클래스 cf.이벤트 처리에서만 아답터라고 불러서...) 클래스를 상속extends하거나 implements, (대신 구현한 클래스)객체를 생성해서 사용 
	- 익명 내부클래스로 미완성 부분을 구현하여 객체 생성 후 사용.	// 
	- 객체를 대신 생성해주는 메서드를 리턴 받아서(객체를 받아서) 사용 // 반 이상이 이걸로 씁니다. 

*/