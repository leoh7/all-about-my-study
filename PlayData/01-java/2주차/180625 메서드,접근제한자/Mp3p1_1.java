//���� ����. ���� ���� �������� ���ϰ� �����ִϱ� �ٽ� ���� ������ ������(�ʱ�ȭ)�� �ؾߵǴ°ǰ�?

/*
Ŭ������		Mp3p
�Ӽ�			color			������ ���
			memory			�޸� �뷮�� ���
����			setMemory()		memory �뷮�� �����Ѵ�.
			setColor()		color ���� �����Ѵ�.
			getMemory()		memory ���� �����´�.
			getColor()		color ���� �����´�.

*/


class Mp3p1_1 {	
	private String	color;		// ������ �Ķ��� ������� ���� �� �ִٰ� ���� -> ���͸޼��尡 ���ƾ� �� / ������ �˷��ִ� �� ���� ����� ��
	private int		memory;		// 32 64 128 �� ���� �� �ִٰ� ���� -> ���� ���͸޼��尡 ���ƾ� ��


	public void	setColor( String c ) {
		if( c.equals("������") || c.equals("�Ķ���") || c.equals("�����")) {
			color = c;
		} else {System.out.println("�������� �ʴ� �����Դϴ�.");}
	}	//���ڿ��� ������ ��� ���� ���� ����� ���迬���ڷ� ���ϸ� �ȵȴ�."hello" == "hello" �̰� �ȵ� / �̰� �ּ� ������ ���� �񱳰� �Ƴ� / ���ڿ� ���� ���� .equals ��� �޼����! /  cf) ������ String c �� ���������� ��������, ��ü�� �Ǹ� c.equals �̷������� ���������� ��ü�� �� �� �ִ�.
	
	public void	setMemory( int m ) {
		if( m==32 || m==64 || m==128 ) {
			memory = m;
		} else {
			System.out.println("�������� �ʴ� �뷮�Դϴ�.");
		}
	}
	
	public String	getColor()		{ return color; }
	public int		getMemory()		{ return memory; }
	




	// �Ʒ����� ���๮

	public static void main( String[] args ){
	
		Mp3p1_1 m3 = new Mp3p1_1();	

		m3.setColor("������");	//. �̶�� ���� ����? "���� �ӿ�"
		m3.setMemory(32);
		System.out.println( "���� : " + m3.getColor() );
		System.out.println( "�뷮 : " + m3.getMemory() );

	System.out.println();

		Mp3p m4 = new Mp3p();

		m4.setColor("�����");	// ������ �ȵǴ� ������	//�޼��尡 ������ �ȵǴ� �����͸� �ɷ��ְ� �� �ȵǴ����� �˷��ִ°�. �̰��� ĸ��ȭ
		m4.setMemory( 256 );	// ������ �ȵǴ� ������	
		System.out.println( "���� : " + m4.getColor() );
		System.out.println( "�뷮 : " + m4.getMemory() );	

	}
}
