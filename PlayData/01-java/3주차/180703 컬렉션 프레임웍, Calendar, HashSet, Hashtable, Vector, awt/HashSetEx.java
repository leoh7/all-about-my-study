/*
	상속관계도		/	 컬렉션은 인터페이스다. new 컬렉션 하고 못함. 부모는 자식을 받아준댔으니까 다른 컬렉션 개체 아무거나 줘도 된다는 소리. 컬렉션 끼리는 호환이 됩니다.
	Collection	set		HashSet
						TreeSet
				List	Vector		Stack
						ArrayList
				Queue	LinkedList


Vector, ArrayList 거의 똑같다. 차이점은 Vector가 쓰레드 동기화를 지원해준다는 것.
Queue	1.5부터 나왔어. 그래서 LinkedList가 보이지? 예전에 했던거.




	Map은 모양이 조금 달라서 나중에 배울 거임. 이것도 어려울 것 없어서 Map이 뭔지만 알면 되
	Map			HashMap
				HashTable

	미리 짜놓은 알고리즘들을 볼 때 자료구조 많이 쓰일 것.
	어려울 것 하나도 없고, 배열이랑 똑같다고 생각하면 된다 / 많은 양의 데이터를 한대 모아놓고 쓴다는 점
	얘네들도 미리 방을 여러개 잡아놓고 넣었다 뺏다 하면서 쓰는 것.
	추가로 검색, 삭제, 몇가지 기능이 더 있어요. Vector 같은 경우는 메서드가 더 되서 좀 더 하기도 하고.
	이 정도라고 보시면 됩니다. 굉장히 쉬울거에여

	배열배울때도 그랬지만 많은 양의 데이터를 관리할 때, 배열보다 컬렉션을 더 먼저 생각해.
	C같은 경우 배열로 하려고 하고, LinkedList를 짜려고 해. 어떻게든 배열로 하려고 하지 관리도 힘들고 짜기도 힘들고
	자바는 고민할 필요가 없어. 불연속적인 메모리를 연속적인 메모리처럼 쓸 수 있고, 삽입 삭제가 가능해. 2가지 장점이 강력함.
	단점, sort같은건 얘가 못해, 배열로 뺐다가 다시 넣어줘야되. 출력하려면 메서드로 뽑아야되. 배열처럼 인덱스로 몇번 방 이렇게 뽑아지는게 아니야.

		데이터의 길이가 안 바껴. 그럼 배열쓰는게 편해
		데이터의 길이가 바뀌면 컬렉션 쓰시면 됩니다.
		보통 자바는 왠만하면 컬렉션 써여.

	종류도 많고 어려워 보이는데 어려운거 하나도 없어여
	안에 있는 메서드도 비슷해, 데이터추가add, remove, contains 뭐 등등

	동작하는 방식에 따라 나눠놓은건데, Vector 정도만 아시면 충분해여.
	set 하고 List, Map 이건 다른 언어에도 있어서 특징을 구분할 수는 있어야 해. 기본 개념이 똑같으니깐.
		
		set은 주머니. index가 없어여. 공이 5개 있으면 그냥 무작위로 들어가 있어. 어떤 공을 꺼낼 확률이 1/5잖아?
		내가 이 데이터를 꺼내는데 시간이 좀 거려. 꺼내봐야 아는거야. 재수없으면 꺼낸걸 또 꺼낼수도 있곘지.
		적은 데이터 간단하게 관리하는데 써요. 잘은 안써, 인덱스가 없고, 그래서 정렬도 못하고, 그러니까 나열도 못하고, 많은 양의 데이터 관리할 때는 굉장히 불편해.
		공이 100개가 들어 있으면 3번 공을 꺼낼 확률이 1/100 인데, 100번 안에 못 꺼낼 수도 있어 ㅋㅋㅋ
		그리고 3번 공이 하나 안에 있는데 또 하나를 넣는게 안되. 데이터는 같은데 인덱스가 없으니깐 구분이 안되는거야.

		List 제일 많이 쓴다. 배열과 비슷해. 얘는 index가 있다. 얘는 인덱스가 있으니까 같은 데이터를 넣어도 구분이 가능해.
		0번방의 3번공, 7번방의 3번공, 이런 식으로.
		또 좋은게 뭐냐면, 1~100의 공이 있으면 3번공을 꺼낼 확률이 1/100 인데, 100% 확률로 꺼낼 수 있어 이 안에.
		작업시간을 어느정도 예상할 수 있다, 라는 거야.

		Map은 set 과 List 와는 모양이 좀 달라서 나중에 할거야.
			Properties 자바에서는 Map 상속받아 만든건데 다른 언어에서는 따로 빼서 4가지로 묶는당. 나중에 할 것.


	원래는 stack과 Queue를 많이 비교를 해.
	stack은 쌓는다는 뜻이잖아. 데이터를 ABC라고 넣으면 아래부터 ABC 순서로 들어가. 꺼낼 때는? CBA 이렇게 꺼내지겠지 LIFO (Last in First Out)
	Queue는 FIFO

	이런 자료구조 알고리즘들 짤 줄 알면 좋아여 기술면접
	그치만 우린 안짤거에여. 다 짜져있는데 뭐..


	file:///C:/Users/Playdata/Desktop/jdk-8u171-docs-all/docs/api/index.html
	Class HashSet<E> / 여기 <E> 이거 알지? 정해져 있지 않은 자료형
	만드는 방법만 다르지 배열하고 똑같아여
			HashSet()							// 디폴트 / 데이터방 16개 있다.
			HashSet(Collection<? extends E> c)	// 매개변수로 컬렉션을 달래요. / 컬렉션끼리는 호환이 됩니다, 라는 소리 / E지정한 클래스보다 하위 클래스
			HashSet(int initialCapacity)		// 초기 용량, 근데 신경 안써도 되 / 자동으로 늘어나
			HashSet(int initialCapacity, float loadFactor)

	

	컬렉션들의 공통된 문제
	반복문 돌리는게 다 불편해, 다 떨어져 있고.
	그게 불편하니까 만든게 iterator() 메서드
	열거자, 반복자라고 부른다. 얘 역할은 떨렁 반복문 돌리는 것만. 반복문 못 돌리는 애들을 돌릴수 있게 말이지
	옛날에는 다 iterator() 로 썼는데 for each(혹은 in) 반복문. 개선된 반복문이라고도 하고.
	for each는 배열돌리라고 만든거 아냐 사실 ㅋ 이거 돌리라고 만든거지.

*/
import java.util.HashSet;
class HashSetEx {
	public static void main(String []args){
		//생성
		HashSet <String> hs = new HashSet <String>();
		
		//추가
		System.out.println("추가 : "+ hs.add("홍길동") );
		System.out.println("추가 : "+ hs.add("홍길동") );	// 중복이 안된다는게 확인이 가능하다. false 나오고 데이터 size 그대로고
		System.out.println("추가 : "+ hs.add("이순신") );
		System.out.println("추가 : "+ hs.add("김유신") );
		System.out.println("크기 : "+ hs.size() );
		System.out.println();
	
		//제거
		System.out.println("제거 : "+ hs.remove("홍길동") );
		//출력
		for(String str : hs){	// 같은방 넣어야되
		System.out.println("출력 : "+ str);
		}

		System.out.println("크기 : "+ hs.size() );
		
		//검색	컬렉션에서 검색 역할을 하는게 있냐 없냐, 몇번 방이냐 이렇게 검색이 되는데 set의 경우는 인덱스가 없어서 있냐없냐밖에 안된다.
		System.out.println("검색 : "+ hs.contains("홍길동"));
		
	


	}	// main
}	// class HashSetEx