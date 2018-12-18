class Car{}
class FireEngine extends Car {}

class InstanceofTest{
	public static void main (String [] args){
		FireEngine fe = new FireEngine();

		if(fe instanceof FireEngine){
			System.out.println("This is a FireEngine instance.");
		}

		if(fe instanceof Car){
			System.out.println("This is a Car instance.");
		}

		if(fe instanceof Object){
			System.out.println("This is an Object instance.");
		}

		System.out.println("(Object Ŭ������ ����ߴ��� ��������)getName() Ȯ��: "+fe.getClass().getName() );
		System.out.println("(Object Ŭ������ ����ߴ��� ��������)getClass() Ȯ��: "+fe.getClass());
	}

}
