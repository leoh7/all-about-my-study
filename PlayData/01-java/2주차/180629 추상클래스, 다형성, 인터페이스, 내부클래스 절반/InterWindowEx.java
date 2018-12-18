// 1. ���� �������̽� implements
// 2. �������̽��� implements �ϰ� �ִ� adapter�� extends	/	�̰� �ȵǸ�?


import java.awt.Frame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class InterWindowEx extends Frame implements WindowListener {	// ���� Frame�� ��ӹް� �ֱ� ������ 2���, adapter�� ��� �� �� ���� / ���� ��� / �׷��� ������ adapter Ŭ������ ����Ŭ������ ���� new �ؼ� ���� �������� ���Ŵ�
	// �����ڿ��� ���� �ϱ��
	public InterWindowEx(){
		setSize(500,700);		// ũ��
		setLocation(700, 100);	// �¿쿩��, ���Ͽ���
		setVisible(true);
		addWindowListener( this );
	} // ������
	
	// ���� ������(�������̵�)�� ���� ����������modifier �� ���� pulbic ���� �ٲ��ָ� ������ ��������!
	// ���� ������ ������ �ͺ��� �Ѵܰ� �δܰ� �̻� ��� ��� �ϴµ�
	// public �ָ� ���� �����̴�
	// event ó���� �����̴�
	// ���� �޼��带 ȣ������ �˾�? ����. ����� ��������
	// �׷��� ���� �����ϰ� �ִ°� �ʿ���
	// �װ� Listener / ������

	public void	windowActivated(WindowEvent e){}	// ������ ���۵� ��
	public void	windowClosed(WindowEvent e){}		// ������ ���� ��
	public void	windowClosing(WindowEvent e){		// ������ �ݴ� ��, �츮�� ���Ŵ� �̰�	/ �������� �Ⱦ��ž� / �׳��� swing �Ѿ�� �Ƚ�
		System.exit( 0 );	// 0�� ��������
	}												
	public void	windowDeactivated(WindowEvent e){}	// ������ �ڿ� ���� ��
	public void	windowDeiconified(WindowEvent e){}	// ������ �ø� ��
	public void	windowIconified(WindowEvent e){}	// ������ ���� ��
	public void	windowOpened(WindowEvent e){}		// ������ ����������


	
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


API �󿡼� �޼��� ���� public ���� ǥ���ϱ� �����Ƽ� �� ����ٰ� �������� / ��κ� �� public �̴ϱ�
Interfae������ �Ⱦ��� public�� �ƴ϶� default��
�� ���Ť������������� �� �̵����� ���������


*/