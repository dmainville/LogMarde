
public class SuiteChainee
{
		/*Parametre1 : Val1
		Parametre2 : Val2
		Parametre3 : Operateur
		Parametre4 : Indexe (le dernier indexe depuis lequel la chaine a été rempli)
		Parametre5 : Taille
		Parametre6 : Contenue 
		*/
	
	public String chemin_liste;
	public int val1;
	public int val2;
	public String operateur;
	public int index;
	public int taille;
	
	public ValeurChainee contenue;
	
	public SuiteChainee(String chemin_liste, String operateur, int val1,int val2,int taille, boolean etatVide)
	{
		this.chemin_liste = chemin_liste;
		this.operateur = operateur;
		this.val1 = val1;
		this.val2 = val2;
		this.taille = taille;
		
		//Ajuste la taille selon les limites [0, 10]
		if(this.taille <0)
			this.taille = 0;
		
		if(this.taille >10)
			this.taille = 10;
		
		if(!etatVide && this.taille >0)
		{
			//Instancier le contenue
			contenue = getValidSuiteChainee();
		}
		
	}
	
	public ValeurChainee getValidSuiteChainee()
	{
		//Retourne une liste chainee valide à partir des propriétés de la suite chainee courante.
		
		ValeurChainee chaine =null;
		for(int i=0; i<taille; i++)
		{
			if(i==0)
			{
				chaine = new ValeurChainee(effectueOperation(operateur,val1,val2));
				continue;
			}
			
			chaine.next = new ValeurChainee(effectueOperation(operateur,chaine.valeur,val2));
		}
		
		return chaine;
	}
	
	public int effectueOperation(String operateur, int a, int b)
	{
		if(operateur.equals("addition"))
			return addition(a,b);
		if(operateur.equals("soustraction"))
			return addition(a,b);
		if(operateur.equals("multiplication"))
			return addition(a,b);
		if(operateur.equals("division"))
			return addition(a,b);
		
		return -111; //si une erreur survient la valeur de retour est facilement identifiable
	}
	
	public int addition(int a, int b)
	{
		return a+b;
	}
	
	public int soustraction(int a, int b)
	{
		return a-b;
	}
	
	public int multiplication(int a, int b)
	{
		return a*b;
	}
	
	public int division(int a, int b)
	{
		return a/b;
	}
	
	public String toString()
	{
		//MaListe : -2, 5, 3, 8, 11
		String retour = "MaListe : ";
		
		for(int i=0; i<taille; i++)
		{

		}
		
		return "";
	}

}
