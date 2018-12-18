/*
	Map

	인덱스라는걸 얘기할 때는 0부터 시작하고 숫자다. 라고만 얘기했어. 인덱스를 직접 건드릴 방법이 없었단 소리.
	0	1	2	3	4
	D	D	D	D	D

	Map 은 열쇠고리 같은거야 / 인덱스가 0부터 쓰는 숫자인게 마음에 안든거야
	인덱스도 우리가 관리하자
	Key 와 Value
	K	0	1	2	3	4
	V	D	D	D	D	D

		key 가 숫자일 필요없이 문자여도 되고, 순서도 중요하지 않아.
	Map을 쓰면 좋은 장점은,
	List 라고 쳤을 때 원하는걸 꺼낼 때, 맨 앞부터 원하는걸 찾을 때까지 이동하면서 찾아야 되
	Map 은 Key를 이용하면 데이터를 바로바로 꺼낼 수 있다는 장점이 있다.
	Key도 지네릭이다 보니까 이것도 데이터일 수 있어.
	Key가 데이터, Value도 데이터, 이럴 때도 쓸 수 있어. 

Class Hashtable<K,V>	Key 와 Value


Constructors	생성자
Hashtable()
Hashtable(int initialCapacity)
Hashtable(int initialCapacity, float loadFactor)
Hashtable(Map<? extends K,? extends V> t)	// 맵 끼리 호환이 된다.


	void	clear()
Clears this hashtable so that it contains no keys.
Object	clone()
Creates a shallow copy of this hashtable.

Key 가 인덱스 역할을 하다 보니까 Key는 중복되면 안되. 
boolean	contains(Object value)
boolean	containsKey(Object key)
boolean	containsValue(Object value)


Enumeration을 지원하는데 뽑아주는게 뭐다? Value
Enumeration<V>	elements()
Returns an enumeration of the values in this hashtable.
얘는 Key를 뽑아주는거
Enumeration<K>	keys()
Returns an enumeration of the keys in this hashtable.



V	get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
V	getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

비어있냐
boolean	isEmpty()
Tests if this hashtable maps no keys to values.

합치는거
V	merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

넣는거 / 이거 특이해여 / Key랑 Value를 넣으면 / 리턴 값이 previous value야 ㅋㅋㅋㅋ / 이건 출력하면 안되
V	put(K key, V value)
Maps the specified key to the specified value in this hashtable.

작업하던걸 끼워넣는거
void	putAll(Map<? extends K,? extends V> t)
Copies all of the mappings from the specified map to this hashtable.


지우는거
V	remove(Object key)
Removes the key (and its corresponding value) from this hashtable.
boolean	remove(Object key, Object value)
Removes the entry for the specified key only if it is currently mapped to the specified value.

toString 여기있네
String	toString()
Returns a string representation of this Hashtable object in the form of a set of entries, enclosed in braces and separated by the ASCII characters ", " (comma and space).

리턴값이 컬렉션이야. values 만 뽑아내서 컬렉션으로 바꿔줄 수 있어
반대로 컬렉션을 Map으로 바꿀수 있냐. 그건 안되. Map에는 Key 와 Value가 있는데 다른애들은 Key가 없어서 일일이 지정해줘야 하니깐
이따 Vector로 바까보께여
Collection<V>	values()
Returns a Collection view of the values contained in this map.



*/

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Vector;
class HashtableEx {
	public static void main(String[] args) {

		// 생성
		Hashtable<Integer, String> ht = new Hashtable <Integer, String>();
		
/*		//추가
		ht.put(0, "홍길동");
		ht.put(7, "이순신");
		ht.put(9, "김유신");
		ht.put(1, "대조영");
		ht.put(8, "홍길동");
//		ht.put(0, "강감찬"); 이렇게 넣으면 값이 덮어씌워짐. 0 key에/ 그래서 if 문과 containsKey를 사용해야 한다.
*/
		if(! ht.containsKey( 0 ) ) ht.put(0, "홍길동");
		ht.put(7, "이순신");
		ht.put(9, "김유신");
		ht.put(1, "대조영");
		ht.put(8, "홍길동");
		if(! ht.containsKey( 0 ) ) ht.put(0, "강감찬");	// 이렇게 하면 강감찬이 덮어씌워지지 않는다.

		//출력 Map은 키들이 규칙이 없어서 반복문을 돌릴수가 없다. 어쩔 수 없이 enumeration 이나 반복문으로 뽑아야되 / 이터레이터를 지원 안해줘서 enumeration을 쓸 수 밖에 없는 것
		Enumeration en = ht.elements();
		while(en.hasMoreElements() ){
			System.out.println("출력 : "+ en.nextElement() ); // key로 내림차순 해서 나온다 사실? 
	
		}
 
		Enumeration e = ht.keys();
		while(e.hasMoreElements() ){
			System.out.println("keys 출력 : "+e.nextElement() );	// key로 내림차순 해서 나온다 사실? 
//			System.out.println("keys 출력 : "+ht.get( e.nextElement() ) );	// 요렇게 하면 Value가 뽑힌다.	//요렇게 두번 뽑으면 결과 이상하게 나온다 알아둘것
		}
		
		System.out.println();

		//Collection
		Vector <String> v = new Vector<String> (ht.values() );
		for(int i=0 ; i<v.size();i++ ){
			System.out.println("Vector : " + v.get(i) );
		}


	}
}
