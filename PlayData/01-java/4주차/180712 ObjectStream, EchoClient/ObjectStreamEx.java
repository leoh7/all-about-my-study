/*
	��ü ���� ��Ʈ�� ObjectInputStream, ObjectOutputStream
	protected -> ���� ������ ��ӹ޾Ƽ� ��� 
	�굵 �ٸ� 1byte ��Ʈ���� �ʿ��ϴ� / ���ʹ� �ƴѵ� �ܵ����� �� ��.
		ObjectInputStream(InputStream in)
		ObjectOutputStream(OutputStream out)
	������ �ɰ��Ÿ� 1byte�� �ɰ���..?

	import java.io.*;
	import java.util.Vector;
	class Customer implements Serializable {	//��ü ���� ��Ʈ���� �� ���� ��ü����ȭ �� �ݵ�� �ʿ��ϴ�

	�÷���, Hashmap ���� ����ȭ�� �Ǿ��ִ�.

	Bean �� �ٱ���
*/


// ��ü ���� ����� + ��ü ����ȭ / Serializable

import java.io.*;
import java.util.Vector;
import java.util.Enumeration;

class Customer implements Serializable {	// ����� �� Ŭ����
	//��� ����
	private String name;
	private int age;
	private String tel;
	
	// ������
	public Customer( String name, int age, String tel ){
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	//�޼���
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getTel(){
		return tel;
	}
}



class ObjectStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;		// ���۴� ��� �̷�α�� �Ѵ�	/ oos �� ����ϴ� ����, ��� writeObject ��� Ư���� �޼��带 ����. �׷��� ���۷� ���δµ��� �����ʿ�
		FileInputStream fis = null;
		ObjectInputStream ois = null;
	
		try{/*
			fos = new FileOutputStream( "result.ser" );
			oos = new ObjectOutputStream( fos );
					// fis = new FileInputStream("result.ser");	// ����ٰ� �����͸� �ֱ����� new �� �ϸ� (�Ųٷ� �� ��) �ƹ��͵� �о�� �� ����.

			oos.writeObject(new Customer("ȫ�浿", 30, "1111-2222") );
			oos.writeObject(new Customer("�̼���", 40, "2222-2222") );
			
			fis = new FileInputStream( "result.ser" );
			ois = new ObjectInputStream( fis );
					//ois.readObject();		// ������Ʈ�� �����Ѵٰ� ������Ʈ�� ������ �ȵȴ�.
			
			Customer cus1 = (Customer) ois.readObject();	// ���ϵǴ� ������Ʈ�� Customer�� ����ȯ ���� / ������ ��ü�� �ƴϾ ���ܰ� �����.
			Customer cus2 = (Customer) ois.readObject();
			System.out.println(
				"�̸� : " + cus1.getName() + "\n"
				+ "���� : " + cus1.getAge() + "\n"
				+ "��ȭ��ȣ ; " + cus1.getTel()
			);
			System.out.println(
				"�̸� : " + cus2.getName() + "\n"
				+ "���� : " + cus2.getAge() + "\n"
				+ "��ȭ��ȣ ; " + cus2.getTel()
			);
			*/
			Customer customers[] = {		// �̷� �����ʹ� ���� �о�ٰ� ����ϴ� ��.
				new Customer("ȫ�浿", 30, "4324-2222" ),
				new Customer("�̼���", 18, "1221-55332" ),
				new Customer("������", 37, "1411-2552" ),
				new Customer("������", 52, "1111-2662" ),
				new Customer("������", 22, "1111-6632" )
				};	// ������ �غ� // ��ü���� ��������� �־��ٰ� ���Ϸ� ������
			
			//  Vector
			Vector <Customer> vCustomer1 = new Vector <Customer>( customers.length );
			for( int i=0; i<customers.length; i++){
				vCustomer1.add( customers[i] );
			}
			
			oos = new ObjectOutputStream( new FileOutputStream("result.ser") );
			oos.writeObject(vCustomer1);
			


			//ser ������ �о����
			ois = new ObjectInputStream( new FileInputStream("result.ser") );
			Vector<Customer>vCustomer2 = (Vector<Customer>) ois.readObject();
			
			for( int i=0; i<vCustomer2.size(); i++){

				System.out.println(
					"�̸� : " + vCustomer2.get(i).getName() + "\n"
					+ "���� : " + vCustomer2.get(i).getAge() + "\n"
					+ "��ȭ��ȣ ; " + vCustomer2.get(i).getTel()
					);
			}

	//		Enumeration<Customer> en = vCustomer2.elements();
	//		while(en.hasMoreElements() ){
	//			en.nextElement();

			//	System.out.println("�̸� : " + en.nextElement().getName() + "\n"	// ������ ������ ����
			//						+ "���� : " + en.nextElement().getAge()	
	//			);
	//		}
			
			


			
		} catch( /*FileNotFoundException |*/ IOException  | ClassNotFoundException e ){	// ��Ƽ�� ĳġ, Exception�� ���谡 �θ��ڽ� ����� ���� �ȵȴ�.
			e.printStackTrace();
		}
	}
}
