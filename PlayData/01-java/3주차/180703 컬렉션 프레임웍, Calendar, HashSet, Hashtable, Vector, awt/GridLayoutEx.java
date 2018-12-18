/*
GridLayout
*/
import java.awt.*;
import java.awt.event.*;
class  GridLayoutEx extends Frame {
	
	
	public GridLayoutEx(){
		//setLayout( new GridLayout(2, 2) );		// 기본 개념이 행 우선, 무조건 행을 맞춰라. 2행 2열인데 5개 붙이면 3열이 생긴다, 사실 (2, 0)이랑 똑같아. // 열은 무시해라 = 행우선
//		setLayout( new GridLayout(0, 2));	// 열 우선
//		setLayout( new GridLayout(0, 2, 20, 30));	// 갭
		setLayout( new GridLayout(0, 4));

		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
		add(new Button("7"));
		add(new Button("8"));
		add(new Button("9"));
		add(new Button("10"));
		add(new Button("11"));
		add(new Button("12"));
		add(new Button("13"));
		add(new Button("14"));
		add(new Button("15"));
		add(new Button("16"));
		add(new Button("17"));
		add(new Button("18"));
		add(new Button("19"));
		add(new Button("20"));
		add(new Button("21"));
		add(new Button("22"));
		add(new Button("23"));
		add(new Button("24"));


		

		setBounds(1200, 200, 700, 500);	//여백 여백 크기 크기
		setVisible(true);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e){
					System.exit(0);
				}
			}	// 익명 클래스 끝	
		);	// 메서드 끝

	}	// 생성자 끝
	


	public static void main(String[] args) {
		new GridLayoutEx();
	}	// main 끝
}	// class GridLayoutEx 끝