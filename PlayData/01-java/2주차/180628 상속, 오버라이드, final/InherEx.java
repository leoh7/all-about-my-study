/*
상속		Inheritance
부모 것은 내 것.
생성자는 제외
재사용( 재활용 )
코드의 간결성. 개발시간의 단축

class CellPhone		모델명, 전화번호 관리
class CaPhone		화소 관리
class Mp3Phone		화음 관리
	
	cf) 데이터를 넣는 기능은 뭐가 있을까?
	생성자는 객체 생성할 때 한 번 밖에 못넣어 (초기값)
	셋터는 메서드니까 원할때마다 호출해서 데이터를 바꿔 넣을 수 있지

셋터까지 다 하면 너무 복잡해지니까
오늘은 생성자 초기화로 데이터를 넣고, 
*/
	// main 시작
class InherEx {
	public static void main(String[] args) {
	//	CellPhone cp = new CellPhone("모델명", "010-1111-2222");
	//	System.out.println("모 델 명 : "+ cp.getModel());
	//	System.out.println("전화번호 : "+ cp.getTel());

	//	CaPhone ca = new CaPhone("모델명","010-1111-2222",500 );
	//	System.out.println("모 델 명 : "+ ca.getModel());
	//	System.out.println("전화번호 : "+ ca.getTel());	
	//	System.out.println("화    소 : " + ca.getPixel());

		Mp3Phone mp3 = new Mp3Phone("모델명", "010-1111-1111", 500, 64);
		System.out.println("모 델 명 : "+ mp3.getModel());
		System.out.println("전화번호 : "+ mp3.getTel());	
		System.out.println("화    소 : " + mp3.getPixel());
		System.out.println("화    음 : " + mp3.getChord());

		
	}
}	// main 끝

class CellPhone {	// 전화기능
							// kt향 skt 향 중국 향 이런게 있음 / 같은 기종이라도 모델명이 다를 수 있엄 / 어따가 납품하냐에 따라
	private String model;	// 모델명
	private String tel;		// 전화

	public CellPhone( String model, String tel ){
		this.model = model;
		this.tel = tel;
	}
//	public CellPhone(){}

	public String getModel(){	return model;	}
	public String getTel()	{	return tel;		}
}	// class CellPhone


class CaPhone extends CellPhone{	// 전화기능 + 카메라기능
// 멤버 변수
	private int pixel; 

// 생성자
	public CaPhone(String model, String tel, int pixel){		//	public CaPhone(String model, String tel, int pixel){ / 각자 자기 것만 해야 되는데 카폰이 셀폰이 하는 기능까지 건들고 있어 / this.model = model 이랑 tel 은 얘가 기능을 건들어선 안되지
		super(model, tel);	// 이게 원래 있는데 생략이 되어있는 것. 부모 생성자를 호출하는 생성자. public CellPhone(){} 을 부르는 친구 / 데이터를 부모쪽으로 던져줘야 한다.
					// 위치 중요함. 항상 맨 처음에 해줘야 해 / 생성자는 생성자 끼리 밖에 호출이 안됨
//		this.model = model;			// 이건 자식클래스가 직접 접근하겠다는 얘긴데 / 그러면 안되고 데이터를 super(model, tel); 로 단순히 데이터만 넘겨준 것. 그래서 멤버변수의 접근제한자를 다시 private으로 바꿔줘도 괜찮아진다.
//		this.tel = tel;				// InherEx.java:55: error: tel has private access in CellPhone -> CellPhone의 model, tel 의 접근제한자를 고쳐줬다
		//
		this.pixel=pixel;
	}
//	public CaPhone(){}
// 멤버 메서드
	public int getPixel()	{	return pixel;	}
}	// class CaPhone


class Mp3Phone extends CaPhone{ 
//멤버 변수
	private int chord;
//생성자
	public Mp3Phone(String model, String tel, int pixel, int chord){
	super(model, tel, pixel);

	this.chord = chord;
	}

//멤버 메서드
	public int getChord()	{	return chord;	}
}	// class CaPhone


/*
상속이란 내용자체는 굉장히 쉽다
그러나 내용 중에 빼먹는 것 없이 다 기억해야 한다.

제일 먼저 만들건, 전화기능을 하는 핸드폰 설계도를 만든다고 가정할 거야.
선택한 값을 저장할 수 있는 전화번호, 기종
CaPhone이라는 애가 CellPhone 을 상속 받기로 하자.
	super 클래스
	sub 클래스
		
		
		자식 클래스는 부모의 멤버를 전부 가져다 쓸 수 있어 / 유일하게 생성자만 빼고


	CaPhone이라는 기능을 설계하는 중에 전화기능을 설정할 필요가 없는 것.
	Mp3Phone은? 전화, 카메라, MP3 기능도 있어야되
	그럼 자기는 MP3 기능만 설계하고 나머지는 상속해서 받을꺼야

	직접 코딩을 할 필요가 없다->코드 개발 시간 단축
	재사용, 재활용 할 수 있고. 코드 간결하고
	에러 잡기도 편해.

상속단계가 복잡해지면
클래스가 갖고 있는 메서드는 일 하나. 할아버지, 아버지 100개씩 있고 내가 100개 가지고 있으면
메서드가 300개가 되는 것.
상속은 거의 단점이 없어

	
		상속을 구현할 때면 반드시 자식의 영역만 건들어야 해
		CaPhone을 만들 땐 카메라 기능만 건들어야 한다는 것.
		그게 깔끔하고 오류도 안나

지금 예제에서는 CellPhone도 만들고 CaPhone도 만들고 Mp3Phone도 만들어야 하지만
API를 보면서 상속만 해서 받아오는 것도 해볼거야

		InherEx.java:51: error: constructor CellPhone in class CellPhone cannot be applied to given types;
		부모-자식 상속을 하면 자식의 생성자 쪽에서 에러가 나는데, CellPhone의 생성자가 이상하다고 에러메세지가 뜬다.
		이럴 땐 부모의 클래스에 default 생성자를 하나 만들어준다.

		!! 최하위 클래스만 객체로 만들고 부모 클래스는 만들지 말 것 !!
		!! 둘 다 잡으면 똑같은 데이터 방이 2개 이상 생긴다는 소리잖아 !!

상속을 받으면 객체의 초기화도 부모건 부모가, 자식건 자식이 하라는 의미로
부모거 생성자가 먼저 호출 됨, ->이게 눈에 안보이는 super	// 위치 중요함. 항상 맨 처음에 해줘야 해 / 생성자는 생성자 끼리 밖에 호출이 안됨
부모쪽 생성자가 호출이 되면서 부모건 부모가 자식건 자식이 
하기로 했는데
이건 값이 없을 때 얘기야. super(); 
부모쪽으로 데이터를 던져줘야되. 니가 해라 하고 


	다중상속 / 왜 안되냐??
	자바는 클래스만 다중상속이 안되고
	인터페이스라는 문법을 만들어서 그건 다중상속이 되

	C는 다중상속이 되지만 사용이 안되, 사기야.
	자바는 다중상속이 안되게 했지만, 인터페이스를 가지고 쓸 수 있어.
	
	클래스를 쓸 때 
	1.객체 생성 (메모리 할당)	//안되? 상속
	2.멤버가 전부 static인지 확인
	3.

우리가 GUI를 만들거야
AWT나
Swing -> AWT를 수정해서 만든거라 Swing을 쓰는게 맞아요. 근데 한번에 하면 힘드니까 잠깐 하고 갈거임. 겹치는거 많아요
다음주 초에 GUI를 만들게 될꺼야 Swing을 배우게 될꺼야
다음주 말 쯤 첫번째 과제가 나갈겁니다
다 동일한 과제구요
주말포함 3~4일
다음주 말 나가면 그 다음 월/화 발표를 시킬꺼야 -> 평가
주제는 동일하기 때문에 서로서로를 비교할 수 있겠찌

잘 하는 사람을 팀장으로 뽑을거야
	과정에 없지만 자바를 정리하기 위해서 5일정도 빼서 프로젝트를 하는것
	4명이 1팀을 해야하고 다음주에 팀장 뽑고 팀원 뽑고
	문서를 만들어서 자기네가 뭘 할지 발표하고	-> 평가
	자바 마지막날(DB 들어가기 전)

	이런걸 다 GUI로 짜야되

	사전에 해야 할 것. 윈도우를 먼저 띄워야 되. 윈도우를 띄우는게 기본
	윈도우즈, 윈도우들이 모여있다. 그래서 윈도우즈.
	에딧플러스도 윈도우, 창들이 윈도우. 윈도우 위에 또 띄우고 감추고 띄워주고 하는 작업을 해서 프로젝트를 해오면 됩니다. 밤을 좀 새야 하실거임.
	다른 사람들이 만든 퀄리티를 보면 아 장난 아니구나 하는 생각이 들거
	다음주 과제 -> 똑같은 주제의 선배들 과제. 보여줄거임. 못놀거야 주말에 ㅇㅇ

	문서, 회의, 코딩 등등등등등등

당장 다음 주 일
숙제를 안 내도 할 일이 있으니까 숙제는 안 냅니닼ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

	윈도우를 띄우려면 상속을 적용해서 윈도우를 띄울거야
	AWT를 사용할거임. 윈도우를 띄울거니까 상속을 적용하면 되.
	내일 인터페이스를 배울거야. 인터페이스를 적용해서 윈도우를 또 띄울거, 내부 클래스(이너 클래스) 
	이렇게 3번을 띄울건데 이렇게 해서 맨 마지막에 띄울 윈도우가 가장 기본 윈도우

	이렇게 윈도우 하나를 띄우는 것도 무척 어려운 일.


*/

