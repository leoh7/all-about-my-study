import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.awt.event.WindowListner;

class InnerWindowEx extends Frame {
	public InnerWindowEx(){
		setSize(400,500);
		setLocation(1200, 500);
		setVisible(true);
//		WindowAdapter wa = new WindowAdapter(){};	//���� ���ϰ� �̷��Ը� �ص� ������ ����.	/ abstract ���� ���� new ���ϰ� ����� �������� �̿ϼ� �Ȱ� ���� abstractŬ����. �׷��� new �� �� �ִ�.�̿ϼ��� �ƴ϶� / �ʿ��� �޼������ �����Ǹ� ����� �Ѵ�.

/*		��� 1��/////////////////////////////
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing( WindowEvent e ){
				System.exit(0);
			}
		};
		addWindowListener(wa);		// �͸� ����Ŭ������ �̿��ؼ� �ƴ��͸� ����ϴ� ���
	}	//������
		///////////////////////////////////


/*		��� 2��/////////////////////////////		*/
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
