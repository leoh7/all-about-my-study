/*
2���� ������ ��ū�� �ϳ��� ���ļ� 
80�� ������ ����
01
12 ������ ����
					*������ ���ڷ� üũ�ؾ� �մϴ� ������ ��Ʈ*
���� ��¥�� ���ؼ� ���̸� ����� callender
	(2018 - �¾ ��)
7��° ������ ��,�� ����	// �ٵ� �̰� 3 ���� 4 ����->�� 2000�� ���Ŀ� �¾

������ �������ϴٿ�


*/		//1980�� 1�� 12�� 38�� �����Դϴ� �� ���

import java.util.StringTokenizer;

class StringStudy{
	//�ν��Ͻ� ����
	public static char[] year, month, date;
	public String firstNum, secondNum;


	//�ν��Ͻ� �޼���
	
	
		

	public static void main(String[] args) {
		StringTokenizer st
			= new StringTokenizer( "800112-1111111", "-");		// StringTokenizer �ν��Ͻ�ȭ -> st
		StringStudy ss = new StringStudy();						//StringStudy �ν��Ͻ�ȭ -> ss

		//�迭 ����


		/*
		String g = "line";
		char c = g.charAt(0);	//char c���� '1'�� ����.
		char[] c_arr = g.toCharArray();	// ũ�Ⱑ 4�� char �迭 ['l','i','n','e']
		*/


			st.hasMoreTokens(); 	//��ū ���� �ֳ�? ������ Ʈ��
			ss.firstNum = st.nextToken();
			st.hasMoreTokens();
			ss.secondNum = st.nextToken();
			System.out.println("������Դϴ� firstNum: "+ss.firstNum);
			System.out.println("������Դϴ� secondNum: "+ss.secondNum);
			
			ss.firstNum.subString(0,1);

			//char year [] = ss.firstNum.toCharArray();
			
			
//		}

	}
}
