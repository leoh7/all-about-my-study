import java.awt.*;
import java.awt.event.*;
// ������Ʈ�� ��ũ�ѹٶ� ĵ���� ���� �� �غ��ž�. ������ ��ư�� ��
// �÷ο췹�̾ƿ����� �ٲܲ���. �г��� �⺻�̾���?
class  ComponentEx extends Frame {
	
	
	public ComponentEx(){
		// Button
		String modelArray[] = new String[]{"����","ȸ��","�𵨸�"};


		Panel p1 = new Panel();				// �г��� ���ڻ��� �ٲ�� �ϸ� �гο� ���ڰ� �����ϱ� ��ư�� ���ڰ� �ٲ��.
		p1.setBackground( new Color(250,0,250) );
		Button bt1 = new Button("����");
		Button bt2 = new Button("����");
		Button bt3 = new Button();
		bt3.setLabel(" �� ");

		bt1.setBackground( Color.ORANGE);
		bt2.setBackground( Color.MAGENTA);
		bt3.setBackground( Color.CYAN);
		p1.setForeground( Color.RED );

//		Font f = new Font("����", Font.BOLD, 20);		//�����ϰ� �ڹٿ��� ����Ʈ ������ or ���°�� / ��� �ȴ� �ٴ� �ƴϰ�
		Font f = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 20);
		bt1.setFont(f);
		bt2.setFont(f);
		bt3.setFont(f);

		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		add(p1);

		// Label
		// Sysout �ϸ� �ֿܼ� ����. �����쿡 ���� ���� ���� �̰� ��
		// �ؽ�Ʈ �ʵ�� ������ ������ �ȵǴµ� ���� ��
		Panel p2 = new Panel();
		p2.setBackground(new Color(230, 0, 230) );
		Label la1 = new Label("���");
		Label la2 = new Label("����", Label.CENTER );
		Label la3 = new Label("�ٳ���");
		la3.setAlignment( Label.RIGHT);
		la3.setText("������");

		la1.setBackground( Color.WHITE );
		la2.setBackground(Color.GRAY );
		la3.setBackground(Color.YELLOW);

		p2.add( la1 );
		p2.add( la2 );
		p2.add( la3 );

		add(p2);

		// List
		// ��� ���� �������� ���� �輼�� ���� ���Ŵϱ�
		// �⺻�� 4���� �����ְ� �Ǿ�����
		Panel p3 = new Panel();
		p3.setBackground( new Color(210,0,210) );
		List list = new List(7);		// �����ڿ��� �⺻���� �������� ������ ������ �� �ִ�. / ��Ƽ�ø�带 true �� �ϸ� �������� ������ �� �ִ�.
		list.add(" " + modelArray[2] + modelArray[1]);
		list.add("������");
		list.add("��û��");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");

		list.add("���");
		list.add("���ֵ�");
		list.select(2);	// �⺻������ ���õ� ���·� ����
		p3.add(list);
		add(p3);
		

		// Choice	/ ���������� JCombobox	/	Ŭ���ϸ� ����Ʈ�� �ߴ°�
		Panel p4 = new Panel();
		p4.setBackground( new Color(190,0,190));
		Choice ch = new Choice();
		ch.add("����");
		ch.add("��õ");
		ch.add("�Ȼ�");
		ch.add("����");
		ch.add("����");


		p4.add(ch);
		add(p4);

		// üũ�ڽ� 
			//Checkbox
			Panel p5 = new Panel();
			p5.setBackground(new Color(170,0,170));
			Checkbox cb1 = new Checkbox("����");
			Checkbox cb2 = new Checkbox("���", true);	// �̸� üũ
			Checkbox cb3 = new Checkbox("����");
			p5.add(cb1);
			p5.add(cb2);
			p5.add(cb3);
			
			add(p5);
			//CheckboxGroup	/ ���������� JRadioButton
			Panel p6 = new Panel();
			p6.setBackground(new Color(160,0,160));
			CheckboxGroup group = new CheckboxGroup();
			Checkbox cb4 = new Checkbox("�౸", false, group);
			Checkbox cb5 = new Checkbox("�߱�", false, group);
			Checkbox cb6 = new Checkbox("��", false, group);

			p6.add(cb4);
			p6.add(cb5);
			p6.add(cb6);

			add(p6);

		//TextArea	//�� Ŀ�� ���� (������¥��)
		Panel p7 = new Panel();
		p7.setBackground(new Color(150,0,150));
		TextArea ta = new TextArea("",5, 30, TextArea.SCROLLBARS_NONE);

		p7.add(ta);
		add(p7);
		//TextField	//�� �۾Ƽ� ���� (����¥����) //��� �����ϴ°� ����. setAlingment �̷���
		Panel p8 = new Panel();
		p8.setBackground(new Color(140,0,140));

		TextField tf = new TextField("Hello", 30);
		tf.setEchoChar('*');	// �������� JpasswordField �� �� �� �ִ�.	
		p8.add(tf);
		
		add(p8);


		setLayout( new FlowLayout() );	// �÷ο췹�̾ƿ� �ϰ� ���� ����� �ǵ�� �����ϱ� �� �ٲٰ� �� ����
		setResizable(false);			// �̷��� ���ٲٰ�

		setBounds(1200, 200, 400, 700);	//���� ���� ũ�� ũ��
		setVisible(true);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e){
					System.exit(0);
				}
			}	// �͸� Ŭ���� ��	
		);	// �޼��� ��

	}	// ������ ��
	


	public static void main(String[] args) {
		new ComponentEx();
	}	// main ��
}	// class ComponentEx ��
/*
List()
Creates a new scrolling list.
List(int rows)
Creates a new scrolling list initialized with the specified number of visible lines.
List(int rows, boolean multipleMode)	// �⺻���� ���ָ� false, ���Ÿ� true �ָ� �ȴٰ�. / �̷��� ���� �ֵ�(boolean �� �Ű������� �޴�)�� �� ����ϰ� �۵��Ѵ�.
Creates a new scrolling list initialized to display the specified number of rows.

void	add(String item)
Adds the specified item to the end of scrolling list.
void	add(String item, int index)
Adds the specified item to the the scrolling list at the position indicated by the index.

��׵� ���߿� ���� �� �ž� / �̺�Ʈ ó���� �ϰ� �Ǹ� ��
int	getSelectedIndex()	// ������ �ֵ��� �ε����� ������ �� �ְ� �ϴ� ��. 
Gets the index of the selected item on the list,
int[]	getSelectedIndexes()	// ��Ƽ�� ��带 ���� �� �迭�� �������� ������ ���� �ְ�
Gets the selected indexes on the list.
String	getSelectedItem()	// ���ڿ��� ������ �� �־�. ��⵵�� �����ϸ� ��⵵�� ������ �� �ְ�
Gets the selected item on this scrolling list.
String[]	getSelectedItems()
Gets the selected items on this scrolling list.
Object[]	getSelectedObjects()
Gets the selected items on this scrolling list in an array of Objects.

�ε����� �ָ� �⺻������ ���õ� ���·� ����
void	select(int index)
Selects the item at the specified index in the scrolling list.




choice
Choice()
Creates a new choice menu.

// item �� �ִ� �ֵ��� item �̺�Ʈ ����� �� �� �ִ�.
void	add(String item)
Adds an item to this Choice menu.
void	addItem(String item)
Obsolete as of Java 2 platform v1.1.
void	addItemListener(ItemListener l)
Adds the specified item listener to receive item events from this Choice menu.


String	getItem(int index)
Gets the string at the specified index in this Choice menu.

int	getSelectedIndex()	// ��� ��Ƽ�� ��� ó�� ������ ������ �Ұ�����
Returns the index of the currently selected item.
String	getSelectedItem()
Gets a representation of the current choice as a string.


üũ�ڽ�
Checkbox()
	Creates a check box with an empty string for its label.
Checkbox(String label)
	Creates a check box with the specified label.
Checkbox(String label, boolean state)
	Creates a check box with the specified label and sets the specified state.
Checkbox(String label, boolean state, CheckboxGroup group)
	Constructs a Checkbox with the specified label, set to the specified state, and in the specified check box group.
Checkbox(String label, CheckboxGroup group, boolean state)		// Ư���ϰԵ� �����ڿ� �����ε带 �س���.
	Creates a check box with the specified label, in the specified check box group, and set to the specified state.




TextArea
TextArea()
Constructs a new text area with the empty string as text.
TextArea(int rows, int columns)	// �ȼ������� �ƴ϶� ���ڼ����� �������
Constructs a new text area with the specified number of rows and columns and the empty string as text.
TextArea(String text)	// �̰� ���ڿ� ���̸�ŭ �����ϴ�
Constructs a new text area with the specified text.
TextArea(String text, int rows, int columns)	// �տ��� ���ڿ��� �ְ� ũ�⸦ ��°�
Constructs a new text area with the specified text, and with the specified number of rows and columns.
TextArea(String text, int rows, int columns, int scrollbars)	// int scrollbars �̷��� �ʵ尪�̷���
Constructs a new text area with the specified text, and with the rows, columns, and scroll bar visibility as specified.

	�ʵ�
	static int	SCROLLBARS_BOTH
	Create and display both vertical and horizontal scrollbars.
	static int	SCROLLBARS_HORIZONTAL_ONLY
	Create and display horizontal scrollbar only.
	static int	SCROLLBARS_NONE
	Do not create or display any scrollbars for the text area.
	static int	SCROLLBARS_VERTICAL_ONLY
	Create and display vertical scrollbar only.
	
	�޼��� getText, setText�� ���� ���� ���ٵ� ������ ����. �θ����� ���� TextComponent


�ؽ�Ʈ�ʵ�
������
TextField()
Constructs a new text field.
TextField(int columns)
Constructs a new empty text field with the specified number of columns.
TextField(String text)
Constructs a new text field initialized with the specified text.
TextField(String text, int columns)
Constructs a new text field initialized with the specified text to be displayed, and wide enough to hold the specified number of columns.

�޼���
void	setEchoChar(char c)
Sets the echo character for this text field.





















*/