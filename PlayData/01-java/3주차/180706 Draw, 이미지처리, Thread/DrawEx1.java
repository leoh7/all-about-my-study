import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//���콺 �̺�Ʈ�� �׸��� �׸���


public class DrawEx1 extends JFrame{
	int ox;	//old x
	int oy;	//old y
	int x,y;

	Graphics g;

	public DrawEx1(){

		setBounds( 1400, 200, 400, 400);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		g = getGraphics();	// �׷��� ��ü�� �������� ��. JComponent �� ��ӹ��� �ֵ鸸 ����	// �������� ���� ���� ������ �ҷ��;��Ѵ�.
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
	}	// ������
	
	// �޼���

	public static void main(String[]args){
		new DrawEx1();
	}

}

/*
class JFrame

Graphics	getGraphics()
Creates a graphics context for this component.


*/