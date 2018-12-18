import java.io.*;
import java.util.Arrays;

class IOEx3 {
	public static void main(String []args){
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] tmp = new byte[4];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		System.out.println("Input src : " + Arrays.toString(inSrc) );
		
		try{
			while(input.available() > 0){
		//		input.read(tmp);	// �̷��� �ϸ� �������� ������ ���� 8,9,6,7 �� �ȴ�. tmp �� �����ִ� 6�� 7�� ����� �Ǵ� ��.
				int len = input.read(tmp);
				

		//		output.write(tmp);
				output.write(tmp, 0, len);
				System.out.println("tmp src : " + Arrays.toString(tmp) );

				outSrc = output.toByteArray();
				printArrays(tmp, outSrc);
			}
		}catch(IOException e){}
	}

	static void printArrays(byte[] tmp, byte[] outSrc){
		System.out.println("tmp : " + Arrays.toString(tmp) );
		System.out.println("Output src : " + Arrays.toString(outSrc) );
	}

}