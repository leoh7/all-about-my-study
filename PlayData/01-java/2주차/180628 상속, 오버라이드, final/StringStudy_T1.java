import java.util.StringTokenizer;
import java.util.Calender;
class StringStudy_T1{
		// 1980�� 1�� 12�� �� 39�� �����Դϴ�.
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("800112-1111111", "-");
		
		//�̾Ƴ��� / �Ϻη� StringTokenizer ���� ������
		// ��ĥ���� �� ���� ������ ���ϴ�
		StringBuffer sb = new StringBuffer();		// �ϳ��� �����ʹ� �ϳ��� �����°� �ξ� �� ������ ���ϴٴ� ��

		//�ݺ���
		while( st.hasMoreTokens() ) {
			sb.append( st.nextToken() );					//append �� sb�� �޼��� / 8001121111111�� ���� ��ó�� ���� �ϴ� ���ĳ����� �̷� ����
		}
		
		int year = (sb.charAt( 0 ) -48)*10 + sb.charAt(1)-48  //=>  �׳� ���ϸ� 104�� ���´� / ������ ���ڱ� ������ �����ϸ� �ƽ�Ű �ڵ�� ������ ��. - 48 ���ϸ� Ư��
					+ (charAt(6)=='3' || sb.charAt(6)=='4' ? 2000 : 1900);
		int month = (sb.charAt(2) -48)*10 + sb.charAt(3)-48;
	//	int day = (sb.charAt(4) -48)*10 + sb.charAt(5)-48;	//ĳ���Ϳ� ����ϱ�
		
	/*	char [] ch = sb.toString().toCharArray();
		int day = (ch[4]-48)*10 + ch[5]-48; */

		int day = Integer.parseInt(sb.substring(4,6));		//��Ʈ������ ����ϱ�
		int age = Calendar.getInstance().get( Calendar.YEAR ) - year +1;

		String gender = ch[6]=='1' || ch[6]=='3' ? "����" : "����";
		System.out.println( year + "��"+ month +"��"+ day+"��" + age + "���Դϴ�" + gender + "�Դϴ�");	//�迭 ���� gender�� �迭�� ������.... ��...
		

		}
}
