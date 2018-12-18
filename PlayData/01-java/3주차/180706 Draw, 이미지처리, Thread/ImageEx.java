import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageEx extends JFrame {
	Toolkit tk;	// Window �� ��ӹ��� �ֵ鸸 getToolkit() �� ����� �� �ִ�.
	Image img;	// �̹��� ��ü�� �����.
	int x = 10;
	int y = 50;
	public ImageEx(){
		tk = getToolkit();
		img = tk.getImage("duke.gif");	// �̹��� ��üȭ ��Ŵ

		setBounds(1200, 200, 500, 500 );
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(
			new KeyAdapter(){
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode() ){
						case KeyEvent.VK_UP :
							y -= 5;
							break;
						case KeyEvent.VK_DOWN :
							y += 5;
							break;
						case KeyEvent.VK_LEFT :
							x -= 5;
							break;
						case KeyEvent.VK_RIGHT :
							x += 5;
							break;
					}
					repaint();		// repaint -> update -> paint
				}
			}	
		);

	}	// ������ ��

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		g2.drawImage( img, x, y, 50, 50, this);	// �̹����� ũ�ٺ��ϱ� ������ �ٷ� �׷���� �ȵǰ� �̹��� ���ۿ� ������ ���� �ε尡 ���� �� �׷��ߵ�. �̰� ���� Ȯ���� �ų� / �������� �ƹ��� ������ �� �� �ִµ� / �ظ��� ����� ���� ImageObserver �������̽��� ��ӹް� �־ 
							//x, y�� ������ �ٲ㼭 ������ �� �ְ� �� �Ŵ�. ������ �׸��°� ���⼭�� �� �� �ֱ� ������
	}

	public static void main(String[]args){
		new ImageEx();
	}
}