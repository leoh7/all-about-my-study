/*
GridLayout
*/
import java.awt.*;
import java.awt.event.*;
class  GridLayoutEx extends Frame {
	
	
	public GridLayoutEx(){
		//setLayout( new GridLayout(2, 2) );		// �⺻ ������ �� �켱, ������ ���� �����. 2�� 2���ε� 5�� ���̸� 3���� �����, ��� (2, 0)�̶� �Ȱ���. // ���� �����ض� = ��켱
//		setLayout( new GridLayout(0, 2));	// �� �켱
//		setLayout( new GridLayout(0, 2, 20, 30));	// ��
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


		

		setBounds(1200, 200, 700, 500);	//���� ���� ũ�� ũ��
		setVisible(true);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e){
					System.exit(0);
				}
			}	// �͸� Ŭ���� ��	
		);	// �޼��� ��

	}	// ������ ��
	


	public static void main(String[] args) {
		new GridLayoutEx();
	}	// main ��
}	// class GridLayoutEx ��