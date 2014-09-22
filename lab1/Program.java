import java.io.Console;


public class Program
{
	public static void main(String[] args)
	{
		SuiteChainee s = new SuiteChainee("","addition",1,3,10,false);
		
		s.save("suite.txt");
		
		System.out.println(s.isValide());
		
		SuiteChainee s1 = new SuiteChainee("","addition",1,3,10,true);
		
		System.out.println(s1.isValide());
		
	}

}
