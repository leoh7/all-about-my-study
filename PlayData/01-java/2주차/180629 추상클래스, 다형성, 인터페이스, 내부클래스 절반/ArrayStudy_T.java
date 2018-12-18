import java.util.Random;

class ArrayStudy_T {
	public static void main(String[] args) {
	Random r = new Random();
	
	int lotto[] = new int[6];
	for(int i=0; i<lotto.length; i++){
         lotto[i]=r.nextInt(45)+1;
      
		 for(int j=0; j<i; j++){
          
			if(lotto[i]== lotto[j]){
               i--;
               break;
            }		// 0	1	2	3	4	5	6
					// 3	7	8
         }
      }

      for(int i=0; i<lotto.length; i++){
         System.out.print(lotto[i] + "\t");
      }
      System.out.println();

	}
}
