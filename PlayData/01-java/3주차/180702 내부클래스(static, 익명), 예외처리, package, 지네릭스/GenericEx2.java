/*
���� ��¥ ������.
�� �� ���� �ĸ� �� �� �ִ�. �̰͸� ����Ͻ� ��. ���� ������ �ʴµ� API �� ����
*/
/*
< ? super ��ü�ڷ���>		��õ� ��ü�� ������ ���� ��ü���� ��ġ
						��ü ������ ��� ���׸� Ÿ���� Object�� �ν�
< ? extends ��ü�ڷ���>		��õ� ��ü�� ������ ���� ��ü���� ��ġ
						��ü ������ ��� ���׸� Ÿ���� extends ������
						��õ� ��ü�ڷ������� �ν�
							ex)HashSet(Collection<? extends E> c)
							Element ���� ������ �� �ްڴٴ� ��


	? -> �̰� ���ϵ�ī��
	��ü�ڷ��� -> ���� ���� Ŭ���� �̸��̶� �Ҹ�
	

*/




class SuperA {
	String msg = "SuperA";
	public String getMsg(){
		return msg;
	}
}	// class SuperA

class SuperB extends SuperA {
	String msg = "SuperB";
	public String getMsg(){
		return msg;
	}
}	// class SuperB

class SuperC extends SuperB {
	String msg = "SuperC";
	public String getMsg(){
		return msg;
	}
}	// class SuperC

class GenericEx2 <T>{	// �갡 ���׸�, main �� ������ �ִ�.
	private T a;
	public GenericEx2(){}
	public GenericEx2( T a ){
		this.a=a;
	}
	public void set( T a ){
		this.a = a;
	}
	public T get(){
		return a;
	}

	public static void main (String []args){
			//����� ���ϵ� ī�尡 ����			//����� ����� �� �ٲ�
		GenericEx2 <?> ge = new GenericEx2 <Integer>(10) ;
			//Object�� �ްڴ�, ��� ��			//Object�� �ްڴ�-> �ߴµ� Integer�� �޾Ҵ�. �θ� �ؿ� �ڽ����� �޾����ϱ� �ڵ�����ȯ �Ͼ�� OK �� ��.
			//getA �޼��带 ���� Object�� ���´ٴ� ��.
//		Integer a = ge.get();	// �̷��� �ϸ� ����, Object�� �θ��, �� ū��, �ڽĿ��ٰ� �����ϱ�
//		Object a = ge.get();	// �̷��� �ϸ� ���� �� �ִ�. �ٵ� �̷��� �ϸ� �θ� �ڽĲ� ���Ἥ �޼��� �ƹ��͵� �����ٴ� �Ҹ���
		Integer a = (Integer) ge.get();	//�׷��� �̷��� "���� �ڷ���"���� �޵�, ������ ���� ����ȯ �ؼ� �޾ƾ� �Ѵٴ� ��.
		
		SuperA sua = new SuperA();
		SuperB sub = new SuperB();
		SuperC suc = new SuperC();

		GenericEx2 <? super SuperB> ge1 = new GenericEx2 <SuperA> (sua);
		GenericEx2 <? super SuperB> ge2 = new GenericEx2 <SuperB> (sub);
//		GenericEx2 <? super SuperB> ge3 = new GenericEx2 <SuperC> (suc);	// �̰� �� ��.
//		Object sb = ge2.get();	// �̰� ok / ��ġ�� �̰� Object�� ������ SuperB�� ������ �ִ°� �� �� ��
//		SuperB sb = ge2.get();	// �̷��� �ϸ� ���� / ����ȯ �ʿ��ϴ�
		SuperB sb = (SuperB) ge2.get();
		System.out.println("sb : " +sb.getMsg() );
		
		/*super SuperB -> ������Ʈ�� �ٲ�� �Ǿ� ����*/

//		GenericEx2 <? extends SuperB> ge4 = new GenericEx2 <SuperA> (sua);	// �̰� �� ��.
		GenericEx2 <? extends SuperB> ge5 = new GenericEx2 <SuperB> (sub);
		GenericEx2 <? extends SuperB> ge6 = new GenericEx2 <SuperC> (suc);

//		Object se = ge6.get();	// ���ߵ��� �ȴ� / ���ߵ��� Object�� ������ SuperB�� ������ �ִ� �޼��带 �� ���ٴ� ��
//		SuperC sc = ge6.get();	// �̰� �� �ǳ�		/
		SuperC sc = (SuperC) ge6.get();	// �̰͵� �ȴ�?
		System.out.println("se : " +sc.getMsg() );
// �̰� �θ� �ڽ� ���迡 ���� ���� SuperB �θ��ڷ������� �� �ٲ��.


	}	// main
}	// class GenericEx2