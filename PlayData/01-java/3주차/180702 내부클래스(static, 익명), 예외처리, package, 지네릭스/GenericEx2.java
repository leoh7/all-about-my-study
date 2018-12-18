/*
이제 진짜 어려운거.
딱 두 가지 식만 쓸 수 있다. 이것만 기억하심 됨. 많이 쓰이진 않는데 API 에 나옴
*/
/*
< ? super 객체자료형>		명시된 객체를 포함한 상위 객체들의 배치
						객체 내부의 모든 제네릭 타입은 Object로 인식
< ? extends 객체자료형>		명시된 객체를 포함한 하위 객체들의 배치
						객체 내부의 모든 제네릭 타입은 extends 다음에
						명시된 객체자료형으로 인식
							ex)HashSet(Collection<? extends E> c)
							Element 포험 밑으로 다 받겠다는 것


	? -> 이건 와일드카드
	객체자료형 -> 쉽게 말해 클래스 이름이란 소리
	

*/




class SuperA {
	String msg = "SuperA";
	public String getMsg(){
		return msg;
	}
}	// class SuperA

class SuperB extends SuperA {
	String msg = "SuperB";
	public String getMsg(){
		return msg;
	}
}	// class SuperB

class SuperC extends SuperB {
	String msg = "SuperC";
	public String getMsg(){
		return msg;
	}
}	// class SuperC

class GenericEx2 <T>{	// 얘가 제네릭, main 도 가지고 있다.
	private T a;
	public GenericEx2(){}
	public GenericEx2( T a ){
		this.a=a;
	}
	public void set( T a ){
		this.a = a;
	}
	public T get(){
		return a;
	}

	public static void main (String []args){
			//여기는 와일드 카드가 가능			//여기는 맘대로 못 바꿈
		GenericEx2 <?> ge = new GenericEx2 <Integer>(10) ;
			//Object로 받겠다, 라는 뜻			//Object로 받겠다-> 했는데 Integer로 받았다. 부모 밑에 자식으로 받았으니깐 자동형변환 일어나고 OK 된 것.
			//getA 메서드를 쓰면 Object로 나온다는 것.
//		Integer a = ge.get();	// 이렇게 하면 에러, Object가 부모고, 더 큰데, 자식에다가 넣으니까
//		Object a = ge.get();	// 이렇게 하면 받을 순 있다. 근데 이렇게 하면 부모가 자식꺼 못써서 메서드 아무것도 못쓴다는 소리야
		Integer a = (Integer) ge.get();	//그래서 이렇게 "원래 자료형"으로 받되, 에러가 나면 형변환 해서 받아야 한다는 것.
		
		SuperA sua = new SuperA();
		SuperB sub = new SuperB();
		SuperC suc = new SuperC();

		GenericEx2 <? super SuperB> ge1 = new GenericEx2 <SuperA> (sua);
		GenericEx2 <? super SuperB> ge2 = new GenericEx2 <SuperB> (sub);
//		GenericEx2 <? super SuperB> ge3 = new GenericEx2 <SuperC> (suc);	// 이건 안 됨.
//		Object sb = ge2.get();	// 이거 ok / 그치만 이걸 Object로 받으면 SuperB가 가지고 있는걸 다 못 씀
//		SuperB sb = ge2.get();	// 이렇게 하면 에러 / 형변환 필요하다
		SuperB sb = (SuperB) ge2.get();
		System.out.println("sb : " +sb.getMsg() );
		
		/*super SuperB -> 오브젝트로 바뀌게 되어 있음*/

//		GenericEx2 <? extends SuperB> ge4 = new GenericEx2 <SuperA> (sua);	// 이건 안 됨.
		GenericEx2 <? extends SuperB> ge5 = new GenericEx2 <SuperB> (sub);
		GenericEx2 <? extends SuperB> ge6 = new GenericEx2 <SuperC> (suc);

//		Object se = ge6.get();	// 말했듯이 된다 / 말했듯이 Object로 받으면 SuperB가 가지고 있는 메서드를 못 쓴다는 것
//		SuperC sc = ge6.get();	// 이거 왜 되냐		/
		SuperC sc = (SuperC) ge6.get();	// 이것도 된다?
		System.out.println("se : " +sc.getMsg() );
// 이건 부모 자식 관계에 따라 전부 SuperB 부모자료형으로 다 바뀐다.


	}	// main
}	// class GenericEx2