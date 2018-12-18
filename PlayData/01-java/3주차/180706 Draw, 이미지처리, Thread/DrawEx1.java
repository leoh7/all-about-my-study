import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//마우스 이벤트로 그림을 그리기


public class DrawEx1 extends JFrame{
	int ox;	//old x
	int oy;	//old y
	int x,y;

	Graphics g;

	public DrawEx1(){

		setBounds( 1400, 200, 400, 400);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		g = getGraphics();	// 그래픽 객체를 가져오는 것. JComponent 를 상속받은 애들만 가능	// 프레임이 먼저 나온 다음에 불러와야한다.
		g.setColor( Color.RED );

		addMouseListener(
			new MouseAdapter(){
				public void mousePressed( MouseEvent e ){
					x = e.getX();
					y = e.getY();
					System.out.println(x + " : "+ y);
				}
				
			}
		);
		addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged( MouseEvent e ){
					ox = x;
					oy = y;
					x = e.getX();
					y = e.getY();
					g.drawLine( ox, oy, x, y );
				}
			}	
		);
	}	// 생성자
	
	// 메서드

	public static void main(String[]args){
		new DrawEx1();
	}

}

/*
class JFrame

Graphics	getGraphics()
Creates a graphics context for this component.


*/