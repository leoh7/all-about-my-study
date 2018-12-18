import java.io.*;
import java.util.Arrays;

class IOEx2 {
	public static void main(String[]args){
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] tmp = new byte[10];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		input.read(tmp,0,tmp.length);	// �о� �� �����͸� �迭 tmp�� ��´�.
		output.write(tmp,5,5);			// tmp [5]���� 5���� �����͸� write�Ѵ�.

		outSrc = output.toByteArray();

		System.out.println("Input Src : " + Arrays.toString(inSrc));
		System.out.println("tmp : " + Arrays.toString(tmp));
		System.out.println("Output Src : " + Arrays.toString(outSrc));
	}
}