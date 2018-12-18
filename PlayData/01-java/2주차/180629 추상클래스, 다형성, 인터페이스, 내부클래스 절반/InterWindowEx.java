// 1. 직접 인터페이스 implements
// 2. 인터페이스를 implements 하고 있는 adapter를 extends	/	이게 안되면?


import java.awt.Frame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class InterWindowEx extends Frame implements WindowListener {	// 지금 Frame을 상속받고 있기 때문에 2방법, adapter를 상속 할 수 없다 / 다중 상속 / 그렇기 때문에 adapter 클래스에 내부클래스를 만들어서 new 해서 쓰는 방향으로 갈거다
	// 생성자에서 일을 하기로
	public InterWindowEx(){
		setSize(500,700);		// 크기
		setLocation(700, 100);	// 좌우여백, 상하여백
		setVisible(true);
		addWindowListener( this );
	} // 생성자
	
	// 내가 재정의(오버라이드)할 때는 접근제한자modifier 를 전부 pulbic 으로 바꿔주면 에러가 없어진다!
	// 접근 제한자 지정된 것보다 한단계 두단계 이상 줘라 라고 하는데
	// public 주면 만사 오케이다
	// event 처리는 상상력이다
	// 언제 메서드를 호출할지 알아? 몰라. 사용자 마음이지
	// 그래서 저걸 감시하고 있는게 필요해
	// 그게 Listener / 감지기

	public void	windowActivated(WindowEvent e){}	// 윈도우 시작될 때
	public void	windowClosed(WindowEvent e){}		// 윈도우 닫힐 때
	public void	windowClosing(WindowEvent e){		// 윈도우 닫는 거, 우리가 쓸거는 이거	/ 나머지는 안쓸거야 / 그나마 swing 넘어가면 안써
		System.exit( 0 );	// 0은 정상종료
	}												
	public void	windowDeactivated(WindowEvent e){}	// 윈도우 뒤에 있을 때
	public void	windowDeiconified(WindowEvent e){}	// 윈도우 올릴 때
	public void	windowIconified(WindowEvent e){}	// 윈도우 내릴 떄
	public void	windowOpened(WindowEvent e){}		// 윈도우 열린다음에


	
	public static void main(String[] args) {
		new InterWindowEx();
	}
}

/*
void	windowActivated(WindowEvent e)
Invoked when the Window is set to be the active Window.
void	windowClosed(WindowEvent e)
Invoked when a window has been closed as the result of calling dispose on the window.
void	windowClosing(WindowEvent e)
Invoked when the user attempts to close the window from the window's system menu.
void	windowDeactivated(WindowEvent e)
Invoked when a Window is no longer the active Window.
void	windowDeiconified(WindowEvent e)
Invoked when a window is changed from a minimized to a normal state.
void	windowIconified(WindowEvent e)
Invoked when a window is changed from a normal to a minimized state.
void	windowOpened(WindowEvent e)
Invoked the first time a window is made visible.


API 상에서 메서드 설명에 public 직접 표기하기 귀찮아서 안 써놨다고 생각하자 / 대부분 다 public 이니깐
Interfae에서는 안쓰면 public이 아니라 default야
이 병신ㄷ가은색끼들이 왜 이따위로 만들었을까


*/