/*
	2Byte ��Ʈ���� �ܵ����� ���°� ���� ����!
	���� ��κ� 1Byte. ��Ʈ��ũ ����.
	������ �� �� ��ü�� 1Byte ������� �Ǿ��� ���� (32��Ʈ ü��)

	�⺻ ����� ��Ʈ�� x2
	2����Ʈ�� ��ȯ ��Ʈ�� x2
	���� ��Ʈ�� x2
	�� �Ѵٰ� �ϸ� �̷��� 6���� �ʿ���

	
*/

// InputStream -> Reader 
// OutputStream -> Writer
// Ű���� ������ �Է�(������) -> ���Ϸ� ���(�ѹ��� ��Ҵٰ� ������)

import java.io.*;

class ByteToCharStreamEx {	// throws �� ���ܰ� �ߴ� �޼��忡�� ������!

	
	public String input (String msg) throws IOException {
		System.out.print(msg);
		// ǥ�� ����� = System �� �ʵ带 ����(in, out, err)
//		InputStreamReader ir = new InputStreamReader( System.in );	// InputStream + Reader = 1Byte -> 2Byte
//		BufferedReader br = new BufferedReader( ir );				// ��� 2Byte ���۸� �� ��
		BufferedReader br 
			= new BufferedReader( new InputStreamReader( System.in ));	// close ���ϳ�? / ���Ѵ� return �� br.readLine(); �� �����ϱ� NullPointerErr / �׸��� �޼��� �����鼭 �ڵ����� ����
		return br.readLine();	// ����¹��� ������ IOException �� �����.
	}

	public static void main(String[] args) throws IOException{
		ByteToCharStreamEx btc = new ByteToCharStreamEx();
		String id = btc.input( "���̵� : " );
		String passwd = btc.input( "��й�ȣ : " );
		
//		FileOutputStream fos = new FileOutputStream( "d1.txt" );	// throws IOException ���� ���������� try catch �� �ʿ� ����.
//		OutputStreamWriter osw = new OutputStreamWriter( fos );
//		BufferedWriter bw = new BufferedWriter( osw );				// 1�� ���

		BufferedWriter bw = new BufferedWriter(						// 2�� ���
			new OutputStreamWriter(						// �Ű������� OutputStream �� �޷���
				new FileOutputStream( "d1.txt" ) ) );	// �Ű������� �̸��� �޷���

		bw.write( "���̵� : " );
		bw.write( id );
		bw.newLine();

		bw.write( "��й�ȣ : " );
		bw.write( passwd );
		bw.newLine();

		bw.flush();
	}
}


// �����ϰ� main ���� throws ���� ���ܰ� �ִٰ� ��... ���蹮�� ���� ��. ���ܴ� �������� ������ �������� �߰��� �ѹ� ��Ƽ� ������ߵ�.













