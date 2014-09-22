import java.io.Console;


public class Program
{
	public static void main(String[] args)
	{
		SuiteChainee s = new SuiteChainee("","addition",0,0,0,true);
		
		System.out.println("Multiplication : "+s.multiplication(0, 200));
		System.out.println("Multiplication : "+s.multiplication(-10, 3));
		
		System.out.println("Division : "+s.division(31, 3));
		System.out.println("Division : "+s.division(31, -3));
		
		s.save("suite.txt");
		
		System.out.println(s.isValide());
		
		SuiteChainee s1 = new SuiteChainee("","addition",1,3,10,false);
		
		System.out.println(s1.isValide());
		
	}

}
