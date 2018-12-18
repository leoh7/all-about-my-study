/*
	Collection	set		HashSet
						TreeSet
				List	Vector		Stack
						ArrayList
				Queue	LinkedList
*/

import java.util.Stack;

class StackEx {
	public static void main(String[]args){
		String[] groupA
			= { "우즈베키스탄", "쿠웨이트", "사우디", "대한민국" };
				//	4			3		2		 1		// 인덱스

		// 생성 / 그냥 디폴트로 만드시면 됩니다. / 생서자가 디폴트밖에 없어요
		Stack<String> s = new Stack<String>();

		// 추가
		for(int i=0; i<groupA.length;i++){
			System.out.println("추가 : "+ s.push(groupA[i] ) );
		}
/*		LIFO 구조
	0				// 데이터가 없는거다 / 자리
	1	대한민국		3-> 정상적인 인덱스 자리
	2	사우디		2
	3	쿠웨이트		1
	4	우즈베키스탄	0

		꺼내지는 순서는 대한민국 부터 우즈베키스탄 순으로
		꺼내는 메서드가 peek()이랑 pop()이 있어요
		해보면 압니다.
*/

		//검색
		System.out.println( "검색 : "+s.search("대한민국"));	// 잉? 대한민국이 인덱스가 1이네????
			// 얘가 이상한거야
			// 보통은 우즈벸이 제일 먼저 넣었으니까 0번이 되는게 보통인데,
			// 스텍은 반대로 들어가니까 인덱스가 반대로 들어간다고 해도 대한민국이 0번 아니냐? // 이게 왜 그러냐면 대한민국 위가 0이야

		//삭제	/ 쿠웨이트가 거기서 왜 나와?
		System.out.println( "삭제 : "+s.remove(1) );
				/* 상속을 받으면 다 좋아, 근데 메서드가 내께 아니어서, 나한테 안 맞는 경우가 있어. 특히 GUI 쪽이 아주 지랄맞아요 시발. remove가 Vector쪽 꺼잖아. stack만 인덱스가 이지랄이고 나머지는 다 정상 인덱스로 봐. 그래서 Vector 쪽 인덱스 가져다 쓰면 정상적인 인덱스를 읽어버린거야*/
		System.out.println( "삭제 : "+s.remove("대한민국") );	//인덱스가 이상해서 제대로 안되면, 그냥 이렇게 지워도 됩니다.feat. API
		// 출력
		while( ! s.empty() ){	// empty() 이건 비었냐? 니까 비었으면 true지? 그래서 부정을 썼어 ! 이거
		//	System.out.println( "출력 : " + s.peek() );	// 무한루프 돕니다. peek은 꺼내고 안지워요. 그래서 또 대한민국, 또 대한민국
			System.out.println( "출력 : " + s.pop() );
		}
		/*
			추가 : 우즈베키스탄
			추가 : 쿠웨이트
			추가 : 사우디
			추가 : 대한민국
			출력 : 대한민국
			출력 : 사우디
			출력 : 쿠웨이트
			출력 : 우즈베키스탄
		*/
		
	}
}

/*
Stack 이라는 애는 stack 구조로 되 있구요
	
	//메서드
boolean	empty()
			Tests if this stack is empty.
	E	peek()
			Looks at the object at the top of this stack without removing it from the stack.
	E	pop()
			Removes the object at the top of this stack and returns that object as the value of this function.
	E	push(E item)
			Pushes an item onto the top of this stack.
	int	search(Object o)		// stack 은 list라 인덱스가 있어. 몇 번째 방(int)
			Returns the 1-based position where an object is on this stack.

실제로 자료구조를 설명할 때 이렇게 설명하고, 추가할 때 add가 아니라 push, 제거할 때는 pop, 찾을 때는 search
구조가 독특하지 많이 쓰는건 아니어서.

꺼내는게 없지??
부모가 Vector야. Vector꺼 쓰면 되.
꺼내고 지우고 꺼내고 지우고 꺼내고 지우고 empty() 비어있냐?

remove도 없지?
Vector 꺼 쓰면 되
*/