/*
	Collection	set		HashSet
						TreeSet
				List	Vector		Stack
						ArrayList
				Queue	LinkedList
*/

import java.util.Stack;

class StackEx {
	public static void main(String[]args){
		String[] groupA
			= { "���Ű��ź", "�����Ʈ", "����", "���ѹα�" };
				//	4			3		2		 1		// �ε���

		// ���� / �׳� ����Ʈ�� ����ø� �˴ϴ�. / �����ڰ� ����Ʈ�ۿ� �����
		Stack<String> s = new Stack<String>();

		// �߰�
		for(int i=0; i<groupA.length;i++){
			System.out.println("�߰� : "+ s.push(groupA[i] ) );
		}
/*		LIFO ����
	0				// �����Ͱ� ���°Ŵ� / �ڸ�
	1	���ѹα�		3-> �������� �ε��� �ڸ�
	2	����		2
	3	�����Ʈ		1
	4	���Ű��ź	0

		�������� ������ ���ѹα� ���� ���Ű��ź ������
		������ �޼��尡 peek()�̶� pop()�� �־��
		�غ��� �дϴ�.
*/

		//�˻�
		System.out.println( "�˻� : "+s.search("���ѹα�"));	// ��? ���ѹα��� �ε����� 1�̳�????
			// �갡 �̻��Ѱž�
			// ������ ������� ���� ���� �־����ϱ� 0���� �Ǵ°� �����ε�,
			// ������ �ݴ�� ���ϱ� �ε����� �ݴ�� ���ٰ� �ص� ���ѹα��� 0�� �ƴϳ�? // �̰� �� �׷��ĸ� ���ѹα� ���� 0�̾�

		//����	/ �����Ʈ�� �ű⼭ �� ����?
		System.out.println( "���� : "+s.remove(1) );
				/* ����� ������ �� ����, �ٵ� �޼��尡 ���� �ƴϾ, ������ �� �´� ��찡 �־�. Ư�� GUI ���� ���� �����¾ƿ� �ù�. remove�� Vector�� ���ݾ�. stack�� �ε����� �������̰� �������� �� ���� �ε����� ��. �׷��� Vector �� �ε��� ������ ���� �������� �ε����� �о�����ž�*/
		System.out.println( "���� : "+s.remove("���ѹα�") );	//�ε����� �̻��ؼ� ����� �ȵǸ�, �׳� �̷��� ������ �˴ϴ�.feat. API
		// ���
		while( ! s.empty() ){	// empty() �̰� �����? �ϱ� ������� true��? �׷��� ������ ��� ! �̰�
		//	System.out.println( "��� : " + s.peek() );	// ���ѷ��� ���ϴ�. peek�� ������ ��������. �׷��� �� ���ѹα�, �� ���ѹα�
			System.out.println( "��� : " + s.pop() );
		}
		/*
			�߰� : ���Ű��ź
			�߰� : �����Ʈ
			�߰� : ����
			�߰� : ���ѹα�
			��� : ���ѹα�
			��� : ����
			��� : �����Ʈ
			��� : ���Ű��ź
		*/
		
	}
}

/*
Stack �̶�� �ִ� stack ������ �� �ֱ���
	
	//�޼���
boolean	empty()
			Tests if this stack is empty.
	E	peek()
			Looks at the object at the top of this stack without removing it from the stack.
	E	pop()
			Removes the object at the top of this stack and returns that object as the value of this function.
	E	push(E item)
			Pushes an item onto the top of this stack.
	int	search(Object o)		// stack �� list�� �ε����� �־�. �� ��° ��(int)
			Returns the 1-based position where an object is on this stack.

������ �ڷᱸ���� ������ �� �̷��� �����ϰ�, �߰��� �� add�� �ƴ϶� push, ������ ���� pop, ã�� ���� search
������ ��Ư���� ���� ���°� �ƴϾ.

�����°� ����??
�θ� Vector��. Vector�� ���� ��.
������ ����� ������ ����� ������ ����� empty() ����ֳ�?

remove�� ����?
Vector �� ���� ��
*/