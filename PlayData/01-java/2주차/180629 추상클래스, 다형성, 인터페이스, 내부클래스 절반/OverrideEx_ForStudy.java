/*
오버라이드 ( 재정의 )								- 오버로드 ( 다중정의 )
변수는 오버라이드랑 전혀 상관 없다.					클래스 하나 에 매개변수 자료형, 매개변수 갯수 등이 다를 때, 같은 이름으로 실행 가능
오버라이드는 '메서드'와 관련된 얘기
1.상속이 안되있으면 무조건 상속이란 말이 안나온다.		
2.상속이 되있는 상태에서 부모한테도 있는데 자식한테도 있으면,
return 값까지 또오옥깥이 있으면 오버라이드

	남의 건데 내꺼처럼 쓸 수 있는거랑 내가 같고 있는거랑 있으면
	내 것이 우선권을 갖고 있다.
	즉, 부모게 있지만 내가 쓰기 위해서 다시 정의 했다!
	라는 것이 오버라이드

캡슐화, 상속은 내가 '하겠다' 라는 행위가 있어야 할 수 있는데
다형성은 상속받은 상태에서 재정의만 해버리면(오버라이드)
다형성이 적용되버려(은연 중에). 하고 싶지 않아도.

	상속을 하면 이걸 또 따져봐야한다.
	상속을 받으면 클래스도 분명히 자료형. 상속도 받았다.
	참조변수랑 인스턴스가 다르잖아. 
	stack	heap

	3번 클래스도 형변환이 가능해	/	자료형이기 때문에.
	
*/

class  OvSuper{
// 멤버 변수
	String name = "부모클래스";		//원래는 부모 자식간에 상속받아서 똑같은 변수를 만드는건 하지 말아야 할 짓 / 객체를 잡을 순 있지만 '출력해라' 하면 에러남
// 멤버 메서드	
	public String getName(){	
		return name;
	}
}

class OverrideEx_ForStudy extends OvSuper{
// 멤버 변수	
	String name = "자식클래스";
	
// 멤버 메서드
	public String getName(){
		return name;
	}

	public static void main (String [] args){
		
		// 부모클래스 참조변수 = 부모클래스 인스턴스			//상속을 받으면 '자식은 부모를 접근할 순 있다' / '부모가 자식을 접근할 수 없다.' / 그래서, name과 getName이 당연하게 부모클래스를 접근한 것.
		OvSuper os = new OvSuper();
		System.out.println("os(부모클래스가 부모클래스 접근)의 변수 :" + os.name);
		System.out.println("os(부모클래스가 부모클래스 접근)의 메서드 :" + os.getName());
		System.out.println();
		// 자식클래스 참조변수 = 자식클래스 인스턴스
		OverrideEx_ForStudy oe = new OverrideEx_ForStudy();
		System.out.println("oe(자식클래스가 자식클래스 접근)의 변수 :" + oe.name);
		System.out.println("oe(자식클래스가 자식클래스 접근)의 메서드 :" + oe.getName());		
		System.out.println();
		// 부모클래스 참조변수 = 자식클래스 인스턴스	*** 특히 중요 / 제일 어려운데 제일 많이 쓰임
		
		OvSuper os2 = new OvSuper();

		os2 = oe;
		os = new OverrideEx_ForStudy();
		if(os2 == os)System.out.println("os= oe; 와 os= new OverrideEx_ForStudy 는 같습니다.");
		else System.out.println("os= oe; 와 os= new OverrideEx_ForStudy 는 다릅니다.");

		System.out.println("os(부모클래스가 자식클래스 접근)의 변수 :" + os.name);			//부모클래스
		System.out.println("os(부모클래스가 자식클래스 접근)의 메서드 :" + os.getName());	//자식클래스
		System.out.println();
				/*
				작은 컵이 있고, 큰 컵이 있다. ( ex) int, double)
				작은 걸 큰 걸로 옮기는 건 된다.	-> 자동으로 자료형이 바뀐다 / double로(자동형변환)
				큰 걸 작은 걸로 옮기는 건 안된다.	-> 강제 형변환 가능.

				클래스도 자료형
				"상속받은" 클래스에서는
				(자식) 작은 컵 / (부모) 큰 컵
					부모는 개념상, 자식 클래스를 전부 포함한다는 의미가 있다.
				자식(으로 만든 인스턴스(데이터))을 부모(로 만든 인스턴스(데이터))로 옮기는 건 된다	->	이것도 자동 형변환(promotion)	 / 클래스 형변환
				부모(로 만든 인스턴스(데이터))를 자식(으로 만든 인스턴스(데이터))으로 옮기는 건 안 된다
					메서드는 다른 얘기 / 객체를 10개 잡으면 똑같은게 다 잡히는데
					메서드는 행위, 행위 자체가 달라지진 않는다, 그건 낭비고, 그래서 메모리도 따로 잡고, 하나만 만들어놓는다.


				*/
		
		// 자식클래스 참조변수 = 부모클래스 인스턴스	**	이것도 많이 쓰임
			// oe = new OvSuper();		/	OverrideEx.java:75: error: incompatible types: OvSuper cannot be converted to OverrideEx
			oe = (OverrideEx_ForStudy) new OvSuper();	//-> 강제 형변환이 됐음.
		
		/*
			부모(로 만든 인스턴스(데이터))를 자식(으로 만든 인스턴스(데이터))으로 옮기는 건 안 된다 -> 잘라서 넣으면 double도 int에 들어간다!!!!


		
		*/

	
	}
}


/*
boolean	equals(Object anObject)
문자열 두개 비교할 때 쓰는 메서드
매개변수에 스트링 주세요 해야되는데
오브젝트 주세요 라고 써있다.
	오브젝트로 주세요 라는건 뭐냐...
	자바에서의 오브젝트는 최상위 클래스
		참조변수, 저 클래스에 해당하는 객체를 만들어서 던져야 되
		equals(Object a)	이거 객체 만들어 달란 소리잖아? / 많은 사람들이 new Object 이렇게 넣는다고 생각을 하는데
		오브젝트를 받겠다는건 모든 클래스의 조상, 참조변수, 부모클래스의 참조변수는 자식클래스로 만든 인스턴스를 받아준댔지
		부모는 자식을 받아줘. 오브젝트는 모든 클래스의 조상. 자바에 있는 어떤 클래스로 객체를 만들어서 던져도 다 받겠다는 소리
		객체는, 다, 받겠다!
		이런 뜻이 되는 겁니다.

MenuItem	add(MenuItem mi)
	add 라는 메서드가 MenuItem 이라는 객체를 달래.
	왜 이걸 자꾸 강조하냐면, 오늘 배운 내용을 모르면 저 메서드를 50% 밖에 못 써
	두 가지 중요한 것 중에 하나.
		여기에 new MenuItem() 해서 던진건 알꺼 아냐
		근데 MenuItem 밑에
			자식클래스로 Menu 자식이 또 있어.
			그 자식 Menu를 객체로 만들어서 줄 수도 있는것
			

그래서 상속관계도 따져야되.
	가장 큰 문제. 
	String. 하 이거 받겠다는 메서드 볼 때마다 String의 자식클래스도 따져봐야되냐.
	그쳐?
	근데 String 클래스는 자식을 볼 필요가 없어, FINAL 이야 자식 없어 더이상/
	String 받겠다? 그럼 String만 보면 되
	다른애들, 객체를 받겠다! 라는 애들은 상속관계를 따져서 그 애의 자식도 넣을 수 있다는 것.

	(제네릭하고도 연관된 개념)
*/