// class Car
class Car {
	//멤버 변수
	private String name;
	private String fuel;
	//생성자	
	//public Car(){}	default 생성자, 필요하면 추가하자
	public Car(String name, String fuel){
	this.name = name;
	this.fuel = fuel;
	}
																						/*	public Car(String name, String fuel, int carry){
																							this.carry = carry;}
																							public Car(String name, String fuel, int number){
																							this.number = number;}	*/
	//멤버 메서드
	public String getName(){ return name; }		// 차종을 리턴
	public String getFuel(){ return fuel; }		// 연료를 리턴
}
// class Car 끝

// class Truck 
class Truck extends Car {	// 적재 추가
	
	//멤버 변수
	private int carry;
	//생성자
	public Truck(String name, String fuel, int carry){
		super(name, fuel);
		this.carry = carry;
	}
	//멤버 메서드
	public int getCarry(){ return carry; }

}
// class Truck 끝



// class Bus 시작
class Bus extends Car {		// 노선 추가 number
	
	//멤버 변수
	private int number;
	//생성자
	public Bus(String name, String fuel, int number){
		super(name, fuel);
		this.number = number;
	}
	//멤버 메서드
	public int getNumber(){ return number; }
}
// class Bus 끝


// class Bike 시작
class Bike extends Car {
	//생성자
	public Bike (String name, String fuel){
		super(name, fuel);
	}
}
// class Bike 끝


// class InherStudy 시작	
class InherStudy {
	
	public static void main(String[] args) {
		//Car 클래스를 상속 받은 Truck, Bus, Bike 클래스를 구현한다.
	
		Truck truck = new Truck( "포터", "경유", 1 );
		System.out.println( "차종 : " + truck.getName() );
		System.out.println( "연료 : " + truck.getFuel() );
		System.out.println( "적재 : " + truck.getCarry() + "ton" );
		System.out.println();

		Bus bus = new Bus( "현대", "가스", 407 );
		System.out.println( "차종 : " + bus.getName() );
		System.out.println( "연료 : " + bus.getFuel() );
		System.out.println( "노선 : " + bus.getNumber() );
		System.out.println();

		Bike bike = new Bike( "대림", "경유" );
		System.out.println( "차종 : " + bike.getName() );
		System.out.println( "연료 : " + bike.getFuel() );	
		
	}	//main
}	//class
// class InherStudy 끝

/*
차종 : 포터
연료 : 경유
적재 : 1ton

차종 : 현대
연료 : 가스
노선 : 407

차종 : 대림
연료 : 경유
*/