import java.util.*;
class  HashMapEx2{

	public static void main(String[] args) {

	//HashMap map = new HashMap();
	//Note: HashMapEx2.java uses unchecked or unsafe operations.
	//에러가 뜬다. 경고=>에러의 형태인가?

	/* 인터넷 참조
	This comes up in Java 5 and later if you're using collections without type specifiers 
	(e.g., Arraylist() instead of ArrayList<String>()). 
	It means that the compiler can't check that you're using the collection 
	in a type-safe way, using generics.

	To get rid of the warning, 
	just be specific about what type of objects you're storing in the collection. 
	So, instead of

				List myList = new ArrayList(); 내가 썼던 형태와 비슷
		
	use

				List<String> myList = new ArrayList<String>(); 이렇게 쓰거나
		
	In Java 7 you can shorten generic instantiation by using Type Inference.

				List<String> myList = new ArrayList<>(); 자바 7부터는 이렇게도 쓸 수 있댄다
	*/

	//HashMap<String> map = new HashMap<String>(); wrong number of type arguments; required 2 랜다. 
	//그러니까 "김자바" 와 90점을 처리하기 위해 두가지 다 필요한듯

	//HashMap<String, Integer> map = new HashMap<String, Integer>();
	//이상하게 Set set = map.entryset(); 여기서 cannot find symbol 에러가 뜬다
	//unsafe operations 만 끌 수 있음 참 좋겠다.

	
	HashMap map = new HashMap();

	map.put ("김자바", new Integer(90));
	map.put ("김자바", new Integer(100));
	map.put ("이자바", new Integer(100));
	map.put ("강자바", new Integer(80));
	map.put ("안자바", new Integer(90));

	Set set = map.entryset();
	Iterator it = set.iterator();

	while(it.hasNext()) {
		Map.Entry e = (Map.Entry)it.next();
		System.out.println("이름 : "+ e.getKey()
									+ ", 점수 : " + e.getValue());
	}

	set = map.keySet();
	System.out.println("참가자 명단 : " +set);

	Collection values = map.values();
	it = values.iterator();

	int total = 0;
	while(it.hasNext()) {
		Integer i = (Integer)it.next();
		total += i.intValue();
	}

	System.out.println("총점 : " + total);
	System.out.println("평균 : " + (float)total/set.size());
	System.out.println("최고점수 : " + Collections.max(values));
	System.out.println("최저점수 : " + Collections.min(values));
	}
}

