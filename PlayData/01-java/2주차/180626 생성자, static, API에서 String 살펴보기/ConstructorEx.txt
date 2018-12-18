/*			ConstructorExam1
생성자	Constructor
생성자는 메서드다.
클래스명과 동일하다.
결과형 반환형이 없다.
구현하지 않으면 default 가 실행된다
객체 생성시 자동 호출 된다.
객체 초기화에 사용된다.

1번 main만 보고 멤버 변수, 멤버 메서드 짜보기
2번 this 써보기(모르겠으면 그냥 쓰는 방법만)
3번 생성자는 중요하니깐 알아두기(맨 아래)
4번 셋터랑 생성자에 this. 써서 완성하세요(미완)

*/


class ConstructorEx {
	private String name;		//셋터 두개 겟터도 두개 니까 멤버 변수도 두개가 필요하다
	private int age;
		
	public void setName(String n){		// 이름 지을 때 set뒤에 대문자는 규칙
		name = n;
	}
	public void setAge(int x){
		age = x;
	}

	public String getName(){			// 이름 지을 때 get뒤에 대문자는 규칙
		return name;
	}
	public int getAge(){
		return age;
	}


	//*******생성자 제작 부분********//


//	public ConstructorEx( String name, int age){		//넘겨받는 데이터와 넘겨주는 데이터가 같을 경우엔 이름을 같게 해주는 게 규칙
//		this.name = name;
//		this.age = age;
//	}
//	public ConstructorEx(int age){
//		this("int만 받은 name", age);
//	}
//	public ConstructorEx(String name){
//		this(name, 555);
//	}
		
			/*
				public ConstructorEx(String name, int age){
				this.name = name;
				this.age = age;
				}	
			*/
								//this를 설명할 부분


	//******밑으로는 main 메서드********//

	public static void main (String[] args){
		ConstructorEx ce1 = new ConstructorEx();	//객체 생성할 때 ConstructorEx() 이 부분이 생성자를 호출한다. / 메서드 처럼 생겼찌?
	//	ce1.setName("홍길동");	// String 받는 변수 필요
	//	ce1.setAge(30);			// int 받는 변수 필요
		System.out.println("이름 : " + ce1.getName() );
		System.out.println("나이 : " + ce1.getAge() );
//	
//		ConstructorEx ce2 = new ConstructorEx("이순신", 40);
//		System.out.println("이름 : " + ce2.getName() );
//		System.out.println("나이 : " + ce2.getAge() );
//
//		ConstructorEx ce3 = new ConstructorEx(30);
//		System.out.println("이름 : " + ce3.getName() );
//		System.out.println("나이 : " + ce3.getAge() );
//
//		ConstructorEx ce4 = new ConstructorEx("홍길동");
//		System.out.println("이름 : " + ce4.getName() );
//		System.out.println("나이 : " + ce4.getAge() );
	}	//main

}	//class

/*
	private String name;	
	이거 초기화 안하는데 왜 에러 안날까?
	변수는 초기화를 해야 쓸 수 있다고 했는데.

	이건 누군가가 초기화를 해주고 있다는 얘기.(보이지 않는 손?)
	객체를 하나 만들었어
	메모리를 할당 받아서 다 저장이 되지
	객체에는 다 쓰레기 값, 이걸 초기화 해야되
	그러면 여태까지는 변수 잡을 때 초기화를 했었단 말야 int a = 0;
	그렇게 하면 항상 똑같은 값으로 초기화 되니깐 재활용의 의미가 좀 퇴색된단 말야

	게다가 클래스를 통해 들어가면 메서드를 통해 들어가야되는데
	셋터를 호출해줘야되, 겟터를 호출해야되 계속 셋터,겟터에서 초기화 계속 해줘야되
	10개 10개 = 20개 100개 100개 =200개 어우

	그래서 클래스로 넘어오면서 접근을 막고 이러니깐 초기화 하기가 힘들어진거야
	
	쫌 더 초기화를 쉽게 하는 방법은 없을까?

	그래서 생각한 것이 그냥 자동으로 초기화하게 하는 뭔가가 있으면 좋겠다(default 생성자)
	생성자라는 애를 직접 구현하지 않는 이상은, default 생성자가 항상 숨어서 자동으로 멤버들을 초기화하는 역할을 해주게 하자.
		그러면 엄청 편해져
		생성자도 메서드야. 선언, 구현, 호출 이걸 다 해야되.
		생성자는, 직접 만들 필요없지. 자동이니깐(선언 구현 안해도 되)
		게다가 호출도 할 필요 없다. 객체 생성시 자동 호출 된다
		깐단해여.
	그래서 클래스를 설계할 때 초기값을 안 줘도 되는거야.
	String 은 null
	int 는 0
	이런식으로
		

		그런데 인제 문제가 있습니다.
		int a = 0; 이렇게 할 수도 있지만
		항상 0으로 초기화 하는게 아니라 어떤 특정값(바로 써먹을)으로 초기화 하고 싶을 때도 있잖아
			나는 int a = 10; 으로 초기화 할래! 이렇게
		근데 default 생성자는 null, 0 이따위로만 초기화를 한단 말야.
		이렇게 기존 것으로는 안되기에 생성자를 직접 구현해서 내가 원하는 초기값을 설정하는게 가능하게 만들어 보자

			constructorEx ce2 = new ConstructorEx("이순신", 40);
		이렇게 만들어보자.
		이러면 에러가 난다.
		생성자를 써서 좋은 점은, 알아서 자동으로 해줘, 안만들어도 되, 자동으로 호출까지 되.
		대신에 반대로 객체를 만들면 무조건 생성자가 호출이 되. 도리어 불편할 때도 있어. 불편할 때가 더 많아.
		그래서 ce1 이든 ce2 이든 생성자를 호출하기 싫어도 호출해야되.
			이걸 받아줄 생성자를 구현할 필요가 있어.

	생성자는 메서드야.
	내가 내 맘대로 아무 메서드를 만들어놓고 자동 호출해! 이건 좀 이상하지. 어떻게 하면 자동으로 호출해 라고 약속이 있어야지
	그 약속에 생성자의 이름을 클래스명과 동일하게 지어야 한다는 것.
	조심할 건, 메서드 만들 때 첫글자를 소문자로 만들지. 생성자는 클래스 이름과 똑같이 만들어야 하니까 첫 글자를 대문자로 만들어야되

	무조건 메서드는 리턴이 있다고 했어. void가 있다는건 return 을 하긴 하는데 리턴 값이 없다는 얘기랬잖아. void 여도 return 하고 적어도(생략해도) 에러가 안나는거야
	하지만 최소한 void는 써줘야 했지

	근데 생성자는 결과형, 반환형이 없다. 라는 것은 void 조차도 없다는 소리. void 써도 에러가 안나. 근데 이건 생성자가 아니라 일반 메서드로 인식을 해부러서 그런거야, 
	우리가 생각하는 방향과 다른 방향으로 동작해버리는 것.
	왜 리턴을 안하냐? 메서드 리턴값 호출하면 어디로 돌아와? 호출했던 자리로 돌아오지. 
	생성자 누가 호출해? 우리가 안하지. 우리가 안하기 때문에 리턴값을 줘봤자 사용할 수도 없는거야. 그래서 리턴을 못하게 막아놓은 것.
	그래서 void 조차도 안 쓰는 거야.

		자. 구현해 봅시다

		public ConstructorEx( String n, int a){		
		name = n;
		age = a;
		}
		
	이렇게 만들어 놓으면 이전에 구현해 놓은 생성자(default)가 에러를 난다
	직접 생성자를 구현했을 때 자동생성자와 충돌 할 수 있어서 자동생성자는 못 쓰게 해버리는거야
	그래서 default 생성자를 따로 구현한다
		public ConstructorEx(){}
		
	자 이렇게 똑같은거 두개를 만들어 놓으면 이걸 뭐라 그런다?
	오버로드
	지금 생성자가 오버로드 된거야.

		우리가 기존에 만들어진 클래스를 갖다 쓴다 해보자.
		그럼 뭐부터 한다? 객체 생성
		객체를 생성하면 뭐가 호출된다? 생성자
		나이는 초기화하는데 이름은 내가 객체를 생성할 때 쓰고 싶어. 이건?
			public ConstructorEx(String name){
				this.name = name;
				this.age = 0;
			}
			
			api에서 int형 4개면 int형 4개
				제일먼저 확인해야 하는건 생성자, 제공되는 생성자를 보고 매개변수를 뭘 달라고 하는지를 확인한 다음에
				그것대로 클래스를 만들어야되. 바꿔 쓸 순 있지만 그런 경우는 많진 않아. 이게 오오피

	클래스를 갖다쓰기 위해 
		1번 객체생성
		2번 상속이 되냐 안되냐 확인
		3번 둘 다 안되면 static
	

	this
		this가 없었으면 클래스를 가져다 쓰지도 못했을 거야

		궁금한게 생기지. 
		stack 에 저장된 ce1(시작주소값이 들어있다) 이 heap 에 저장된 name 과 age를 참조해서 가져오는데
		ce2 도 가져온단 말야. 근데 ce2 는 "이순신", 40이지?

		얘네가 메인에서 잡은 변수야. 지역변수라는 얘기
		메인에서 ce1 ce2 를 잡았어. main은 지역변수야. 메인의 지역변수 메인만 쓸 수 있는 변수
		heap을 접근하는것도 main밖에 접근을 못한다는 소린데.

		클래스에 있는 생성자든 메서드든 얘네들은 어떻게 알고 멤버 변수들을 들고 오고 갖다 넣느냐

		사실 return this.age 가 생략되어 있는거야. 원래 생략 가능해

		ce2를 잡으면 main에서 잡은거라 메인밖에 몰라( 생성자는 몰라 )
		우리 눈에 안보이지만 항상 멤버 메서드로 호출할 때는 맨 앞에 그 위치값(참조값)이 넘어가게 되어있어

		앞에서 생성자에 (//이부분// name, age ) 이 부분에 ConstructorEx//클래스 이름// this 인 애로 받게 되어있어

		멤버변수들은 자동으로 this 라는 방이 생기는 거고 this라는 주소를 통해서 참조를 했던 것..
		
		ce1.getNmae
		ce2.getNmae
		name이 두갠데 어떻게 구분을 하냐
		
		메인은 this가 없다. 그냥 참조변수를 쓰면 되니깐. 만들 수도 없고 만들 필요도 없고.
		

생성자 안에 name 방이 두개고 age방이 두개지. 매개변수로 name과 age 방이고
서열이 있으면 우선순위, 안 싸운다. 같은 이름의 방이 있어도
this가 만들어준건 내꺼 아냐
그래서 
사람이 한 명 있으면 철수라고 불러야지 누구는 인호라고 부르면 이상하잖아
그래서 문제가 생겼어 네임을 같이 했더니 지건줄 알고 돌아가니깐
this.name, this.age 



		데이터를 넣는 메서드, 생성자와 셋터에 이름이 똑같으면 매개변수와 멤버 변수의 이름이 같을 때
		멤버변수 앞에다만 this를 써주면 아무 문제 안 생겨


*/


//그럼 전역변수 영역에서 class의 객체를 생성하면 this가 없어도 참조하는것이 가능할까?