package main;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeImplTest {

	SuiteChainee suiteChainee;
	Calculator myCalculator= new CalculatorImpl();
	
	public TestCase AllCover1 	= TestCase.Create("add", 1, 9, 3, true); // Fichier valide
	public TestCase AllCover2 	= TestCase.Create("soust", 1, 9, 3, true); // Fichier valide
	public TestCase AllCover3	= TestCase.Create("mult", 1, 2, 3, true); // Fichier valide
	public TestCase AllCover4 	= TestCase.Create("div", 24, 12, 3, true); // Fichier valide
	public TestCase AllCover5 	= TestCase.Create("DROPTABLE", 1, 1, 3, true); // Fichier valide
	public TestCase AllCover6 	= TestCase.Create("add", 1, 2, 12, true); // Fichier valide

	public TestCase AllCover7 	= TestCase.Create("add", 1, 9, 3, false); // Fichier valide
	public TestCase AllCover8 	= TestCase.Create("add", 1, 9, 8, false); // Fichier valide
	public TestCase AllCover9 	= TestCase.Create("add", 1, 9, 3, false); // Fichier valide
	public TestCase AllCover10 	= TestCase.Create("add", 1, 9, 3, false); // Fichier valide
	public TestCase AllCover11 	= TestCase.Create("div", 4, 3, 3, false); // Fichier valide
	public TestCase AllCover12 	= TestCase.Create("div", 4, 3, 0, true); // Fichier valide
	
	@Before
	public void setUp() throws Exception {
		suiteChainee= new SuiteChaineeImpl();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void AllCoverTest1() {	
			RunTest();
	}
	@Test
	public void AllCoverTest2() {	
			RunTest();
	}
	@Test
	public void AllCoverTest3() {	
			RunTest();
	}
	@Test
	public void AllCoverTest4() {	
			RunTest();
	}
	@Test
	public void AllCoverTest5() {	
			RunTest();
	}
	@Test
	public void AllCoverTest6() {	
			RunTest();
	}
	@Test
	public void AllCoverTest7() {	
			RunTest();
	}
	@Test
	public void AllCoverTest8() {	
			RunTest();
	}
	@Test
	public void AllCoverTest9() {	
			RunTest();
			try {
				String name = Thread.currentThread().getStackTrace()[1].getMethodName();
				int nb = Integer.parseInt(name.substring(12));
				String configFile = GetConfigFile(nb);
			
				Properties prop = PropReader.readfile("bin/"+configFile);
				prop.setProperty("indexe", Integer.toString(0));
				FileOutputStream out = new FileOutputStream("bin/"+configFile);
				prop.save(out, "save");
			} catch (Exception e) {
				
			}
			
	}
	@Test
	public void AllCoverTest10() {	
			RunTest();
	}
	@Test
	public void AllCoverTest11() {	
			RunTest();
	}
	@Test
	public void AllCoverTest12() {	
			RunTest();
	}
	
	@Test
	public void Liste1() {	
		try {
			MyList list = new MyListImpl();
			
			list.add(5);
			list.add(5);
			list.setAt(0, 1);
			assertEquals(list.getAt(1), 0);
			assertEquals(list.getSize(), 2);
			list.removeAt(0);
			list.add(5);
			list.removeAt(1);
			list.add(6);
			list.add(7);
			list.reset();
			
			list.add(5);
			list.add(5);
			list.add(6);
			list.add(7);
			list.add(8);
			list.add(9);
			list.add(10);
			list.removeItem(6);
			list.removeItem(5);
			list.removeAt(3);


		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void Liste2() {	
		try {
			MyList list = new MyListImpl();
			list.setAt(5, 5);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void Liste3() {	
		try {
			MyList list = new MyListImpl();
			list.getAt(5);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void Liste4() {	
		try {
			MyList list = new MyListImpl();
			list.removeAt(5);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void Liste5() {	
		try {
			MyList list = new MyListImpl();
			list.removeItem(5);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	//Test de Calculator
	@Test
	public void AllCoverCalcTest1() {
		int result = myCalculator.add(1, 2);
		assertEquals(true, result == 3);
	}
	
	@Test
	public void AllCoverCalcTest2() {
		int result = myCalculator.add(1, -2);
		assertEquals(true, result == -1);
	}
	
	@Test
	public void AllCoverCalcTest3() {
		int result = myCalculator.substract(4, -3);
		assertEquals(true, result == 7);
	}
	
	@Test
	public void AllCoverCalcTest4() {
		int result = myCalculator.multiply(3, 4);
		assertEquals(true, result == 12);
	}
	
	@Test
	public void AllCoverCalcTest5() {
		int result = myCalculator.multiply(-2, 4);
		assertEquals(true, result == -8);
	}
	
	@Test
	public void AllCoverCalcTest6() {
		int result = myCalculator.multiply(-2, -4);
		assertEquals(true, result == 8);
	}
	
	@Test
	public void AllCoverCalcTest7() {
		try{
			int result = myCalculator.divide(2, 0);
			assertEquals(true, false);
		}
		catch(Exception e){
			assert(true);
		}
	}
	
	@Test
	public void AllCoverCalcTest8() {
		int result = myCalculator.divide(-8, 2);
		assertEquals(true, result == -4);

	}
	
	@Test
	public void AllCoverCalcTest9() {
		int result = myCalculator.divide(-8, -2);
		assertEquals(true, result == 4);

	}
	
	@Test
	public void AllCoverCalcTest10() {
		int result = myCalculator.divide(4, 8);
		assertEquals(true, result == 1);

	}
	
	@Test
	public void AllCoverCalcTest11() {
		int result = myCalculator.divide(4, -1);
		assertEquals(true, result == -4);

	}
	
	
	
	protected void RunTest()
	{
		try
		{	
			int nb = GetCurrentTestCase();
			TestCase testCase = GetTestCase(nb);
			String configFile = GetConfigFile(nb);
			
			suiteChainee.build(configFile, testCase.operation, testCase.a, testCase.b, testCase.taille, testCase.etatVide);
			suiteChainee.isValid(configFile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+e.toString());
		}
	}
	
	protected static int GetCurrentTestCase()
	{
		String name = Thread.currentThread().getStackTrace()[3].getMethodName();
		return Integer.parseInt(name.substring(12));
	}
	
	protected TestCase GetTestCase(int caseID) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Field field = this.getClass().getDeclaredField("AllCover"+caseID);
		Object testCaseObj = field.get(this);
		return (TestCase)testCaseObj;
	}
	
	protected static String GetConfigFile(int nb)
	{
		return "AllCover"+nb+".properties";
	}
	
	public static class TestCase {
		public String operation;
		public int a;
		public int b;
		public int taille;
		public Boolean etatVide;
		
		public static TestCase Create(String op, int a, int b, int taille, Boolean etatVide)
		{
			TestCase instance = new TestCase();
			instance.operation = op;
			instance.a = a;
			instance.b = b;
			instance.taille = taille;
			instance.etatVide = etatVide;
			
			return instance;
		}
	}
	
	
	
	public static class PropReader {
		
		
		public static Properties readfile(String path) throws Exception
		{
			Properties prop = new Properties();
			FileInputStream propFile = new FileInputStream(path);
			prop.load(propFile);
			
			return prop;
		}
		
		public static boolean isValid(Properties prop)
		{
			int taille 			= Integer.parseInt(prop.getProperty("taille"));
			String[] valeurs 	= prop.getProperty("contenue").trim().split(" ");
			int index 			= Integer.parseInt(prop.getProperty("indexe"));
			String operateur 	= prop.getProperty("operateur");
			int val1			= Integer.parseInt(prop.getProperty("val1"));
			int val2			= Integer.parseInt(prop.getProperty("val2"));
			
			if (taille < 1 || taille > 10)
				return false;
			
			int[] intval = new int[valeurs.length];
			for (int i = 0; i < valeurs.length; i++){
				intval[i] = Integer.parseInt(valeurs[i]);
			}
			int[] correct = compute(operateur, val1, val2, taille);
			
			for (int i = 0; i < correct.length; i++){
				if (correct[i] != intval[i])return false;
			}
			
			return true;
		}
		
		public static int[] compute(String oper, int val1, int val2, int taille){
			int[] result = new int[taille];
			result[0] = val1;
			result[1] = val2;
			
			for (int i = 2; i < taille; i++)
			{
				switch (oper){
				case "add":
					result[i] = result[i - 2] + result [i - 1];
				break;
				case "soust":
					result[i] = result[i - 2] - result [i - 1];
				break;
				case "mult":
					result[i] = result[i - 2] * result [i - 1];
				break;
				case "div":
					result[i] = result[i - 2] / result [i - 1];
				break;
				} 
			}
			
			return result;
		}
	}

}
