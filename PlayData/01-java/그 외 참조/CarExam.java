class Car {
	private String name;
	private int number;

	public Car (String name){
	this("�̸�����",0);
	}
	public Car (){
	}
	public Car (String name, int number){
		this.name = name;
		this.number = number;
	}

	public String getName()	{ return name;}
	public int getNumber()	{ return number;}
}

class CarExam{
	public static void main(String[] args){
		Car c1 = new Car();
		Car c2 = new Car("�ڵ���");
		Car c3 = new Car("�ڵ���", 1234);
	
	System.out.println("��ü�� name �� number : "+c1.getName()+", "+c1.getNumber);

	}	//main
}	//class