package main;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// call for main operation
		//suiteChainee.build(path, op, val1, val2, taille, etatVide) 
		//path="config.properties"
		//op{"add","mult","soust",div"}
		//val1,val2 are int
		//0< taille <=10
		//etatVide{true,false}
		
		SuiteChainee suiteChainee= new SuiteChaineeImpl();
		suiteChainee.build("config.properties", "div", 3, 2, 5, false);
	
		if(suiteChainee.isValid("config.properties")){
			System.out.println("chaine valide");
		}else{
			System.out.println("chaine pas valide");
		}
	}

}
