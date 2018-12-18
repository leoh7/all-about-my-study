package wiring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELTest {
	public static void main(String[] args){
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("wiring/spel/ApplicationContext.xml");
		
		SpEL spel = (SpEL) ctx.getBean("spel");
		System.out.println("String1 값 : " + spel.getStr1());
		System.out.println("String2 값 : " + spel.getStr2());
		System.out.println("String3 값 : " + spel.getStr3());
		System.out.println("String4 값 : " + spel.getStr4());
		System.out.println("String5 값 : " + spel.getStr5());
		System.out.println("String6 값 : " + spel.getStr6());
		System.out.println("String7 값 : " + spel.getStr7());
		System.out.println("String8 값 : " + spel.getStr8());
		System.out.println("String9 값 : " + spel.getStr9());
		System.out.println("String10 값 : " + spel.getStr10());
		System.out.println("String11 값 : " + spel.getStr11());
		System.out.println("String12 값 : " + spel.getStr12());
		System.out.println("String13 값 : " + spel.getStr13());
		System.out.println("String14 값 : " + spel.getStr14());
		System.out.println("String15 값 : " + spel.getStr15());
		System.out.println("String16 값 : " + spel.getStr16());
		System.out.println("String17 값 : " + spel.getStr17());
		System.out.println("String18 값 : " + spel.getStr18());
		System.out.println("String19 값 : " + spel.getStr19());
		System.out.println("String20 값 : " + spel.getStr20());
		System.out.println("String21 값 : " + spel.getStr21());
		System.out.println("String22 값 : " + spel.getStr22());
		System.out.println("String23 값 : " + spel.getStr23());
		System.out.println("String24 값 : " + spel.getStr24());
		System.out.println("String25 값 : " + spel.getStr25());
		System.out.println("String26 값 : " + spel.getStr26());
		System.out.println("String27 값 : " + spel.getStr27());
		System.out.println("String28 값 : " + spel.getStr28());
		System.out.println("String29 값 : " + spel.getStr29());
		System.out.println("String30 값 : " + spel.getStr30());
		System.out.println("String31 값 : " + spel.getStr31());
		System.out.println("String32 값 : " + spel.getStr32());
		System.out.println("String33 값 : " + spel.getStr33());
		System.out.println("String34 값 : " + spel.getStr34());
		System.out.println("String35 값 : " + spel.getStr35());
		System.out.println("String36 값 : " + spel.getStr36());
		System.out.println("String37 값 : " + spel.getStr37());
		System.out.println("String38 값 : " + spel.getStr38());
		System.out.println("String39 값 : " + spel.getStr39());
		System.out.println("String30 값 : " + spel.getStr40());
		System.out.println("String31 값 : " + spel.getStr41());
		System.out.println("String32 값 : " + spel.getStr42());
		System.out.println("String33 값 : " + spel.getStr43());
		System.out.println("String34 값 : " + spel.getStr44());
		System.out.println("String35 값 : " + spel.getStr45());
		System.out.println("String36 값 : " + spel.getStr46());
		System.out.println("String37 값 : " + spel.getStr47());
		System.out.println("String38 값 : " + spel.getStr48());
		System.out.println("String39 값 : " + spel.getStr49());
		
		
	}
}
