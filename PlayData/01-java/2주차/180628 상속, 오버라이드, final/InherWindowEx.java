
import java.awt.Frame;
// 2. 상속	/ 원래 생성자라는게 객체 생성할 떄 초기화한다고 말했잖아. 뒤로 갈수록 객체 생성할 때 자동으로 호출 되. 굳이 초기화에만 쓰지말고 다른 역할들에 사용하면 안되냐. 당연히 됩니다. / 생성자에다 시키는 일은 프로그램 시작할 때 딱 한번만 할 일, 이건 생성자한테 줍니다. 크기, 계속 띄워라 뭐 이렇게. 모양 잡는 작업에서 생성자에다 다 때려넣어 거의
class InherWindowEx extends Frame {
	//private String title; ->이거 필요 없다

//생성자 구역

	public InherWindowEx (String title){
		super(title);	// 부모의 생성자를 쓸 거니깐 Frame(String title) 요걸 쓰는거임 / 쓰기위해 super를 하는 거고 ㅇㅋ?
	//	this.title = title;	->이거 필요 없다

		setSize(500, 700);
		setVisible(true);
	}
//생성자 구역 끝

	public static void main(String[] args) {
	//	setSize(500, 700);
	//	setVisible(true);	// non static 이 아니라고 에러. 호출해야 할 메서드가 따로 필요하다고 이 메서드를 호출하는 메서드를 또 만드는 것도 이상하고 / 하니까 어차피 실행되는, 어차피 호출되야 하는 생성자에다가 초기값을 다 때려넣는 것. / 최초에, 처음에, 한번만 실행하면 되는 것들만!

		
		//생성자 호출용 객체를 만든다.
			new InherWindowEx("상속연습"); //1회용 객체 -> 참조변수를 안 만들었지. 참조변수를 만드는 이유는 나중에 또 쓸려고 하는건데, 또 쓸게 아니니까 앞에 참조변수를 안 만들면 되는거야.



		/*
		// 1. 객체 생성
		Frame f = new Frame("상속연습");		// 여기까지 하면 잠깐 멈춘다. 사람이 느낄만큼 멈춘다는 것은 / 컴퓨터 입장에선 어마무시하게 기다리고 있는것. / 만들자마자 띄워라 할 수 없어 / 보여라 마라도 정해야되
		f.setSize(1000,1200);
		f.setVisible(true);
		*/

		

	}
}



/*
	window 클래스를 쓰면 아무것도 못함
	그래서 그 자식인 frame 이라는 클래스를 가져다 쓸꺼야
	public class Frame 객체 생성 됨
	생성자 있지
	FINAL 아니어서 상속도 되

원래 자바 GUI부분은 진도에 잘 안해
자바는 웹프로그램으로 굳어져 있어 ->JSP
이쪽 배우려면 안드로이드 배워야되
양 많아서 뺴야 하는데, 
어쨋든 자바 정리도 해야되고 프로젝트를 텍스트에 띄울 수도 없으니
그리고 안드로이드 만들 사람은 이거 배워놓으면 편함
	
	자바는 이 동안에 무조건 정리를 끝내야 한다.
	프로젝트 끝난 다음날, 발표 다음날에 자바 시험있습니다.

다 주관식. 코딩하는 문제도 있어. 서술도 있어. 


Frame() 디폴트
Frame(String title) 타이틀도 줄 수 있다.

	자바에 있는 클래스는 전부 다 Object 클래스의 자손이다.
	우리가 만든 클래스 조차도 Object 클래스의 자손이 된다.
	Object 자기 자신 딱 하나 빼고는 전부 다.
	모든 클래스를 다 묶기 위해서.

		java.awt.Component
		모든 GUI 클래스의 조상
			
			java.awt.Container
			모든 담아주는 애들의 조상

				





*/