/*
	���� = 3�ڸ� ���� ����
	
*/

import java.util.Random;
class BullsAndCowsWhy {
	private int value;
	int a[]=new int[3];
	Random r = new Random();
	public void setRandom(){
				for(int i=0; i<a.length; i++){
					a[i] = r.nextInt(8)+1;

					for(int j=0; j<i ;j++){		
						
						if(a[i]==a[j]){ 
							i--; 
							break; 
							}	
					}	//for j
					
				}	//for i
			
			
		}	//setRandom
	



	public static void main(String[] args) {
		// ���߿� �͸� Ŭ������ ���� �� ������?
	
	
	BullsAndCowsWhy bac = new BullsAndCowsWhy();
	for(int i=0;i<bac.a.length;i++){
		bac.setRandom();
		System.out.print(bac.a[i]+" ");}
	

	
	
	}
}
