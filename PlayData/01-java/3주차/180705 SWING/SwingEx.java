/*
������ ���� ����, ���ϴ� ���ڴ�
������ �ֱ��ϸ� ������ ���� ������ 


	�ڹ��� ���� �� �ϳ��� �÷����� ������,
	�ٸ� �ü�������� ������ �����ϴٴ� ��.
	�ü�� �� ������ ���� ������ �ٸ� �ü������ �����ϸ� �������� ���̾ƿ��� ���� �� �ִٴ� ��.
	�ڹ��� ������ �÷����� ������ �̶�� ������ ����������.

�׷��� ����� �����̿���. 
�ڹٰ� �׳� �Ȱ����� �ϳ��� �� �������� ��

awt © �� ���� ������ �̺�Ʈ, �̰� ���� ������ x ��ư���� ���� �������ݾ�?
�������� �Ѿ���鼭 ������ ���� ����°� ���ϰ� ������ �ؼ� xǥ ������ ����
������ �ִ°� set default �̰� ���̵�� �Ǿ��־�

������ Pane (�̸� �������)�� ���ƿ�. ���������� �������� �⺻������ �г��� �پ ����
�� �ؿ� JFRame
Jrootpane
layeredpane ���� �޴���
glasspane
contentpane �갡 ����



���������� contentPane�� �ٿ���
1.4����
cp=getContentPane;
�׷��� �̷��� �Ἥ ���;� ��.
�̹� ������� �ִ� ä�� �����Ǵϱ� get �ؿ;� �ϴ°ž� / �츮�� ����� �ƴ϶� �̸��� �𸣴ϱ�
cp.add()

�ٵ� �̰� �ʹ� �����ذ����� 1.5���ĺ��� �׳� add �Ͻø� �ǿ�
�Ȱ��� �׷��� contentPane�� �پ

�������� ���� �θ�� JComponent.
�� �ؿ� J��� �����ֵ��� �� �־ �� ���ž� �Ǵ°� Jcomponent�� �θ� Container, �� �θ� Component
��������� awt �� �ִ°� �� ������ ���� �ȴٴ� �Ҹ�

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SwingEx extends JFrame implements ActionListener {
	//��� ����
	private JPanel north, south;
	private JScrollPane sp;	// �ߴ�
	private JButton ok, can;
	private JLabel la;	//��� ��
	private JTextField tf;	//��� ��
	private JTextArea ta;
	Random r = new Random();

		//JMenuBar, JMenu, JMenuItem
		private JMenuBar mb;
		private JMenu mfile, medit, mview, mcolor;
		private JMenuItem mnew, mopen, msave, mexit,
						minput, moutput,
						mred, mblue, myellow, mselect;

	//������
	public SwingEx(){
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
	//�޴���->�޴�->�޴� ������

		// �޴��� ����
		mb = new JMenuBar();
		setJMenuBar( mb );
		// �޴� ����
		mfile = new JMenu("����(F)");
		medit = new JMenu("����(E)");
		mview = new JMenu("����(V)");
		mfile.setMnemonic( KeyEvent.VK_F);		//JMenu Ŭ������ �ִ�.
		medit.setMnemonic( KeyEvent.VK_E);
		mview.setMnemonic( KeyEvent.VK_V);

		mb.add( mfile );
		mb.add( medit );
		mb.add( mview );

		// �޴� ������ ����
			mcolor = new JMenu("����");
			mview.add( mcolor );

			mnew = new JMenuItem("�� ����");
			mopen = new JMenuItem("����");
			msave = new JMenuItem("����");
			mexit = new JMenuItem("����");
			
			mfile.add( mnew );
			mfile.addSeparator();
			mfile.add( mopen );
			mfile.add( msave );
			mfile.addSeparator();
			mfile.add( mexit );

			minput = new JMenuItem("�Է�");
			moutput = new JMenuItem("���");
			medit.add( minput );
			medit.add( moutput );

			mred = new JMenuItem("����");
			mblue = new JMenuItem("�Ķ�");
			myellow = new JMenuItem("���");
			mcolor.add( mred );
			mcolor.add( mblue );
			mcolor.add( myellow );

			mselect = new JMenuItem("����");
			mview.add( mselect );

		// �ϴ�
		south = new JPanel();
			ok = new JButton("Ȯ��");
			can = new JButton("���");
			ok.setFont(f);
			can.setFont(f);
			south.add(ok);
			south.add(can);
		add(south, "South");

		// �ߴ�
		ta = new JTextArea(); // ���Ϳ� ���̸� ũ�� �˾Ƽ� �Խ��̴�
			sp = new JScrollPane(ta);	// �̹����� �����Ÿ� ����ٰ�. ��� ���鶧 �־ ����� �ǿ�	// JScrollPane() ��� �ȿ� ���� �Ű����� ã�ƺ���
			ta.setFont(f);
		add(sp, "Center");
		// ���
		north = new JPanel();	// ��ġ�����ϱ� ���� setLayout
			la = new JLabel("  �Է� : ");	//���ʿ� �� �ٴ°� ������ ����
			JLabel eastSpace = new JLabel("     ");	//������ �����
			tf = new JTextField();	//
			la.setFont(f);
			tf.setFont(f);
			north.setLayout( new BorderLayout() );	// �������̾ƿ����� �ٲ���
			north.add(la, "West" );
			north.add(eastSpace, "East" );
			north.add(tf, "Center" );
		add(north, "North");
		//////////// ������ ���̱� ��

		//�̺�Ʈ ó�� / 
		

		setBounds(1400, 200, 500, 690);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// KeyEvent Ű �̺�Ʈ �ְ�礧�������ʵ���;����;
		tf.addKeyListener(		// KeyEvent Ŭ������ �̷��� ����. �̷��� �س��� case �� Ű�� ���� ����ָ� �Ǵ°ž�
			new KeyAdapter(){
				public void keyPressed( KeyEvent e){
					switch( e.getKeyCode() ) {				//getkey �ڵ� ����׷�� �װ� ���ؿ�
						case KeyEvent.VK_ESCAPE :	//KeyEvent Ŭ�������� �����°� ����. ���� API�� ã�� �ʿ䰡 ������ �Ӹ�
							tf.setText( "" );
							break;
						case KeyEvent.VK_W :		//����Ű ���
							if(e.getModifiers() == /*�θ�*/KeyEvent.CTRL_MASK){
							System.exit(0);}
							break;
					}
				}	
			}	
		);
//		// FocusEvent	-> ��Ŀ�� ����
//		tf.addFocusListener(
//			new FocusAdapter(){
//				public void focusLost( FocusEvent e ){
//					tf.requestFocus();
//				}
//			}	
//		);

		// ActionEvent ������
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
	}	/////////////////////////////////////////������ ��
	
	// ��� �޼���
		// ActionEvent
		public void actionPerformed( ActionEvent e){	// �� �ڸ��� �Ѿ���°� 20���� �Ѵ´�. ���� �߻���Ű�� ���� ���� ����. getActionCommand�� ���ڿ��̾��� / �ص� �� / �ٵ� �Ȱ����� �� �ϸ� ��̾����ϱ� getSource �Ẽ���� / ActionEvent �� ���� EventObject / �ٵ� ��� ������Ʈ�� �޴´ٴ°� ���
			Object obj = e.getSource();
			if( obj == ok || obj == tf ){		// Ȯ�ι�ư�� �������� �̸��� ok��, �׷���		// tf ���� �Ȱ��� ���� �ϸ� ���� ����� �ض� / ���� / 
				String str = tf.getText(); // �� ���� ���°� ���� ���� String���� ����
				if(!str.equals("")){
					ta.append(str +"\n"); // �ؽ�Ʈ�����.���̱�(�ؽ�Ʈ �ʵ忡 �ִ� ������ ���÷�)
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
				ta.setBackground(/*Color ��ü�� ����*/JColorChooser.showDialog(this, /*Ÿ��Ʋ*/"������ �����ϼ���", Color.BLUE));
				ta.setForeground(/*Color ��ü�� ����*/JColorChooser.showDialog(this, /*Ÿ��Ʋ*/"���ڻ��� �����ϼ���", Color.BLUE));
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
				JFileChooser fc = new JFileChooser(".");	// file �̸��� �˾ƾ� ������ ��¡ / file �̸��� ���� �� �ִ� ���� �ܰ迡��
				fc.showSaveDialog(this);
				ta.append(fc.getName(fc.getSelectedFile() ) + "\n" );
			}else if (obj == mexit){
				//JOptionPane // �̰͵� show �Ұų� ���ų� �߿���
				
				int select = JOptionPane.showConfirmDialog(this, "������ ������?", "����޼���", JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.YES_OPTION ){
					JOptionPane.showMessageDialog(
						this, "�����մϴ�", "����޼���", JOptionPane.INFORMATION_MESSAGE );
					System.exit(0);
				} else if( select == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(
						this, "���ư��ϴ�", "����޼���", JOptionPane.ERROR_MESSAGE );} 
			}else if(obj == minput){
				String msg = JOptionPane.showInputDialog(
					this, "�Է��մϴ�","�Է¸޼���",JOptionPane.WARNING_MESSAGE );
				if(msg != null && !msg.equals("") ){
					ta.append( msg + "\n");
				}
			}
		}

	public static void main (String[]args){
	//������ ȣ��
		new SwingEx();
	}
}

/*
�ٷ� �̺�Ʈó�� �ϸ鼭 ���ſ���
�ڹٴ� �������̴� ���ϱ� �ڲ� �������⼭ ���� ���ݾ�
�ڱ���� ����� java��� �ϰ� �ٸ� ȸ�翡�� ���� �����Ѱ� javax ���� �־���


����Ű
int	getModifiers()	// ���� �����°� ���
Returns the modifier mask for this event.
int	getModifiersEx()	// ��� Ȯ����
Returns the extended modifier mask for this event.

javax.swing	/	Class JColorChooser
static Color	showDialog(Component component, String title, Color initialColor)	//������Ʈ ���Ⱑ �θ�â ���� �ڸ� / �θ� ������. ����, this ���� �˴ϴ�. this�� JFrame �� ���� /
			Shows a modal color-chooser dialog and blocks until the dialog is hidden.	// ���ϰ��� Color ��ü��!!

modal��� -> �ڰ� ������ �ȵǰ� �ϴ�. ������ �߰��� �ؼ�
modalLess ��� -> �ڰ� ������ ��!
�����츦 ���� �����. �׷� ���� ��� �����츦 �ڽ�, �ڿ� �ִ°� �θ� ������(��Ӱ��� ����ϴ°� �ƴ�)
��� ������� �� �θ� �ִ�. ����Ʈ �÷����� �θ�� �ü���� �Ǵ� ��.

����â ����â static�� �ƴϱ� ������ �׻� ��ü���� ��������� �Ѵ�.
����� / ������

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

���� ��������
String	getName(File f)
					Returns the filename.
File	getSelectedFile()
					Returns the selected file.
File[]	getSelectedFiles()
					Returns a list of selected files if the file chooser is set to allow multiple selection.




�޼��� Ÿ��	//����ƽ�̳�? �׳� �� �� �ִ�
���ϰ��� int��? �׷� �ʵ带 ã�ƺ���
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