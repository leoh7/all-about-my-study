// EventHandler()를 익명 클래스로 전환하세영
// 왜 전환해야 할까요
// Eventhandler 가 WindowAdapter를 상속하고 있다.
// 



import java.awt.*;
import java.awt.event.*;

class Exercise7_28 {
	public static void main(String[] args) {
		Frame f = new Frame();

		f.addWindowListener(new EventHandler(){
			public void windowClosing(WindowEvent e){
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);} 
			} 
		);
	}	// main
}

/* 정답
import java.awt.*;
import java.awt.event.*;

class Exercise7_28_2{
public static void main(String[] args) {
	Frame f = new Frame();
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	});
	} // main
}
*/