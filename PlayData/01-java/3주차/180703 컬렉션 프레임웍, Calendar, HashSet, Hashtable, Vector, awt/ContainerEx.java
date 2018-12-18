/*
AWT 쓰면 안되요 이유는 나중에
Swing 다 할건 아니에요
많이 쓰는거 위주로 간단히

나중에 AWT 가 스윙이랑 중복되는게 있으니깐
 스윙에에서 
	 콤포넌트가 쥐유아이의 조상 스윙은 에떠티를 상속받아서 만든거야
	 그 밑에 있는게 여러 콤포넌트들
	 윈도우에서 제공하는걸 가져다 쓰는 중이다 보니까 윈도우 프로그램들은 다 이걸로 만든거야
	 어떻게 가져다 쓰고 모양을 만드는 부분만 신경을 쓰면되. 레이아웃 클래스(배치관리자)
	 그 중에 몇개만 가져다 쓰면 되요

	컨테이너는 담는 애
	컨테이너는 컴포넌트들을 담는 애 버튼 라벨 리스ㅡ 다 같은 라인이지
	형제처럼 보이는데 어떻게 담아.
	근데 그거는 대입할 때 얘기고, 이거는 전혀 다른 개념임. 붙인다고 생각하면 되
	컴포넌트는 도화지

		내일 이벤트 처리를 배우면 여기다 쓰면 되.
	컨테이너에 보면 프레임 있져 윈도우의 자식클래스로 프레임 있엇지
	윈도우 클래스를 쓰면 붙ㅌ이고 그런게 아무것도 안되

		다이얼로그. 메세지창 이걸 직접 만들면 쌩노가다를 해야되
		윈도우 띄우고 버튼 달고 이벤트처리 하고 어후
		이건 안합니다.
		안해도 되요
		스윙이 그래서 좋아, 만들어놓은게 있어 이쁘게

	탐색기 만들수 있어여 파일 출력할 때 쓸거야
	근데 AWT 도 있고 스윙에도 있어 열기, 저장 뭐 따로따로 나중에 할거

	우리가 지금 할 거는 패널
	프레임에 다 갖다 붙여도 되요
	근데 그렇게 하시면 안됩니다.
	패널에 붙였다가 패널을 프레임에 붙입니다.
	그냥 프레임에 다 갖다 붙이면 뭐 하나 빼버리면 모양이 다 박살나는 수가 있어
	컴포넌트 -> 패널 -> 프레임(윈도우 하나당 프레임 하나)
	대기실 화면, 게임 화면을 setVisible true false 로 놨다갔다
	스윙 가면 이터널윈도우로 중복해서 띄울수 있는데, 지금은 저 방법이 최선

	패널은 안에 생성자도 없고 아무것도 업성
	그냥 영역잡는거. 

	에플릿은, 쥐유아이를 윈도우에 띄울거면 프레임클래스
	웹브라우저에다 띄울거면 에플릿인데 요즘엔 보안때문에 프로그램을 못 띄워서 사장됨

	스크롤바
	이벤트가 엄청 많다. 애는 말 그대로 스크롤바만 붙여
	붙인다음에 이벤트 처리를 다 해줘야되
	한 페이지 중에 얼마나 이동시킬지도 ;ㅁ; 옛날엔 직접 했는데 ScrollPane 이게 만들어놓은거
	앞으로 ScrollPane 이거 쓰면 되 나중에 스윙때 할거야

	캔버스 같은것도 쓸 필요 없구여

	제일 먼저 컨테이너 중에 패널부터 보죠
	


계산기 할라면 그리드 레이아웃 이따할거야
*/

// 지금부턴 콘솔창이 아니라 윈도우에 띄운다는걸 기억하자. 지금부턴 도스창 필요 없서
// 도스창 뜨는거 귀찮으니까 없애부릴거야
// Container 연습
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class ContainerEx extends Frame {	// frame을 상속받으면 내가 frame이 된다.
	public ContainerEx(){
		// Panel
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
//		this.add(p1);
//		this.add(p2);
//		this는 생략 가능
		add(p1, "North");
		add(p2, "South");	//원래는 색깔도 안주고 크기도 안건드는데 우리가 눈으로 확인해보자 / 배경색, 글자색 / setBackground / set	/	Methods inherited from class java.awt.Component 에 있다
					//이미지를 넣고 싶어 이미지란 클래스로 만들어야되. 파일을 넣고 싶어 파일이란 클래스로 객체화 시켜야되
					// 컬러 객체 달라그러면 컬러란 클래스로 객체화 시켜야되.
					// Color(int r, int g, int b)
					// Creates an opaque sRGB color with the specified red, green, and blue values in the range (0 - 255).
					// 색상표에서 rgb 값을 가져다 쓰거나, 필드에서 가져다 쓸 수도 있다 / 필드값은 대문자로 써야하는데 / color 클래스만 특이하게 소문자로도 갖고 있다
		add(p3, "Center");
		add(p4, "West");
		add(p5, "East");
		
		p1.setBackground( Color.RED);
		p2.setBackground( Color.BLUE);
		p3.setBackground( Color.LIGHT_GRAY);
		p4.setBackground( Color.MAGENTA);
		p5.setBackground( Color.YELLOW);

					/*LayoutManager 란게 있고 BorderLayout, FlowLayout, GridLayout, CardLayout / 카드레이아웃은 안해, 그리드레이아웃은 쌩노가다니깐 하지마 / 플로우레이아웃은 계산기 할 때 쓸거
					카드레이아웃 -> 핸드폰 화면이 작으니깐 화면을 아주 갈면서 쓸 수 있게 만들어 놓았던거
					왜 우리는 파란 패널만 나오냐 프레임의 기본 레이아웃이
					프레임에는 패널 두개 붙였지. 레이아웃 지정을 안하면 보더레이아웃이 프레임의 기본 레이아웃
					레이아웃 지정 안하면 플로우레이아웃이 기본 레이아웃.
					
						보더레이아웃 전체 화면을 다섯개로 쪼갤수 있어. 위치를 지정할 수 있는데 레이아웃들이 다 지랄맞아, 입맛이 다 달라. 위치를 지정할 수 있는건 유일함 / 근데 크기 지정 안되
						플로우레이아웃 얘는 위치도 크기도 지정 안되
					빨간 패널 붙일때 위치지정 안했지. 위치지정 안하면 센터가 기본이야
					센터는 기본이다 보니까 센터만 지정하면 전체에 빨패널이 다 붙었어
					그러고 파패널 붙일때도 위치지정 안해서 센터에 붙고 다 파패널 이고
					빨패 위에 파패가 덮여있는상태야. 붙일 때 지정한다(add 시에)
					*/

//		이 아래도 this.가 생략되있는거 알지?
		setBounds(1200, 200, 400, 700);	//여백 여백 크기 크기
		setVisible(true);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e){
					System.exit(0);
				}
			}	// 익명 클래스 끝	
		);	//메서드 끝

	}


	public static void main(String[] args) {
		new ContainerEx();
	}
}
