class WhileEx2_2 {
	public static void main(String[] args){

		int i=0;			// while�� ������ ���� i ����
		int sum_even=0;		// ¦����
		int sum_odd=0 ;		// Ȧ����
		int sum=0;			// ����
		
		while(i<100){
			i++;
		
			sum += i;				//���� ��
			if(i%2==0){				
			sum_even += i;		//¦����
			}else{sum_odd += i;}		//Ȧ����
		
		/*
			ó�� ®�� �ڵ��
			�̷��� © �Ÿ� while�� �� �ʿ䰡 ����. �Դٰ� while�� while�� ��ø�ذ��鼭 ����!
			while(i%2==0){
			sum_even += i;}
			while(i%3==0){
			sum_odd += i;}
		*/
		

			//System.out.println(i);
		}
		System.out.println("¦���� : " + sum_even );		//2550
		System.out.println("Ȧ���� : " + sum_odd );		//2500
		System.out.println("��ü�� : " + sum );		//5050
	}
}
