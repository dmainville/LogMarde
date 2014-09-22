import java.io.Console;


public class Program
{
	public static void main(String[] args)
	{
		SuiteChainee s = new SuiteChainee("","addition",0,0,0,true);
		
		int a = 3;
		int b = 100;
		System.out.println("Addition : "+s.addition(3, 200));
		System.out.println("Addition : "+s.addition(a, b));
		
		System.out.println("Multiplication : "+s.multiplication(3, 200));
		System.out.println("Multiplication : "+s.multiplication(-10, 3));
		
		System.out.println("Division : "+s.division(31, 3));
		System.out.println("Division : "+s.division(31, -3));
		System.out.println("Division : "+s.division(872, -14));
		
		s.save("suite.txt");
		
		System.out.println(s.isValide());
		
		SuiteChainee s1 = new SuiteChainee("","addition",1,3,10,false);
		
		System.out.println(s1.isValide());
		
	}

}
