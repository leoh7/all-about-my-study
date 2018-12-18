/*
	Map

	�ε�����°� ����� ���� 0���� �����ϰ� ���ڴ�. ��� ����߾�. �ε����� ���� �ǵ帱 ����� ������ �Ҹ�.
	0	1	2	3	4
	D	D	D	D	D

	Map �� ����� �����ž� / �ε����� 0���� ���� �����ΰ� ������ �ȵ�ž�
	�ε����� �츮�� ��������
	Key �� Value
	K	0	1	2	3	4
	V	D	D	D	D	D

		key �� ������ �ʿ���� ���ڿ��� �ǰ�, ������ �߿����� �ʾ�.
	Map�� ���� ���� ������,
	List ��� ���� �� ���ϴ°� ���� ��, �� �պ��� ���ϴ°� ã�� ������ �̵��ϸ鼭 ã�ƾ� ��
	Map �� Key�� �̿��ϸ� �����͸� �ٷιٷ� ���� �� �ִٴ� ������ �ִ�.
	Key�� ���׸��̴� ���ϱ� �̰͵� �������� �� �־�.
	Key�� ������, Value�� ������, �̷� ���� �� �� �־�. 

Class Hashtable<K,V>	Key �� Value


Constructors	������
Hashtable()
Hashtable(int initialCapacity)
Hashtable(int initialCapacity, float loadFactor)
Hashtable(Map<? extends K,? extends V> t)	// �� ���� ȣȯ�� �ȴ�.


	void	clear()
Clears this hashtable so that it contains no keys.
Object	clone()
Creates a shallow copy of this hashtable.

Key �� �ε��� ������ �ϴ� ���ϱ� Key�� �ߺ��Ǹ� �ȵ�. 
boolean	contains(Object value)
boolean	containsKey(Object key)
boolean	containsValue(Object value)


Enumeration�� �����ϴµ� �̾��ִ°� ����? Value
Enumeration<V>	elements()
Returns an enumeration of the values in this hashtable.
��� Key�� �̾��ִ°�
Enumeration<K>	keys()
Returns an enumeration of the keys in this hashtable.



V	get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
V	getOrDefault(Object key, V defaultValue)
Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

����ֳ�
boolean	isEmpty()
Tests if this hashtable maps no keys to values.

��ġ�°�
V	merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

�ִ°� / �̰� Ư���ؿ� / Key�� Value�� ������ / ���� ���� previous value�� �������� / �̰� ����ϸ� �ȵ�
V	put(K key, V value)
Maps the specified key to the specified value in this hashtable.

�۾��ϴ��� �����ִ°�
void	putAll(Map<? extends K,? extends V> t)
Copies all of the mappings from the specified map to this hashtable.


����°�
V	remove(Object key)
Removes the key (and its corresponding value) from this hashtable.
boolean	remove(Object key, Object value)
Removes the entry for the specified key only if it is currently mapped to the specified value.

toString �����ֳ�
String	toString()
Returns a string representation of this Hashtable object in the form of a set of entries, enclosed in braces and separated by the ASCII characters ", " (comma and space).

���ϰ��� �÷����̾�. values �� �̾Ƴ��� �÷������� �ٲ��� �� �־�
�ݴ�� �÷����� Map���� �ٲܼ� �ֳ�. �װ� �ȵ�. Map���� Key �� Value�� �ִµ� �ٸ��ֵ��� Key�� ��� ������ ��������� �ϴϱ�
�̵� Vector�� �ٱ����
Collection<V>	values()
Returns a Collection view of the values contained in this map.



*/

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Vector;
class HashtableEx {
	public static void main(String[] args) {

		// ����
		Hashtable<Integer, String> ht = new Hashtable <Integer, String>();
		
/*		//�߰�
		ht.put(0, "ȫ�浿");
		ht.put(7, "�̼���");
		ht.put(9, "������");
		ht.put(1, "������");
		ht.put(8, "ȫ�浿");
//		ht.put(0, "������"); �̷��� ������ ���� �������. 0 key��/ �׷��� if ���� containsKey�� ����ؾ� �Ѵ�.
*/
		if(! ht.containsKey( 0 ) ) ht.put(0, "ȫ�浿");
		ht.put(7, "�̼���");
		ht.put(9, "������");
		ht.put(1, "������");
		ht.put(8, "ȫ�浿");
		if(! ht.containsKey( 0 ) ) ht.put(0, "������");	// �̷��� �ϸ� �������� ��������� �ʴ´�.

		//��� Map�� Ű���� ��Ģ�� ��� �ݺ����� �������� ����. ��¿ �� ���� enumeration �̳� �ݺ������� �̾ƾߵ� / ���ͷ����͸� ���� �����༭ enumeration�� �� �� �ۿ� ���� ��
		Enumeration en = ht.elements();
		while(en.hasMoreElements() ){
			System.out.println("��� : "+ en.nextElement() ); // key�� �������� �ؼ� ���´� ���? 
	
		}
 
		Enumeration e = ht.keys();
		while(e.hasMoreElements() ){
			System.out.println("keys ��� : "+e.nextElement() );	// key�� �������� �ؼ� ���´� ���? 
//			System.out.println("keys ��� : "+ht.get( e.nextElement() ) );	// �䷸�� �ϸ� Value�� ������.	//�䷸�� �ι� ������ ��� �̻��ϰ� ���´� �˾ƵѰ�
		}
		
		System.out.println();

		//Collection
		Vector <String> v = new Vector<String> (ht.values() );
		for(int i=0 ; i<v.size();i++ ){
			System.out.println("Vector : " + v.get(i) );
		}


	}
}
