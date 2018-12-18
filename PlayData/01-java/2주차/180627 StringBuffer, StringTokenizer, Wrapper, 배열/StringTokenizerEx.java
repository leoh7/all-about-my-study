import java.util.StringTokenizer;	// lang -> util ������ ���� ����. / util �� �� ��ߵǴ°� �ƴ����� ���� ���� ���� Ŭ�������� �������ִ�

class  StringTokenizerEx{

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer( "2018/06/27", "/" );	// �Ű������� ���� / ����Ʈ �����ڷ� ȣ���Ѱ��� / ������ ����? / ����Ʈ �����ڰ� ���ٴ°�	/ �����ڴ� ���ϰ��� ��� �߶� ���� �׳� ���� �ִ�. �ᱹ �갡 �϶���� �ؾ���. / �̷� ��� ����
		
		System.out.println( "���� : " +st.countTokens() );			// �ڿ� ���� ��ū ���� ����
			
			while( st.hasMoreTokens() ){	//��ū ���� �ֳ�? ������ Ʈ�縦 ����
			System.out.println( "Token : " + st.nextToken() ); 
			}
			System.out.println( "���� : " +st.countTokens() );	// ������� ���� ���� ��ū�� �����ϱ�


		StringTokenizer st2 = new StringTokenizer( "2018/06/27", "/", true );	//
			System.out.println( "���� : " +st2.countTokens() );
				
				while( st2.hasMoreTokens() ){	//��ū ���� �ֳ�? ������ Ʈ��
				System.out.println( "Token : " + st2.nextToken() );
			}
			System.out.println( "���� : " +st2.countTokens() );



// ū ���ڿ��� �߶� ������ ���� �� token �̶�� �θ���.
// �̷��� �ݺ������� �����°� �������� ���� ���� / "2018" "06" "27" �̷��� �߷��ִ� ��ū�� �� "2018"�� �տ� �����Ͱ� �ִٰ� / ��ū �ֳ�? ������ true, ������ false �ؼ� �ݺ���

// StringTokenizer(String str) / ��� ���ڿ� �ϳ��� �������Ѵٴ� ��. / ���ڿ��� �ڸ��� Ŭ�����ŵ�
// �׷� ������ ����Ʈ �����ڰ� ����.	/ /�±�����, �������� / ������, �������͸� �� �ָ� �ǹ̾��� ����, ȭ��Ʈ �����̽��� �������� ���ڸ� �߶��ش�.
// StringTokenizer(String str, String delim) / �̰� �������͸� �ִ°�.

// StringTokenizer(String str, String delim, boolean returnDelims) / �����ڿ� boolean ���� ��� �� �� ���� �� �������� ���� / �⺻���� boolean / �� �Ҳ��� �׳� �� ���� ��. �տ� �� �׷� �Ŷ�� �����ϸ� �� / 


	}
}
