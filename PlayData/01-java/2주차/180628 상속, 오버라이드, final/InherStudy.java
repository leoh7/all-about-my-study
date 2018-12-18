// class Car
class Car {
	//��� ����
	private String name;
	private String fuel;
	//������	
	//public Car(){}	default ������, �ʿ��ϸ� �߰�����
	public Car(String name, String fuel){
	this.name = name;
	this.fuel = fuel;
	}
																						/*	public Car(String name, String fuel, int carry){
																							this.carry = carry;}
																							public Car(String name, String fuel, int number){
																							this.number = number;}	*/
	//��� �޼���
	public String getName(){ return name; }		// ������ ����
	public String getFuel(){ return fuel; }		// ���Ḧ ����
}
// class Car ��

// class Truck 
class Truck extends Car {	// ���� �߰�
	
	//��� ����
	private int carry;
	//������
	public Truck(String name, String fuel, int carry){
		super(name, fuel);
		this.carry = carry;
	}
	//��� �޼���
	public int getCarry(){ return carry; }

}
// class Truck ��



// class Bus ����
class Bus extends Car {		// �뼱 �߰� number
	
	//��� ����
	private int number;
	//������
	public Bus(String name, String fuel, int number){
		super(name, fuel);
		this.number = number;
	}
	//��� �޼���
	public int getNumber(){ return number; }
}
// class Bus ��


// class Bike ����
class Bike extends Car {
	//������
	public Bike (String name, String fuel){
		super(name, fuel);
	}
}
// class Bike ��


// class InherStudy ����	
class InherStudy {
	
	public static void main(String[] args) {
		//Car Ŭ������ ��� ���� Truck, Bus, Bike Ŭ������ �����Ѵ�.
	
		Truck truck = new Truck( "����", "����", 1 );
		System.out.println( "���� : " + truck.getName() );
		System.out.println( "���� : " + truck.getFuel() );
		System.out.println( "���� : " + truck.getCarry() + "ton" );
		System.out.println();

		Bus bus = new Bus( "����", "����", 407 );
		System.out.println( "���� : " + bus.getName() );
		System.out.println( "���� : " + bus.getFuel() );
		System.out.println( "�뼱 : " + bus.getNumber() );
		System.out.println();

		Bike bike = new Bike( "�븲", "����" );
		System.out.println( "���� : " + bike.getName() );
		System.out.println( "���� : " + bike.getFuel() );	
		
	}	//main
}	//class
// class InherStudy ��

/*
���� : ����
���� : ����
���� : 1ton

���� : ����
���� : ����
�뼱 : 407

���� : �븲
���� : ����
*/