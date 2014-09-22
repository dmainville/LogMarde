import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class SuiteChainee
{
		/*Parametre1 : Val1
		Parametre2 : Val2
		Parametre3 : Operateur
		Parametre4 : Indexe (le dernier indexe depuis lequel la chaine a ÈtÈ rempli)
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
		
		System.out.println("MaListe : " + this.toString());
	}
	
	public ValeurChainee getValidSuiteChainee()
	{
		//Retourne une liste chainee valide √† partir des propri√©t√©s de la suite chainee courante.
		
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
	
	/* Code provenant de l'ÈnoncÈ */
	public int addition(int a, int b)
	{
		int res = a;
		if (b > 0) 
		{
			while(b-- != 0) 
			{
				res++;
			}
		}
		else if (b < 0) 
		{
			while(b++ != 0) 
			{
				res--;
			}
		}
		return res;
	}
	
	/* InspirÈ de l'exemple de l'ÈnoncÈ */
	public int soustraction(int a, int b)
	{
		int res = a;
		if (b > 0) 
		{
			while(b-- != 0) 
			{
				res--;
			}
		}
		else if (b < 0) 
		{
			while(b++ != 0) 
			{
				res++;
			}
		}
		return res;
	}
	
	public int multiplication(int a, int b)
	{
		if(multiplicationResultShouldBeNegative(a,b))
			return  Math.negateExact(absMultiplication(a,b));
		
		return  absMultiplication(a,b);
	}
	
	public int absMultiplication(int a, int b)
	{
		//Pris de http://stackoverflow.com/questions/2069488/how-can-i-perform-multiplication-without-the-operator
		return  (int) Math.round(Math.pow(10,(Math.log10(Math.abs(a)) + Math.log10(Math.abs(b)))));
	}
	
	public Boolean multiplicationResultShouldBeNegative(int a, int b)
	{
		return ((a <0 && b>=0) || (a>=0 && b<0));
	}
	
	public int division(int a, int b)
	{
		if(multiplicationResultShouldBeNegative(a,b))
			return  Math.negateExact(asbDivision(a,b));
		
		return  asbDivision(a,b);
	}
	
	public int asbDivision(int dividend, int divisor)
	{ 

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		if(divisor == 0)
			return 0;
		
		//Pris de http://stackoverflow.com/questions/5386377/division-without-using
	    int denom=divisor;
	    int current = 1;
	    int answer=0;

	    if ( denom > dividend) 
	        return 0;

	    if ( denom == dividend)
	        return 1;

	    while (denom <= dividend) {
	        denom <<= 1;
	        current <<= 1;
	    }

	    denom >>= 1;
	    current >>= 1;

	    while (current!=0) {
	        if ( dividend >= denom) {
	            dividend -= denom;
	            answer |= current;
	        }
	        current >>= 1;
	        denom >>= 1;
	    }    
	    return answer;
	}
	
	// Print the values with ',' as separator
	public String toString()
	{
		//MaListe : -2, 5, 3, 8, 11
		String retour = "";
		
		ValeurChainee v = contenue;
		
		for(int i=0; i<taille; i++)
		{
			// Cut it short if it's not populated
			if (v == null)
				return retour;
			
			retour += v.valeur;
			if (i != (taille - 1))
				retour += ", ";
			v = v.next;
		}
		
		return retour;
	}
	
	public Boolean add(int element)
	{
		if (index < taille-1)
		{
			ValeurChainee v = contenue;
			
			while (v.next != null)
			{
				v = v.next;
			}
			
			v.next = new ValeurChainee(element);
			v.next.previous = v;
			
			index++;
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void removeAt(int position)
	{
		ValeurChainee v = contenue;
		
		while (position > 0)
		{
			v = v.next;
			position--;
		}
		
		v.previous = v.next;
		v.next = v.previous;
		
		index--;
	}
	
	public void removeItem(int element)
	{
		ValeurChainee v = contenue;
		
		for (int i = 0; i <= index; i++)
		{
			if (v.valeur == element)
			{
				this.removeAt(i);
			}

			v = v.next;
		}
	}
	
	public void setAt(int element, int position)
	{
		ValeurChainee v = contenue;
		
		while(position > 0)
		{
			v = v.next;
		}
		
		v.valeur = element;
	}
	
	public int getAt(int position)
	{
		ValeurChainee v = contenue;
		
		while(position > 0)
		{
			v = v.next;
		}
		
		return v.valeur;
	}
	
	public int getSize()
	{
		return this.taille;
	}
	
	public void reset()
	{
		this.contenue = null;
		
		this.index = 0;
	}
	
	// This function checks if the values in list are valid according to 
	// the parameters operateur, val1 and val2
	// return: Boolean, true if values match the rules
	public Boolean isValide()
	{
		ValeurChainee a = this.getValidSuiteChainee(), b = contenue;
		
		for (int i = 0; i < taille; i++)
		{
			if (a == null || b == null)
				return false;
			
			if (a.valeur != b.valeur)
				return false;
			a = a.next;
			b = b.next;
		}
		
		return true;
	}
	
	
	// Write parameters and list values to a file
	// Parameters : 
	// 			String path : file path to save the current list 
	public void save(String path)
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(path);
			writer.println("Parametre1 : " + this.val1);
			writer.println("Parametre2 : " + this.val2);
			writer.println("Parametre3 : " + this.operateur);
			writer.println("Parametre4 : " + this.index);
			writer.println("Parametre5 : " + this.taille);
			writer.println("Parametre6 : " + this.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
