/*	이벤트처리
	이벤트 소스(Event Source)		이벤트가 발생되는 컴포넌트
	이벤트 리스너(Event Listener)	이벤트가 발생하는지를 검사.
								이벤트를 처리할 수 있도록 핸들러를 호출
	이벤트 핸들러(Event Handler)	이벤트를 처리하는 메서드

	ActionEvent			Button List MenuItem 등의 Component가 눌리거나 선택이 되었을 때
	AdjustmentEvent		Scrollbar 와 같은 조정 가능한 컴포넌트에서 조정이 일어날 때			// 처리 안합니다. 스윙에서는 슬라이더	// 근데 이벤트가 다 처리되있어서 이제 필요 없음
	ComponentEvent		Component의 모습이나 크기가 이동 변화될 때						// 부모 역할이 해서 처리 안함
	ItemEvent			List Choice Checkbox 같은 Component의 선택항목이 선택될 때		// 선택만이 아니라 해제했을 때도
	TextEvent			TextField TextArea 에서 값이 입력되거나 지워질 때				// 하긴 할텐데 잘 안해요 / 다음달에 많이 하는데 그때는 KeyEvent라고 함 / 5글자만 받아야 할 때, 글자수를 세서 경고창을 띄운다던지?
	ContainerEvent		Container에 Component가 추가되거나 제거될 때					// 이것도 거의 안해요
	FocusEvent			Component에 초점이 들어올 때									// 이건 KeyEvent랑 같이 얘기할 겁니다 / 
	PaintEvent			Component가 그려져야 할 때									// 그림을 그리거나 그림그린걸 이동시키거나 할 때는 무조건 해야 하는데, 이건 따로 뺄겁니다. 예제를 두 세개 할겁니다. 이미 처리는 되있어 / 윈도우를 띄우면 일단 되있긴 해 / 처리하는 방식이 달라 / 감지기도 못 붙여 / 메서드 호출까지 다 된 상태 / 이벤트 완료, 감지기 완료, 호출까지 완료 / 어떻게 바꾸나? / 중간에 가로채서 처리를 해야 해서 이건 다시 따로 할거야. / 난 이거 쓰고 싶다
	WindowEvent			Window가 활성화되거나 비활성화 될 때 최소 최대 종료 될 때				// 처리해서 안합니다
	KeyEvent			키보드로 부터 입력이 될 때										// 중요
	MouseEvent			마우스가 눌려지거나 움직일 때 커서가 들어오거나 나갈 때					// 중요



	C, MFC 계열에서는 메세지 / 우리는 이벤트라고 부릅니다.
	이벤트 소스.
	이벤트 리스너.	갑지기
	이벤트 핸들러.
	발생하는 소스한테 감지기를 붙이고, 감지기가 호출할 수 있는 메서드만 붙여주면됩니다.
	대신 문제는 이벤트 리스너가 호출할 수 있는 메서드는 자동호출 되기때문에 정해져 있는데
	이벤트 핸들러들(메서드)은 정해져 있습니다. 인터페이스로, 인터페이스 모르면 그래서 여기 힘들어여
	우리한테 이벤트 소스는, 지금배운 컴포넌트들이 이벤트 소스가 됩니다.
		컴포넌트들이 뭔가 해. 버튼을 눌러. 리스트에서 선택을 해, 체크박스 체크해, 텍스트 에어리어에서 글자를 입력해
	그럼 그 때 이벤트 소스가 이벤트를 발생시키는 거야
	액션 이벤트 / 버튼, 메뉴아이템, 리스트, 텍스트 필드 이런데서만 발생해 유일하게 얘네 넷은 공통점이 없어.
	누가 무슨 이벤트를 발생시키는지 알고 쓰셔야댕

		// 이벤트 처리를 하려며 main에도 메서드가 필요하기 때문에, 멤버 변수로 넣어줄 필요가 있다.
	
*/

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class EventEx extends Frame implements ActionListener, ItemListener, TextListener {		//ActionListener 같이 메서드가 하나밖에 없는 interface 들은 당연하지만 아답터가 없다. 필요도 없지.
	//멤버 변수
	private Panel south, center, north, northLeft, northCenter;	// 이벤트처리 안할 거
	private Button ok, del, exit;								// 이벤트처리 할 거
	private TextArea ta;										// 이벤트처리 할 거
	private Choice ch;											// 이벤트처리 할 거
	private Checkbox cb1, cb2, cb3;								// 이벤트처리 할 거
	Random r = new Random();
	//생성자
	public EventEx() {
			Font f = new Font( Font.SANS_SERIF, Font.BOLD, 30);
			Font e = new Font( Font.SANS_SERIF, Font.BOLD, 18);
	//		Color back = new Color(150, 150, 250);
	//		Color inBack = new Color( 160,160,255 );

		// 이벤트 처리
			
			// 하단
			south = new Panel();
			south.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );	//패널로 프레임을 다 덮을거니까 프레임은 색깔 안줄겁니다
			
			
			ok = new Button("확인");				// 제일 먼저 구현한 곳에 포커스의 디폴트가 들어간다. 키 이벤트는 포커스가 있는 곳에서 입력받는 것으로 
			del = new Button("삭제");
			exit = new Button("종료");

			ok.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			del.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			exit.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			
			ok.setFont(f);
			del.setFont(f);
			exit.setFont(f);
			south.setLayout( new FlowLayout( FlowLayout.CENTER, 40, 10 ) );
			
			south.add(ok);		// 패널 기본은 플로우, 플로우는 기본적으로 가운데 정렬
			south.add(del);
			south.add(exit);

			add(south, "South");	// 뒤에 "South" 뭐지? / BorderLayout 위치

			south.setForeground(Color.WHITE);
			
			
			// 중단 / 상단하단 들어간거 나머지를 잡아야 해서 뒤에 잡을거야
			center = new Panel();
			center.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			ta = new TextArea( "", 14, 40, TextArea.SCROLLBARS_NONE );
			ta.setBackground( new Color(245,245,245) );
			ta.setFont( e );
			ta.setEditable(false);	// 입력 불가
			center.add( ta );
			
			add( center, "Center" );
			
			// 상단 / 좀 복잡합니다 / 패널 위에다 패널을 또 붙여야 하기 때문에 / 일단 north가 있고 그걸 또 왼쪽 오른쪽 나눌겁니다
			north = new Panel();
			northLeft = new Panel();
			northCenter = new Panel();

			// 좌상단 붙이기
				// Choice
			ch = new Choice();
			ch.add("경기도");
			ch.add("강원도");
			ch.add("경상도");
			ch.add("전라도");
			ch.add("충청도");
			ch.add("제주도");
			ch.setFont(e);
			northLeft.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			northLeft.add(ch);
				// Checkbox
			cb1 = new Checkbox("축구");
			cb2 = new Checkbox("농구");
			cb3 = new Checkbox("야구");
			cb1.setFont(e);
			cb2.setFont(e);
			cb3.setFont(e);
			northCenter.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			northCenter.setForeground(new Color(245,245,245));	// 요걸로 야매로 글자색을 정해버릴 수 있다. 한번에 .
			northCenter.setLayout(new FlowLayout( FlowLayout.CENTER, 20, 7));
			northCenter.add(cb1);
			northCenter.add(cb2); 
			northCenter.add(cb3);

			north.setLayout(new BorderLayout());
			north.add( northLeft, "West");
			north.add( northCenter, "Center" );
			add (north, "North");

				

		setBounds(1200, 200, 500, 600);
		setVisible(true);
			
	

/*감지기*/	addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e ){
					System.exit(0);
				}
			}	// 익명 클래스 끝	
		);	// 메서드 addWindowListener 끝
/*감지기*/	ok.addActionListener( this );	//감지기가 다 해, 근데 모르는게 뭐냐면 메서드가 어디 구현되어있는지는 몰라, 그래서 this.
/*감지기*/	del.addActionListener( this );
/*감지기*/	exit.addActionListener( this );

/*감지기*/	cb1.addItemListener(this);
/*감지기*/	cb2.addItemListener(this);
/*감지기*/	cb3.addItemListener(this);

/*감지기*/	ta.addTextListener(this);
/*감지기*/	del.setEnabled(false);	// 삭제버튼이 처음부터 활성화가 되있을 필요가 없는거지!!!!!!!

/*감지기*/	ch.addItemListener(this);
			// KeyEvent // 제일 먼저 구현한 곳에 포커스의 디폴트가 들어간다. 키 이벤트는 포커스가 있는 곳에서 입력받는 것으로 
			ta.requestFocus();
			ta.addKeyListener(
				new KeyAdapter() {
					public void keyPressed(KeyEvent e){
						Rectangle r = getBounds();		//getBounds ->Component
						
						
						switch( e.getKeyCode() ){
							case KeyEvent.VK_UP: ta.append("위로\n"); setLocation( r.x, r.y - 5);break;
							case KeyEvent.VK_DOWN: ta.append("아래로\n"); setLocation(r.x, r.y + 5);break;
							case KeyEvent.VK_LEFT: ta.append("왼쪽으로\n"); setLocation(r.x-5, r.y);break;
							case KeyEvent.VK_RIGHT: ta.append("오른쪽으로\n"); setLocation(r.x+5, r.y); break;
						}
					}
				}	
			);
/*감지기*/	
/*감지기*/	
/*감지기*/
/*감지기*/
/*감지기*/
			// MouseEvent
			ta.addMouseListener(	// 왜 ta냐면 ta 안으로 들어왔냐 나갔냐를 볼거니깐
				new MouseAdapter(){
					
					public void mouseClicked(MouseEvent e){
						ta.setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
					}
					public void mouseEntered(MouseEvent e){
						ta.append("마우스 들어갔다\n");
					}
					public void mouseExited(MouseEvent e){
						ta.setBackground( new Color(245,245,245) );
						ta.append("마우스 나갔다\n");
					}
				}
			);

			// MouseWheelEvent
			ta.addMouseWheelListener(
				new MouseAdapter(){
					Random r = new Random();
					public void mouseWheelMoved( MouseWheelEvent e){
					ta.setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
					}
				}	
			);
	}	// 생성자

////////////////// 메서드 /////////////////////////////////////////////////////////////////
		//ActionEvent	/*버튼이 여러개이니까 각각이 소스가 되는거야 / 내가 확인버튼 눌러도 삭제 눌러도 종료 눌러도 다 actionPerformed로 일루와 / 양이 엄청나게 많아지겠지? / 이 3개중에 액션을 발생시켜주는게 누구냐. 를 먼저 알아야해. 골라내야 하는데, 우리가 발생하는게 아니니까 골라낼 수가 없어. 그래서 여기서 e. 하고 ActionEvent 라는 클래스에서 메서드를 쓸 수 있어. API ㄱㄱ*/

		public void actionPerformed( ActionEvent e){	//ActionListener 같이 메서드가 하나밖에 없는 interface 들은 당연하지만 아답터가 없다. 필요도 없지.
			
			String com = e.getActionCommand();
			if( com.equals( "확인" )){
//				ta.setText( "확인했습니다.\n" );	// setText는 덮어써서 한번밖에 안나온다.
				ta.append( "확인했습니다.\n" );
			}else if( com.equals("삭제")){
//				ta.removeNotify();	// TextArea가 지워진닼ㅋㅋㅋㅋ
				ta.setText( "" );
			}else if( com.equals("종료")){
				System.exit(0);
			}
		}
		

		//아이템 이벤트 / 선택 했을때, 해제 했을 때 / 그래서 하나를 더 잡아야되. 누가 이벤트를 발생시켰냐만이 아니라 누가 선택이냐, 누가 해제이냐
		// ItemEvent
		public void itemStateChanged( ItemEvent e) {
			
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				ta.append(e.getItem() + "를 선택했습니다.\n");
			} else if(e.getStateChange() == ItemEvent.DESELECTED) {
				ta.append(e.getItem() + "를 해제했습니다.\n");
			}
		}

		// TextEvent 글자가 한 글자 들어오거나, 글자가 한 글자 이상 삭제되거나 하면 발생함 / 지금은 글자 편집을 금지 시켜놨는뎅 / 약간 꼴꺼야 / 삭제버튼과 연동시킬거임
		public void textValueChanged(TextEvent e){
	//		ta.getText().equals(""); //리턴하는건 String 클래스 객체, 리턴값은 어디로? 호출한 자리, 이 자리로 뭐가 넘어오냐면 문자열이 넘어오는데 그게 스트링클래스 객체 / 메서드 쓸때는 객체 쩜 메서드지 넘어왔지 그게 스트링클래스객체지 / 그럼 여기서 바로 메서드를 쓸 수가 있다!!!!!!!!!!
			if(ta.getText().equals("")){
				del.setEnabled(false);
			}else{
				del.setEnabled(true);
			}
		}
		
		
		



/////////////////////////////////////////////main 메서드 시작////////////////////////////////////////////////
	public static void main (String []args){
		new EventEx();
	
		// ActionEvent	// Button 만 해보자, 리스트는 의미 없고 메뉴아이템이랑 텍스트는 나중에 할거

		// KeyEvent
		// MouseEvent
	}
}



/*
Class ActionEvent
String	getActionCommand()
Returns the command string associated with this action.
int	getModifiers()
Returns the modifier keys held down during this action event.
long	getWhen()
Returns the timestamp of when this event occurred.
String	paramString()
Returns a parameter string identifying this action event.

getSource 얘를 쓰면 객체를 리턴시켜, 나중엔 이걸로 할거야. 사실 이걸로 하는게 맞는데 나중에 하자


ItemEvent
void	itemStateChanged(ItemEvent e)
Invoked when an item has been selected or deselected by the user.

getStateChange
public int getStateChange()
	Returns the type of state change (selected or deselected).
	Returns:
	an integer that indicates whether the item was selected or deselected
	See Also:
	SELECTED, DESELECTED
필드		SELECTED
		public static final int SELECTED
		This state-change value indicates that an item was selected.
		See Also:
		Constant Field Values
		DESELECTED
		public static final int DESELECTED
		This state-change-value indicates that a selected item was deselected.
		See Also:
		Constant Field Values



Class ItemEvent

Object	getItem()
Returns the item affected by the event.
ItemSelectable	getItemSelectable()
Returns the originator of the event.
int	getStateChange()
Returns the type of state change (selected or deselected).
String	paramString()
Returns a parameter string identifying this item event.





choice에서 getSelected index나 item 이런걸 써야되

충청도 / 충청도를 선택했습니다. 그리고 글자를 가져와야 되





Class TextEvent
메서드가 없네???????????? paramString() 은 잘 안쓰는거
얘가지고는 안되
TextArea에 있냐 없냐를 체크해야되니까 거길 봐야되



Class Choice

int	getSelectedIndex()
Returns the index of the currently selected item.
String	getSelectedItem()
Gets a representation of the current choice as a string.



KeyListener
void	keyPressed(KeyEvent e)
Invoked when a key has been pressed.
void	keyReleased(KeyEvent e)
Invoked when a key has been released.
void	keyTyped(KeyEvent e)
Invoked when a key has been typed.

KeyEvent	
char	getKeyChar()
Returns the character associated with the key in this event.

얘가 더 편하다.  필드보자
int	getKeyCode()
Returns the integer keyCode associated with the key in this event.


마우스
void	mouseClicked(MouseEvent e)
Invoked when the mouse button has been clicked (pressed and released) on a component.
void	mouseEntered(MouseEvent e)
Invoked when the mouse enters a component.
void	mouseExited(MouseEvent e)
Invoked when the mouse exits a component.
*/