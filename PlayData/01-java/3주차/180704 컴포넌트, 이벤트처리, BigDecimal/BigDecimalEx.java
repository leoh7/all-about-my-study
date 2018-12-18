/*
double 이 관리하는게 소숫점 14자리
이걸 넘어가면 (지 범위를 넘어가면) 끊어버림
실수연산을 할 때는 BigDecimal 을 해서 잡아줘야되.
뜬금없는 빼기 문제

BigDecimal과 BigInteger
실수연산 보정	굉장히 큰 정수값 보정


*/
import java.lang.ArithmeticException;
import java.math.BigDecimal;
import java.math.MathContext;
class BigDecimalEx {
	
	

	public static void main(String[]args) throws ArithmeticException {
		System.out.println( 2.0 + 1.1 );
		System.out.println( 2.0 - 1.1 );	// 요게 제일 문제 
		System.out.println( 2.0 * 1.1 );
		System.out.println( 2.0 / 1.1 );
		int i;
		

		System.out.println();

//		BigDecimal a = 2.0;	// 숫자랑 객체를 막 넣어준다고 생각을 하는데 오토박싱 언박싱은 인트랑 인티져 이런겅 / 이런거 못 넣어여
		BigDecimal a = new BigDecimal(2.0);	// BigDecimal(Double val)
		BigDecimal b = new BigDecimal(1.1);
		

		System.out.println(" + "+a.add( b, MathContext.DECIMAL32 ));
		System.out.println(" - "+a.subtract( b, MathContext.DECIMAL32 ));	// 소숫점을 자르면서 자동으로 반 올림을 해줘여. 
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

	필드 값
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
		static MathContext	DECIMAL32	// 이거 쓸겁미다
		static MathContext	DECIMAL64
		static MathContext	UNLIMITED

*/