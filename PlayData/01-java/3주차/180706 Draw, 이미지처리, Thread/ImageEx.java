import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageEx extends JFrame {
	Toolkit tk;	// Window 를 상속받은 애들만 getToolkit() 을 사용할 수 있다.
	Image img;	// 이미지 객체를 만든다.
	int x = 10;
	int y = 50;
	public ImageEx(){
		tk = getToolkit();
		img = tk.getImage("duke.gif");	// 이미지 객체화 시킴

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

	}	// 생성자 끝

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		g2.drawImage( img, x, y, 50, 50, this);	// 이미지는 크다보니까 무조건 바로 그려라는 안되고 이미지 버퍼에 가져다 놓고 로드가 됐을 때 그려야되. 이걸 누가 확인할 거냐 / 옵저버에 아무나 가져다 쓸 수 있는데 / 왠만한 놈들은 전부 ImageObserver 인터페이스를 상속받고 있어서 
							//x, y를 변수로 바꿔서 움직일 수 있게 할 거다. 어차피 그리는건 여기서만 할 수 있기 때문에
	}

	public static void main(String[]args){
		new ImageEx();
	}
}