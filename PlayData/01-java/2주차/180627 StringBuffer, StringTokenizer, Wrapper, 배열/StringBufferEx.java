class  StringBufferEx {
	public static void main(String[] args) 	{
		// ����
		StringBuffer sb = new StringBuffer("Hello Java!!!");	//��ü�� �����ϸ� �����ڰ� ȣ��ȴ�	 / ���ڿ��� ��Ʈ��Ŭ���� ��ü�� / 
		System.out.println("ũ�� : " + sb.length() );	//null ���� 13ĭ
		System.out.println("�뷮 : " + sb.capacity() );	//�޸𸮰� 29. ���ڸ� �൵ ������ ������ 16ĭ �� ��´ٴ� �Ҹ�

		// �߰�
		System.out.println("�߰� : " +sb.append( "!!" ) );
		System.out.println("���� : " +sb);			//StringBuffer�� ������ �ٲ㼭 Garbage�� �������� �ʴ´�.
		//insert
		System.out.println("�߰� : " + sb.insert( 6,"JSP &"));
		System.out.println("ũ�� Ȯ�� : " + sb.length() );
		System.out.println("�뷮 Ȯ�� : " + sb.capacity() );
	
		//����
		System.out.println("���� : "+ sb.delete(6, sb.length() ) );		//�׻� ���۰� ���� �̷��� ���ؿ;��Ѵ�.
		System.out.println("ũ�� Ȯ�� : " + sb.length() );
		System.out.println("�뷮 Ȯ�� : " + sb.capacity() );
		
		// trimToSize()
		sb.trimToSize();
		System.out.println("ũ�� Ȯ�� : " + sb.length() );	//6
		System.out.println("�뷮 Ȯ�� : " + sb.capacity() );	//6 / �뷮�� �� �°� �ٿ�����!!! ����

//	append(char c ���) / ���� ���ڿ� �ڿ� �Ű������� ���� ���� �����ش�

// StringBuffer	delete(int start, int end) / ��� �����ϴ� �͵� �����ϴ�
// int	indexOf(String str)
// StringBuffer	insert(int offset, boolean b) / offset�� ���°���� ���� �־��, ���� ��
// StringBuffer	delete(int start, int end)
// void	trimToSize() / �� �ڷ� �������� ������ ���ִµ� ũ�⿡ ���缭

	}
}
