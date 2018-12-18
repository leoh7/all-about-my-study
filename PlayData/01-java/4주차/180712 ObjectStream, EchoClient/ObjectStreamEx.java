/*
	객체 단위 스트림 ObjectInputStream, ObjectOutputStream
	protected -> 같은 폴더나 상속받아서 써라 
	얘도 다른 1byte 스트림이 필요하다 / 필터는 아닌데 단독으로 못 씀.
		ObjectInputStream(InputStream in)
		ObjectOutputStream(OutputStream out)
	어차피 쪼갤거면 1byte로 쪼갠다..?

	import java.io.*;
	import java.util.Vector;
	class Customer implements Serializable {	//객체 단위 스트림을 할 떄는 객체직렬화 가 반드시 필요하다

	컬렉션, Hashmap 들은 직렬화가 되어있다.

	Bean 과 바구니
*/


// 객체 단위 입출력 + 객체 직렬화 / Serializable

import java.io.*;
import java.util.Vector;
import java.util.Enumeration;

class Customer implements Serializable {	// 입출력 할 클래스
	//멤버 변수
	private String name;
	private int age;
	private String tel;
	
	// 생성자
	public Customer( String name, int age, String tel ){
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	//메서드
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
		ObjectOutputStream oos = null;		// 버퍼는 잠시 미뤄두기로 한다	/ oos 가 출력하는 거지, 얘는 writeObject 라는 특수한 메서드를 쓴다. 그래서 버퍼로 감싸는데에 주의필요
		FileInputStream fis = null;
		ObjectInputStream ois = null;
	
		try{/*
			fos = new FileOutputStream( "result.ser" );
			oos = new ObjectOutputStream( fos );
					// fis = new FileInputStream("result.ser");	// 여기다가 데이터를 넣기전에 new 를 하면 (거꾸로 할 때) 아무것도 읽어올 게 없다.

			oos.writeObject(new Customer("홍길동", 30, "1111-2222") );
			oos.writeObject(new Customer("이순신", 40, "2222-2222") );
			
			fis = new FileInputStream( "result.ser" );
			ois = new ObjectInputStream( fis );
					//ois.readObject();		// 오브젝트로 리턴한다고 오브젝트로 받으면 안된다.
			
			Customer cus1 = (Customer) ois.readObject();	// 리턴되는 오브젝트를 Customer로 형변환 해줌 / 정해진 객체가 아니어서 예외가 생긴다.
			Customer cus2 = (Customer) ois.readObject();
			System.out.println(
				"이름 : " + cus1.getName() + "\n"
				+ "나이 : " + cus1.getAge() + "\n"
				+ "전화번호 ; " + cus1.getTel()
			);
			System.out.println(
				"이름 : " + cus2.getName() + "\n"
				+ "나이 : " + cus2.getAge() + "\n"
				+ "전화번호 ; " + cus2.getTel()
			);
			*/
			Customer customers[] = {		// 이런 데이터는 원래 읽어다가 써야하는 것.
				new Customer("홍길동", 30, "4324-2222" ),
				new Customer("이순신", 18, "1221-55332" ),
				new Customer("김유신", 37, "1411-2552" ),
				new Customer("강감찬", 52, "1111-2662" ),
				new Customer("대조영", 22, "1111-6632" )
				};	// 데이터 준비 // 객체단위 입출력으로 넣었다가 파일로 뺄거임
			
			//  Vector
			Vector <Customer> vCustomer1 = new Vector <Customer>( customers.length );
			for( int i=0; i<customers.length; i++){
				vCustomer1.add( customers[i] );
			}
			
			oos = new ObjectOutputStream( new FileOutputStream("result.ser") );
			oos.writeObject(vCustomer1);
			


			//ser 파일을 읽어오기
			ois = new ObjectInputStream( new FileInputStream("result.ser") );
			Vector<Customer>vCustomer2 = (Vector<Customer>) ois.readObject();
			
			for( int i=0; i<vCustomer2.size(); i++){

				System.out.println(
					"이름 : " + vCustomer2.get(i).getName() + "\n"
					+ "나이 : " + vCustomer2.get(i).getAge() + "\n"
					+ "전화번호 ; " + vCustomer2.get(i).getTel()
					);
			}

	//		Enumeration<Customer> en = vCustomer2.elements();
	//		while(en.hasMoreElements() ){
	//			en.nextElement();

			//	System.out.println("이름 : " + en.nextElement().getName() + "\n"	// 변수에 저장을 하자
			//						+ "나이 : " + en.nextElement().getAge()	
	//			);
	//		}
			
			


			
		} catch( /*FileNotFoundException |*/ IOException  | ClassNotFoundException e ){	// 멅티플 캐치, Exception이 관계가 부모자식 관계면 쓰면 안된다.
			e.printStackTrace();
		}
	}
}
