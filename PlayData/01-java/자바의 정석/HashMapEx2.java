import java.util.*;
class  HashMapEx2{

	public static void main(String[] args) {

	//HashMap map = new HashMap();
	//Note: HashMapEx2.java uses unchecked or unsafe operations.
	//������ ���. ���=>������ �����ΰ�?

	/* ���ͳ� ����
	This comes up in Java 5 and later if you're using collections without type specifiers 
	(e.g., Arraylist() instead of ArrayList<String>()). 
	It means that the compiler can't check that you're using the collection 
	in a type-safe way, using generics.

	To get rid of the warning, 
	just be specific about what type of objects you're storing in the collection. 
	So, instead of

				List myList = new ArrayList(); ���� ��� ���¿� ���
		
	use

				List<String> myList = new ArrayList<String>(); �̷��� ���ų�
		
	In Java 7 you can shorten generic instantiation by using Type Inference.

				List<String> myList = new ArrayList<>(); �ڹ� 7���ʹ� �̷��Ե� �� �� �ִ��
	*/

	//HashMap<String> map = new HashMap<String>(); wrong number of type arguments; required 2 ����. 
	//�׷��ϱ� "���ڹ�" �� 90���� ó���ϱ� ���� �ΰ��� �� �ʿ��ѵ�

	//HashMap<String, Integer> map = new HashMap<String, Integer>();
	//�̻��ϰ� Set set = map.entryset(); ���⼭ cannot find symbol ������ ���
	//unsafe operations �� �� �� ���� �� ���ڴ�.

	
	HashMap map = new HashMap();

	map.put ("���ڹ�", new Integer(90));
	map.put ("���ڹ�", new Integer(100));
	map.put ("���ڹ�", new Integer(100));
	map.put ("���ڹ�", new Integer(80));
	map.put ("���ڹ�", new Integer(90));

	Set set = map.entryset();
	Iterator it = set.iterator();

	while(it.hasNext()) {
		Map.Entry e = (Map.Entry)it.next();
		System.out.println("�̸� : "+ e.getKey()
									+ ", ���� : " + e.getValue());
	}

	set = map.keySet();
	System.out.println("������ ��� : " +set);

	Collection values = map.values();
	it = values.iterator();

	int total = 0;
	while(it.hasNext()) {
		Integer i = (Integer)it.next();
		total += i.intValue();
	}

	System.out.println("���� : " + total);
	System.out.println("��� : " + (float)total/set.size());
	System.out.println("�ְ����� : " + Collections.max(values));
	System.out.println("�������� : " + Collections.min(values));
	}
}

