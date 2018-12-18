import java.awt.*;
import javax.swing.*;

class DrawEx extends JFrame {
	public DrawEx() {
		
		
		setBounds(1200, 200, 400, 400);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}	//������
	
	public void paint(Graphics g){
		super.paint(g);		// �θ��� paint �� ���� �����ϰ� ���� �츮�� �����ϰԲ� / �ȱ׷��� �ܼ��� �������̵��� �Ǽ� Window���� ó���ϴ� ���� paint ����� �������
	//	Graphics2D g2 = g;	// �θ� �ڽĿ� �����Ŵϱ� �ȵ���? ����ȯ ���ذž�
	//	Graphics2D g2 = (Graphics2D) g; 
	// Ȥ�� super.paint ( g2 );
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
�������ϰ� �гιۿ� �� �׷�
�׸���� pen �� �־�� �Ǵµ� �װ� ���� ���� ����
�̰� ������ִ� �޼��尡 �ִµ� �� �޼��尡 �������ϰ� �гιۿ� �� ��.

JFrame
void	repaint(long time, int x, int y, int width, int height)
Repaints the specified rectangle of this component within time milliseconds.

Window�� paint�� �ִ�

Graphics2D
draw �� �����ϴ� �޼���� ���� �� ����
fill �� �����ϴ� �޼���� ���� �� ����
*/