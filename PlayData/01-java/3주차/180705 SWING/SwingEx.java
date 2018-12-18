/*
스윙을 쓰는 이유, 편하다 예쁘다
엄밀히 애기하면 스윙을 쓰는 이유는 


	자바의 장점 중 하나는 플랫폼에 독립적,
	다른 운영체제에서도 실행이 가능하다는 것.
	운영체제 걸 가져다 쓰기 때문에 다른 운영체제에서 실행하면 윈도우의 레이아웃이 깨질 수 있다는 것.
	자바의 장점인 플랫폼에 독립적 이라는 장점이 깨져버린다.

그래서 만든게 스윙이에요. 
자바가 그냥 똑같은걸 하나씩 다 만들었어요 ㅋ

awt 짤 때 보면 윈도우 이벤트, 이게 들어가는 이유가 x 버튼으로 끄기 위함이잖아?
스윙으로 넘어오면서 어차피 새로 만드는거 편하게 만들자 해서 x표 누르면 꺼져
문제가 있는게 set default 이게 하이드로 되어있어

스윙이 Pane (미리 만들어진)이 많아요. 스윙에서의 프레임은 기본적으로 패널이 붙어서 나와
맨 밑에 JFRame
Jrootpane
layeredpane 위에 메뉴바
glasspane
contentpane 얘가 문제



스윙에서는 contentPane에 붙여여
1.4버전
cp=getContentPane;
그래서 이렇게 써서 얻어와야 해.
이미 만들어져 있는 채로 제공되니까 get 해와야 하는거야 / 우리가 만든게 아니라 이름을 모르니까
cp.add()

근데 이게 너무 불편해가지고 1.5이후부턴 그냥 add 하시면 되여
똑같네 그러면 contentPane에 붙어영

스윙ㅇ의 제일 부모는 JComponent.
그 밑에 J라고 붙은애들이 좍 있어여 잘 보셔야 되는게 Jcomponent의 부모가 Container, 그 부모가 Component
결과적으로 awt 에 있는걸 다 가져다 쓰면 된다는 소리

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SwingEx extends JFrame implements ActionListener {
	//멤버 변수
	private JPanel north, south;
	private JScrollPane sp;	// 중단
	private JButton ok, can;
	private JLabel la;	//상단 좌
	private JTextField tf;	//상단 우
	private JTextArea ta;
	Random r = new Random();

		//JMenuBar, JMenu, JMenuItem
		private JMenuBar mb;
		private JMenu mfile, medit, mview, mcolor;
		private JMenuItem mnew, mopen, msave, mexit,
						minput, moutput,
						mred, mblue, myellow, mselect;

	//생성자
	public SwingEx(){
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
	//메뉴바->메뉴->메뉴 아이템

		// 메뉴바 생성
		mb = new JMenuBar();
		setJMenuBar( mb );
		// 메뉴 생성
		mfile = new JMenu("파일(F)");
		medit = new JMenu("편집(E)");
		mview = new JMenu("보기(V)");
		mfile.setMnemonic( KeyEvent.VK_F);		//JMenu 클래스에 있다.
		medit.setMnemonic( KeyEvent.VK_E);
		mview.setMnemonic( KeyEvent.VK_V);

		mb.add( mfile );
		mb.add( medit );
		mb.add( mview );

		// 메뉴 아이템 성성
			mcolor = new JMenu("색상");
			mview.add( mcolor );

			mnew = new JMenuItem("새 파일");
			mopen = new JMenuItem("열기");
			msave = new JMenuItem("저장");
			mexit = new JMenuItem("종료");
			
			mfile.add( mnew );
			mfile.addSeparator();
			mfile.add( mopen );
			mfile.add( msave );
			mfile.addSeparator();
			mfile.add( mexit );

			minput = new JMenuItem("입력");
			moutput = new JMenuItem("출력");
			medit.add( minput );
			medit.add( moutput );

			mred = new JMenuItem("빨강");
			mblue = new JMenuItem("파랑");
			myellow = new JMenuItem("노랑");
			mcolor.add( mred );
			mcolor.add( mblue );
			mcolor.add( myellow );

			mselect = new JMenuItem("선택");
			mview.add( mselect );

		// 하단
		south = new JPanel();
			ok = new JButton("확인");
			can = new JButton("취소");
			ok.setFont(f);
			can.setFont(f);
			south.add(ok);
			south.add(can);
		add(south, "South");

		// 중단
		ta = new JTextArea(); // 센터에 붙이면 크기 알아서 먹습미다
			sp = new JScrollPane(ta);	// 이미지를 넣을거면 여기다가. 얘는 만들때 넣어서 만들면 되여	// JScrollPane() 요기 안에 들어가는 매개변수 찾아보기
			ta.setFont(f);
		add(sp, "Center");
		// 상단
		north = new JPanel();	// 위치지정하기 위해 setLayout
			la = new JLabel("  입력 : ");	//왼쪽에 딱 붙는게 싫으면 띄어쓰기
			JLabel eastSpace = new JLabel("     ");	//오른쪽 띄어쓰기용
			tf = new JTextField();	//
			la.setFont(f);
			tf.setFont(f);
			north.setLayout( new BorderLayout() );	// 보더레이아웃으로 바꿔줌
			north.add(la, "West" );
			north.add(eastSpace, "East" );
			north.add(tf, "Center" );
		add(north, "North");
		//////////// 프레임 붙이기 끝

		//이벤트 처리 / 
		

		setBounds(1400, 200, 500, 690);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// KeyEvent 키 이벤트 최고당ㄷㅊㄷㅁ너디렂;ㅐ러;
		tf.addKeyListener(		// KeyEvent 클래스는 이렇게 쓴다. 이렇게 해놓고 case 만 키를 따로 잡아주면 되는거야
			new KeyAdapter(){
				public void keyPressed( KeyEvent e){
					switch( e.getKeyCode() ) {				//getkey 코드 쓰라그랬어여 그게 편해여
						case KeyEvent.VK_ESCAPE :	//KeyEvent 클래스에서 가져온거 봐라. 굳이 API를 찾을 필요가 없었지 임마
							tf.setText( "" );
							break;
						case KeyEvent.VK_W :		//단축키 잡기
							if(e.getModifiers() == /*부모*/KeyEvent.CTRL_MASK){
							System.exit(0);}
							break;
					}
				}	
			}	
		);
//		// FocusEvent	-> 포커스 고정
//		tf.addFocusListener(
//			new FocusAdapter(){
//				public void focusLost( FocusEvent e ){
//					tf.requestFocus();
//				}
//			}	
//		);

		// ActionEvent 감지기
		ok.addActionListener(this);
		tf.addActionListener(this);
		can.addActionListener(this);
		mred.addActionListener(this);
		mblue.addActionListener(this);
		myellow.addActionListener(this);
		mselect.addActionListener(this);
		mnew.addActionListener(this);
		mopen.addActionListener(this);
		msave.addActionListener(this);
		mexit.addActionListener(this);
		minput.addActionListener(this);
		moutput.addActionListener(this);
	}	/////////////////////////////////////////생성자 끝
	
	// 멤버 메서드
		// ActionEvent
		public void actionPerformed( ActionEvent e){	// 이 자리로 넘어오는게 20개가 넘는다. 누가 발생시키나 구분 먼저 하자. getActionCommand는 문자열이었지 / 해도 됭 / 근데 똑같은거 또 하면 재미없으니깐 getSource 써볼꺼야 / ActionEvent 의 조상 EventObject / 근데 얘는 오브젝트로 받는다는걸 명심
			Object obj = e.getSource();
			if( obj == ok || obj == tf ){		// 확인버튼의 참조변수 이름이 ok다, 그러면		// tf 에서 똑같은 일을 하면 같은 기능을 해라 / 엔터 / 
				String str = tf.getText(); // 빈 문자 들어가는거 빼기 위해 String으로 빼기
				if(!str.equals("")){
					ta.append(str +"\n"); // 텍스트에어리어.붙이기(텍스트 필드에 있는 내용을 얻어올래)
					tf.setText("");		
				}					
				tf.requestFocus();
			}else if (obj == can){
				tf.setText("");
				tf.requestFocus();
			}else if (obj == mred){
				ta.setBackground( Color.RED );
				ta.setForeground( Color.WHITE );
			}else if (obj == mblue){
				ta.setBackground( Color.BLUE );
				ta.setForeground( Color.WHITE );
			}else if (obj == myellow){
				ta.setBackground( Color.YELLOW );
				ta.setForeground( Color.BLACK );
			}else if (obj == mselect){
				ta.setBackground(/*Color 객체로 리턴*/JColorChooser.showDialog(this, /*타이틀*/"배경색을 선택하세요", Color.BLUE));
				ta.setForeground(/*Color 객체로 리턴*/JColorChooser.showDialog(this, /*타이틀*/"글자색을 선택하세요", Color.BLUE));
			}else if (obj == mnew){
				ta.setBackground( Color.WHITE );
				ta.setForeground( Color.BLACK );
				ta.setText("");
				tf.setText("");
			}else if (obj == mopen){
				JFileChooser fc = new JFileChooser(".");
				fc.showOpenDialog(this);
				ta.append(fc.getName(fc.getSelectedFile() ) + "\n" );
			}else if (obj == msave){
				JFileChooser fc = new JFileChooser(".");	// file 이름을 알아야 저장을 하징 / file 이름은 얻어올 수 있다 지금 단계에선
				fc.showSaveDialog(this);
				ta.append(fc.getName(fc.getSelectedFile() ) + "\n" );
			}else if (obj == mexit){
				//JOptionPane // 이것도 show 할거냐 말거냐 중요함
				
				int select = JOptionPane.showConfirmDialog(this, "정말로 종료할?", "종료메세지", JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.YES_OPTION ){
					JOptionPane.showMessageDialog(
						this, "종료합니다", "종료메세지", JOptionPane.INFORMATION_MESSAGE );
					System.exit(0);
				} else if( select == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(
						this, "돌아갑니다", "종료메세지", JOptionPane.ERROR_MESSAGE );} 
			}else if(obj == minput){
				String msg = JOptionPane.showInputDialog(
					this, "입력합니다","입력메세지",JOptionPane.WARNING_MESSAGE );
				if(msg != null && !msg.equals("") ){
					ta.append( msg + "\n");
				}
			}
		}

	public static void main (String[]args){
	//생성자 호출
		new SwingEx();
	}
}

/*
바로 이벤트처리 하면서 볼거에영
자바는 공개용이다 보니까 자꾸 여기저기서 만들어서 하잖아
자기들이 만든건 java라고 하고 다른 회사에서 만들어서 제공한건 javax 에다 넣었어


단축키
int	getModifiers()	// 같이 눌리는거 잡기
Returns the modifier mask for this event.
int	getModifiersEx()	// 고거 확장판
Returns the extended modifier mask for this event.

javax.swing	/	Class JColorChooser
static Color	showDialog(Component component, String title, Color initialColor)	//컴포넌트 여기가 부모창 쓰는 자리 / 부모가 누구야. 나지, this 쓰면 됩니다. this가 JFrame 임 지금 /
			Shows a modal color-chooser dialog and blocks until the dialog is hidden.	// 리턴값이 Color 객체네!!

modal기능 -> 뒤가 선택이 안되게 하는. 윈도우 추가로 해서
modalLess 기능 -> 뒤가 선택이 됨!
윈도우를 새로 띄웠지. 그럼 새로 띄운 윈도우를 자식, 뒤에 있는걸 부모 윈도우(상속관계 얘기하는거 아님)
모든 윈도우는 다 부모가 있다. 에디트 플러스의 부모는 운영체제가 되는 것.

저장창 열기창 static이 아니기 때문에 항상 객체먼저 생성해줘야 한다.
상대경로 / 절대경로

JFileChooser()
	Constructs a JFileChooser pointing to the user's default directory.
JFileChooser(File currentDirectory)
	Constructs a JFileChooser using the given File as the path.
JFileChooser(String currentDirectoryPath)
	Constructs a JFileChooser using the given path.



int	showOpenDialog(Component parent)
Pops up an "Open File" file chooser dialog.
int	showSaveDialog(Component parent)
Pops up a "Save File" file chooser dialog.

파일 가져오깅
String	getName(File f)
					Returns the filename.
File	getSelectedFile()
					Returns the selected file.
File[]	getSelectedFiles()
					Returns a list of selected files if the file chooser is set to allow multiple selection.




메세지 타입	//스태틱이네? 그냥 쓸 수 있다
리턴값이 int야? 그럼 필드를 찾아보자
static int	showConfirmDialog(Component parentComponent, Object message)
Brings up a dialog with the options Yes, No and Cancel; with the title, Select an Option.
static int	showConfirmDialog(Component parentComponent, Object message, String title, int optionType)
Brings up a dialog where the number of choices is determined by the optionType parameter.
static int	showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType)
Brings up a dialog where the number of choices is determined by the optionType parameter, where the messageType parameter determines the icon to display.
static int	showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)
Brings up a dialog with a specified icon, where the number of choices is determined by the optionType parameter.


static String	showInputDialog(Component parentComponent, Object message)	
static String	showInputDialog(Component parentComponent, Object message, Object initialSelectionValue)
static String	showInputDialog(Component parentComponent, Object message, String title, int messageType)
static Object	showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
static String	showInputDialog(Object message)
static String	showInputDialog(Object message, Object initialSelectionValue)



*/