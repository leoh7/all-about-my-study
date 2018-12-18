/*	�̺�Ʈó��
	�̺�Ʈ �ҽ�(Event Source)		�̺�Ʈ�� �߻��Ǵ� ������Ʈ
	�̺�Ʈ ������(Event Listener)	�̺�Ʈ�� �߻��ϴ����� �˻�.
								�̺�Ʈ�� ó���� �� �ֵ��� �ڵ鷯�� ȣ��
	�̺�Ʈ �ڵ鷯(Event Handler)	�̺�Ʈ�� ó���ϴ� �޼���

	ActionEvent			Button List MenuItem ���� Component�� �����ų� ������ �Ǿ��� ��
	AdjustmentEvent		Scrollbar �� ���� ���� ������ ������Ʈ���� ������ �Ͼ ��			// ó�� ���մϴ�. ���������� �����̴�	// �ٵ� �̺�Ʈ�� �� ó�����־ ���� �ʿ� ����
	ComponentEvent		Component�� ����̳� ũ�Ⱑ �̵� ��ȭ�� ��						// �θ� ������ �ؼ� ó�� ����
	ItemEvent			List Choice Checkbox ���� Component�� �����׸��� ���õ� ��		// ���ø��� �ƴ϶� �������� ����
	TextEvent			TextField TextArea ���� ���� �Էµǰų� ������ ��				// �ϱ� ���ٵ� �� ���ؿ� / �����޿� ���� �ϴµ� �׶��� KeyEvent��� �� / 5���ڸ� �޾ƾ� �� ��, ���ڼ��� ���� ���â�� ���ٴ���?
	ContainerEvent		Container�� Component�� �߰��ǰų� ���ŵ� ��					// �̰͵� ���� ���ؿ�
	FocusEvent			Component�� ������ ���� ��									// �̰� KeyEvent�� ���� ����� �̴ϴ� / 
	PaintEvent			Component�� �׷����� �� ��									// �׸��� �׸��ų� �׸��׸��� �̵���Ű�ų� �� ���� ������ �ؾ� �ϴµ�, �̰� ���� ���̴ϴ�. ������ �� ���� �Ұ̴ϴ�. �̹� ó���� ���־� / �����츦 ���� �ϴ� ���ֱ� �� / ó���ϴ� ����� �޶� / �����⵵ �� �ٿ� / �޼��� ȣ����� �� �� ���� / �̺�Ʈ �Ϸ�, ������ �Ϸ�, ȣ����� �Ϸ� / ��� �ٲٳ�? / �߰��� ����ä�� ó���� �ؾ� �ؼ� �̰� �ٽ� ���� �Ұž�. / �� �̰� ���� �ʹ�
	WindowEvent			Window�� Ȱ��ȭ�ǰų� ��Ȱ��ȭ �� �� �ּ� �ִ� ���� �� ��				// ó���ؼ� ���մϴ�
	KeyEvent			Ű����� ���� �Է��� �� ��										// �߿�
	MouseEvent			���콺�� �������ų� ������ �� Ŀ���� �����ų� ���� ��					// �߿�



	C, MFC �迭������ �޼��� / �츮�� �̺�Ʈ��� �θ��ϴ�.
	�̺�Ʈ �ҽ�.
	�̺�Ʈ ������.	������
	�̺�Ʈ �ڵ鷯.
	�߻��ϴ� �ҽ����� �����⸦ ���̰�, �����Ⱑ ȣ���� �� �ִ� �޼��常 �ٿ��ָ�˴ϴ�.
	��� ������ �̺�Ʈ �����ʰ� ȣ���� �� �ִ� �޼���� �ڵ�ȣ�� �Ǳ⶧���� ������ �ִµ�
	�̺�Ʈ �ڵ鷯��(�޼���)�� ������ �ֽ��ϴ�. �������̽���, �������̽� �𸣸� �׷��� ���� ����
	�츮���� �̺�Ʈ �ҽ���, ���ݹ�� ������Ʈ���� �̺�Ʈ �ҽ��� �˴ϴ�.
		������Ʈ���� ���� ��. ��ư�� ����. ����Ʈ���� ������ ��, üũ�ڽ� üũ��, �ؽ�Ʈ ������ ���ڸ� �Է���
	�׷� �� �� �̺�Ʈ �ҽ��� �̺�Ʈ�� �߻���Ű�� �ž�
	�׼� �̺�Ʈ / ��ư, �޴�������, ����Ʈ, �ؽ�Ʈ �ʵ� �̷������� �߻��� �����ϰ� ��� ���� �������� ����.
	���� ���� �̺�Ʈ�� �߻���Ű���� �˰� ���žߴ�

		// �̺�Ʈ ó���� �Ϸ��� main���� �޼��尡 �ʿ��ϱ� ������, ��� ������ �־��� �ʿ䰡 �ִ�.
	
*/

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class EventEx extends Frame implements ActionListener, ItemListener, TextListener {		//ActionListener ���� �޼��尡 �ϳ��ۿ� ���� interface ���� �翬������ �ƴ��Ͱ� ����. �ʿ䵵 ����.
	//��� ����
	private Panel south, center, north, northLeft, northCenter;	// �̺�Ʈó�� ���� ��
	private Button ok, del, exit;								// �̺�Ʈó�� �� ��
	private TextArea ta;										// �̺�Ʈó�� �� ��
	private Choice ch;											// �̺�Ʈó�� �� ��
	private Checkbox cb1, cb2, cb3;								// �̺�Ʈó�� �� ��
	Random r = new Random();
	//������
	public EventEx() {
			Font f = new Font( Font.SANS_SERIF, Font.BOLD, 30);
			Font e = new Font( Font.SANS_SERIF, Font.BOLD, 18);
	//		Color back = new Color(150, 150, 250);
	//		Color inBack = new Color( 160,160,255 );

		// �̺�Ʈ ó��
			
			// �ϴ�
			south = new Panel();
			south.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );	//�гη� �������� �� �����Ŵϱ� �������� ���� ���̴ٰϴ�
			
			
			ok = new Button("Ȯ��");				// ���� ���� ������ ���� ��Ŀ���� ����Ʈ�� ����. Ű �̺�Ʈ�� ��Ŀ���� �ִ� ������ �Է¹޴� ������ 
			del = new Button("����");
			exit = new Button("����");

			ok.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			del.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			exit.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			
			ok.setFont(f);
			del.setFont(f);
			exit.setFont(f);
			south.setLayout( new FlowLayout( FlowLayout.CENTER, 40, 10 ) );
			
			south.add(ok);		// �г� �⺻�� �÷ο�, �÷ο�� �⺻������ ��� ����
			south.add(del);
			south.add(exit);

			add(south, "South");	// �ڿ� "South" ����? / BorderLayout ��ġ

			south.setForeground(Color.WHITE);
			
			
			// �ߴ� / ����ϴ� ���� �������� ��ƾ� �ؼ� �ڿ� �����ž�
			center = new Panel();
			center.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			ta = new TextArea( "", 14, 40, TextArea.SCROLLBARS_NONE );
			ta.setBackground( new Color(245,245,245) );
			ta.setFont( e );
			ta.setEditable(false);	// �Է� �Ұ�
			center.add( ta );
			
			add( center, "Center" );
			
			// ��� / �� �����մϴ� / �г� ������ �г��� �� �ٿ��� �ϱ� ������ / �ϴ� north�� �ְ� �װ� �� ���� ������ �����̴ϴ�
			north = new Panel();
			northLeft = new Panel();
			northCenter = new Panel();

			// �»�� ���̱�
				// Choice
			ch = new Choice();
			ch.add("��⵵");
			ch.add("������");
			ch.add("���");
			ch.add("����");
			ch.add("��û��");
			ch.add("���ֵ�");
			ch.setFont(e);
			northLeft.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			northLeft.add(ch);
				// Checkbox
			cb1 = new Checkbox("�౸");
			cb2 = new Checkbox("��");
			cb3 = new Checkbox("�߱�");
			cb1.setFont(e);
			cb2.setFont(e);
			cb3.setFont(e);
			northCenter.setBackground( new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)) );
			northCenter.setForeground(new Color(245,245,245));	// ��ɷ� �߸ŷ� ���ڻ��� ���ع��� �� �ִ�. �ѹ��� .
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
			
	

/*������*/	addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e ){
					System.exit(0);
				}
			}	// �͸� Ŭ���� ��	
		);	// �޼��� addWindowListener ��
/*������*/	ok.addActionListener( this );	//�����Ⱑ �� ��, �ٵ� �𸣴°� ���ĸ� �޼��尡 ��� �����Ǿ��ִ����� ����, �׷��� this.
/*������*/	del.addActionListener( this );
/*������*/	exit.addActionListener( this );

/*������*/	cb1.addItemListener(this);
/*������*/	cb2.addItemListener(this);
/*������*/	cb3.addItemListener(this);

/*������*/	ta.addTextListener(this);
/*������*/	del.setEnabled(false);	// ������ư�� ó������ Ȱ��ȭ�� ������ �ʿ䰡 ���°���!!!!!!!

/*������*/	ch.addItemListener(this);
			// KeyEvent // ���� ���� ������ ���� ��Ŀ���� ����Ʈ�� ����. Ű �̺�Ʈ�� ��Ŀ���� �ִ� ������ �Է¹޴� ������ 
			ta.requestFocus();
			ta.addKeyListener(
				new KeyAdapter() {
					public void keyPressed(KeyEvent e){
						Rectangle r = getBounds();		//getBounds ->Component
						
						
						switch( e.getKeyCode() ){
							case KeyEvent.VK_UP: ta.append("����\n"); setLocation( r.x, r.y - 5);break;
							case KeyEvent.VK_DOWN: ta.append("�Ʒ���\n"); setLocation(r.x, r.y + 5);break;
							case KeyEvent.VK_LEFT: ta.append("��������\n"); setLocation(r.x-5, r.y);break;
							case KeyEvent.VK_RIGHT: ta.append("����������\n"); setLocation(r.x+5, r.y); break;
						}
					}
				}	
			);
/*������*/	
/*������*/	
/*������*/
/*������*/
/*������*/
			// MouseEvent
			ta.addMouseListener(	// �� ta�ĸ� ta ������ ���Գ� �����ĸ� ���Ŵϱ�
				new MouseAdapter(){
					
					public void mouseClicked(MouseEvent e){
						ta.setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
					}
					public void mouseEntered(MouseEvent e){
						ta.append("���콺 ����\n");
					}
					public void mouseExited(MouseEvent e){
						ta.setBackground( new Color(245,245,245) );
						ta.append("���콺 ������\n");
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
	}	// ������

////////////////// �޼��� /////////////////////////////////////////////////////////////////
		//ActionEvent	/*��ư�� �������̴ϱ� ������ �ҽ��� �Ǵ°ž� / ���� Ȯ�ι�ư ������ ���� ������ ���� ������ �� actionPerformed�� �Ϸ�� / ���� ��û���� ����������? / �� 3���߿� �׼��� �߻������ִ°� ������. �� ���� �˾ƾ���. ��󳻾� �ϴµ�, �츮�� �߻��ϴ°� �ƴϴϱ� ��� ���� ����. �׷��� ���⼭ e. �ϰ� ActionEvent ��� Ŭ�������� �޼��带 �� �� �־�. API ����*/

		public void actionPerformed( ActionEvent e){	//ActionListener ���� �޼��尡 �ϳ��ۿ� ���� interface ���� �翬������ �ƴ��Ͱ� ����. �ʿ䵵 ����.
			
			String com = e.getActionCommand();
			if( com.equals( "Ȯ��" )){
//				ta.setText( "Ȯ���߽��ϴ�.\n" );	// setText�� ����Ἥ �ѹ��ۿ� �ȳ��´�.
				ta.append( "Ȯ���߽��ϴ�.\n" );
			}else if( com.equals("����")){
//				ta.removeNotify();	// TextArea�� ����������������
				ta.setText( "" );
			}else if( com.equals("����")){
				System.exit(0);
			}
		}
		

		//������ �̺�Ʈ / ���� ������, ���� ���� �� / �׷��� �ϳ��� �� ��ƾߵ�. ���� �̺�Ʈ�� �߻����׳ĸ��� �ƴ϶� ���� �����̳�, ���� �����̳�
		// ItemEvent
		public void itemStateChanged( ItemEvent e) {
			
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				ta.append(e.getItem() + "�� �����߽��ϴ�.\n");
			} else if(e.getStateChange() == ItemEvent.DESELECTED) {
				ta.append(e.getItem() + "�� �����߽��ϴ�.\n");
			}
		}

		// TextEvent ���ڰ� �� ���� �����ų�, ���ڰ� �� ���� �̻� �����ǰų� �ϸ� �߻��� / ������ ���� ������ ���� ���ѳ��µ� / �ణ �ò��� / ������ư�� ������ų����
		public void textValueChanged(TextEvent e){
	//		ta.getText().equals(""); //�����ϴ°� String Ŭ���� ��ü, ���ϰ��� ����? ȣ���� �ڸ�, �� �ڸ��� ���� �Ѿ���ĸ� ���ڿ��� �Ѿ���µ� �װ� ��Ʈ��Ŭ���� ��ü / �޼��� ������ ��ü �� �޼����� �Ѿ���� �װ� ��Ʈ��Ŭ������ü�� / �׷� ���⼭ �ٷ� �޼��带 �� ���� �ִ�!!!!!!!!!!
			if(ta.getText().equals("")){
				del.setEnabled(false);
			}else{
				del.setEnabled(true);
			}
		}
		
		
		



/////////////////////////////////////////////main �޼��� ����////////////////////////////////////////////////
	public static void main (String []args){
		new EventEx();
	
		// ActionEvent	// Button �� �غ���, ����Ʈ�� �ǹ� ���� �޴��������̶� �ؽ�Ʈ�� ���߿� �Ұ�

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

getSource �긦 ���� ��ü�� ���Ͻ���, ���߿� �̰ɷ� �Ұž�. ��� �̰ɷ� �ϴ°� �´µ� ���߿� ����


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
�ʵ�		SELECTED
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





choice���� getSelected index�� item �̷��� ��ߵ�

��û�� / ��û���� �����߽��ϴ�. �׸��� ���ڸ� �����;� ��





Class TextEvent
�޼��尡 ����???????????? paramString() �� �� �Ⱦ��°�
�갡����� �ȵ�
TextArea�� �ֳ� ���ĸ� üũ�ؾߵǴϱ� �ű� ���ߵ�



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

�갡 �� ���ϴ�.  �ʵ庸��
int	getKeyCode()
Returns the integer keyCode associated with the key in this event.


���콺
void	mouseClicked(MouseEvent e)
Invoked when the mouse button has been clicked (pressed and released) on a component.
void	mouseEntered(MouseEvent e)
Invoked when the mouse enters a component.
void	mouseExited(MouseEvent e)
Invoked when the mouse exits a component.
*/