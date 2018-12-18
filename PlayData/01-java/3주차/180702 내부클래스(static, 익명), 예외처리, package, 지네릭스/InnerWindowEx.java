import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.awt.event.WindowListner;

class InnerWindowEx extends Frame {
	public InnerWindowEx(){
		setSize(400,500);
		setLocation(1200, 500);
		setVisible(true);
//		WindowAdapter wa = new WindowAdapter(){};	//구현 안하고 이렇게만 해도 에러가 없다.	/ abstract 으로 만들어서 new 못하게 만들어 놓았지만 미완성 된게 없는 abstract클래스. 그래서 new 할 수 있다.미완성이 아니라서 / 필요한 메서드들은 재정의를 해줘야 한다.

/*		방법 1번/////////////////////////////
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing( WindowEvent e ){
				System.exit(0);
			}
		};
		addWindowListener(wa);		// 익명 내부클래스를 이용해서 아답터를 사용하는 방법
	}	//생성자
		///////////////////////////////////


/*		방법 2번/////////////////////////////		*/
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e ){
					System.exit(0);
				}
			}	
		);
	}
		////////////////////////////////////
	public static void main(String[] args) {
		new InnerWindowEx();	
	}
}	// class 
