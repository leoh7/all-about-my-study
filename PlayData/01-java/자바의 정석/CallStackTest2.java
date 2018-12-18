class CallStackTest2 {
	public static void main(String[] args) {
		System.out.println("1. main(String[] args) 이 시작되었음.");
		firstMethod();
		System.out.println("6.main(String[] args) 이 끝났음.");
	}

	static void firstMethod() {
		System.out.println("2.firstMethod() 가 시작되었음.");
		secondMethod();
		System.out.println("5.firstMethod() 가 끝났음.");
	}
	static void secondMethod() {
		System.out.println("3.secondMethod() 가 시작되었음.");
		System.out.println("4.secondMethod() 가 끝났음.");
	}
}
