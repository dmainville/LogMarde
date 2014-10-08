package main;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeImplTest {

	SuiteChainee suiteChainee;
	
	@Before
	public void setUp() throws Exception {
		suiteChainee= new SuiteChaineeImpl();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEC1() {
		try {
			suiteChainee.build("config.properties", "add", 3, 2, 5, true);
			Properties prop = PropReader.readfile("src/config.properties");
			assertEquals(true, PropReader.isValid(prop));
			
		} catch (Exception e) {
			assertTrue(false);
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
