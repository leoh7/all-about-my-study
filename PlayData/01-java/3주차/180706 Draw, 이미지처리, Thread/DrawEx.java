import java.awt.*;
import javax.swing.*;

class DrawEx extends JFrame {
	public DrawEx() {
		
		
		setBounds(1200, 200, 400, 400);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}	//생성자
	
	public void paint(Graphics g){
		super.paint(g);		// 부모쪽 paint 를 먼저 실행하고 나서 우리껄 실행하게끔 / 안그러면 단순한 오버라이딩이 되서 Window에서 처리하던 많은 paint 기능이 사라진다
	//	Graphics2D g2 = g;	// 부모를 자식에 넣은거니깐 안되지? 형변환 해준거야
	//	Graphics2D g2 = (Graphics2D) g; 
	// 혹은 super.paint ( g2 );
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);

		
		g2.drawRect( 10, 40, 50, 50 );
		g2.setColor( Color.PINK );
		g2.fillRect( 70, 40, 50, 50 );
		g2.drawLine( 140, 40, 300, 90 );
		g2.drawLine( 140, 140, 300, 90 );

		g2.drawOval( 10, 120, 100, 50 );
		g2.clearRect( 70, 70, 100, 100 );
		g2.fillRoundRect( 10, 250, 100, 100, 10, 10 );


		
	}
	
	public static void main (String []args){
		new DrawEx();
	}
}


/*
PaintEvent
프레임하고 패널밖에 못 그려
그릴라면 pen 이 있어야 되는데 그걸 만들 수가 없어
이걸 만들어주는 메서드가 있는데 그 메서드가 프레임하고 패널밖에 못 씀.

JFrame
void	repaint(long time, int x, int y, int width, int height)
Repaints the specified rectangle of this component within time milliseconds.

Window에 paint가 있다

Graphics2D
draw 로 시작하는 메서드는 속이 빈 도형
fill 로 시작하는 메서드는 속이 찬 도형
*/