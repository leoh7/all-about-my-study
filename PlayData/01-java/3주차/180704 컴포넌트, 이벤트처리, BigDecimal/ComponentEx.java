import java.awt.*;
import java.awt.event.*;
// 컴포넌트에 스크롤바랑 캔버스 빼고 다 해볼거야. 오늘은 버튼과 라벨
// 플로우레이아웃으로 바꿀꺼야. 패널의 기본이었찌?
class  ComponentEx extends Frame {
	
	
	public ComponentEx(){
		// Button
		String modelArray[] = new String[]{"종류","회사","모델명"};


		Panel p1 = new Panel();				// 패널의 글자색을 바꿔라 하면 패널엔 글자가 없으니까 버튼의 글자가 바뀐다.
		p1.setBackground( new Color(250,0,250) );
		Button bt1 = new Button("가위");
		Button bt2 = new Button("바위");
		Button bt3 = new Button();
		bt3.setLabel(" 보 ");

		bt1.setBackground( Color.ORANGE);
		bt2.setBackground( Color.MAGENTA);
		bt3.setBackground( Color.CYAN);
		p1.setForeground( Color.RED );

//		Font f = new Font("보통", Font.BOLD, 20);		//유일하게 자바에서 바이트 단위로 or ㅆ는경우 / 몇개만 된다 다는 아니고
		Font f = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 20);
		bt1.setFont(f);
		bt2.setFont(f);
		bt3.setFont(f);

		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		add(p1);

		// Label
		// Sysout 하면 콘솔에 뜨지. 윈도우에 글자 찍을 때는 이걸 씀
		// 텍스트 필드는 오른쪽 정렬이 안되는데 라벨은 됨
		Panel p2 = new Panel();
		p2.setBackground(new Color(230, 0, 230) );
		Label la1 = new Label("사과");
		Label la2 = new Label("딸기", Label.CENTER );
		Label la3 = new Label("바나나");
		la3.setAlignment( Label.RIGHT);
		la3.setText("원숭이");

		la1.setBackground( Color.WHITE );
		la2.setBackground(Color.GRAY );
		la3.setBackground(Color.YELLOW);

		p2.add( la1 );
		p2.add( la2 );
		p2.add( la3 );

		add(p2);

		// List
		// 요거 예제 날려먹지 말고 계세요 내일 갈거니까
		// 기본이 4개를 보여주게 되어있음
		Panel p3 = new Panel();
		p3.setBackground( new Color(210,0,210) );
		List list = new List(7);		// 생성자에다 기본으로 보여지는 갯수를 조절할 수 있다. / 멀티플모드를 true 로 하면 여러개를 선택할 수 있다.
		list.add(" " + modelArray[2] + modelArray[1]);
		list.add("강원도");
		list.add("충청도");
		list.add("전라도");
		list.add("전라도");
		list.add("전라도");
		list.add("전라도");
		list.add("전라도");

		list.add("경상도");
		list.add("제주도");
		list.select(2);	// 기본적으로 선택된 상태로 나옴
		p3.add(list);
		add(p3);
		

		// Choice	/ 스윙에서는 JCombobox	/	클릭하면 리스트가 뜨는것
		Panel p4 = new Panel();
		p4.setBackground( new Color(190,0,190));
		Choice ch = new Choice();
		ch.add("서울");
		ch.add("인천");
		ch.add("안산");
		ch.add("수원");
		ch.add("평택");


		p4.add(ch);
		add(p4);

		// 체크박스 
			//Checkbox
			Panel p5 = new Panel();
			p5.setBackground(new Color(170,0,170));
			Checkbox cb1 = new Checkbox("독서");
			Checkbox cb2 = new Checkbox("등산", true);	// 미리 체크
			Checkbox cb3 = new Checkbox("게임");
			p5.add(cb1);
			p5.add(cb2);
			p5.add(cb3);
			
			add(p5);
			//CheckboxGroup	/ 스윙에서는 JRadioButton
			Panel p6 = new Panel();
			p6.setBackground(new Color(160,0,160));
			CheckboxGroup group = new CheckboxGroup();
			Checkbox cb4 = new Checkbox("축구", false, group);
			Checkbox cb5 = new Checkbox("야구", false, group);
			Checkbox cb6 = new Checkbox("농구", false, group);

			p6.add(cb4);
			p6.add(cb5);
			p6.add(cb6);

			add(p6);

		//TextArea	//넘 커서 문제 (여러줄짜리)
		Panel p7 = new Panel();
		p7.setBackground(new Color(150,0,150));
		TextArea ta = new TextArea("",5, 30, TextArea.SCROLLBARS_NONE);

		p7.add(ta);
		add(p7);
		//TextField	//넘 작아서 문제 (한줄짜리만) //얘는 정렬하는게 없다. setAlingment 이런거
		Panel p8 = new Panel();
		p8.setBackground(new Color(140,0,140));

		TextField tf = new TextField("Hello", 30);
		tf.setEchoChar('*');	// 스윙가면 JpasswordField 로 쓸 수 있다.	
		p8.add(tf);
		
		add(p8);


		setLayout( new FlowLayout() );	// 플로우레이아웃 하고 나서 사이즈를 건들면 깨지니까 못 바꾸게 함 보통
		setResizable(false);			// 이렇게 못바꾸게

		setBounds(1200, 200, 400, 700);	//여백 여백 크기 크기
		setVisible(true);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing( WindowEvent e){
					System.exit(0);
				}
			}	// 익명 클래스 끝	
		);	// 메서드 끝

	}	// 생성자 끝
	


	public static void main(String[] args) {
		new ComponentEx();
	}	// main 끝
}	// class ComponentEx 끝
/*
List()
Creates a new scrolling list.
List(int rows)
Creates a new scrolling list initialized with the specified number of visible lines.
List(int rows, boolean multipleMode)	// 기본값을 안주면 false, 쓸거면 true 주면 된다고. / 이렇게 생긴 애들(boolean 을 매개변수로 받는)은 다 비슷하게 작동한다.
Creates a new scrolling list initialized to display the specified number of rows.

void	add(String item)
Adds the specified item to the end of scrolling list.
void	add(String item, int index)
Adds the specified item to the the scrolling list at the position indicated by the index.

얘네들 나중에 쓰게 될 거야 / 이벤트 처리를 하게 되면 함
int	getSelectedIndex()	// 선택한 애들의 인덱스를 가져올 수 있게 하는 것. 
Gets the index of the selected item on the list,
int[]	getSelectedIndexes()	// 멀티플 모드를 했을 때 배열로 여러개를 가져올 수도 있고
Gets the selected indexes on the list.
String	getSelectedItem()	// 문자열을 가져올 수 있어. 경기도를 선택하면 경기도를 가져올 수 있고
Gets the selected item on this scrolling list.
String[]	getSelectedItems()
Gets the selected items on this scrolling list.
Object[]	getSelectedObjects()
Gets the selected items on this scrolling list in an array of Objects.

인덱스를 주면 기본적으로 선택된 상태로 나옴
void	select(int index)
Selects the item at the specified index in the scrolling list.




choice
Choice()
Creates a new choice menu.

// item 이 있는 애들은 item 이벤트 기능을 쓸 수 있다.
void	add(String item)
Adds an item to this Choice menu.
void	addItem(String item)
Obsolete as of Java 2 platform v1.1.
void	addItemListener(ItemListener l)
Adds the specified item listener to receive item events from this Choice menu.


String	getItem(int index)
Gets the string at the specified index in this Choice menu.

int	getSelectedIndex()	// 얘는 멀티플 모드 처럼 여러개 선택이 불가능해
Returns the index of the currently selected item.
String	getSelectedItem()
Gets a representation of the current choice as a string.


체크박스
Checkbox()
	Creates a check box with an empty string for its label.
Checkbox(String label)
	Creates a check box with the specified label.
Checkbox(String label, boolean state)
	Creates a check box with the specified label and sets the specified state.
Checkbox(String label, boolean state, CheckboxGroup group)
	Constructs a Checkbox with the specified label, set to the specified state, and in the specified check box group.
Checkbox(String label, CheckboxGroup group, boolean state)		// 특이하게도 생성자에 오버로드를 해놨다.
	Creates a check box with the specified label, in the specified check box group, and set to the specified state.




TextArea
TextArea()
Constructs a new text area with the empty string as text.
TextArea(int rows, int columns)	// 픽셀단위가 아니라 글자수임을 명심하자
Constructs a new text area with the specified number of rows and columns and the empty string as text.
TextArea(String text)	// 이건 문자열 길이만큼 잡힙니다
Constructs a new text area with the specified text.
TextArea(String text, int rows, int columns)	// 앞에다 문자열을 주고 크기를 잡는것
Constructs a new text area with the specified text, and with the specified number of rows and columns.
TextArea(String text, int rows, int columns, int scrollbars)	// int scrollbars 이런건 필드값이랬져
Constructs a new text area with the specified text, and with the rows, columns, and scroll bar visibility as specified.

	필드
	static int	SCROLLBARS_BOTH
	Create and display both vertical and horizontal scrollbars.
	static int	SCROLLBARS_HORIZONTAL_ONLY
	Create and display horizontal scrollbar only.
	static int	SCROLLBARS_NONE
	Do not create or display any scrollbars for the text area.
	static int	SCROLLBARS_VERTICAL_ONLY
	Create and display vertical scrollbar only.
	
	메서드 getText, setText를 가장 많이 쓸텐데 얘한테 없다. 부모한테 있음 TextComponent


텍스트필드
생성자
TextField()
Constructs a new text field.
TextField(int columns)
Constructs a new empty text field with the specified number of columns.
TextField(String text)
Constructs a new text field initialized with the specified text.
TextField(String text, int columns)
Constructs a new text field initialized with the specified text to be displayed, and wide enough to hold the specified number of columns.

메서드
void	setEchoChar(char c)
Sets the echo character for this text field.





















*/