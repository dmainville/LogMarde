/**
 * @class			: SuiteChaineeImpl
 * @interface		: SuiteChainee
 * @author	 		: Ons mlouki
 * 					  Ons.mlouki@gmail.com
 * 					  
 * 
 * @summary			: build numerical sequence in linkedList and check if last numerical sequence saved isValid
 */
package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class SuiteChaineeImpl implements SuiteChainee {
	
	private static Properties prop;
	private static FileInputStream propFile;
	private static FileOutputStream editpropFile;
	
	public void build(String path, String op,int val1, int val2,int taille,Boolean etatVide) throws Exception{
		
		prop = new Properties();
		propFile = new FileInputStream("src/"+path); //charge le fichier de propriétés
		prop.load(propFile);
		StringBuilder chaineContent=new StringBuilder();
		if (taille>=10)
		{
			System.out.println("taille chaine doit etre inferieur/egal a 10");
			//System.exit(0);
		}else if (etatVide==false && taille<=Integer.parseInt(prop.getProperty("taille"))){
			
			System.out.println("chaine deja pleine");
			//System.exit(0);
						
		}else{
			
			if(etatVide==false){
			taille= taille-Integer.parseInt(prop.getProperty("taille"));
			}
		
		MyList list = new MyListImpl();	
		Calculator myCalculator= new CalculatorImpl();
		 if(taille>=1){
			   list.add(val1);
			   chaineContent.append(""+val1);
			   }
		 if(taille>=2){
			   list.add(val2);
			   chaineContent.append(" "+val2);
		 }
		 taille--;
		 int i=1;
		 taille--;
		 
		switch (op){
		   case "add":while(taille>0){
			   list.add(myCalculator.add(list.getAt(i-1),list.getAt(i)));
			   i++;
			   chaineContent.append(" "+list.getAt(i));
			   taille--;
			   };
		   break;
		   case "mult":while(taille>0){
			   list.add(myCalculator.multiply(list.getAt(i-1),list.getAt(i)));
			   i++;
			   chaineContent.append(" "+list.getAt(i));
			   taille--;
			   };
		   break;
		   case "soust":while(taille>0){
			   list.add(myCalculator.substract(list.getAt(i-1),list.getAt(i)));
			   i++;
			   chaineContent.append(" "+list.getAt(i));
			   taille--;
			   };
		   break;
		   case "div":while(taille>0){
			   list.add(myCalculator.divide(list.getAt(i-1),list.getAt(i)));
			   i++;
			   chaineContent.append(" "+list.getAt(i));
			   taille--;
			   };
		   break;
		   default:System.out.println("operateur "+op+" non identifié");
			   break;
		
		}
		
//save data in properties file	
		
		prop.setProperty("operateur", op);
	
		if(etatVide==true){
			prop.setProperty("indexe", "0");
			prop.setProperty("contenue", ""+chaineContent);
		}else{
			prop.setProperty("indexe", ""+prop.getProperty("taille"));
			prop.setProperty("contenue", ""+prop.getProperty("contenue")+" "+chaineContent);
		}
		
		prop.setProperty("val1", ""+val1);
		prop.setProperty("val2", ""+val2);
		prop.setProperty("taille", ""+(Integer.parseInt(prop.getProperty("indexe"))+list.getSize()));
		editpropFile = new FileOutputStream("src/"+path);
		
		//save is deprecated but we can use it
		prop.save(editpropFile, "save");
		
		propFile.close();
		}
	}
		
	
	
	public boolean isValid(String path) throws Exception {
		prop = new Properties();
		propFile = new FileInputStream("src/"+path); //charge le fichier de propriétés
		prop.load(propFile);
		
		//parse properties file
		int size = Integer.parseInt(prop.getProperty("taille"));
		int indexe = Integer.parseInt(prop.getProperty("indexe"));
		int val1=Integer.parseInt(prop.getProperty("val1"));
		int val2=Integer.parseInt(prop.getProperty("val2"));
		
		if(size<indexe){
			System.out.println("fichier non valide");
			return false;
		}
		
		ArrayList<Integer> listExpectedValues = new ArrayList<Integer>();
		
		int nbValues = size-indexe;
		
		listExpectedValues.add(val1);
		nbValues--;
		listExpectedValues.add(val2);
		nbValues--;
		int i=1;
		switch (prop.getProperty("operateur")){
			   case "add":while(nbValues>0){
				   listExpectedValues.add(listExpectedValues.get(i-1)+listExpectedValues.get(i));
				   i++;
				   nbValues--;
				   };
			   break;
			   case "mult":while(nbValues>0){
				   listExpectedValues.add(listExpectedValues.get(i-1)*listExpectedValues.get(i));
				   i++;
				   nbValues--;
				   };
			   break;
			   case "soust":while(nbValues>0){
				   listExpectedValues.add(listExpectedValues.get(i-1)-listExpectedValues.get(i));
				   i++;
				   nbValues--;
				   };
			   break;
			   case "div":while(nbValues>0){
				   int res=listExpectedValues.get(i-1)/listExpectedValues.get(i);
				   if ((((float)listExpectedValues.get(i-1) % listExpectedValues.get(i))/listExpectedValues.get(i))>=0.5){
					   res++;
				   }
				   listExpectedValues.add(res);
				   i++;
				   nbValues--;
				   };
			   break;
			   default:{
				   System.out.println("operateur "+prop.getProperty("operateur")+" non identifié");
				   return false;
				   }
			}

		String numbers = prop.getProperty("contenue"); //récupère le contenue de la chaine
		int indexIterator=0;
		int j=0;
		for(String nb : numbers.split(" ")) { //pour chaque nombre 
			int value=Integer.parseInt(nb.trim());  // l'enregistrer en tant que int
			if(indexIterator>=indexe){
				if(value!=listExpectedValues.get(j)){
					return false;
				}
				j++;
			}
			indexIterator++;
	        }
		
		return true;
	}
}