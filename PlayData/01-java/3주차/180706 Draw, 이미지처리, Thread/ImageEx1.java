import java.awt.*;
import javax.swing.*;
import java.net.*;

class ImageEx1 extends JFrame {
	Toolkit tk;
	Image img;
	URL url;	

	public ImageEx1() {
		try{
			tk = getToolkit();
			url = new URL( "https://search2.kakaocdn.net/argon/0x200_85_hr/11kytaRuMBd" );
			img = tk.getImage( url );
			
			MediaTracker mt = new MediaTracker(this);	//java.net 패키지
			mt.addImage(img, 0);	//0은 순서
			System.out.println("이미지 로딩중...");
			mt.waitForAll();
			if(mt.isErrorAny() )	// 있냐 없냐 물어볼 땐 is
				{ System.out.println("이미지 로딩 실패"); 
				System.exit(1);
			}
			System.out.println("이미지 로딩 성공");

		} catch( MalformedURLException e ){
			e.printStackTrace();
		} catch( InterruptedException e ){
			e.printStackTrace();
		}
		

		setBounds( 1200, 200, 1000, 1000);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	
	public void paint( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		super.paint( g2 );
		g2.drawImage( img, 10, 50, 420, 314, this);	//JFrame 이 ImageObserver
	}

	public static void main(String[]args) {
		new ImageEx1();	
	}
}