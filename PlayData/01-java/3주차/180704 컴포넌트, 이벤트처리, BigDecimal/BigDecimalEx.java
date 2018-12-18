/*
double �� �����ϴ°� �Ҽ��� 14�ڸ�
�̰� �Ѿ�� (�� ������ �Ѿ��) �������
�Ǽ������� �� ���� BigDecimal �� �ؼ� �����ߵ�.
��ݾ��� ���� ����

BigDecimal�� BigInteger
�Ǽ����� ����	������ ū ������ ����


*/
import java.lang.ArithmeticException;
import java.math.BigDecimal;
import java.math.MathContext;
class BigDecimalEx {
	
	

	public static void main(String[]args) throws ArithmeticException {
		System.out.println( 2.0 + 1.1 );
		System.out.println( 2.0 - 1.1 );	// ��� ���� ���� 
		System.out.println( 2.0 * 1.1 );
		System.out.println( 2.0 / 1.1 );
		int i;
		

		System.out.println();

//		BigDecimal a = 2.0;	// ���ڶ� ��ü�� �� �־��شٰ� ������ �ϴµ� ����ڽ� ��ڽ��� ��Ʈ�� ��Ƽ�� �̷��� / �̷��� �� �־
		BigDecimal a = new BigDecimal(2.0);	// BigDecimal(Double val)
		BigDecimal b = new BigDecimal(1.1);
		

		System.out.println(" + "+a.add( b, MathContext.DECIMAL32 ));
		System.out.println(" - "+a.subtract( b, MathContext.DECIMAL32 ));	// �Ҽ����� �ڸ��鼭 �ڵ����� �� �ø��� ���࿩. 
		System.out.println(" * "+a.multiply( b, MathContext.DECIMAL32 ));
		System.out.println(" / "+a.divide( b, MathContext.DECIMAL32 ));
	
		BigDecimal ad = a.add( b, MathContext.DECIMAL32 );
		BigDecimal su = a.subtract( b, MathContext.DECIMAL32 );
		BigDecimal mu = a.multiply( b, MathContext.DECIMAL32 );
		BigDecimal di = a.divide( b, MathContext.DECIMAL32 );
	
	System.out.println();	//Rounding necessary
		ad = a.add( b, MathContext.DECIMAL32 );
	
		
		// MathContext(String val)
	}
}

/*

	�ʵ� ��
static BigDecimal	ONE
static int	ROUND_CEILING
static int	ROUND_DOWN
static int	ROUND_FLOOR
static int	ROUND_HALF_DOWN
static int	ROUND_HALF_EVEN
static int	ROUND_HALF_UP
static int	ROUND_UNNECESSARY
static int	ROUND_UP
static BigDecimal	TEN
static BigDecimal	ZERO


BigDecimal	add(BigDecimal augend)
Returns a BigDecimal whose value is (this + augend), and whose scale is max(this.scale(), augend.scale()).
BigDecimal	add(BigDecimal augend, MathContext mc)
Returns a BigDecimal whose value is (this + augend), with rounding according to the context settings.
		
		Class MathContext
		static MathContext	DECIMAL128
		static MathContext	DECIMAL32	// �̰� ���̴̹�
		static MathContext	DECIMAL64
		static MathContext	UNLIMITED

*/